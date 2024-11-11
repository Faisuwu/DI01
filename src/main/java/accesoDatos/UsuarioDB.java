/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

/**
 *
 * @author faisu
 */
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB {
    
    private Connection connection = ConexionDB.getConnection();

    public Usuario findUsuarioByEmail(String email) throws SQLException {
        String query = "SELECT * FROM Usuaris WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                /*if (rs.next()) {
                    return new Usuario(rs.getInt("id"), rs.getString("nom"),
                            rs.getString("email"), rs.getString("passwordHash"));
                }*/
            }
        }
        return null;
    }
    
}
