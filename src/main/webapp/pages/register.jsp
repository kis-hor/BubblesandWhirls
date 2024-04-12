<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="/BubblesandWhirls/RegisterServlet" method="post">
		<label for="firstName">First Name:</label> <input type="text" id="firstName" name="firstName" required>
		<label for="lastName">Last Name:</label> <input type="text" id="lastName" name="lastName" required>
		<label for="username">Username:</label> <input type="text" id="username" name="username" required>
		<label for="email">Email:</label> <input type="email" id="email" name="email" required>
		<label for="phoneNumber">Phone Number:</label> <input type="tel" id="phoneNumber" name="phoneNumber" required>
		<label for="password">Password:</label> <input type="password"	id="password" name="password" required>
		<label for="retypePassword">Retype Password:</label> <input	type="password" id="retypePassword" name="retypePassword" required>
		<button type="submit">Register</button>		
	</form>
</body>
</html>