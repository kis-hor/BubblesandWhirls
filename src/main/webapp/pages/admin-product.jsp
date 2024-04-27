<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/> -->
</head>
<body class="poppins-regular">
	<h1>Welcome to product page of Admin Panel</h1>
	<div class="products-info">
		<div class="products">
			<c:forEach var="product" items="${productList}">
				<div class="card">
					<img src ="${pageContext.request.contextPath}/resources/images/user/${product.productImageUrl}"/>
					<div class="card-body">
						<h4 class="card-title">${product.productName}</h4>
						<h4 class="card-title">Rs.${product.productPrice}</h4>
						<h5 class="card-text">Available: ${product.productInventory} pcs</h5>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/ModifyServlet">
						<input type="hidden" name="updateId" value="${product.productId}" />
						<button type="submit">Update</button>
					</form>
					<form id="deleteForm-${product.productId}" method="post"
						action="${pageContext.request.contextPath}/ModifyServlet">
						<input type="hidden" name="deleteId" value="${product.productId}" />
						<button type="button"
							onclick="confirmDelete('${product.productId}')">Delete</button>
					</form>
				</div>
				
			</c:forEach>
		
		</div>
	</div>
</body>

		<script>
			function confirmDelete(productName) {
				if (confirm("Are you sure you want to delete this product: " + productName
						+ "?")) {
					document.getElementById("deleteForm-" + productName).submit();
				}
			}
		</script>
</html>