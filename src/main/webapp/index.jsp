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
        bottom: 20px; /* Slightly above the bottom */
        left: 50%;

        text-align: center; /* Center the content horizontally */
        color: white; /* Text color */
        padding: 20px; /* Add padding for better spacing */
        background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent background */
    }

    .hero-description h5,
    .hero-description h2,
    .hero-description button {
        margin: 0;
    }

    .hero-description button {
        margin-top: 20px; /* Adjust vertical spacing as needed */
    }

    .fade-overlay {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.7)); /* Black fade effect */
    }
</style>
</head>
<body class="poppins-regular">
    <div class="hero-section">
        <div class="hero-image">
            <img src="${pageContext.request.contextPath}/images/hero.png">
             <div class="fade-overlay"></div>
            <div class="hero-description">
                <h6>Bubbles & Whirls</h6>
                <h2>Elevate cleanliness</h2>
                <a href="${pageContext.request.contextPath}/pages/product.jsp"><button class="poppins-semibold">Shop Now</button></a>
            </div>
            
           
        </div>
    </div>
</body>
</html>

