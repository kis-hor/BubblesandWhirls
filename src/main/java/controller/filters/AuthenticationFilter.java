package controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// Cast the request and response to HttpServletRequest and HttpServletResponse
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res = (HttpServletResponse) response;

				// Get the requested URI
				String uri = req.getRequestURI();
//				System.out.println("Running Filter in" + uri);
				
				// Immediately allows requests for CSS files and the index page to pass
				// through without further checks.
				// If you want other files to directly open, include them in this
				// condition
				if (uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".webp") ) {
			        chain.doFilter(request, response);
			        return;
			    }
//				
////				if(uri.endsWith("/index.jsp") || uri.endsWith("/")) {
////					request.getRequestDispatcher("/index.jsp").forward(request, response);
//////			        res.sendRedirect(req.getContextPath() + StringUtils.SERVLET_URL_HOME);
////			        return;
////		    	}
//				if(uri.endsWith("/")) {
//					request.getRequestDispatcher("/index.jsp").forward(request, response);
//					return;
//		    	}

				// Check if the requested URI indicates a login page (e.g., /login.jsp)
				boolean isLogin = uri.endsWith(StringUtils.LOGIN_PAGE);
				boolean isRegister = uri.endsWith(StringUtils.REGISTER_PAGE);// Check if the requested URI indicates a login servlet (e.g., /login)
						
				boolean isLoginServlet = uri.endsWith("/LoginServlet");

				// Check if the requested URI indicates a logout servlet (e.g., /logout)
				boolean isLogoutServlet = uri.endsWith("/LogoutServlet");
				boolean isRegisterServlet = uri.endsWith("/RegisterServlet");
				
				//User Pages
				boolean isUserHeader = uri.endsWith("/pages/header.jsp");
				boolean isUserFooter = uri.endsWith("/pages/footer.jsp");
				boolean isUserProduct = uri.endsWith("/pages/product.jsp");
				boolean isUserWelcome = uri.endsWith("/pages/welcome.jsp");
				boolean isUserCart = uri.endsWith("/pages/cart.jsp");
				boolean isUserCheckout = uri.endsWith("/pages/checkout.jsp");
				boolean isUserProductDescription = uri.endsWith("/pages/product-description.jsp");
				boolean isUserSearch = uri.endsWith("/pages/search.jsp");
				boolean isUserSearchResult = uri.endsWith("/pages/search-result.jsp");
				boolean isUserOrders = uri.endsWith("/pages/user-orders.jsp");
				boolean isUserProfile = uri.endsWith("/pages/user-profile.jsp");
				boolean isUserSideNav = uri.endsWith("/pages/user-sidenav.jsp");
				boolean isUserUpdateProfile = uri.endsWith("/pages/user-update-profile.jsp");
				
				// Admin Pages
				boolean isAddProduct = uri.endsWith("/admin/add-product.jsp");
				boolean isAdminProduct = uri.endsWith("/admin/admin-product.jsp");
				boolean isAdminUpdateProduct = uri.endsWith("/admin/admin-update-product.jsp");
				boolean isAdminSideNav = uri.endsWith("/admin/admin-sidenav.jsp");
				boolean isDashboard = uri.endsWith("/admin/dashboard.jsp");
				boolean isAdminUserProfile = uri.endsWith("/admin/user-profile.jsp");
				boolean isAdminOrder = uri.endsWith("/admin/admin-orders.jsp");
				boolean isAdminOrderUpdate = uri.endsWith("/admin/admin-update-order.jsp");
				boolean isAdminUsers = uri.endsWith("/admin/admin-users.jsp");			
				
//				boolean isAdminPanel = uri.endsWith("")
				// Attempt to retrieve the current session associated with the request.
				// If 'false' is passed as an argument and no session exists, it returns null.
				HttpSession session = req.getSession(false);

				// Check if a session exists and if the 'USERNAME' attribute is set in the
				// session.
				
				// If both conditions are true, it indicates that the user is logged in.
				boolean isLoggedIn = session != null && session.getAttribute(StringUtils.USER_NAME) != null;
				
				boolean isAdmin = session != null && session.getAttribute("role") == "admin";
				boolean isUser = session != null && session.getAttribute("role") == "user";
//				System.out.println("Admin or User" + isUser);
				

				// If the user is logged in, redirect away from login and register pages
				if (isLoggedIn && isAdmin) {
				    if (isLogin || isRegister || isLoginServlet || isRegisterServlet || uri.endsWith("/index.jsp")
				    	|| isUserHeader || isUserFooter || isUserProduct || isUserWelcome || isUserCart || isUserCheckout
				    	|| isUserProductDescription || isUserSearch || isUserSearchResult || isUserOrders || isUserProfile || isUserSideNav 
				    	|| isUserUpdateProfile) {
				        res.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
				        return;
				    }
				}

				// If the user is logged in as a regular user, redirect away from login, register, admin, and dashboard pages
				if (isLoggedIn && isUser) {
				    if (isLogin || isRegister || isLoginServlet || isRegisterServlet || uri.endsWith("/admin/dashboard.jsp") || uri.endsWith("/") || isAddProduct 
				    	|| isAdminProduct || isAdminUpdateProduct || isAdminSideNav || isDashboard || isAdminUserProfile 
				    	|| isUserHeader || isUserFooter || isAdminOrder || isAdminOrderUpdate || isAdminUsers ) {
				        res.sendRedirect(req.getContextPath() + "/index.jsp");
				        return;
				    }
				}
				
				// If the user is not logged in, redirect to login page for unauthorized access attempts
				if (!isLoggedIn && !isLogin && !isRegister && !isLoginServlet && !isRegisterServlet) {
				    // Allow access to index.jsp
					if (uri.endsWith("/index.jsp") || uri.endsWith("/pages/product.jsp") ||  uri.endsWith("/ProductListServlet") || uri.endsWith("/pages/about-us.jsp") ) {
				        chain.doFilter(request, response);
				        return;
				    }
				    // Redirect to login for other unauthorized attempts
				    else {
				        res.sendRedirect(req.getContextPath() + "/pages/login.jsp");
				        return;
				    }
				}

				// Allow access to other pages
				chain.doFilter(request, response);
	
			}	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}