<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
</head>
<body class="poppins-regular">
	<nav class="side-panel">
    	<h2 style="color:#ffffff;">MENU</h2>
	    	<ul>
		        <li><a href="${pageContext.request.contextPath}/pages/dashboard.jsp">Dashboard<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/ProductListServlet">Products<img src="/BubblesandWhirls//images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/OrderListServlet">Orders<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/UserListServlet">Customers<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
	    	</ul>
		</nav>
</body>
</html>