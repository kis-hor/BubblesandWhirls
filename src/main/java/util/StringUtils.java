package util;

public class StringUtils {
	public static final String DB_NAME = "bubbles_whirls";
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String HOST_URL = "jdbc:mysql://localhost:3304/bubbles_whirls";
    public static final String HOST_NAME = "root";
    public static final String HOST_PASS = "";
    
    public static final String GET_USERNAME = "SELECT COUNT(*) FROM users WHERE user_name = ?";
	public static final String GET_PHONE = "SELECT COUNT(*) FROM users WHERE phone_number = ?";
	public static final String GET_EMAIL = "SELECT COUNT(*) FROM users WHERE email = ?";
	public static final String REGISTER_USER_QUERY = "INSERT INTO users(user_name, first_name, last_name, email, phone_number, password, role) VALUES( ?, ?, ?, ?, ?, ?, ?)";
    public static final String USER_LOGIN_QUERY_CHECK = "SELECT * FROM users WHERE user_name = ?";
    
    // Keep or modify the changes made in your local branch
    public static final String USER_NAME = "user_name";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String PASSWORD = "password";
    public static final String RETYPE_PASSWORD = "retype_password";
//    public static final String ROLE = "role";
    
    public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered";
	public static final String SUCCESS_LOGIN_MESSAGE = "Successfully logged in";
	public static final String REGISTER_ERROR_MESSAGE = "Please correct the form data";
	public static final String LOGIN_ERROR_MESSAGE = "Login Unsuccessful";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occured";
	
	public static final String SUCCESS_MESSAGE = "successMessage";
	public static final String ERROR_MESSAGE = "errorMessage";
	
	public static final String USERNAME_ERROR_MESSAGE = "Username is already registered";
	public static final String EMAIL_ERROR_MESSAGE = "Email is already registered";
	public static final String PHONE_ERROR_MESSAGE = "Phone number is already registered";
	public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "The password does not match";
	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please input all the fields correctly.";
	public static final String FIRST_NAME_ERROR = "Please input firstname correctly";
	public static final String LAST_NAME_ERROR = "Please input lastname correctly";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";
	
        
	public static final String USERNAME_INVALID_ERROR_MESSAGE = "Username should contain both name and letters";
	public static final String USERNAME_LENGTH_ERROR_MESSAGE = "Username should be greater than 4 and less than 20";
    
    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String HOME_PAGE = "/index.jsp";
    public static final String REGISTER_PAGE = "/pages/register.jsp";
    
    public static final String USER = "user";
    
    
	
	
	
}

