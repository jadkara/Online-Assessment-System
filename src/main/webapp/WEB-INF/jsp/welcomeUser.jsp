<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Select Tests</title>
</head>
<body bgcolor="#00FFFF">
<div id = "msg">
	<h2>Select the Test</h2>
	</div>
	<h3><a href="${pageContext.request.contextPath}/springAssessment">Spring Assessment </a><br><br>
	<a href="${pageContext.request.contextPath}/hibernateAssessment">Hibernate Assessment </a>
	</h3><br><br><br>
	<a href="${contextPath}/logout">Logout</a>
</body>
</html>