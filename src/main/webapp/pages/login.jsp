<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/login.css"/>
</head>
<body>
	<h1>Login Form</h1>
	
	<form action="../LoginServlet" method="post">
		<label for="username">Username:</label> <input type="text" id="username" name="username" required>
		<label for="password">Password:</label> <input type="password"	id="password" name="password" required>
		<button type="submit">Login</button>		
	</form>
</body>
</html>