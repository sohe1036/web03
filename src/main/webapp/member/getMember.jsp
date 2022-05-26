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
.form_warp { width: 1260px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="form_warp">
		<h2 class="title is-3">메인 페이지</h2>
		<form action="${path1 }/UpdateMemberCtrl" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" id="name" value="${member.name }" required /></td>					
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="u_id" id="u_id" value="${member.u_id }" readonly /></td>					
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" name="tell" id="tell" value="${member.tell }" required /></td>					
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="email" value="${member.email }" required /></td>					
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="date" name="birth" id="birth" value="${member.birth }" required /></td>					
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="postcode" id="postcode" value="${member.postcode }" /></td>
						<td><input type="text" name="addr1" id="addr1" value="${member.addr1 }" required /></td>
						<td><input type="text" name="addr2" id="addr2" value="${member.addr1 }" required /></td>					
					</tr>
					<tr>
						<th>가입일</th>
						<td>${member.regdate }</td>					
					</tr>
					<tr>
						<th>포인트</th>
						<td><input type="number" name="point" is="point" value=${member.point }></td>					
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
						</td>					
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>