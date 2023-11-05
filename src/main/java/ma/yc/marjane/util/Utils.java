package ma.yc.marjane.util;

import org.mindrot.jbcrypt.BCrypt;

public class Utils {
    // Utility method to hash a password using bcrypt
    public static String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    // Utility method to check if a password matches a hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}