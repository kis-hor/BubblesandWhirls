<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="poppins-regular">
<jsp:include page="header.jsp"></jsp:include>
	<h1>Welcome to product page of Admin Panel</h1>
	<div class="products-info">
		<div class="products">
			<c:forEach var="product" items="${productList}">
				<div class="card">
					<img src ="${pageContext.request.contextPath}/resources/images/user/${product.productImageUrl}" style="width:200px; height:200px"/>
					<div class="card-body">
						<h4 class="card-title">${product.productName}</h4>
						<h4 class="card-title">Rs.${product.productPrice}</h4>
						<h5 class="card-text">Available: ${product.productInventory} pcs</h5>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/CartServlet">
						<input type="hidden" name="" value="" />
						<button type="submit">Add to Cart</button>
					</form>
				</div>
				
			</c:forEach>
		
		</div>
	</div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>