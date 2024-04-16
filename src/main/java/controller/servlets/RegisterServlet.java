package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.RegisterModel;
import util.StringUtils;
import util.ValidationUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DBController dbController = new DBController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
//		
			if(!ValidationUtils.isValidName(firstName)) {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.FIRST_NAME_ERROR);
				request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				return;
			}
			if(!ValidationUtils.isValidName(lastName)) {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.LAST_NAME_ERROR);
				request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
				return;
			}
//			if(!ValidationUtils.isValidName(userName)) {
//			    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_INVALID_ERROR_MESSAGE);
//			    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
//			    return;
//			}
		    
		    int result = dbController.registerStudent(registerModel);
		    
		    if(password.equals(retypePassword)) {
		    switch(result) {
		    	case 1 -> {
		    		request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
		    		response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		    	}
		    	case 0 -> {
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    	}
		    	case -1 -> {
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    	}
		    	case -2 -> {
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    	}
		    	case -3 -> {
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    	}
		    	case -4 -> {
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    	}
		    	default ->{
		    		request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
		    		request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    		
		    	}
		    }
		  }else {
		    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
		    	request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    }
		    
		}
		

}
