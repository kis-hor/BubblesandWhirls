<%@ page import="util.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>


<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute(StringUtils.USER_NAME);
    String currentUserRole = (String) userSession.getAttribute("role");
    String contextPath = request.getContextPath();
%>

<div id="header">
    <header class="header">
        <h1 class="logo"><a href=""><img src="${pageContext.request.contextPath}/images/logo.png"/></a></h1>
        <ul class="main-nav" style="padding-left:200px;">
            <li><a href="index.jsp">HOME</a></li>
            <li><a href="/BubblesandWhirls/ProductListServlet">PRODUCTS</a></li>
            <li><a href="${pageContext.request.contextPath}/pages/about-us.jsp">ABOUT US</a></li>
            <li><a href="/BubblesandWhirls/OrderDetailServlet">ORDERS</a></li>
        </ul>
        <div class="login-signup" style="display: flex;align-items: center; margin-left: auto;">
            <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + "/LogoutServlet");
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                <input type="submit" style="font-size:16px;" class="poppins-regular" value="<%
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
        </div>
        <div class="icon-container">
           <a href="${pageContext.request.contextPath}/UserDetailServlet"><img src="${pageContext.request.contextPath}/images/Vector.png" alt="Icon 1"></a>
           	<a href="${pageContext.request.contextPath}/pages/search.jsp"><img src="${pageContext.request.contextPath}/images/search.png" alt="Icon 2"></a>
            
            <img src="${pageContext.request.contextPath}/images/shop.png" alt="Icon 3">
        </div>
    </header>
</div>