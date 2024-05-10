package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.OrderModel;

/**
 * Servlet implementation class OrderUpdateServlet
 */
@WebServlet("/OrderUpdateServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController dbController = new DBController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Getting order info");
		String orderId = request.getParameter("updateId");
	
		OrderModel order = dbController.getOrderInfo(orderId);
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("/pages/admin-update-order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Updating order");
		String orderId = request.getParameter("order_id");
		String deliveryStatus = request.getParameter("delivery_status");
		String orderStatus = request.getParameter("order_status");
//		String paymentOption =  request.getParameter("payment_option");
//		String shippingAddress =  request.getParameter("shipping_address");
		
		
//		System.out.println(request.getParameter("shipping_address"));
//		System.out.println(request.getParameter("payment_option"));
		
		
		OrderModel orderModel = new OrderModel();
		
		orderModel.setOrderId(Integer.parseInt(orderId));
		orderModel.setDeliveryStatus(deliveryStatus);
		orderModel.setOrderStatus(orderStatus);
//		orderModel.setPaymentOption(paymentOption);
//		orderModel.setShippingAddress(shippingAddress);
		
		int result = dbController.updateOrderInfo(orderModel);
		System.out.println(""+result);
		response.sendRedirect(request.getContextPath()+"/OrderListServlet");
		
	}

}
