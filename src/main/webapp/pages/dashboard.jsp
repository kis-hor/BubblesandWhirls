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
				<a href="${pageContext.request.contextPath}/pages/add-product.jsp"><button class="poppins-semibold add-button">Add Product</button></a>
				<div class="products-info">
			        <table class="products-table">
			            <thead>
			                <tr>
			                    <th>Image</th>
			                    <th>Product ID</th>
			                    <th>Name</th>
			                    <th>Price</th>
			                    <th>Inventory</th>
			                    <th>Update</th>
			                    <th>Delete</th>
			                </tr>
			            </thead>
			            <tbody>
			                <c:forEach var="product" items="${productList}">
			                    <tr>
			                        <td><img src="${pageContext.request.contextPath}/resources/images/user/${product.productImageUrl}" alt="Product Image" style="width:100px; height:100px;"></td>
			                        <td>${product.productId}</td>
			                        <td>${product.productName}</td>
			                        <td>Rs.${product.productPrice}</td>
			                        <td>${product.productInventory} pcs</td>
			                        <td>
			                            <form method="post" action="${pageContext.request.contextPath}/ModifyServlet">
			                                <input type="hidden" name="updateId" value="${product.productId}" />
			                                <a href="${pageContext.request.contextPath}/ProductUpdateServlet?updateId=${product.productId}"><img src="/BubblesandWhirls/images/update.png"></a>
			                            </form>
			                       
			                       	</td>
			                         <td>
			                            <form id="deleteForm-${product.productId}" method="post" action="${pageContext.request.contextPath}/ModifyServlet">
			                                <input type="hidden" name="deleteId" value="${product.productId}" />
			                                <a style="cursor:pointer; "onclick="confirmDelete('${product.productId}')"><img src="/BubblesandWhirls/images/delete.png"></a>
			                            </form>
			                        </td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			    </div>
			</div>

			</div>
			
			<div class="order-table">
			
			</div>
		</div>
	</div>
	
	
</body>
</html>