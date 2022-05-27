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
<title>상품리스트</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">상품 리스트</h2>
		<table class=table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제품명</th>
					<th>사이즈</th>
					<th>컬러</th>
					<th>가격</th>
					<th>이미지</th>
				</tr>
			</thead>
				<c:forEach items="${list }" var="goods" varStatus="status">			<!-- 배열을 다시 순서대로 풀어줘 -->
				<tr>
					<td>${goods.gno }</td>			<!-- goods에 정보담아서 배열에 넣었으니까 변수 goods로 -->
					<td>${goods.gname }</td>
					<td>${goods.gsize }</td>
					<td>${goods.gcolor }</td>
					<td>${goods.price }</td>
					<td><a href="${path1 }/GetGoodsctrl?gno=${goods.gno }" ><img src=${path1 }${goods.gimg }></a></td>
				</tr>
				</c:forEach>	
			<tbody>
			</tbody>	
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>