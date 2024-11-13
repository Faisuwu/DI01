//Antoni Maqueda Bestard - DI01 - AuthService
package service;

import model.Usuari;
import conection.BCryptUtils;
import conection.DataAccess;

//Lógica per comprobar que l'usuari ha introduit la contrasenya correcta
public class AuthService {
    public boolean login(String email, String password) {
        Usuari user = DataAccess.getUser(email);
        if (user != null) {
            return BCryptUtils.verify(password, user.getPasswordHash());
        }
        return false;
    }
}

