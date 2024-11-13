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

    private void initComponents() {
        setLayout(new BorderLayout());
        exerciseModel = new DefaultListModel<>();
        exerciseList = new JList<>(exerciseModel);
        add(new JScrollPane(exerciseList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Exercise");
        addButton.addActionListener(e -> addExercise());

        JButton deleteButton = new JButton("Delete Exercise");
        deleteButton.addActionListener(e -> deleteExercise());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadExercises() {
        List<Exercici> exercises = exerciseService.getAllExercises();
        exerciseModel.clear();
        for (Exercici exercise : exercises) {
            exerciseModel.addElement(exercise);
        }
    }

    private void addExercise() {
    String exerciseName = JOptionPane.showInputDialog(this, "Enter exercise name:");
    String description = JOptionPane.showInputDialog(this, "Enter exercise description:");
    if (exerciseName != null && !exerciseName.isEmpty()) {
        Exercici newExercise = new Exercici();
        newExercise.setNomExercici(exerciseName);
        newExercise.setDescripcio(description);

        exerciseService.createExercise(newExercise);
        loadExercises(); // Actualizamos la lista de ejercicios
    }
}

    private void deleteExercise() {
    Exercici selectedExercise = exerciseList.getSelectedValue();
    if (selectedExercise != null) {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this exercise?");
        if (confirm == JOptionPane.YES_OPTION) {
            exerciseService.deleteExercise(selectedExercise.getId());
            loadExercises(); // Recargamos la lista de ejercicios
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select an exercise to delete.");
    }
    }
}