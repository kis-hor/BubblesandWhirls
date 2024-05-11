<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>

<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>

<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin-header.css"/>





</head>

<body class="poppins-regular">

	<div class="admin-container">

	

		<jsp:include page="admin-sidenav.jsp"></jsp:include>

		

		<div class="main-panel">

			<div class="data-panel">

				<div class="data-panel-row">

						<div class="data-panel-item">

							<div class="data-panel-icon">

								<img src="../images/revenue.png" alt="Dashboard Icon">

							</div>

							<h3>Total Revenue</h3>

							<h3>Rs.1000000</h3>

						</div>

						<div class="data-panel-item">

							<div class="data-panel-icon">

								<img src="../images/order.png" alt="Dashboard Icon">

							</div>

							<h3>Total Orders</h3>

							<h3>1780</h3>

						</div>

						<div class="data-panel-item">

							<div class="data-panel-icon">

								<img src="../images/users.png" alt="Dashboard Icon">

							</div>

							<h3>Total Customers</h3>

							<h3>387</h3>

						</div>

						<div class="data-panel-item">

							<div class="data-panel-icon">

								<img src="../images/fulfilled.png" alt="Dashboard Icon">

							</div>

							<h3>Fulfilled Orders</h3>

							<h3>1098</h3>

						</div>

					</div>

			</div>

			

			<div class="product-table">

				<a href="${pageContext.request.contextPath}/admin/add-product.jsp"><button class="poppins-semibold add-button">Add Product</button></a>

				

			</div>



			</div>

			

			<div class="order-table">

			

			</div>

		</div>

	

	

</body>

</html>