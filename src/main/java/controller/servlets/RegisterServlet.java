package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

import controller.database.DBController;
import model.RegisterModel;
import util.StringUtils;
import util.ValidationUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/RegisterServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)

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
		Part imagePart = request.getPart("image");

		RegisterModel registerModel = new RegisterModel(firstName, lastName, email, phoneNumber, userName, password, role, imagePart);
		
		
		//where is saving
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
	    String fileName = registerModel.getImageUrlFromPart();
	    if(!fileName.isEmpty() && fileName != null)
    		imagePart.write(savePath + fileName);
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

		if(!ValidationUtils.hasSpecialCharOrDigit(userName)) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_INVALID_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    return;
		} 
		
		if(!ValidationUtils.hasLength(userName, 5, 35)) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_LENGTH_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    return;
		}

		if(!ValidationUtils.isEmail(email)) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_INVALID_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    return;
		}

		if(!ValidationUtils.isNumbersOnly(phoneNumber)) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_INVALID_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    return;
		}

		if(!ValidationUtils.isValidPassword(password)) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_INVALID_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		    return;
		}
		    
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
