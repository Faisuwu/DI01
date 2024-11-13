//Antoni Maqueda Bestard - DI01 - MainJFrame
package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.AuthService;

public class MainJFrame extends JFrame {
    private UsuariPanel userListPanel;
    private WorkoutPanel workoutListPanel;
    private ExercisePanel exercisePanel;
    private JMenuBar menuBar;
    private JMenu fileMenu, helpMenu;
    
    private AuthService authservice;
    private boolean isLoggedIn;

    public MainJFrame() {
        authservice = new AuthService();
        isLoggedIn = false;
        
        setTitle("Gestió de Entrenaments");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        initMenu();
        initComponents();
        
        showLoginDialog();
    }

    //Iniciam el menú principal
   private void initMenu() {
       
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    
    JMenuItem logoutMenuItem = new JMenuItem("Logout");
    logoutMenuItem.addActionListener(e -> logout());
    fileMenu.add(logoutMenuItem);
    
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener(e -> System.exit(0));
    fileMenu.add(exitMenuItem);
    
    menuBar.add(fileMenu);
    setJMenuBar(menuBar);
    
   }   

   //Iniciam tots els altres components
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

        setPanelsVisible(false);
    }

    private void setPanelsVisible(boolean visible) {
        userListPanel.setVisible(visible);
        workoutListPanel.setVisible(visible);
        exercisePanel.setVisible(visible);
    }
    
    private void showLoginDialog() {
        Login loginDialog = new Login(this);
        loginDialog.setVisible(true);

        isLoggedIn = authservice.login(loginDialog.getEmail(), loginDialog.getPassword());
        setPanelsVisible(isLoggedIn);
    }
    
    private void logout() {
        isLoggedIn = false;
        setPanelsVisible(false);
        showLoginDialog();
    }
    
    //El Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainJFrame mainFrame = new MainJFrame();
            mainFrame.setVisible(true);
        });
    }
}