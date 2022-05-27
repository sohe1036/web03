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
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<%-- <c:if test="${empty name }"><c:redirect url="../member/login.jsp" /></c:if> --%>
<div id="content">
	<div class="table_warp">
		<form method="post" action="${path1 }/EditBoardCtrl">
			<table class="table">
				<tbody>
					<tr>
						<th>번호</th>
						<td>
						<c:if test="${sid=='admin' }">
						<p>${board.seq }</p>
						</c:if>
						<input type="hidden" name="seq" value="${board.seq }">
						<c:if test="${sid!='admin' }">
						<p>${board.seq }</p>
						</c:if>
						</td>
					</tr>
					<tr>	
						<th>제목</th>
						<td>
						<c:if test="${sid=='admin' }">
						<input type="text" name="title" value="${board.title }" required />
						</c:if>
						<c:if test="${sid!='admin' }">
						${board.title }
						</c:if>
						</td>
					</tr>
					<tr>	
						<th>글내용</th>
						<td>
						<c:if test="${sid=='admin' }"> 
						<textarea cols="90" rows="10" name="content" required>${board.content }</textarea>
						</c:if>
						<c:if test="${sid!='admin' }"> 
						<p>${board.content }</p>
						</c:if>
						</td>
					</tr>
					<tr>	
						<th>작성자</th>
						<td>
						<p>${board.name }</p>
						</td>
					</tr>
					<tr>	
						<th>작성일</th>
						<td>
						${board.regdate }
						</td>
					</tr>
					<tr>	
						<th>조회수</th>
						<td>
						${board.show }
						</td>
					</tr>
					<tr>	
						<td colspan="2">
						<c:if test="${sid=='admin' }">
							<input type="submit" value="수정" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
							<a href="${path1 }/DelBoardCtrl?num=${board.seq}" class="button is-danger">삭제</a>		<!-- 번호를 넘겨줘야 조건에맞춰 삭제 -->
						</c:if> 
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