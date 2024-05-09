package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;

import controller.database.DBController;
import model.ProductModel;
import util.StringUtils;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ProductUpdateServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController dbController = new DBController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		System.out.println("Getting product info");
		String productId = request.getParameter("updateId");
		ProductModel product = dbController.getProductInfo(productId);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("/pages/admin-update-product.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Updating product");
		
		String productName = request.getParameter(StringUtils.PRODUCT_NAME);
		String productPrice = request.getParameter(StringUtils.PRODUCT_PRICE);
		String productDescription = request.getParameter(StringUtils.PRODUCT_DESCRIPTION);
		String productInventory = request.getParameter(StringUtils.PRODUCT_INVENTORY);
		String productCategory = request.getParameter(StringUtils.PRODUCT_CATEGORY);
		String productId = request.getParameter(StringUtils.PRODUCT_ID);
		
//		System.out.println(""+productName+" "+ productPrice+" "+productDescription+" "+ productInventory+" "+productCategory);
		
		ProductModel productModel = new ProductModel();
		
		productModel.setProductName(productName);
		productModel.setProductPrice(Integer.parseInt(productPrice));
		productModel.setProductDescription(productDescription);
		productModel.setProductInventory(Integer.parseInt(productInventory));
		productModel.setProductCategory(productCategory);
		productModel.setProductId(Integer.parseInt(productId));
		
		int result = dbController.updateProductInfo(productModel);
		System.out.println(""+result);
		response.sendRedirect(request.getContextPath()+"/ProductListServlet");
		
	//
		
		
	}

}
