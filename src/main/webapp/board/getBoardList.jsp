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
.search_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<%-- <c:if test="${empty name }"><c:redirect url="../member/login.jsp" /></c:if> --%>
<div id="content" >
	<div>
		<%-- <h3>${name }님 &nbsp; &nbsp; <a href="../LogoutCtrl">로그아웃</a></h3> --%>
	</div>
	<div class="search_warp">
		<h2 class="title is-3">글 목록</h2>
		<form method="post" action="${path1 }/GetBoardSearchCtrl">
			<table class="table" id="search_tb">
				<tr>
					<td>
						<select name="searchCondition" >
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
						<input type="text" name="searchKeyword" />
						<input type="submit" value="검색" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<table class="table" id="lst_tb">
		<thead>
			<tr>
				<th class="item1">번호</th>
				<th class="item2">제목</th>
				<th class="item3">작성자</th>
				<th class="item4">작성일</th>
				<th class="item5">조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="vo" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="${path1 }/GetBoardCtrl?num=${vo.seq }">${vo.title }</a></td>
				<td>${vo.name }</td>
				<td>${vo.regdate }</td>
				<td>${vo.show }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="4"><a href="${path1 }/board/addBoardForm.jsp" class="button is-info">글 등록</a></td>
			</tr>	
		</tbody>
	</table>
</div>
<jsp:include page="../footer.jsp"></jsp:include>


<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>