<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>QnA 목록</title>
<style>
	.content{clear:both; width:100%; padding:80px 0;}
	.qnaTable {width:1000px; margin: 0 auto; }
	.qnaTable ul{font-size: 20px; }
	.qnaTable li{font-size: 18px; text-align: center; }
	.col1 {display: inline-block; width: 100px; }
	.col2 {display: inline-block; width: 450px; }
	.col3 {display: inline-block; width: 200px; }
	.col4 {display: inline-block; width: 150px; }
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="content">
		<div class="qnaTable">
			<ul>
				<li>
					<b class="col1">글번호</b>
					<b class="col2">글제목</b>
					<b class="col3">작성일</b>
					<b class="col4">작성자</b>
				<li>
			</ul>
		<c:forEach items="${qvo }" var="qvo" varStatus="status" >
			<ul>
				<li>
					<span class="col1">${qvo.qno }</span>
					<span class="col2"><a href="${path1 }/GetQuestionCtrl?qno=${qvo.qno}">${qvo.qtitle }</a></span>		
					<span class="col3">${qvo.qdate }</span>	
					<span class="col4">${qvo.u_id }</span>	
				</li>
			</ul>
		</c:forEach>	
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>