<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/register.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body class="poppins-regular">
	<div class="wrapper" style="background-image: url('images/bg-registration-form-1.jpg');">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<form action="/BubblesandWhirls/RegisterServlet" method="post">
			<h3 class="poppins-semibold">REGISTRATION FORM</h3>
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