<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>


</head>
<body class="poppins-regular">
	<div class="admin-container">
		<nav class="side-panel">
    	<h2 style="color:#ffffff;">MENU</h2>
	    	<ul>
		        <li><a href="dashboard.jsp">Dashboard<img src="../images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/ProductListServlet">Products<img src="../images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="#Orders">Orders<img src="../images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="#Customsers">Customers<img src="../images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
	    	</ul>
		</nav>
			
		
		<div class="main-panel">
			<div class="data-panel">
				<div class="data-panel-row">
						<div class="data-panel-item">
							<div class="data-panel-icon">
								<img src="../images/revenue.png" alt="Dashboard Icon">
							</div>
							<h3>Total Revenue</h3>
						</div>
						<div class="data-panel-item">
							<div class="data-panel-icon">
								<img src="../images/order.png" alt="Dashboard Icon">
							</div>
							<h3>Total Orders</h3>
						</div>
						<div class="data-panel-item">
							<div class="data-panel-icon">
								<img src="../images/users.png" alt="Dashboard Icon">
							</div>
							<h3>Total Customers</h3>
						</div>
						<div class="data-panel-item">
							<div class="data-panel-icon">
								<img src="../images/fulfilled.png" alt="Dashboard Icon">
							</div>
							<h3>Fulfilled Orders</h3>
						</div>
					</div>
			</div>
			
			<div class="product-table">
				<a href="${pageContext.request.contextPath}/pages/add-product.jsp"><button class="poppins-semibold">Add Product</button></a>

			</div>
			
			<div class="order-table">
			
			</div>
		</div>
	</div>
	
	
</body>
</html>