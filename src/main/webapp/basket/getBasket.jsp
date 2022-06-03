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
		<h2 class="title is-3">메인 페이지</h2>
		<ul>
			<li>
				<br>
				<p>번호 : ${basket.bno }</p>
				<p>상품명 : ${basket.gname }</p>
				<p>사이즈 : ${basket.gsize }</p>
				<p>컬러 :${basket.gcolor }</p>
				<p>가격 : ${basket.price }원</p>
				<p>수량 : ${basket.pieces }</p>
				<p>종류 : ${basket.gtype }</p>
				<p><img src="${basket.gimg }"></p>
				<p>${basket.ginfo }</p>
				<a href="${path1 }/GetBasketListCtrl" class="button is-info">목록</a> &nbsp;&nbsp;
				<a href="${path1 }/DelBasketCtrl?bno=${basket.bno }" class="button is-info">삭제</a>
			</li>	
		</ul>	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>