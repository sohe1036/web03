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
<title>메인</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class=table_warp>
		<h2 class="title is-3">리뷰목록</h2>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제품번호</th>
					<th>글제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="re" varStatus="statue">
				<tr>
					<td>${statue.count }</td>		<!-- reno로하면 모든 리뷰번호가 출력되고 statue.count는 그 사람의 리뷰순서를 출력 -->
					<td>${re.gno }</td>
					<td><a href="MyReviewCtrl?reno=${re.reno }&u_id=${re.u_id}"> ${re.retitle }</a></td>
					<td>${re.redate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>