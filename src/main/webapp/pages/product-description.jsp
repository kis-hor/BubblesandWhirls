<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
</head>
<body class="poppins-regular">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="wrapper" style="background-image: url('${pageContext.request.contextPath}/images/background.png');">
		<div class="inner">
			<div class="image-holder">
				 <img src="${pageContext.request.contextPath}/resources/images/user/${product.productImageUrl}" alt="Product Image" style="width: 450px; height: 600px;">
			</div>
			<div class="form-holder">
				<div class="product-details">
			        <c:if test="${empty product}">
			            <p>No product details available.</p>
			        </c:if>
			        <c:if test="${not empty product}">
			            <h1>${product.productName}</h1>
			           
			            <p>Price: Rs.${product.productPrice}</p>
			            <p>Description: ${product.productDescription}</p>
			            <p>Available: ${product.productInventory} pcs</p>
			            <form method="post" action="${pageContext.request.contextPath}/CartServlet">
			                <input type="hidden" name="productId" value="${product.productId}" />
			                <button type="submit">Add to Cart</button>
			            </form>
			        </c:if>
    			</div>
			</div>
		</div>
	</div>
    
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
