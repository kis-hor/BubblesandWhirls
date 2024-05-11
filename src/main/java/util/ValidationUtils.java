package util;

/**
 * Utility class for performing various validation checks on strings.
 */
public class ValidationUtils {

     public static boolean isValidName(String name) {
    	return name != null && !name.isEmpty() && name.matches("[a-zA-Z]+");
    }
    
     
     /**
      * Validates if the provided text contains only digits (0-9).
      * 
      * @param text The text to be validated.
      * @return True if the text contains only digits, false otherwise.
      */
     public static boolean isNumbersOnly(String text) {
         return text.matches("\\d+"); // Match digits only
     }
     
     /**
      * Validates if the provided text has hasSpecialCharOrDigit, containing only letters, special characters and digits.
      * 
      * @param text The text to be validated.
      * @return True if the text hasSpecialCharOrDigit , false otherwise.
      */
     public static boolean hasSpecialCharOrDigit(String text) {
    	 return text != null && text.matches("^[A-Za-z][A-Za-z0-9_]{5,35}$");
     }
     
     /**
      * Validates if the provided text is a valid email address format.
      * 
      * @param email The email address to be validated.
      * @return True if the email address has a valid format, false otherwise.
      */
     public static boolean isEmail(String email) {
         return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$"); // Match standard email pattern
     }
     
     /**
      * Validates if the provided text contains no special characters other than letters, digits, and whitespace.
      * 
      * @param text The text to be validated.     
      * @return True if the text contains no special characters, false otherwise.
      */
     public static boolean hasNoSpecialCharacters(String text) {
         return text.matches("[a-zA-Z0-9\\s]+"); // Match only letters, digits, and whitespace
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
     
     /**
      * Validates if the provided text has the specified length.
      * 
      * @param text The text to be validated.
      * @param length The expected length of the text.
      * @return True if the text has the specified length, false otherwise.
      */
	     public static boolean hasLength(String text, int minLength, int maxLength) {
	         int textLength = text.length();
	         return textLength >= minLength && textLength <= maxLength;
	     }
     
}