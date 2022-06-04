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
		<h2 class="title is-3">내 정보</h2>
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>${member.u_id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.name }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${member.tell }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email }</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${member.birth }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
				<p>${member.postcode }</p>
				<p>${member.addr1 }</p>
				<p>${member.addr2 }</p>
				</td>
			<tr>	
				<th>가입일</th>
				<td>${member.regdate }</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${member.point }</td>
			</tr>
			<tr>
				<th>방문횟수</th>
				<td>${member.visited }</td>
			</tr>
			<tr>
				<td>
				<a href="${path1 }/GetUserCtrl?u_id=${sid }" class="button is-info">정보수정</a> &nbsp;&nbsp;
				<a href="${path1 }/MyPaymentCtrl?u_id=${sid }" class="button is-info">주문조회</a>
				</td>
			</tr>
		</table>
	</div>	
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>