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
<title>글쓰기</title>
<style>
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<%-- <c:if test="${empty name }"><c:redirect url="../member/login.jsp" /></c:if> --%>
<div id="content">
	<div class="table_warp">
		<h2 class="title is-3">공지사항 글 추가</h2>
		<form action="${path1 }/AddBoardCtrl" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="title" value="" required>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<input type="text" name="name" value="관리자">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea cols="90" rows ="9" name="content" required></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글 등록" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
							<a href="${path1 }/GetBoardListCtrl" class="button is-info">목록</a>
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