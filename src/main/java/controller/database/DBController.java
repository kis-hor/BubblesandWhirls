package controller.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.PasswordEncryptionWithAes;
import model.RegisterModel;
import util.StringUtils;

public class DBController {
	 
		public Connection getConnection() throws SQLException, ClassNotFoundException {

		    // Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		    Class.forName(StringUtils.DRIVER_NAME);

		    // Create a connection to the database using the provided credentials
		    return DriverManager.getConnection(StringUtils.HOST_URL, StringUtils.HOST_NAME,
		                                      StringUtils.HOST_PASS);
		}
		
		// Register User Starts here
		public int registerStudent(RegisterModel user) {

		    try {
		        // Preparation of Registering User
		        PreparedStatement stmt = getConnection()
		        		.prepareStatement(StringUtils.REGISTER_USER_QUERY);//Query of Registering User

		        // Setting the user information
		        stmt.setString(1, user.getFirstName());
		        stmt.setString(2, user.getLastName());
		        stmt.setString(3, user.getEmail());
		        stmt.setString(4, user.getPhoneNumber());
		        stmt.setString(5, user.getUsername());
		        stmt.setString(6, user.getPassword());
		        stmt.setString(7, user.getRole());
		        

		        // Execute the update statement and store the number of affected rows
		        int result = stmt.executeUpdate();

		        // Check if the update was successful (i.e., at least one row affected)
		        if (result > 0) {
		            return 1; // Registration successful
		        } else {
		            return 0; // Registration failed (no rows affected)
		        }

		    } catch (ClassNotFoundException | SQLException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        return -1; // Internal error
		    }
		}
		// Register User Ends here
		
		// Login User starts here
		/**
		 * This method attempts to validate a student login by checking the username 
		 * and password against a database.
		 * 
		 * @param username The username provided by the user attempting to log in.
		 * @param password The password provided by the user attempting to log in.
		 * @return An integer value indicating the login status:
		 *         - 1: Login successful
		 *         - 0: Username or password mismatch
		 *         - -1: Username not found in the database
		 *         - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
		 * @throws SQLException if a database access error occurs.
		 * @throws ClassNotFoundException if the JDBC driver class is not found.
		 */
		public int getStudentLoginInfo(LoginModel loginModel) {
		    // Try-catch block to handle potential SQL or ClassNotFound exceptions
		    try {
		        // Prepare a statement using the predefined query for login check
		        PreparedStatement st = getConnection()
		        		.prepareStatement(StringUtils.USER_LOGIN_QUERY_CHECK);

		        // Set the username in the first parameter of the prepared statement
		        st.setString(1, loginModel.getUsername());

		        // Execute the query and store the result set
		        ResultSet result = st.executeQuery();

		        // Check if there's a record returned from the query
		        if (result.next()) {
		            // Get the username from the database
		            String userDb = result.getString(StringUtils.USER_NAME);

		            // Get the password from the database
		            String encryptedPwd = result.getString(StringUtils.PASSWORD);

		            String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
		            // Check if the username and password match the credentials from the database
		            if (userDb.equals(loginModel.getUsername()) 
		            		&& decryptedPwd.equals(loginModel.getPassword())) {
		                // Login successful, return 1
		                return 1;
		            } else {
		                // Username or password mismatch, return 0
		                return 0;
		            }
		        } else {
		            // Username not found in the database, return -1
		            return -1;
		        }

		    // Catch SQLException and ClassNotFoundException if they occur
		    } catch (SQLException | ClassNotFoundException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        // Return -2 to indicate an internal error
		        return -2;
		    }
		}
		// Login User Ends here
		
		
		
		
	
}
