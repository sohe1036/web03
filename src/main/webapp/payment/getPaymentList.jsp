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
<title>판매 목록</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">판매 목록</h2>
		<table class="table">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>상품번호</th>
					<th>주문날짜</th>
					<th>아이디</th>
					<th>결제금액</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payList }" var="vo" varStatus="status">
				<tr>
					<td><a href="${path1 }/GetPaymentCtrl?ono=${vo.ono }" target="_blank" >${vo.ono }</a></td>
					<td><a href="${path1 }/GetGoodsCtrl?gno=${vo.gno }" target="_blank">${vo.gno }</a></td>
					<td>${vo.sdate }</td>
					<td><a href="${path1 }/GetMemberCtrl?u_id=${vo.u_id }" target="_blank" >${vo.u_id }</a></td>
					<td>${vo.money }</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
					 <span>주문이 없습니다.</span>
					</td>
				</tr>			
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>