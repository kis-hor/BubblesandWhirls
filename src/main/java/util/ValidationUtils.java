package util;

/**
 * Utility class for performing various validation checks on strings.
 */
public class ValidationUtils {

     public static boolean isValidName(String name) {
    	return name != null && !name.isEmpty() && name.matches("[a-zA-Z]+");
    }
    
     public static boolean isValidUsername(String username) {
         // Check if the username is not null, not empty, contains only alphanumeric characters, and is within the specified length range
    	 return username != null && !username.isEmpty() && username.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]*$");
     }
     /**
      * Validates if the provided password meets complexity requirements:
      * - Contains at least one uppercase letter (A-Z)
      * - Contains at least one lowercase letter (a-z)
      * - Contains at least one digit (0-9)
      * - Contains at least one symbol (@$!%*?&).
      * 
      * @param password The password to be validated.
      * @return True if the password meets complexity requirements, false otherwise.
      */
     public static boolean isValidPassword(String password) {
         return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]*$"); // No length validation
     }
}