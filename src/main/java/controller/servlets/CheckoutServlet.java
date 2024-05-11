package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process any necessary data or validation here

        // Forward the request to the checkout JSP page
    	
    	int total = Integer.parseInt(request.getParameter("total"));
//        System.out.println(total);
        // Set the total as a request attribute
        request.setAttribute("total", total);
        
        // Forward the request to the checkout JSP page
        request.getRequestDispatcher("/pages/checkout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process any form submissions or additional actions here
    	String totalPriceString = request.getParameter("total");
    	int total = Integer.parseInt(totalPriceString);
    	System.out.println(total);
        
        // You can process the total price here, such as saving it to the database
    	request.setAttribute("total", total);
        // Forward the request to the checkout JSP page
        request.getRequestDispatcher("/pages/checkout.jsp").forward(request, response);
    }
}