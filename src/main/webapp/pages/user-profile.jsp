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
</head>
<body>
<div class="students-info">
		<div class="users">

			<c:if test="${empty userList}">
				<p>No user found.</p>
			</c:if>

			<c:if test="${not empty userList}">
				<c:forEach var="user" items="${userList}">
					<div class="card">
						<img src="resources/images/user/${user.imageUrlFromPart}"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h4 class="card-title">${user.firstName}
								${user.lastName}</h4>
								<h4 class="card-title">${user.email}
								</h4>
								<h4 class="card-title">${user.phoneNumber}
								</h4>
								<h4 class="card-title">${user.role}
								</h4>
						</div>
						<form method="post">
							<%-- action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER%>"> --%>
							<%-- <input type="hidden" name="<%=StringUtils.UPDATE_ID %>" value="${student.username}" /> --%>
							<button type="submit">Update</button>
						</form>
						<form id="deleteForm-${user.username}" method="post">
							<%-- action="<%=contextPath + StringUtils.SERVLET_URL_MODIFY_USER %>">
							<input type="hidden" name="<%=StringUtils.DELETE_ID %>" value="${student.username}" /> --%>
							<button type="button"
								onclick="confirmDelete('${user.username}')">Delete</button>
						</form>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>

	<%-- <jsp:include page="<%=StringUtils.PAGE_URL_FOOTER%>" /> --%>
</body>


<script>
	function confirmDelete(userName) {
		if (confirm("Are you sure you want to delete this user: " + username
				+ "?")) {
			document.getElementById("deleteForm-" + userName).submit();
		}
	}
</script>

</html>