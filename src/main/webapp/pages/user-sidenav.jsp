<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/user-details.css"/>
</head>
<body>
    		<nav class="side-panel">
    		<h2 style="color:#ffffff;">MENU</h2>
	    	<ul>
		        <li><a href="${pageContext.request.contextPath}/index.jsp">Home Page<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/ProductListServlet">Product Page<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/UserDetailServlet">My Account<img src="/BubblesandWhirls//images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
		        <li><a href="/BubblesandWhirls/OrderDetailServlet">My Orders<img src="/BubblesandWhirls/images/dashboard-icon.png" alt="Dashboard Icon"></a></li>
	    	</ul>
		</nav>
</body>
</html>