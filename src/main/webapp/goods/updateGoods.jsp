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
		<form action="${path1 }/EditGoodsCtrl" method="post" enctype="multipart/form-data">
			<table class="table" id="lst_tb">
				<tr>
					<th>상품번호</th>
					<td><input type="text" name="gno" id="gno" value="${goods.gno }" readonly></td>
				</tr>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="gname" id="gname" value="${goods.gname }"></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td>
					<img src="${path1 }/${goods.gimg }">
					<input type="file" accept="image/png, image/jpeg, image/gif" name="gimg" id="gimg" class="input is-normal"/>
					<input type="hidden" accept="image/png, image/jpeg, image/gif" name="gimg" id="gimg" value="${goods.gimg }" class="input is-normal"/>
					</td>
				</tr>
				<tr>
					<th>상품타입</th>
					<td>
						<select name="gtype" class="select is-primary" required>
							<option value="${goods.gtype }">${goods.gtype }</option>
							<option value="luggage">luggage</option>
							<option value="backpack">backpack</option>
							<option value="bag">bag</option>
							<option value="accessory">accessory</option>						
						</select>
						<input type="hidden" name="gno" id="gno" value="${goods.gno }">
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="number" name="price" id="price" value="${goods.price }"></td>
				</tr>
				<tr>
					<th>컬러</th>
					<td><input type="text" name="gcolor" id="gcolor" value="${goods.gcolor }"></td>
				</tr>
				<tr>
					<th>상품타입</th>
					<td>
						<select name="gsize" class="select is-primary" required>
							<option value="${goods.gsize }">${goods.gsize }</option>
							<option value="대형">대형</option>
							<option value="중형">중형</option>
							<option value="소형">소형</option>
							<option value="서류가방">서류가방</option>
							<option value="크로스백">크로스백</option>
							<option value="보스턴백">보스턴백</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>상세 사이즈</th>
					<td><input type="text" name="gsize2" id="gsize2" value="${goods.gsize2 }"></td>
				</tr>
				<tr>
					<th>상세정보</th>
					<td><textarea rows="8" cols="100" name="ginfo" id="ginfo" required>${goods.ginfo }</textarea></td>
				</tr>
				<tr>
					<th>재고량</th>
					<td><input type="number" name="pieces" value="${goods.pieces }"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정" class="button is-info">
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