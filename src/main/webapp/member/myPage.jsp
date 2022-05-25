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
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<h2 class="title is-3">내 정보</h2>
	<form action="${path1 }/EditMemberCtrl" method="post">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="u_id" value="${member.u_id }" readonly></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="u_pw" value="${member.u_pw }"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="${member.name }" readonly> </td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="tell" value="${member.tell }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="${member.email }"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birth" value="${member.birth }"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
				<input type="text" name="postcode" value="${member.postcode }">
				<input type="text" name="addr1" value="${member.addr1 }">
				<input type="text" name="addr2" value="${member.addr2 }">
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
				<td colspan="2">
					<input type="submit" value="수정" class="button is-info" />
					<input type="reset" value="취소" class="button is-info" />
					<a href="${path1 }/GetMemberListCtrl" class="button is-info">목록</a>
					<a href="${path1 }/DelMemberCtrl?uid=${member.u_id }" class="button is-danger">회원탈퇴</a>		<!-- 회우너탈퇴시 id정보 넘겨줘야해 -->
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>