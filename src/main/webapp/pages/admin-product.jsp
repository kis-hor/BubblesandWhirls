<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/> 
</head>
<body class="poppins-regular">
		<div class="admin-container">
			<jsp:include page="admin-sidenav.jsp"></jsp:include>
			<div class="main-panel">
			    <h1>Products</h1> 
			    
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
			                                <input type="hidden" name="updateProductId" value="${product.productId}" />
			                                <a href="${pageContext.request.contextPath}/ProductUpdateServlet?updateId=${product.productId}"><img src="/BubblesandWhirls/images/update.png"></a>
			                            </form>
			                       
			                       	</td>
			                         <td>
			                            <form id="deleteForm-${product.productId}" method="post" action="${pageContext.request.contextPath}/ModifyServlet">
			                                <input type="hidden" name="deleteProductId" value="${product.productId}" />
			                                <a style="cursor:pointer; "onclick="confirmDelete('${product.productId}')"><img src="/BubblesandWhirls/images/delete.png"></a>
			                            </form>
			                        </td>
			                    </tr>
			                </c:forEach>
			            </tbody>
			        </table>
			    </div>
			    
			<a href="${pageContext.request.contextPath}/pages/add-product.jsp"><button class="poppins-semibold add-button">Add Product</button></a>
			</div>
		</div>
</body>

		<script>
			function confirmDelete(productName) {
				if (confirm("Are you sure you want to delete this product: " + productName
						+ "?")) {
					document.getElementById("deleteForm-" + productName).submit();
				}
			}
		</script>
</html>