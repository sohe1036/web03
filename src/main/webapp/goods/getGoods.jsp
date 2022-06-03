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
<title>상품 상세페이지</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
	<h2 class="title is-3">상품 상세페이지</h2>
		<table class="table">
			<tr>
				<th>상품명</th>
				<td>${goods.gname }</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><img src="${path1 }/${goods.gimg }"/></td>
			</tr>
			<tr>
				<th>상품타입</th>
				<td>${goods.gtype }</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${goods.price }원</td>
			</tr>
			<tr>
				<th>컬러</th>
				<td>${goods.gcolor }</td>
			</tr>
			<tr>
				<th>사이즈</th>
				<td>${goods.gsize }</td>
			</tr>
			<tr>
				<th>상세 사이즈</th>
				<td>${goods.gsize2 }</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td>${goods.ginfo }</td>
			</tr>
			<c:if test="${sid=='admin' }">
			<tr>
				<th>재고수량</th>
				<td>${goods.pieces }</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="2">
				<c:if test="${sid!=null }">
				<a href="${path1 }/AddBasketCtrl?gno=${goods.gno }&gname=${goods.gname }&gsize=${goods.gsize }&gcolor=${goods.gcolor }&price=${goods.price }" class="button is-info">장바구니</a>
				</c:if>
				<a href="${path1 }/GetGoodsListCtrl" class="button is-info">목록</a>
				<c:if test="${sid=='admin' }">
				<a href="${path1 }/GetGoodsUpdateCtrl?gno=${goods.gno }" class="button is-info">수정</a>
				<a href="${path1 }/DelGoodsCtrl?gno=${goods.gno }" class="button is-danger">삭제</a>
				</c:if>
				</td>
			</tr>
		</table>	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>