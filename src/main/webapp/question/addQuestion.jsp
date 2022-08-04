<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path1" value="${pageContext.request.contextPath }" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<title>질문하기</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="content">
		<div class="question_table">
			<form action="">
				<table>
					
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>