/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

/**
 *
 * @author faisu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class ConexionDB {
    
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
                        
            /*try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
                Properties properties = new Properties();
                properties.load(input);
                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.username");
                String password = properties.getProperty("db.password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        return connection;
    }
    
}