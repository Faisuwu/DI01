//Antoni Maqueda Bestard - DI01 - BCryptUtils
package conection;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCryptUtils {
    
    //Codi per xifrar la contrasenya a BCrypt
    public static String hash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    //Codi per verificar si una contrasenya és correcta
    public static boolean verify(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}