<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/style.css"/>

<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
</head>
<body class="poppins-regular">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper" style="background-image: url('${pageContext.request.contextPath}/images/background.png');">
		<div class="inner" style="height:500px;">
			<div class="form-holder">
			<form action="/BubblesandWhirls/UserUpdateServlet" method="post"  enctype="multipart/form-data">
			<h3 class="poppins-semibold" style="font-size: 25px; text-align: center;">UPDATE ACCOUNT</h3>
				<div class="form-group">
					<label for="firstName"></label> <input type="text" id="firstName" name="first_name" placeholder="First Name" value="${user.firstName}" required style="margin-left:0px;" >
					<label for="lastName"></label> <input type="text" id="lastName" name="last_name" placeholder="Last Name" value="${user.lastName}" required>
				</div>
				<div class="form-wrapper">
					<label for="username"></label> <input type="text" id="username" name="user_name" placeholder="Username" value="${user.username}" required>	
				</div>
				<div class="form-wrapper">
					<label for="email"></label> <input type="email" id="email" name="email" placeholder="Email" value="${user.email}"required>
				</div>
				<div class="form-wrapper">
					<label for="phoneNumber"></label> <input type="tel" id="phoneNumber" name="phone_number" placeholder="Phone Number" value="${user.phoneNumber}" required>
				</div>
				
				<a href="${pageContext.request.contextPath}/pages/user-profile.jsp"><button type="submit" class="poppins-semibold">Update Account</button></a>

			</form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>