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
#content { margin-top: 30px; }
.table_warp { width: 1260px; margin: 0 auto;}
.th { float: left; padding-right: 20px; }
.menu { float: left; margin-right: 30px; padding-bottom: 50px;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">상품 리스트</h2>
		<div class=table>
			<div class="table_body">
				<c:forEach items="${list }" var="goods" varStatus="status">			<!-- 배열을 다시 순서대로 풀어줘 -->
				<ul class="menu">
					<li class="th">번호</li>
					<li class="td">${goods.gno }</li>			<!-- goods에 정보담아서 배열에 넣었으니까 변수 goods로 -->
					<li class="th">제품명</li>
					<li class="td">${goods.gname }</li>
					<li class="th">상품타입</li>
					<li class="td">${goods.gsize }</li>
					<li class="th">컬러</li>
					<li class="td">${goods.gcolor }</li>
					<li class="th">가격</li>
					<li class="td">${goods.price }원</li>
					<li class="td"><a href="${path1 }/GetGoodsCtrl?gno=${goods.gno }" ><img src=${path1 }/${goods.gimg }></a></li>
				</ul>
				</c:forEach>
			<div class="addgoods">	
				<ul>
				<c:if test="${sid=='admin' }">
					<li>
						<a href="./goods/addGoodsForm.jsp" class="button is-info">추가</a>
					</li>
				</c:if>
				</ul>	
			</div>	
		</div>
	</div>
</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>