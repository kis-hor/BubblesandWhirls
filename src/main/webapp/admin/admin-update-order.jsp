<%@page import="model.OrderModel"%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="poppins-regular">
	

<jsp:include page="admin-sidenav.jsp"></jsp:include>

	<div class="main-panel">
		
		<h1>All Order Details</h1>
		<div class="order-details">
			<div class="details">
				
				<label>Order ID:</label>
				<span>${order.orderId}</span>
			</div>
			<div class="details">
				<label>Order Date:</label>
				<span>${order.orderDate}</span>
			</div>
			<div class="details">
				<label>Ordered By:</label>
				<span>${order.username}</span>
			</div>
			<div class="details">
				<label>Customer Email Address:</label>
				<span>${order.email}</span>
			</div>
			<div class="details">
				<label>Order Total:</label>
				<span>${order.orderTotal}</span>
			</div>
			<div class="details">
				<label>Ordered Product ID:</label>
				<span>${order.productId}</span>
			</div>
			<div class="details">
				<label>Ordered Product Name:</label>
				<span>${order.productName}</span>
			</div>
			<div class="details">
				<label>Ordered Product Price:</label>
				<span>${order.productPrice}</span>
			</div>
			<div class="details">
				<label>Ordered Product Image:</label>
				<img src ="${pageContext.request.contextPath}/resources/images/user/${order.productImageUrl}"/>
			</div>
		</div>
		<form action="/BubblesandWhirls/OrderUpdateServlet" enctype="multipart/form-data" method="post">
		<div class="form-wrapper">
		<input type="hidden" name="order_id" value="${order.orderId}">
			<label for="deliveryStatus">Delivery Status</label>
				<select id="status" name="delivery_status" required>
				    <option value="delivered" ${order.deliveryStatus == 'Delivered' ? 'selected' : ''}>Delivered</option>
				    <option value="not delivered" ${order.deliveryStatus == 'Not Delivered' ? 'selected' : ''}>Not Delivered</option>
				</select>

		<!--  <input type="text" id="deliveryStatus" name="delivery_status" placeholder="Delivery Status" value="${order.deliveryStatus}" required>-->	
		</div>
		<div class="form-wrapper">
		    <label for="orderStatus">Order Status</label>
		    <select id="status" name="order_status" required>
		        <option value="pending" ${order.orderStatus == 'Pending' ? 'selected' : ''}>Pending</option>
		        <option value="paid" ${order.orderStatus == 'Paid' ? 'selected' : ''}>Paid</option>
		        <option value="failed" ${order.orderStatus == 'Failed' ? 'selected' : ''}>Failed</option>
		    </select>
			</div>

		<a href="${pageContext.request.contextPath}/pages/admin-orders.jsp"><button type="submit" class="poppins-semibold">Update Product</button></a>
	</form>
	</div>
</body >
</html>