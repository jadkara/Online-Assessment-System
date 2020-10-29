<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>All Tests Details</title>
</head>
<body bgcolor="#00FFFF">
	<h1>List of Candidates and Tests</h1>
<h3>
	<table border="2" >
		<tr>
			<th>Test Date</th>
			<th>Assessment</th>
			<th>Test Marks</th>
			<th>Email Id</th>
			<th>Total Marks</th>
			<th>Result</th>
		</tr>
		<c:forEach var="test" items="${testData}">
			<tr>
				<td>${test.testTakenDate}</td>
				<td>${test.assessmentName}</td>
				
				<td>${test.score}</td>
				<td>${test.email}</td>
				<td>${test.totalMark}</td>
				<td>${test.result}</td>
			</tr>
		</c:forEach>

	</table>
</h3>
<a href="${contextPath}/welcomeAdmin">Exit</a>

</body>
</html>