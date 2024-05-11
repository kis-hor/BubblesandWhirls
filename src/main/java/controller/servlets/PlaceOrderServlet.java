package controller.servlets;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DBController dbController = new DBController();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		String username = (String) session.getAttribute(StringUtils.USER_NAME);
		
		int userId = dbController.getUserIdByUserName(username);
		
		List<CartModel> cartItems = dbController.getCartItemsByUserId(userId);
        
		int totalOrderPrice = 0;
	    for (CartModel cartItem : cartItems) {
	        totalOrderPrice += cartItem.getProductPrice() * cartItem.getQuantity();
	    }
	    int orderId = 0;
            // Add order items
	    try {
			orderId = dbController.addOrder(userId, totalOrderPrice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            try {
				dbController.addOrderItem(orderId, userId, cartItems);
				dbController.addOrder(userId, totalOrderPrice);
				dbController.clearCart(userId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            // Redirect to success page or any other appropriate action
            response.sendRedirect(request.getContextPath() + "/OrderDetailServlet");
    
    }
}