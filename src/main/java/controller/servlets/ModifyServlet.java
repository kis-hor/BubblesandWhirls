package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import util.StringUtils;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DBController databaseController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        this.databaseController = new DBController();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateProductId = request.getParameter(StringUtils.UPDATE_ID);
		String deleteProductId = request.getParameter(StringUtils.DELETE_ID);

		if (updateProductId != null && !updateProductId.isEmpty()) {
			request.getRequestDispatcher("/ProductUpdateServlet").forward(request,response);
		}
		if (deleteProductId != null && !deleteProductId.isEmpty()) {
			doDelete(request, response);
		}
		
		String updateUserId = request.getParameter(StringUtils.UPDATE_USER_ID);
		String deleteUserId = request.getParameter(StringUtils.DELETE_USER_ID);

		if (updateUserId != null && !updateUserId.isEmpty()) {
			request.getRequestDispatcher("/UserUpdateServlet").forward(request,response);
		}
		if (deleteUserId != null && !deleteUserId.isEmpty()) {
			doDelete(request, response);
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put triggered");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String deleteProductId = req.getParameter(StringUtils.DELETE_ID);
	    String deleteUserId = req.getParameter(StringUtils.DELETE_USER_ID);
	    

	    if (deleteProductId != null && !deleteProductId.isEmpty()) {
	    	System.out.println("Delete product trigerred");
	        if (databaseController.deleteProductInfo(deleteProductId) == 1) {
	            resp.sendRedirect(req.getContextPath() + StringUtils.PRODUCT_LIST_SERVLET);
	        } else {
	            req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_DELETE);
	            resp.sendRedirect(req.getContextPath() + StringUtils.PRODUCT_LIST_SERVLET);
	        }
	    } else if (deleteUserId != null && !deleteUserId.isEmpty()) {
	    	System.out.println("Delete user trigerred");
	        if (databaseController.deleteUserInfo(deleteUserId) == 1) {
	            resp.sendRedirect(req.getContextPath() + StringUtils.USER_LIST_SERVLET);
	        } else {
	            req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_DELETE);
	            resp.sendRedirect(req.getContextPath() + StringUtils.USER_LIST_SERVLET);
	        }
	    } else {
	        // Handle invalid or missing delete ID parameter
	        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing delete ID parameter");
	    }
	}
}
