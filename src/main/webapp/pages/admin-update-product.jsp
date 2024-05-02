<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
</head>
<body class="poppins-regular">
		<jsp:include page="admin-sidenav.jsp"></jsp:include>
		<div class="main-panel">
		<div class="inner">
			<div class="image-holder">
				<img src=>
			</div>
			<div class="form-holder">
			<form action="/BubblesandWhirls/ProductUpdateServlet" enctype="multipart/form-data" method="post">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">UPDATE PRODUCT</h3>

				<div class="form-wrapper">
					<label for="productName"></label> <input type="text" id="productName" name="product_name" placeholder="Product Name" value="${product.productName}" required>
				</div>
				<div class="form-wrapper">
					<label for="productPrice"></label> <input type="text" id="productPrice" name="product_price" placeholder="Product Price" value="${product.productPrice}" required>	
				</div>
				<div class="form-wrapper">
					<label for="productDescription"></label> <textarea style="border:none; border-bottom: 1px solid black; margin-bottom:25px" class="poppins-regular" rows="3" cols="57" name="product_description" placeholder="Product Description" required>${product.productDescription}</textarea>
				</div>
				<div class="form-wrapper">
					<label for="productInventory"></label> <input type="text" id="productInventory" name="inventory" placeholder="Product Inventory" value="${product.productInventory}"required>
				</div>
				<div class="form-wrapper">
					<label for="productCategory"></label> <input type="text" id="productCategory" name="product_category" placeholder="Product Category" value="${product.productCategory}" required>
				</div>
				<div class="form-wrapper">
				<label for="image">Product Image</label> <input type="file" id="image" name="image">
				</div>
				<!-- add hidden wala -->
				 <input type="hidden" name="product_id" value="${product.productId}" />
				
		
				<a href="${pageContext.request.contextPath}/pages/admin-product.jsp"><button type="submit" class="poppins-semibold">Update Product</button></a>
					
			</form>
			</div>
		</div>
	</div>
	
</body>
</html>