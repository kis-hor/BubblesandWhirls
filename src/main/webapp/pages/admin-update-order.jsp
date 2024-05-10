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
<title>All Order Details</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/update-order.css"/>
</head>
<body class="poppins-regular">
    <jsp:include page="admin-sidenav.jsp"></jsp:include>
    <div class="container">
        
        <div class="main-panel">
        <h1>All Order Details</h1>
        <table class="order-table">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Ordered By</th>
                <th>Customer Email Address</th>
                <th>Order Total</th>
                <th>Ordered Product ID</th>
                <th>Ordered Product Name</th>
                <th>Ordered Product Price</th>
                <th>Ordered Product Image</th>
                <th>Payment Option</th>
                <th>Shipping Address</th>
            </tr>
            <tr>
                <td>${order.orderId}</td>
                <td>${order.orderDate}</td>
                <td>${order.username}</td>
                <td>${order.email}</td>
                <td>${order.orderTotal}</td>
                <td>${order.productId}</td>
                <td>${order.productName}</td>
                <td>${order.productPrice}</td>
                 <td><img src="${pageContext.request.contextPath}/resources/images/user/${order.productImageUrl}" alt="Product Image"></td>
                <td>${order.paymentOption}</td>
                <td>${order.shippingAddress}</td>
              
            </tr>
        </table>
        <form action="${pageContext.request.contextPath}/OrderUpdateServlet" enctype="multipart/form-data" method="post">
            <input type="hidden" name="order_id" value="${order.orderId}">
            <div class="form-wrapper">
                <label for="deliveryStatus">Delivery Status</label>
                <select id="deliveryStatus" name="delivery_status" required>
                    <option value="delivered" ${order.deliveryStatus == 'Delivered' ? 'selected' : ''}>Delivered</option>
                    <option value="not delivered" ${order.deliveryStatus == 'Not Delivered' ? 'selected' : ''}>Not Delivered</option>
                </select>
            </div>
            <div class="form-wrapper">
                <label for="orderStatus">Order Status</label>
                <select id="orderStatus" name="order_status" required>
                    <option value="pending" ${order.orderStatus == 'Pending' ? 'selected' : ''}>Pending</option>
                    <option value="paid" ${order.orderStatus == 'Paid' ? 'selected' : ''}>Paid</option>
                    <option value="failed" ${order.orderStatus == 'Failed' ? 'selected' : ''}>Failed</option>
                </select>
            </div>
            <button type="submit" class="poppins-semibold">Update Order</button>
        </form>
    </div>
    </div>
</body>
</html>
