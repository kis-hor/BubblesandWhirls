<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/register.css"/>
</head>
<body>
	<div class="wrapper" style="background-image: url('images/bg-registration-form-1.jpg');">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<form action="/BubblesandWhirls/RegisterServlet" method="post">
			<h3>Registration Form</h3>
				<div class="form-group">
					<label for="firstName">First Name:</label> <input type="text" id="firstName" name="first_name" required>
					<label for="lastName">Last Name:</label> <input type="text" id="lastName" name="last_name" required>
				</div>
				<div class="form-wrapper">
					<label for="username">Username:</label> <input type="text" id="username" name="user_name" required>
				</div>
				<div class="form-wrapper">
					<label for="email">Email:</label> <input type="email" id="email" name="email" required>
				</div>
				<div class="form-wrapper">
					<label for="phoneNumber">Phone Number:</label> <input type="tel" id="phoneNumber" name="phone_number" required>
				</div>
				<div class="form-wrapper">
					<label for="password">Password:</label> <input type="password"	id="password" name="password" required>
				</div>
				<div class="form-wrapper">
					<label for="retypePassword">Retype Password:</label> <input	type="password" id="retypePassword" name="retype_password" required>
				</div>
				
		
				<button type="submit">Register</button>		
			</form>
		</div>
	</div>
</body>
</html>