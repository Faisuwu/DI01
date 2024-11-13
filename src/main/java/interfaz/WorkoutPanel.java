//Antoni Maqueda Bestard - DI01 - WorkoutPanel
package interfaz;

import model.Workout;
import service.WorkoutService;
import java.time.format.DateTimeFormatter;
import model.Usuari;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WorkoutPanel extends JPanel {
    private JList<Workout> workoutList;
    private DefaultListModel<Workout> workoutModel;
    private WorkoutService workoutService;
    private Usuari usuari;
    
    public WorkoutPanel() {
        workoutService = new WorkoutService();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        workoutModel = new DefaultListModel<>();
        workoutList = new JList<>(workoutModel);
        add(new JScrollPane(workoutList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Workout");
        addButton.addActionListener(e -> addWorkout());

        JButton deleteButton = new JButton("Delete Workout");
        deleteButton.addActionListener(e -> deleteWorkout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadWorkouts(int userId) {
        List<Workout> workouts = workoutService.getWorkoutsByUserId(usuari);
        workoutModel.clear();
        for (Workout workout : workouts) {
            workoutModel.addElement(workout);
        }
    }

    private void addWorkout() {
    String workoutName = JOptionPane.showInputDialog(this, "Enter workout name:");
    if (workoutName != null && !workoutName.isEmpty()) {
        Workout newWorkout = new Workout();
        newWorkout.setName(workoutName);
        newWorkout.setIdUsuari(2);
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        newWorkout.setForDate(formattedDate); // Usamos la fecha formateada como String

        workoutService.createWorkout(newWorkout,);
        loadWorkouts(newWorkout.getIdUsuari());

        workoutService.createWorkout(newWorkout);
        loadWorkouts(newWorkout.getIdUsuari()); // Actualizamos la lista de entrenamientos
    }
}

    private void deleteWorkout() {
    Workout selectedWorkout = workoutList.getSelectedValue();
    if (selectedWorkout != null) {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this workout?");
        if (confirm == JOptionPane.YES_OPTION) {
            workoutService.deleteWorkout(selectedWorkout.getId());
            loadWorkouts(selectedWorkout.getIdUsuari()); // Recargamos la lista de entrenamientos
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a workout to delete.");
    }
}
}