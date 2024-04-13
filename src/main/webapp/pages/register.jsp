<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body class="poppins-regular">
	<div class="wrapper" style="background-image: url('../images/background.png');">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<div class="form-holder">
			<form action="/BubblesandWhirls/RegisterServlet" method="post">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">REGISTRATION FORM</h3>
				<div class="form-group">
					<label for="firstName"></label> <input type="text" id="firstName" name="first_name" placeholder="First Name" required style="margin-left:0px;">
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
				
		
				<button type="submit" class="poppins-semibold">Register</button>	
				<p style="text-align:center;">Already have an account? <a href="login.jsp">Log in</a></p>	
			</form>
			</div>
		</div>
	</div>
</body>
</html>