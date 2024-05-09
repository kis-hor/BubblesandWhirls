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
		
		System.out.println("Getting all products");
		List<ProductModel> productList = dbController.getAllProductsInfo();
		request.setAttribute("productList",productList);
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		boolean isAdmin = session != null && session.getAttribute("role") == "admin";
		
//		String uri = req.getRequestURI();
		
//		if(isAdmin) {
			request.getRequestDispatcher(StringUtils.ADMIN_PRODUCT_PAGE).forward(request, response);	
//		}else {
//			
//			request.getRequestDispatcher(StringUtils.USER_PRODUCT_PAGE).forward(request, response);			
//		}
		
		
		
//		if(isAdmin) {
//			request.getRequestDispatcher(StringUtils.ADMIN_PRODUCT_PAGE).forward(request, response);	
//		}else if(uri.endsWith("/index.jsp")) {
//			request.getRequestDispatcher(StringUtils.USER_PRODUCT_PAGE).forward(request, response);		
//				
//		}else if(uri.endsWith("/user")) {
//			request.getRequestDispatcher(StringUtils.USER_PRODUCT_PAGE).forward(request, response);		
//		}
//		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
