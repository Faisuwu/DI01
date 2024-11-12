//Antoni Maqueda Bestard - DI01 - BCryptUtils
package application;

//importar BCrypt;

public class BCryptUtils {
    public static String hash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean verify(String password, String hashedPassword) {
        return BCrypt.verifyer().verify(password.toCharArray(), hashedPassword).verified;
    }
}

