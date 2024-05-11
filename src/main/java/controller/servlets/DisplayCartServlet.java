package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.CartModel;
import util.StringUtils;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBController dbController = new DBController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  	HttpSession session = request.getSession();
	        String username = (String) session.getAttribute(StringUtils.USER_NAME);
			System.out.println(username);
			
			int userId = dbController.getUserIdByUserName(username);
			System.out.println(userId);
	        // Fetch cart items for the user
	        List<CartModel> cartItems = dbController.getCartItemsByUserId(userId);
	        
	        request.setAttribute("cartItems", cartItems);
	        
	        // Forward the request to cart.jsp
	        request.getRequestDispatcher("/pages/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
