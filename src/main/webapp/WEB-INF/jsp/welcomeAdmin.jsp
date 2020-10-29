<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Select Reports</title>
</head>
<body bgcolor="#00FFFF">
	      
	<h2 id ="msg">Select Reports</h2>
	
	<h3><a href="${pageContext.request.contextPath}/getUser">View List of all candidates</a>
	<br><br>
	<a href="${pageContext.request.contextPath}/getTest">View List of all tests taken</a>
	</h3>
	<br><br><br>
	<a href="${contextPath}/logout">Logout</a>
	
</body>
</html>