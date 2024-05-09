<%@page import="util.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
</head>
<body class="poppins-regular">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper" style="background-image: url('../images/background.png');">
		<div class="inner">
			<div class="image-holder">
				<img src="${pageContext.request.contextPath}/images/image-holder.png">
			</div>
			<div class="form-holder">
			<form action="/BubblesandWhirls/RegisterServlet" method="post"  enctype="multipart/form-data">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">REGISTRATION FORM</h3>
			<% 
		    String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
		    if(errorMessage != null && !errorMessage.isEmpty()){
			%>
		    <p class="error-message"><%= errorMessage %></p>
			<%
		    }
			%>
				<div class="form-group">
					<label for="firstName"></label> <input type="text" id="firstName" name="first_name" placeholder="First Name" required style="margin-left:0px;" >
					<label for="lastName"></label> <input type="text" id="lastName" name="last_name" placeholder="Last Name" required>
				</div>
				<div class="form-wrapper">
					<label for="username"></label> <input type="text" id="username" name="user_name" placeholder="Username" required>	
				</div>
				<div class="form-wrapper">
					<label for="email"></label> <input type="email" id="email" name="email" placeholder="Email" required>
				</div>
				<div class="form-wrapper">
					<label for="phoneNumber"></label> <input type="tel" id="phoneNumber" name="phone_number" placeholder="Phone Number" required>
				</div>
				<div class="form-wrapper">
					<label for="password"></label> <input type="password"	id="password" name="password" placeholder="Password" required>
				</div>
				<div class="form-wrapper">
					<label for="retypePassword"></label> <input	type="password" id="retypePassword" name="retype_password" placeholder="Retype Password" required>
				</div>
				<div class="form-wrapper">
					<label for="image">User Image</label> <input type="file" id="image" name="image">
				</div>
				
		
				<button type="submit" class="poppins-semibold">Register</button>	
				<p style="text-align:center;">Already have an account? <a href="login.jsp">Log in</a></p>	
			</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>