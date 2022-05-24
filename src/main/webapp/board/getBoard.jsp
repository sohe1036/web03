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
<title>게시판 목록</title>
<style>
#lst_tb { width:700px; margin:0 auto; }
.navbar-link:not(.is-arrowless)::after { display:none; }
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<form method="post" action="${path1 }/EditBoardCtrl">
		<table class="table">
			<tbody>
				<tr>
					<th>번호</th>
					<td>
					<%-- <c:if test="${sid=='admin' }"> --%>
					<p>${board.seq }</p>
					<%-- </c:if> --%>
					</td>
				</tr>
				<tr>	
					<th>제목</th>
					<td>
					<%-- <c:if test="${sid=='admin' }"> --%>
					<input type="text" name="title" value="${board.title }"/>
					<%-- </c:if> --%>
					</td>
				</tr>
				<tr>	
					<th>글내용</th>
					<td>
					<%-- <c:if test="${sid=='admin' }"> --%>
					<textarea cols="90" rows="10">${board.content }</textarea>
					<%-- </c:if> --%>
					</td>
				</tr>
				<tr>	
					<th>작성자</th>
					<td>
					<%-- <c:if test="${sid=='admin' }"> --%>
					<p>${board.name }</p>
					<%-- </c:if> --%>
					</td>
				</tr>
				<tr>	
					<th>작성일</th>
					<td>
					<%-- <c:if test="${sid=='admin' }"> --%>
					${board.regdate }
					<%-- </c:if> --%>
					</td>
				</tr>
				<tr>	
					<td colspan="2">
					<%-- <c:if test="${sid=='admin' }"> --%>
						<input type="submit" value="수정" class="button is-info"/>
						<input type="reset" value="취소" class="button is-info"/>
						<a href="${path1 }/DelBoardCtrl" class="button is-danger">삭제</a>
					<%-- </c:if> --%>
						<a href="${path1 }/GetBoardListCtrl" class="button is-info">목록</a>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>