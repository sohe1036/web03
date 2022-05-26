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
<title>고객정보보기</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">고객정보 보기</h2>
		<table class="table">
			<thead>
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>가입일</th>
				<tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="vo" varStatus="status">		<!-- c:forEach는 배열을 순서대로 처리 /items는 배열객체, varStatus는 반복 인덱스변수-->
				<tr>
					<td><a href="${path1 }/GetMemberCtrl?u_id=${vo.u_id }">${vo.name }</a></td>		<!-- DAO에서 vo에정보담았으니까 vo사용 -->
					<td>${vo.u_id }</td>
					<td>${vo.regdate }</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>