//Antoni Maqueda Bestard - DI01 - AuthService
package service;

import model.Usuari;
import conection.BCryptUtils;
import conection.DataAccess;

public class AuthService {
    public boolean login(String email, String password) {
        Usuari user = DataAccess.getUser(email);
        if (user != null) {
            return BCryptUtils.verify(password, user.getPasswordHash());
        }
        return false;
    }
}

