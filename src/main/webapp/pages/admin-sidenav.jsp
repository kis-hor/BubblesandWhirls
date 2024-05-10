<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="util.StringUtils" %>
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(StringUtils.USER_NAME);
    String currentUserRole = (String) userSession.getAttribute("role");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
</head>
<body class="poppins-regular">
	<nav class="side-panel">
    	<h2 style="color:#ffffff;">MENU</h2>
	    	<ul>
		        <li><a href="${pageContext.request.contextPath}/pages/dashboard.jsp">Dashboard<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/ProductListServlet">Products<img src="/BubblesandWhirls//images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/OrderListServlet">Orders<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/UserListServlet">Customers<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
	    	<li>
            <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + "/LogoutServlet");
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                <input type="submit" style="font-size:16px; margin-top:30px; margin-left:100px; border-radius:25px; padding:10px 20px;" class="poppins-regular" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print("LOGOUT");
                        } else {
                            out.print("LOGIN");
                        }
                    %>"/>
            </form>
            <% if (currentUser == null) { %>
                <form action="<%= contextPath %>/pages/register.jsp" method="post">
                    <input type="submit" value="SIGNUP" style="font-size:16px; padding-left:0px" class="poppins-regular">
                </form>
            <% } %>

        </li>
        </ul>
		</nav>
</body>
</html>