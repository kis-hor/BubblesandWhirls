package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.ProductModel;
import model.RegisterModel;
import util.StringUtils;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController dbController = new DBController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Getting user info");
		String username = request.getParameter("updateId");
		RegisterModel user = dbController.getUserInfo(username);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/pages/user-update-profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Updating user");
		
		String userName = request.getParameter(StringUtils.USER_NAME);
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String email = request.getParameter(StringUtils.EMAIL);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		
		RegisterModel registerModel = new RegisterModel();
		
		registerModel.setUsername(userName);
		registerModel.setFirstName(firstName);
		registerModel.setLastName(lastName);
		registerModel.setEmail(email);
		registerModel.setPhoneNumber(phoneNumber);
		
		
		int result = dbController.updateUserInfo(registerModel);
		System.out.println("update result"+result);
		response.sendRedirect(request.getContextPath()+"/UserDetailServlet");
		
	}

}