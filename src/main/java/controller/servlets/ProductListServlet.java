package controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.ProductModel;
import util.StringUtils;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController dbController = new DBController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		
		if ("user".equals(userRole)) {
			System.out.println("Getting all products");
			List<ProductModel> products = dbController.getAllProductsInfo();
			request.setAttribute("productList", products);
			request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
		} else if("admin".equals(userRole)) {
			List<ProductModel> products = dbController.getAllProductsInfo();
			request.setAttribute("productList", products);
			request.getRequestDispatcher("/admin/admin-product.jsp").forward(request, response);
		}else {
			System.out.println("Getting all products");
			List<ProductModel> products = dbController.getAllProductsInfo();
			request.setAttribute("productList", products);
			request.getRequestDispatcher("/pages/product.jsp").forward(request, response);
		}
		//if user role admin
		
		//else
		//		request.getRequestDispatcher(StringUtils.ADMIN_PRODUCT_PAGE).forward(request, response);
		
		
	}
	

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
