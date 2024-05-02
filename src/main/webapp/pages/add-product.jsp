<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body class="poppins-regular">
		<jsp:include page="admin-sidenav.jsp"></jsp:include>
		<div class="main-panel">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<div class="form-holder">
			<form action="/BubblesandWhirls/ProductServlet" enctype="multipart/form-data" method="post">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">ADD NEW PRODUCT</h3>
			<%-- <% 
		    String errorMessage = (String) request.getAttribute(StringUtils.ERROR_MESSAGE);
		    if(errorMessage != null && !errorMessage.isEmpty()){
			%>
		    <p class="error-message"><%= errorMessage %></p>
			<%
		    }
			%> --%>
				<div class="form-wrapper">
					<label for="productName"></label> <input type="text" id="productName" name="product_name" placeholder="Product Name" required>
				</div>
				<div class="form-wrapper">
					<label for="productPrice"></label> <input type="text" id="productPrice" name="product_price" placeholder="Product Price" required>	
				</div>
				<div class="form-wrapper">
					<label for="productDescription"></label> <textarea style="border:none; border-bottom: 1px solid black; margin-bottom:25px" class="poppins-regular" rows="3" cols="57" name="product_description" placeholder="Product Description" required></textarea>
				</div>
				<div class="form-wrapper">
					<label for="productInventory"></label> <input type="text" id="productInventory" name="inventory" placeholder="Product Inventory" required>
				</div>
				<div class="form-wrapper">
					<label for="productCategory"></label> <input type="text" id="productCategory" name="product_category" placeholder="Product Category" required>
				</div>
				<div class="form-wrapper">
				<label for="image">Product Image</label> <input type="file" id="image" name="image">
				</div>
		
				<a href="${pageContext.request.contextPath}/pages/admin-product.jsp"><button type="submit" class="poppins-semibold">Add Product</button></a>
					
			</form>
			</div>
		</div>
	</div>
	
</body>
</html>