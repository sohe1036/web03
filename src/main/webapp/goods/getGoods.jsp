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
				<th>종류</th>
				<td>${goods.gsize }</td>
			</tr>
			<c:if test="${goods.gsize2 !=null }">
			<tr>
				<th>상세 사이즈</th>
				<td>${goods.gsize2 }</td>
			</tr>
			</c:if>
			<tr>
				<th>상세정보</th>
				<td>${goods.ginfo }</td>
			</tr>
			<c:if test="${sid=='admin' }">
			<tr>
				<th>재고수량</th>
				<td>
				<c:if test="${goods.pieces > 0 }">
				${goods.pieces }
				</c:if>
				<c:if test="${goods.pieces==0 }">
				<span>품절된 상품입니다.</span>
				</c:if>
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="2">
				<c:if test="${sid!=null }">
					<c:if test="${goods.pieces > 0 }">
						<a href="${path1 }/SailFormCtrl?gno=${goods.gno }" class="button is-info">주문하기</a>
						<a href="${path1 }/AddBasketCtrl?gno=${goods.gno }&gname=${goods.gname }&gsize=${goods.gsize }&gcolor=${goods.gcolor }&price=${goods.price }" class="button is-info">장바구니</a>
					</c:if>
					<c:if test="${goods.pieces==0 }">
					<span style="color:red">품절</span> &nbsp;&nbsp;
					</c:if>
				</c:if>
				<a href="${path1 }/GetGoodsListCtrl" class="button is-info">목록</a>
				<c:if test="${sid=='admin' }">
				<a href="${path1 }/GetGoodsUpdateCtrl?gno=${goods.gno }" class="button is-info">수정</a>
				<a href="${path1 }/DelGoodsCtrl?gno=${goods.gno }" class="button is-danger">삭제</a>
				</c:if>
				</td>
			</tr>
		</table>
		<div class="show_riview">
			<a href="${path1 }/GetReviewListCtrl?gno=${goods.gno }" class="button is-normal">리뷰</a>
		</div>
		<table class="table">
			<tbody>		
				<c:forEach items="${list }" var="re" varStatus="status">
				<c:if test="${!empty re.retitle}">
				<tr>
					<td>
					<c:forEach var="item" begin="0" end="${re.best-1 }" varStatus="status">
					<img src="${path1 }/img/star.png" />
					</c:forEach>
					</td>
					<td>${re.u_id }</td>
					<td>${re.redate }</td>
					<td>${re.retitle }</td>
					<td><a href="${path1 }/GetReviewCtrl?gno=${re.gno }&reno=${re.reno }" class="button is-small">상세</a></td>
				</tr>
				</c:if>
				<c:if test="${empty re.retitle}">
				<tr><td>아직 리뷰가 없습니다.</td></tr>
				</c:if>
				</c:forEach>
			</tbody>	
		</table>
		<c:if test="">
		
		</c:if>	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>