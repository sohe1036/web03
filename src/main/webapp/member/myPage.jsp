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
span { font-size: 25px; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">마이페이지</h2>
		<table class="table">
			<tr>
				<td>
				 <span>${member.name }</span>
				 <span>(${member.u_id })님</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <a href="${path1 }/MypageDetailCtrl?u_id=${sid }" class="button is-normal">회원정보</a>
			</tr>
			<tr>
				<td>
				<span>보유 포인트 : </span>
				<span>${member.point } P</span>
				</td>
			</tr>
			<tr>
				<td>
					<span>주문내역</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${path1 }/MyPaymentCtrl?u_id=${sid }" class="button is-normal">상세보기</a>
				</td>
			</tr>
			<tr>
				<td>
					<span>리뷰</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${path1 }/MyReviewListCtrl?u_id=${sid }" class="button is-normal">상세보기</a>
				</td>
			</tr>
		</table>
	</div>	
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>