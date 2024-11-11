/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author faisu
 */

/*Importar BCript*/
import accesoDatos.UsuarioDB;
import modelo.Usuario;
public class Autenticacion {
    
    private UsuarioDB usuarioDB;

    public Autenticacion() {
        this.usuarioDB = new UsuarioDB();
    }

    public boolean autenticar(String email, String password) {
        /*Usuario usuario = usuarioDB.findUsuarioByEmail(email);
        if (usuario != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), usuario.getPasswordHash());
            return result.verified;
        }*/
        return false;
    }
    
}
