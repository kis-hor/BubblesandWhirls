<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body class="poppins-regular">
		<div class="admin-container">
			<jsp:include page="admin-sidenav.jsp"></jsp:include>
			<div class="main-panel">
			    <h1>All Orders</h1>
			    <div class="products-info">
			        <table class="products-table">
			            <thead>
			                <tr>
			                    <th>Order ID</th>
			                    <th>Order Date</th>
			                    <th>Username</th>
			                    <th>User Email</th>
			                    <th>Order Total</th>
			                    <th>Delivery Status</th>
			                    <th>Order Status</th>
			                    <th>No. of Items</th>
			                    <th>Update Order</th>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach var="order" items="${orderList}">
			                    <tr>
			                        <td>${order.orderId}</td>
			                        <td>${order.orderDate}</td>
			                        <td>${order.username}</td>
			                        <td>${order.email} </td>
			                        <td>Rs. ${order.orderTotal} </td>
			                        <td>${order.deliveryStatus} </td>
			                        <td>${order.orderStatus} </td>
			                        <td>${order.orderQuantity} items </td>
			                        <td>
			                            <form method="post" action="${pageContext.request.contextPath}/ModifyServlet">
			                                <input type="hidden" name="updateId" value="${order.orderId}" />
			                                <a href="${pageContext.request.contextPath}/OrderUpdateServlet?updateId=${order.orderId}"><img src="/BubblesandWhirls/images/update.png"></a>
			                            </form>
			                       
			                       	</td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			    </div>
			</div>

		</div>
	
</body>
</html>