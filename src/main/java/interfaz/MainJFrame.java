//Antoni Maqueda Bestard - DI01 - MainJFrame
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame {
    private UsuariPanel userListPanel;
    private WorkoutListPanel workoutListPanel;
    private ExerciseManagementPanel exercisePanel;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;

    public MainFrame() {
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

        // Menú Ayuda
        helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    private void initComponents() {
        userListPanel = new UserListPanel();
        workoutListPanel = new WorkoutListPanel();
        exercisePanel = new ExerciseManagementPanel();

        userListPanel.setBounds(10, 10, 200, 500);
        workoutListPanel.setBounds(220, 10, 300, 500);
        exercisePanel.setBounds(530, 10, 250, 500);

        add(userListPanel);
        add(workoutListPanel);
        add(exercisePanel);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, "App creada por [Tu Nombre]. Curso DI01 24-25.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
