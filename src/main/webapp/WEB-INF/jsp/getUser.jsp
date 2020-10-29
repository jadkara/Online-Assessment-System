<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>All User Details</title>
</head>
<body bgcolor="#00FFFF">
	<h1 style="color: red;">List of All Users</h1>
<h3>
	<table border="2" >
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email ID</th>
			<th>User Type</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.userTypeValue}</td>
			</tr>
		</c:forEach>

	</table>
</h3>
<a href="${contextPath}/welcomeAdmin">Exit</a>
</body>
</html>