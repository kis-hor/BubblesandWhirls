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
				System.out.println("Running Filter in" + uri);
				
				// Immediately allows requests for CSS files and the index page to pass
				// through without further checks.
				// If you want other files to directly open, include them in this
				// condition
				if (uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".webp") ) {
			        chain.doFilter(request, response);
			        return;
			    }
				
				if(uri.endsWith("/index.jsp") || uri.endsWith("/")) {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
//			        res.sendRedirect(req.getContextPath() + StringUtils.SERVLET_URL_HOME);
			        return;
		    	}
				
//				if(uri.endsWith("/index.jsp") || uri.endsWith("/")) {
//					request.getRequestDispatcher("").forward(request, response);
////			        res.sendRedirect(req.getContextPath() + StringUtils.SERVLET_URL_HOME);
//			        return;
//		    	}

				// Check if the requested URI indicates a login page (e.g., /login.jsp)
				boolean isLogin = uri.endsWith(StringUtils.LOGIN_PAGE);
				boolean isRegister = uri.endsWith(StringUtils.REGISTER_PAGE);
				
				// Check if the requested URI indicates a login servlet (e.g., /login)
				boolean isLoginServlet = uri.endsWith("/LoginServlet");

				// Check if the requested URI indicates a logout servlet (e.g., /logout)
				boolean isLogoutServlet = uri.endsWith("/LogoutServlet");
				boolean isRegisterServlet = uri.endsWith("/RegisterServlet");
				
//				boolean isAdminPanel = uri.endsWith("")
				// Attempt to retrieve the current session associated with the request.
				// If 'false' is passed as an argument and no session exists, it returns null.
				HttpSession session = req.getSession(false);

				// Check if a session exists and if the 'USERNAME' attribute is set in the
				// session.
				
				// If both conditions are true, it indicates that the user is logged in.
				boolean isLoggedIn = session != null && session.getAttribute(StringUtils.USER_NAME) != null;
				
				boolean isAdmin = session != null && session.getAttribute("role") == "admin";

				
				
				if(isAdmin) {
					
					
				}
				if (!isLoggedIn) {
				    // User is not logged in
				    if (!isLogin && !isLoginServlet && !isRegister && !isRegisterServlet) {
				        // Redirect to login page for unauthorized access attempts
				        res.sendRedirect(req.getContextPath() + "/pages/login.jsp");
				    } else {
				        // Allow access to login and register pages
				        chain.doFilter(request, response);
				    }
				} else {
					// Allow access to login page if user is trying to access it after logout
					if (uri.endsWith(StringUtils.LOGIN_PAGE) && !isLoggedIn && isLogoutServlet) {
					    chain.doFilter(request, response);
					    return;
					
				    } else if (isLogin || isLoginServlet || isRegister || isRegisterServlet) {
			    		res.sendRedirect(req.getContextPath() + "/index.jsp");
			    	} else {
			        // User is logged in and not trying to logout or access register, allow access to other pages
			        chain.doFilter(request, response);
			    	}
				}
	
				}
				
				

			

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}