<%@page import="model.RegisterModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/admin.css"/>
</head>
<body class="poppins-regular">
		<div class="admin-container">
			<jsp:include page="admin-sidenav.jsp"></jsp:include>
			<div class="main-panel">
			    <h1>Users</h1>
			    <div class="products-info">
 				<table class="products-table">
			            <thead>
			                <tr>
			                    <th>Image</th>
			                    <th>Username</th>
			                    <th>Name</th>
			                    <th>Email</th>
			                    <th>Phone Number</th>
			                   	<th>Update</th>
			                    <th>Delete</th>
			                </tr>
			            </thead>
			            <tbody>
			            	<c:if test="${empty userList}">
								<p>No user found.</p>
							</c:if>
							<c:if test="${not empty userList}">
			                <c:forEach var="user" items="${userList}">
			                    <tr>
			                        <td><img src="${pageContext.request.contextPath}/resources/images/user/${user.imageUrlFromPart}" alt="User Image" style="width:100px; height:100px;"></td>
			                        <td>${user.username}</td>
			                        <td>${user.firstName} ${user.lastName}</td>
			                        <td>${user.email}</td>
			                        <td>${user.phoneNumber}</td>
			                        <td>
			                            <form method="post" action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER%>">
										<input type="hidden" name="<%=StringUtils.UPDATE_USER_ID %>" value="${user.username}" />
			                                <a href="${pageContext.request.contextPath}/UserUpdateServlet?updateId=${user.username}"><img src="/BubblesandWhirls/images/update.png"></a>
			                            </form>
			                       
			                       	</td>
			                         <td>
			                            <form id="deleteForm-${user.username}" method="post" action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER %>">
										<input type="hidden" name="<%=StringUtils.DELETE_USER_ID %>" value="${user.username}" />
			                                <a style="cursor:pointer; "onclick="confirmDelete('${user.username}')"><img src="/BubblesandWhirls/images/delete.png"></a>
			                            </form>
			                        </td>
			                    </tr>
			                </c:forEach>
			                </c:if>
			            </tbody>
			        </table>
				</div>
				</div>
			</div>

	<%-- <jsp:include page="<%=StringUtils.PAGE_URL_FOOTER%>" /> --%>
</body>


<script>
	function confirmDelete(username) {
		if (confirm("Are you sure you want to delete this user: " + username
				+ "?")) {
			document.getElementById("deleteForm-" + username).submit();
		}
	}
</script>

</html>