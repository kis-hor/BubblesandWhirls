<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <title>Cart</title>
    <style>
       body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 800px;
        margin: 20px auto; /* Center the container and add margin */
        padding: 0 20px; /* Add padding from left and right */
    }
    h1 {
        text-align: center;
        margin-top: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
    tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tfoot {
        font-weight: bold;
    }
    form {
        display: inline;
    }
    button {
        padding: 5px 10px;
        cursor: pointer;
        background-color: #007bff;
        border: none;
        color: white;
        border-radius: 5px;
    }
    button:hover {
        background-color: #0056b3;
    }
    </style>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>
	<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
	<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/product.css"/>
	<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/footer.css"/>
	<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h1>Your Cart</h1>
    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        	<c:set var="totalPrice" value="0" />
            <c:forEach var="item" items="${cartItems}">
                <tr>
                    <td>${item.productName}</td>
                    <td>${item.productPrice}</td>
                    <%-- <td>
                        ${item.productId}
                    </td> --%>
                    <td>
                        ${item.quantity}
                    </td>
                     <td id="totalPrice-${item.cartId}">${item.productPrice * item.quantity}</td>
                     <td>
                    <form id="deleteForm-${item.cartId}" method="post"
						action="${pageContext.request.contextPath}/ModifyServlet">
						<input type="hidden" name="deleteCartId" value="${item.cartId}" />
						<button type="button"
							onclick="confirmDelete('${item.cartId}')">Delete</button>
					</form>
                </td> 
                </tr>
                <c:set var="totalPrice" value="${totalPrice + (item.productPrice * item.quantity)}" />
            </c:forEach>
            <%-- Accumulate total price --%>
            
        </tbody>
    </table>
    <p>Total: ${totalPrice}</p>
    <br><br>
    <form method="post" action="/BubblesandWhirls/CheckoutServlet">
    	<input type="hidden" name="total" value="${totalPrice}" />
    	<button type="submit">Proceed to Checkout</button>
	</form>
	<br><br>
    <script>
		function confirmDelete(cartId) {
			if (confirm("Are you sure you want to delete this user: " + cartId
					+ "?")) {
				document.getElementById("deleteForm-" + cartId).submit();
			}
		}
	</script>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>