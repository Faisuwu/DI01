//Antoni Maqueda Bestard - DI01 - ExercisePanel
package interfaz;

import model.Exercici;
import service.ExerciseService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExercisePanel extends JPanel {
    private JList<Exercici> exerciseList;
    private DefaultListModel<Exercici> exerciseModel;
    private ExerciseService exerciseService;

    public ExercisePanel() {
        exerciseService = new ExerciseService();
        initComponents();
        loadExercises();
    }

    //Iniciam els components de la pantalla
    private void initComponents() {
        setLayout(new BorderLayout());
        exerciseModel = new DefaultListModel<>();
        exerciseList = new JList<>(exerciseModel);
        add(new JScrollPane(exerciseList), BorderLayout.CENTER);

        JButton addButton = new JButton("Afegir Exercici");
        addButton.addActionListener(e -> addExercise());

        JButton deleteButton = new JButton("Eliminar Exercici");
        deleteButton.addActionListener(e -> deleteExercise());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //Métode per càrregar els exercicis
    private void loadExercises() {
        List<Exercici> exercises = exerciseService.getAllExercises();
        exerciseModel.clear();
        for (Exercici exercise : exercises) {
            exerciseModel.addElement(exercise);
        }
    }

    //Métode per afegir un nou exercici
    private void addExercise() {
    String exerciseName = JOptionPane.showInputDialog(this, "Nom del Exercici:");
    String description = JOptionPane.showInputDialog(this, "Descripcio del Exercici:");
    if (exerciseName != null && !exerciseName.isEmpty() && description != null) {
        Exercici newExercise = new Exercici();
        newExercise.setNomExercici(exerciseName);
        newExercise.setDescripcio(description);

        exerciseService.createExercise(newExercise);
        loadExercises();
    } else {
        JOptionPane.showMessageDialog(this, "No pot estar buid");
    }
}

    //Métode per eliminar un exercici
    private void deleteExercise() {
    Exercici selectedExercise = exerciseList.getSelectedValue();
    if (selectedExercise != null) {
        int confirm = JOptionPane.showConfirmDialog(this, "Estás segur de voler eliminar l'Exercici?");
        if (confirm == JOptionPane.YES_OPTION) {
            exerciseService.deleteExercise(selectedExercise.getId());
            loadExercises();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona un exercici per eliminar");
    }
    }
}