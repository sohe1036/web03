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
<title>상품 추가 폼</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">상품 추가 폼</h2>
		<form action="${path1 }/AddGoodsCtrl" method="post">
			<table class="table">
				<tr>
					<th>상품명</th>
					<td><input type="text" name="gname" id="gname" required></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type="file" accept="image/png, image/jpeg, image/gif" name="gimg" id="gimg" ></td>
				</tr>
				<tr>
					<th>상품타입</th>
					<td><input type="text" name="gtype" id="gtype" required></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" id="price" required></td>
				</tr>
				<tr>
					<th>컬러</th>
					<td><input type="text" name="gcolor" id="gcolor" required></td>
				</tr>
				<tr>
					<th>사이즈</th>
					<td><input type="text" name="gsize" id="gsize" required></td>
				</tr>
				<tr>
					<th>상세정보</th>
					<td><textarea rows="8" cols="100" name="ginfo" id="ginfo" required></textarea></td>
				</tr>
				<tr>
					<th>재고량</th>
					<td><input type="number" name="pieces" ></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="확인" class="button is-info">
						<input type="reset" value="취소" class="button is-info">
					</td>
				</tr>
			</table>	
		</form>	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>