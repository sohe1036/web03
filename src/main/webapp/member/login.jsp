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
<title>로그인</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">로그인</h2>
		<form  action="${path1 }/LoginCtrl" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>아이디 : </th>
						<td><input type="text" name="u_id" id="u_id" required ></td>
					</tr>
					<tr>
						<th>비밀번호 : </th>
						<td><input type="password" name="u_pw" id="u_pw" required ></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인" class="button is-info" />
							<input type="reset" value="취소" class="button is-info" />
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