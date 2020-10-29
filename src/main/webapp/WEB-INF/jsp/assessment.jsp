<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Assessment</title>
</head>
<body bgcolor="#00FFFF">
	<h1>${assessment.assessmentName}</h1>
	<hr>
	<form method = "post" action="${pageContext.request.contextPath}/submit">
	
	<input type="hidden" name="assessment" value="${assessment.assessmentName}">
	
		<c:forEach var="question" items="${assessment.questions}">
			<br>
			<b>Question ${question.questionId}: ${question.questionValue}</b>
			<input type="hidden" name="questionId" value="${question.questionId}">
			<c:forEach var="answer" items="${question.answerOption}">
				<br>
				<input type="radio" name="question_${question.questionId}"
					value="${answer}">
	             ${answer}
	       </c:forEach>
			<br>
		</c:forEach>
		<br>
		<input type="submit" value = "Submit">
	</form>
</body>
</html>