package util;

public class StringUtils {
    public static final String DRIVER_NAME = "jdbc:mysql://localhost:3304/";
    public static final String HOST_URL = "localhost";
    public static final String HOST_NAME = "root";
    public static final String HOST_PASS = "";
    public static final String DB_NAME = "bubbles_whirls";
    
    // Keep or modify the changes made in your local branch
    public static final String USER_NAME = "username";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String PASSWORD = "password";
    public static final String RETYPE_PASSWORD = "retypePassword";
    public static final String ROLE = "role";
        
    public static final String REGISTER_USER_QUERY = "INSERT INTO bubbles_whirls(user_name, first_name, last_name, email, phone_number, password, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
    public static final String USER_LOGIN_QUERY_CHECK = "SELECT * FROM student_info WHERE user_name = ?";
}
