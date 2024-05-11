<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
</head>
<body>
<jsp:include page="/pages/header.jsp"></jsp:include>
	<form action="/BubblesandWhirls/SearchServlet" method="post">
	<div class="form-holder">
		<div class="form-wrapper">
		
					<label for="search"></label> <input type="text" id="search" name="product_name" placeholder="Search for products" required>	
		</div>
		<button type="submit" class="poppins-semibold">Search</button>	
	</div>
	</form>
</body>
</html>