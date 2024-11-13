//Antoni Maqueda Bestard - DI01 - Login
package interfaz;

import service.AuthService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login(JFrame parent) {
        super(parent, "Login", true);
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(parent);

        initComponents();
    }

    //Iniciam els components de la pantalla de login
    private void initComponents() {
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 20, 80, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 20, 160, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    //Lógica per realitzar el login
    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        AuthService authService = new AuthService();

        if (authService.login(email, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials, please try again.");
        }
    }
}
