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
		
			<table class="table">
				<tr>
					<td><input type="text" placeholder="답변입력" style="width:250px; height:150px;"></td>
				</tr>
				<tr>
					<td><button type="button"></button></td>
				</tr>
			</table>
	</div>
</body>
</html>