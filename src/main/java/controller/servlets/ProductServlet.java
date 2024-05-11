	package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DBController;
import model.ProductModel;
import util.StringUtils;

/**
 * Servlet implementation class ProductServlet
 */

@WebServlet(asyncSupported = true, urlPatterns = {"/ProductServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBController dbController = new DBController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter printOut = response.getWriter();
		
//		String productId = request.getParameter(StringUtils.PRODUCT_ID);
		String productName = request.getParameter(StringUtils.PRODUCT_NAME);
		String productPrice = request.getParameter(StringUtils.PRODUCT_PRICE);
		String productDescription = request.getParameter(StringUtils.PRODUCT_DESCRIPTION);
		String productInventory = request.getParameter(StringUtils.PRODUCT_INVENTORY);
		String productCategory = request.getParameter(StringUtils.PRODUCT_CATEGORY);
		Part imagePart = request.getPart("image");
		
		// Adjust the parameter types to match the ProductModel constructor
		ProductModel productModel = new ProductModel(productName, imagePart, Integer.parseInt(productPrice), productDescription, Integer.parseInt(productInventory),productCategory);

		
		String savePath = StringUtils.IMAGE_DIR_SAVE_PATH;
	    String fileName = productModel.getProductImageUrl();
	    
	    System.out.println(savePath);
	    System.out.println(fileName);
	    if(!fileName.isEmpty() && fileName != null) {
    		imagePart.write(savePath + fileName);
	    	System.out.println(imagePart);
	    }
	    int result = dbController.addProduct(productModel);
	    System.out.println("Result="+result);
	    if(result == 1) {
	    response.sendRedirect(request.getContextPath() + StringUtils.PRODUCT_LIST_SERVLET);
	    }else {
	    	
	    }
	}
	

}
