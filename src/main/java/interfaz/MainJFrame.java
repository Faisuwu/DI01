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
        setTitle("Gestió de Entrenaments");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        initMenu();
        initComponents();
    }

    //Iniciam el menú principal
   private void initMenu() {
    menuBar = new JMenuBar();

    fileMenu = new JMenu("File");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener(e -> System.exit(0));
    fileMenu.add(exitMenuItem);
    menuBar.add(fileMenu);

    helpMenu = new JMenu("Help");
    menuBar.add(helpMenu);

    setJMenuBar(menuBar);
    
   }   

   //Iniciam tots els altres components
    private void initComponents() {
    userListPanel = new UsuariPanel();
    workoutListPanel = new WorkoutPanel();
    exercisePanel = new ExercisePanel();

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(1, 3, 10, 0));

    mainPanel.add(userListPanel);
    mainPanel.add(workoutListPanel);
    mainPanel.add(exercisePanel);

    add(mainPanel, BorderLayout.CENTER);
    }

    //El Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainJFrame mainFrame = new MainJFrame();
            mainFrame.setVisible(true);
        });
    }
}