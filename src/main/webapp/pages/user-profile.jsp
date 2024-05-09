<%@page import="model.RegisterModel"%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/user-profile.css"/>
</head>
<body class="poppins-regular">
    <div class="user-container">
    	<jsp:include page="user-sidenav.jsp"></jsp:include>
      
        
        <div class="main-panel">
          <h1>My Account</h1>
            <table class="user-table">
                <tr>
                    <td class="label">User Image:</td>
                    <td><img src ="${pageContext.request.contextPath}/resources/images/user/${user.imageUrlFromPart}" style="width:200px; height:200px;"></td>
                </tr>
                <tr>
                    <td class="label">Username:</td>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <td class="label">Full Name:</td>
                    <td>${user.firstName} ${user.lastName}</td>
                </tr>
                <tr>
                    <td class="label">Email:</td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td class="label">Phone Number:</td>
                    <td>${user.phoneNumber}</td>
                </tr>
            </table>
            <!-- Add more details as needed -->
        </div>
        <div class="actions">
            <form method="post" action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER%>">
                <input type="hidden" name="<%=StringUtils.UPDATE_USER_ID %>" value="${user.username}" />
                
                <a href="${pageContext.request.contextPath}/UserUpdateServlet?updateId=${user.username}"><img src="/BubblesandWhirls/images/update.png"></a>
               
            </form>
            	 <label for="updateAccount">Edit Account</label>
        </div>
    </div>
</body>
</html>
