//Antoni Maqueda Bestard - DI01 - MainJFrame
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame {
    private UsuariPanel userListPanel;
    private WorkoutPanel workoutListPanel;
    private ExercisePanel exercisePanel;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;

    public MainJFrame() {
        setTitle("Gestión de Entrenamientos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        initMenu();
        initComponents();
    }

    private void initMenu() {
        menuBar = new JMenuBar();

        // Menú Archivo
        fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

    }

    private void initComponents() {
        userListPanel = new UsuariPanel();
        workoutListPanel = new WorkoutPanel();
        exercisePanel = new ExercisePanel();

        userListPanel.setBounds(10, 10, 200, 500);
        workoutListPanel.setBounds(220, 10, 300, 500);
        exercisePanel.setBounds(530, 10, 250, 500);

        add(userListPanel);
        add(workoutListPanel);
        add(exercisePanel);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "App feta per: Antoni Maqueda");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainJFrame mainFrame = new MainJFrame();
            mainFrame.setVisible(true);
        });
    }
}