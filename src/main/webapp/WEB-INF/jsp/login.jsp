<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Online Assessment - Home Page</title>

</head>

<body bgcolor="#00FFFF">
	<h1>Welcome to Online Assessmenst</h1>
	<div class="container">

		<form method="POST" action="${contextPath}/login" >
			<h2 class="form-heading">Login</h2>

			<div class="form-group">
				<table border="0">
					<tr>
						<td>Email ID :</td>
						<td><input name="username" id=”email" type="email" 
						class="form-control" 
							required placeholder="Username" autofocus="true" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input name="password" id=”password” type="password"
							required class="form-control" placeholder="Password" /></td>
					</tr>
				</table>



				<button class="btn btn-lg btn-primary btn-block" id=”login” type="submit">LOGIN</button>
				
				<br>
				New User ? <a href="${pageContext.request.contextPath}/addNewUser">register here</a> 
			</div>

		</form>

	</div>
</body>
</html>
