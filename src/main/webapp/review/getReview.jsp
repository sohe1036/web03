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
	<div class="table_warp">
		<h2 class="title is-3">리뷰상세</h2>
		<table class="table">
			<tbody>
				<tr>
					<th>번호</th>
					<td>${review.reno }</td>
				</tr>
				<tr>
					<th>별점</th>
					<td>
					<c:forEach var="item" begin="0" end="${review.best -1}"  varStatus="status">
					<img src="./img/star.png" >
					</c:forEach>
					</td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td>${review.retitle }</td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td>${review.recontent }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${review.redate }</td>
				</tr>
				<tr>
					<th>리뷰이미지</th>
					<td><img src="${path1 }/${review.reimg }"></td>
				</tr>
				<tr>
					<th>상품번호</th>
					<td>${review.gno }</td>
				</tr>
				<tr>
				<td colspan="2">
				<a href="${path1 }/GetReviewListCtrl?gno=${review.gno }" class="button is-info">목록</a> &nbsp;&nbsp;	
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>