<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/product.css"/>
<style>
        body, html {
        height: 100%;
        margin: 0;
    }

    .hero-section {
    position: relative;
    height: 70vh; /* 70% of the viewport height */
    overflow: hidden; /* Hide overflow content */
}

.hero-image {
    position: relative;
    width: 100%;
    height: auto;
}

.hero-description {
    position: absolute;
    top: 50%; /* Position from the top */
    left: 50%; /* Position horizontally centered */
    transform: translate(-50%, -50%); /* Move back 50% of its own width and height */
    z-index: 1; /* Ensure it appears above the image */
    text-align: center; /* Center the content horizontally */
    color: white; /* Text color */
    padding: 20px; /* Add padding for better spacing */
    /*background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent background */
}

.fade-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.7)); /* Black fade effect */
}


    .hero-description button {
        margin-top: 20px; /* Adjust vertical spacing as needed */
        margin-left:30px;
    }
    

</style>
</head>
<body class="poppins-regular">
    <jsp:include page="/pages/header.jsp"></jsp:include>
    <div class="hero-section">
        <div class="hero-description">
            <h4>Bubbles & Whirls</h4>
            <h2>Elevate cleanliness!</h2>
            <a href="${pageContext.request.contextPath}/ProductListServlet"><button class="poppins-semibold">Shop Now</button></a>
        </div>
        <div class="hero-image">
            <img src="${pageContext.request.contextPath}/images/hero.png">
            <div class="fade-overlay"></div>
        </div>
    </div>
    
    	<h1 style="padding-left:50px;">Our Products</h1>
		<div class="products-info">
		<div class="products">
			<c:forEach var="product" items="${productList}">
				<div class="card">
					
					<div class="card-body">
						<a href="${pageContext.request.contextPath}/ProductDetailServlet?productId=${product.productId}"><img src ="${pageContext.request.contextPath}/resources/images/user/${product.productImageUrl}" style="width:200px; height:200px"/></a>
						<h4 class="card-title">${product.productName}</h4>
						<h4 class="card-title">Rs.${product.productPrice}</h4>
						<h5 class="card-text">Available: ${product.productInventory} pcs</h5>
					
					<form method="post"
						action="${pageContext.request.contextPath}/CartServlet">
						<input type="hidden" name="" value="" />
						<button class="poppins-semibold" type="submit">Add to Cart</button>
					</form>
				</div>
				</div>
				
			</c:forEach>
		
		</div>
	</div>
</body>

</html>

