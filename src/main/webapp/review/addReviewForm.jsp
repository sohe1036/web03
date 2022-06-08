<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="path1" value="${pageContext.request.contextPath }" /> 

<%
	String sid = "";
	if(session != null){
		sid =  (String)session.getAttribute("sid");		//세션에서 sid 값 받아와
	}
%> 	  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>리뷰작성 폼</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.form_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="form_warp">
		<form action="${path1 }/AddReviewCtrl" method="post" enctype="multipart/form-data">
			<h2 class="title is-3">리뷰 작성</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>상품번호</th>
						<td>${param.gno }</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><%=sid %></td>
					</tr>
					<tr>
						<th>글제목</th>
						<td><input type="text" name="retitle" id="retitle" required> </td>
					</tr>
					<tr>	
						<th>별점</th>
						<td><input type="number" min="1" max="5" name="best" required ></td>
					</tr>
					<tr>	
						<th>글내용</th>
						<td>
						<textarea rows="8" cols="90" name="recontent" required></textarea>
						</td>
					</tr>
					<tr>	
						<th>사진</th>
						<td>
						<input type="file" name="reimg" accept="image/png, image/jpeg, image/gif">
						<input type="hidden" name="gno" value="${param.gno }">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>						
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