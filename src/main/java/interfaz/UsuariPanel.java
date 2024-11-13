//Antoni Maqueda Bestard - DI01 - UsuariPanel
package interfaz;

import model.Usuari;
import service.UsuariService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.BorderLayout;

public class UsuariPanel extends JPanel {
    private JList<Usuari> userList;
    private DefaultListModel<Usuari> userModel;
    private UsuariService userService;

    public UsuariPanel() {
        userService = new UsuariService();
        initComponents();
        loadUsers();
    }

    //Iniciam els components
    private void initComponents() {
        setLayout(new BorderLayout());
        userModel = new DefaultListModel<>();
        userList = new JList<>(userModel);
        add(new JScrollPane(userList), BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refrescar");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUsers();
            }
        });
        add(refreshButton, BorderLayout.SOUTH);
    }

    //Càrregam els usuaris
    private void loadUsers() {
        List<Usuari> users = userService.getAllUsers();
        userModel.clear();
        for (Usuari user : users) {
            userModel.addElement(user);
        }
    }
}