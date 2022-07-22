<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path1" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>질문 상세보기</title>
<style>
	.content{clear:both; width:100%; padding:80px 0;}
	.qna_table {width:1000px; margin: 0 auto; }
	.q_box {width: 800px; display:block; margin: 0 auto; font-size: 20px; border: 1px solid #ddd; padding: 20px;}
	b {padding-right:50px;}


</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="content">
		<div class="qna_table">
			<ul class="q_box" style="margin: 0 auto;">
				<li><b>글 제목</b><span>${question.qtitle }</span></li>
				<li style="display: inline; float:left;">
					<b>작성자</b><span class="uid">${question.u_id }</span>
				</li>
				<li style=" display: inline; float: right;">	
					<b>작성일</b><span>${question.qdate }</span>
				</li>
				<li class="con" style="margin-top: 80px;"><span>${question.qcontent }</span></li>			
			</ul>
			<c:if test="${question.acontent }">
			<ul class="a_box">
				<li><b>${sid }</b>${question.adate }</li>
				<li><p>${question.acontent }</p></li>
			</ul>
			</c:if>
			<ul>
				<li>
				<a href="${path1 }/GetQuestionListCtrl" class="button is-info">목록</a>
				<c:if test="${sid =='admin' && empty question.acontent }">
				<button class="button is-info" onclick= "window.open('${path1}/question/addAnswerForm.jsp','addForm','width=500 height=400')">답글달기</button>
				</c:if>
				<c:if test="${sid =='admin' && !empty question.acontent }">
				<a href=""class="button is-info">답글수정</a>
				</c:if>
				</li>
			</ul>
		</div>
	</div>

	<jsp:include page="../footer.jsp" />
</body>
</html>