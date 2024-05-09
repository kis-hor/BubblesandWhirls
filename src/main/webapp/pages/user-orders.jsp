<%@page import="model.OrderModel"%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
</head>
<body class="poppins-regular">
	<div class="user-container">
    	<jsp:include page="user-sidenav.jsp"></jsp:include>
       
        
        <div class="main-panel">
         <h1>My Orders</h1>
        <div class="products-info">
        			<c:if test="${empty userOrderList}">
						<p>No Order found.</p>
					</c:if>
					<c:if test="${not empty userOrderList}">
			        <table class="products-table">
			        
			            <thead>
			                <tr>
			                	<th>Order Product Image</th>
			                    <th>Order ID</th>
			                    <th>Order Date</th>
			                    <th>Product ID</th>
			                    <th>Product Name</th>
			                    <th>Order Total</th>
			                    <th>Delivery Status</th>
			                    <th>Order Status</th>
			                </tr>
			            </thead>
			            <tbody>
			            	
							
			            	<c:forEach var="userOrder" items="${userOrderList}">
			                    <tr>
			                        <td><img src ="${pageContext.request.contextPath}/resources/images/user/${userOrder.productImageUrl}" style="width:100px; height:100px;"></td>
			                        <td>${userOrder.orderId}</td>
			                        <td>${userOrder.orderDate}</td>
			                        <td>${userOrder.productId} </td>
			                        <td>${userOrder.productName} </td>
			                        <td>Rs. ${userOrder.orderTotal} </td>
			                        <td>${userOrder.deliveryStatus} </td>
			                        <td>${userOrder.orderStatus} </td>
			                    </tr>
			                </c:forEach>
			              
						</tbody>
						
					</table>
			            
          </c:if>
     	</div>
     	</div>
     	</div>
</html>