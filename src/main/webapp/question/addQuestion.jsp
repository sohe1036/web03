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
<title>질문하기</title>
<style>
.content {clear:both; width:100%; display:block;}	
.question_table {width:1000px; margin:20px auto;}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="content">
		<div class="question_table">
			<form action="${path1 }/AddQuestionCtrl" method="post">
				<table>
					<tbody>
						<tr>
							<th><label for="qtitle" >질문제목</label></th>
							<td><input type="text" name="qtitle" id="qtitle" ></td>
						</tr>
						<tr>
							<th><label for="qcontent" >질문내용</label></th>
							<td><input type="text" name="qcontent" id="qcontent" style="width:500px; height: 300px;"></td>
						</tr>
						<tr>
							<th><label for="u_id" >작성자</label></th>
							<td><input type="text" name="u_id" id="u_id" value="${sid }" readonly></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="등록" class="button is-primary"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>