<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>답글달기</title>
</head>
<body>
	<div class="content">
		<form method="post" action="${path1 }/EditQuestionCtrl">
			<table class="table">
				<tr>
					<td>
					<c:if test="${!empty question.acontent }">
						<input type="text" placeholder="답변입력" name="acontent" value="${question.acontent }" style="width:250px; height:150px;">
					</c:if>
					<c:if test="${empty question.acontent }">
					<input type="text" placeholder="답변입력" name="acontent" style="width:250px; height:150px;">
					</c:if>
					<input type="hidden" name="qno" value="${question.qno }">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="button is-info" value="답변">
					</td>
				</tr>
			</table>
		</form>	
	</div>
</body>
</html>