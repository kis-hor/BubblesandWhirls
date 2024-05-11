package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import util.StringUtils;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DBController databaseController;

    public ModifyServlet() {
        this.databaseController = new DBController();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateProductId = request.getParameter(StringUtils.UPDATE_ID);
        String deleteProductId = request.getParameter(StringUtils.DELETE_ID);

        if (updateProductId != null && !updateProductId.isEmpty()) {
            request.getRequestDispatcher("/ProductUpdateServlet").forward(request,response);
            return; // Exit the method after forwarding
        }
        if (deleteProductId != null && !deleteProductId.isEmpty()) {
            doDelete(request, response);
            return; // Exit the method after performing the delete operation
        }

        String updateUserId = request.getParameter(StringUtils.UPDATE_USER_ID);
        String deleteUserId = request.getParameter(StringUtils.DELETE_USER_ID);

        if (updateUserId != null && !updateUserId.isEmpty()) {
            request.getRequestDispatcher("/UserUpdateServlet").forward(request,response);
            return; // Exit the method after forwarding
        }
        if (deleteUserId != null && !deleteUserId.isEmpty()) {
            doDelete(request, response);
            return; // Exit the method after performing the delete operation
        }

        String deleteCartIdString = request.getParameter("deleteCartId");
        if (deleteCartIdString != null && !deleteCartIdString.isEmpty()) {
            int deleteCartId = Integer.parseInt(deleteCartIdString);
            if (deleteCartId != 0) {
                if (databaseController.deleteCart(deleteCartId) == 1) {
                    response.sendRedirect(request.getContextPath() + "/DisplayServlet");
                } else {
                    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_DELETE);
                    response.sendRedirect(request.getContextPath() + StringUtils.USER_LIST_SERVLET);
                }
                return; // Exit the method after performing the delete operation
            }
        }

        // Handle other operations if needed
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteProductId = req.getParameter(StringUtils.DELETE_ID);
        String deleteUserId = req.getParameter(StringUtils.DELETE_USER_ID);

        if (deleteProductId != null && !deleteProductId.isEmpty()) {
            if (databaseController.deleteProductInfo(deleteProductId) == 1) {
                resp.sendRedirect(req.getContextPath() + StringUtils.PRODUCT_LIST_SERVLET);
            } else {
                req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_DELETE);
                resp.sendRedirect(req.getContextPath() + StringUtils.PRODUCT_LIST_SERVLET);
            }
        } else if (deleteUserId != null && !deleteUserId.isEmpty()) {
            if (databaseController.deleteUserInfo(deleteUserId) == 1) {
                resp.sendRedirect(req.getContextPath() + StringUtils.USER_LIST_SERVLET);
            } else {
                req.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.MESSAGE_ERROR_DELETE);
                resp.sendRedirect(req.getContextPath() + StringUtils.USER_LIST_SERVLET);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid delete operation");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put triggered");
    }
}
