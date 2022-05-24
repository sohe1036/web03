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
<title>공지사항 추가 폼</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content" >
	<h2>공지사항 추가</h2>
	<form method="post" action="${path1 }/AddBoardCtrl">
		<table class="table" id="search_tb">
			<tr>
				<th>제목</th>
				<td><input  type="text" name="title"  required></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea cols="90" rows="9" name="content" required></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
				<p><input  type="text" name="name" value="관리자" ></p>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록" class="button is-info"/>
					<input type="reset" value="취소" class="button is-info"/>
					<a href="${path1 }/GetBoardListCtrl" class="button is-info">목록</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>