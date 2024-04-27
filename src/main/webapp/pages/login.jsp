<%@page import="util.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<!-- <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/register.css"/>
</head>
<body class="poppins-regular">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper" style="background-image: url('../images/background.png');">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<div class="form-holder">
			<form action="/BubblesandWhirls/LoginServlet" method="post">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">LOGIN FORM</h3>
			<% 
		    String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
		    if(errorMessage != null && !errorMessage.isEmpty()){
			%>
		    <p class="error-message"><%= errorMessage %></p>
			<%
		    }
			%>
			<% 
		    String successMessage = (String) request.getAttribute(StringUtils.SUCCESS_MESSAGE);
		    if(successMessage != null && !successMessage.isEmpty()){
			%>
		    <p class="success-message"><%= successMessage %></p>
			<%
		    }
			%>
			<div class="form-wrapper" style="margin-top:100px;">
					<label for="username"></label> <input type="text" id="username" name="user_name" placeholder="Username" required>
			</div>
			<div class="form-wrapper" style="margin-bottom:80px;">
					<label for="password"></label> <input type="password" id="password" name="password" placeholder="Password" required>
			</div>
			<button type="submit" class="poppins-semibold">Login</button>	
				<p style="text-align:center;">Don't have an account? <a href="register.jsp">Register</a></p>	
			</form>
			</div>
		</div>
	</div>	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>