//Antoni Maqueda Bestard - DI01 - WorkoutPanel
package interfaz;

import model.Workout;
import model.Exercici;
import service.WorkoutService;
import java.time.format.DateTimeFormatter;
import model.Usuari;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class WorkoutPanel extends JPanel {
    private JList<Workout> workoutList;
    private DefaultListModel<Workout> workoutModel;
    private WorkoutService workoutService;
    private Usuari usuari;
    
    public WorkoutPanel() {
        workoutService = new WorkoutService();
        initComponents();
    }

    //Iniciam els components
    private void initComponents() {
        setLayout(new BorderLayout());
        workoutModel = new DefaultListModel<>();
        workoutList = new JList<>(workoutModel);
        add(new JScrollPane(workoutList), BorderLayout.CENTER);

        JButton addButton = new JButton("Afegir Workout");
        addButton.addActionListener(e -> addWorkout());

        JButton deleteButton = new JButton("Eliminar Workout");
        deleteButton.addActionListener(e -> deleteWorkout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //Càrregam els Workouts
    private void loadWorkouts(int userId) {
        List<Workout> workouts = workoutService.getWorkoutsByUserId(usuari);
        workoutModel.clear();
        for (Workout workout : workouts) {
            workoutModel.addElement(workout);
        }
    }

    //Métode per afegir un nou workout
    private void addWorkout() {
        String workoutName = JOptionPane.showInputDialog(this, "Nom del Workout:");
        if (workoutName != null && !workoutName.isEmpty()) {
            Workout newWorkout = new Workout();
            newWorkout.setName(workoutName);
            newWorkout.setIdUsuari(usuari.getId());
            String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            newWorkout.setForDate(formattedDate); // Hem de convertir la data en string
            
            ArrayList<Exercici> exercicis = new ArrayList<>();
            
            workoutService.createWorkout(newWorkout, exercicis);
            loadWorkouts(newWorkout.getIdUsuari()); // Actualitzam la llista de workouts
        }
    }
        
    //Métode per eliminar un workout
    private void deleteWorkout() {
        Workout selectedWorkout = workoutList.getSelectedValue();
        if (selectedWorkout != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Segur que ho vols eliminar?");
            if (confirm == JOptionPane.YES_OPTION) {
                workoutService.deleteWorkout(selectedWorkout.getId());
                loadWorkouts(selectedWorkout.getIdUsuari());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un workout per eliminar");
        }
    }
}