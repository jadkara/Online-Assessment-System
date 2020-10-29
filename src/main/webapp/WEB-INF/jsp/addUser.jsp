<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Registration Page</title>
</head>

<body bgcolor="#00FFFF">
	<h1>Registration</h1>
<br><br><br>
	<div id="addUser">
		<form:form action="/addUser" method="post" modelAttribute="user">
			<table border="0">
				<tr>
					<td><label>First Name : </label></td>
					<td><form:input id = "firstName" type = "text" pattern="[A-Za-z]+"
					 path="firstName" required="true" /></td>
				</tr>

				<tr>
					<td><label>Last Name : </label></td>
					<td><form:input id = "lastName"
					 pattern="[a-zA-Z]+"
					 path="lastName" required="true" /></td>
				</tr>

				<tr>
					<td><label>Email ID : </label></td>
					<td><form:input id = "email" type="email"
					path="email" required="true" /></td>
				</tr>
				<tr>
					<td><label>Password : </label></td>
					<td><form:input id = "password" type="password" minlength="8"
					 path="password" required="true"/></td>
				</tr>
			</table>
			<input type="SUBMIT" id = "register" value="REGISTER" />
		</form:form>
	</div>
</body>
</html>
