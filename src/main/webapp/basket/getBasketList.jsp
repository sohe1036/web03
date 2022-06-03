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
<title>장바구니 목록</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
li { float: left; padding: 20px;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">장바구니 목록</h2>
		<c:forEach items="${list }" var="basket" varStatus="status">		<!-- 배열을 순서대로 나열 -->
		<ul>
			<li>
			<br>
			<p>번호 : ${basket.bno }</p>
			<p>상품명 : ${basket.gname }</p>
			<p>사이즈 : ${basket.gsize }</p>
			<p>컬러 :${basket.gcolor }</p>
			<p>가격 : ${basket.price }원</p>
			<p>수량 : ${basket.pieces }</p>
			<br>	
			<a href="${path1 }/GetBasketCtrl?bno=${basket.bno }" class="button is-info">상세보기</a> &nbsp;&nbsp;
			<a href="${path1 }/SailFormCtrl?gno=${basket.gno }&bno=${basket.bno }" class="button is-info">주문하기</a>
			</li>
		</ul>
		</c:forEach>
	</div>	
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>