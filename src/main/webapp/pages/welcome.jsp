<%@page import="util.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
    // Get the session and request objects
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
        String cookieUsername  = null;
        String cookieSessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("user_role")) cookieUsername = cookie.getValue();
            }
        }
    %>
    <div class="welcome-container">
        <h1>Hello <%=cookieUsername %>. Welcome to our page!</h1>
        <a href="<%=contextPath %>/index.jsp">
            <button class="home-button">Continue to Home Page</button>
        </a>
    </div>
</body>
</html>