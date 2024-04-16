package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.LoginModel;
import util.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBController dbController = new DBController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		

		LoginModel loginModel = new LoginModel(username, password);
		
		int loginResult = dbController.getUserLoginInfo(loginModel);
		
		
		if(loginResult == 1) {
			HttpSession userSession = request.getSession();
			userSession.setAttribute(StringUtils.USER_NAME, username);
			userSession.setMaxInactiveInterval(30*60);
			
			Cookie userCookie= new Cookie(StringUtils.USER, username);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
            request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
			response.sendRedirect(request.getContextPath() + StringUtils.HOME_PAGE);
		} else if (loginResult == 0) {
            // Username or password mismatch
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.LOGIN_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } else if (loginResult == -1) {
            // Username not found
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
	
	}

}
