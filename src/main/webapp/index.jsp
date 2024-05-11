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
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/footer.css"/>

<%
    // Get the session and request objects
    String contextPath = request.getContextPath();
%>
<style>
   .red-container, .blue-container, .third-container{
    display: flex;
    justify-content: center;
    align-items: center;
    height: auto;
    width: 100%;
    position: relative;
  }

  .hero-image, .hero-image2 {
    width: 100%;
    height: auto;
    object-fit: contain;
  }

  .text-container {
    position: absolute;
    top: 80%;
    transform: translateY(-50%);
    text-align: center;
    color: #ffffff;
    z-index: 1;
  }

  .brand-name {
    font-size: 16px;
    margin-bottom: 10px;
    color: #004E4E;
  }

  .slogan {
    font-size: 24px;
    color: #004E4E;
    font-weight: bold;
  }

  .button {
    padding: 10px 30px;
    background-color: #ffffff;
    color: #004E4E;
    border: none;
    border-radius: 35px;
    font-size: 18px;
    cursor: pointer;
    margin-top: 20px;
    
  }
  .button-container {
    margin-top: 20px;
    margin-left: 40px;
  }
  
  .blue-container {
    margin: 20px 0; /* Add margin only to the blue container */
  }

  .blue-container img {
    max-width: 60%; /* Adjust the width of the blue container image */
    height: auto;
    object-fit: contain;
    background-color: #808080;
  }
  .third-container {
    margin-top: 20px;
    margin-bottom: 200px;
    text-align: center;
}

.third-container .text-container {
    color: #ffffff;
}

   .third-container .brand-name {
    font-size: 16px;
    margin-bottom: 10px;
    color: black;
}
  .buttont {
  	 padding: 10px 10px;
    background-color: #004E4E;
    color: #fffff;
    border: none;
    border-radius: 35px;
    font-size: 18px;
    cursor: pointer;
    margin-top: 20px;
}

.third-container .slogan {
    font-size: 24px;
    color: black;
    font-weight: bold;
}

.third-container .button-container {
    margin-top: 20px;
}
  
</style>
</head>
<body class="poppins-regular">
    <jsp:include page="/pages/header.jsp"></jsp:include>
   	<div class="red-container">
    <div class="text-container">
        <div class="brand-name">Bubbles & Whirls</div>
        <div class="slogan">Elevate Cleanliness</div>
        <div class="button-container">
            <a href="/BubblesandWhirls/ProductListServlet" style="text-decoration:none;"><button class="button">Shop Now</button></a>
        </div>
    </div>
    <img src="${pageContext.request.contextPath}/resources/images/hero-section-1.jpg" alt="Hero Image" class="hero-image">
</div>

<div class="blue-container">
    <img src="${pageContext.request.contextPath}/resources/images/hero-section-2 .jpg" alt="Hero Image" class="hero-image2">
</div>

<div class="third-container">
    <div class="text-container">
        <div class="brand-name">Bubbles & Whirls</div>
        <div class="slogan">Contact Our Team!!</div>
        <div class="button-container">
            <a href="/pages/about-us.jsp"><button class="buttont">Go to About Us</button></a>
        </div>
    </div>
</div>
	<jsp:include page="/pages/footer.jsp"></jsp:include>
</body>

</html>