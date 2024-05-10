<%@page import="util.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
    }
    .contact-form {
        background-color: #f4f4f4;
        padding: 20px;
        border-radius: 10px;
    }
    .contact-form label {
        display: block;
        margin-bottom: 10px;
    }
    .contact-form input[type="text"], .contact-form textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .contact-form input[type="submit"] {
        background-color: #4caf50;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }
    .contact-details {
        margin-top: 30px;
    }
</style>
</head>
<jsp:include page="header.jsp"></jsp:include> 
<body>
<div class="container">

    <h1>About Us</h1>
    <div class="contact-form">
    		<% 
		    String successMessage = (String) request.getAttribute(StringUtils.SUCCESS_MESSAGE);
		    if(successMessage != null && !successMessage.isEmpty()){
			%>
		    <p class="success-message"><%= successMessage %></p>
			<%
		    }
			%>
    
        <h2>Contact Us</h2>
        <form action="/BubblesandWhirls/ContactServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
            <label for="message">Message:</label>
            <textarea id="message" name="message" rows="4" required></textarea>
            <input type="submit" value="Submit">
        </form>
    </div>
    <div class="contact-details">
        <h2>Contact Details</h2>
        <p><strong>Address:</strong> Islington College, Kamalpokhari</p>
        <p><strong>Phone:</strong> +977 9812345678</p>
        <p><strong>Email:</strong> bubblesandwhirls@gmail.com</p>
    </div>
</div>
</body>
<jsp:include page="footer.jsp"></jsp:include> 
</html>
