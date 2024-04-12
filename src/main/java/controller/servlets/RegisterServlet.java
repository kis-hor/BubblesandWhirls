package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
<<<<<<< HEAD
=======
import model.RegisterModel;
import util.StringUtils;
>>>>>>> a2314042a2d35ea0df5932b153bf142814ce28b6

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
       
	/**
=======
    
	DBController dbController = new DBController();
    /**
>>>>>>> a2314042a2d35ea0df5932b153bf142814ce28b6
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        new DBController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		

			
=======
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter printOut = response.getWriter();
		
		String userName = request.getParameter(StringUtils.USER_NAME);
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String email = request.getParameter(StringUtils.EMAIL);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String password= request.getParameter(StringUtils.PASSWORD);
		String retypePassword= request.getParameter(StringUtils.RETYPE_PASSWORD);
		String role = "user";

		
		RegisterModel registerModel = new RegisterModel(firstName, lastName, email, phoneNumber, userName, password, role);
		
		int result = dbController.registerStudent(registerModel);
		
		if(result==1) {
			response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		}
		
>>>>>>> a2314042a2d35ea0df5932b153bf142814ce28b6
	}

}
