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
<title>주문조회</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.form_warp { width: 1600px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="form_warp">
		<!-- <form action="" method="post"> -->
		<h2 class="title is-3">주문조회</h2>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>상품번호</th>
					<th>주문날짜</th>
					<th>결제정보</th>
					<th>주문수량</th>
					<th>결제금액</th>
					<th>배송정보</th>
					<th>배송지</th>
					<th>배송정보수정</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payList }" var="vo" varStatus="status">		<!-- 배열정보를 하나씩풀어 -->
				<tr>
					<td>${status.count }</td>		
					<td><a target="_blank" href="${path1 }/GetGoodsCtrl?gno=${vo.gno }">${vo.gno }</a></td>		<!-- a target="_blank" 새로운 창 열기 -->
					<td>${vo.sdate }</td>		<!-- 주문날짜 -->
					<td>
						<c:if test="${vo.paytype =='credit'}">		<!-- 결제정보 -->
						<span>신용카드 /</span>
						</c:if>
						<c:if test="${vo.paytype =='check'}">
						<span>체크카드 /</span>
						</c:if>
						<c:if test="${vo.paytype =='account'}">
						<span>무통장입금 /</span>
						</c:if>	
						<span>${vo.payno }</span>
					</td>
					<td><span>${vo.pieces }</span></td>
					<td><span>${vo.money }</span></td>
					<td>
						<c:if test="${empty vo.transno }">			<!-- 배송코드 -->
						<span>상품준비중</span>
						</c:if>
						<c:if test="${!empty vo.transno }">
						<span>${vo.transco } </span>		<!-- 택배회사 -->
						<span> ${vo.transno }</span><br>		<!-- 운송장번호 -->
						<span>배송상태 : ${vo.rstatus }</span>
						<span>도착 예정일 : ${vo.rdate }</span>
						</c:if>
					</td>
					<td>
						<span>${vo.postcode }</span>&nbsp;&nbsp;
						<span>${vo.addr1 }</span>&nbsp;&nbsp;
						<span>${vo.addr2 }</span>
					</td>
					<td>	
						<c:if test="${empty vo.transno }">
							<a href="${path1 }/EditShoppingCtrl?ono=${vo.ono }" class="button is-light">배송 수정</a>
							<a href="${path1 }/DelPaymentCtrl?ono=${vo.ono }" class="button is-light">결제 취소</a>
						</c:if>
						<c:if test="${!empty vo.transno }">
							<span>배송 시작</span>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- </form> -->
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>