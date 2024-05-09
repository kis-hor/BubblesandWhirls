<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/user-details.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
</head>
<body>			<jsp:include page="/pages/header.jsp"></jsp:include>
				    <div class="products-info">
			        <table class="products-table">
			            <thead>
			                <tr>
			                    <th>Image</th>
			                    <th>Product ID</th>
			                    <th>Name</th>
			                    <th>Price</th>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach var="result" items="${searchResultList}">
			                    <tr>
			                        <td><a href="${pageContext.request.contextPath}/ProductDetailServlet?productId=${result.productId}"><img src="${pageContext.request.contextPath}/resources/images/user/${result.productImageUrl}" alt="Product Image" style="width:100px; height:100px;"></a></td> 
			                        <td>${result.productId}</td>
			                        <td>${result.productName}</td>
			                        <td>Rs.${result.productPrice}</td>
			                        
			                        
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			    </div>
</body>
</html>