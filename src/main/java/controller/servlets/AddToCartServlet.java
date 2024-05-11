package controller.servlets;

import java.io.IOException;


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
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBController dbController = new DBController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute(StringUtils.USER_NAME);
		System.out.println(username);
		
		int userId = dbController.getUserIdByUserName(username);
		System.out.println(userId);
		int productId = Integer.parseInt(request.getParameter("product_id"));
		System.out.println(productId);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        System.out.println(quantity);
        
        // Create CartModel object and set values
        CartModel cartItem = new CartModel();
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        
        // Add cart item to the database
        
        int result = dbController.addToCart(cartItem, userId);
        
        if (result > 0) {
        	response.sendRedirect(request.getContextPath() + "/DisplayServlet");
        } else {
            // Handle error
        	request.setAttribute(StringUtils.ERROR_MESSAGE, "Error Occured");
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
	}

}
