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
<title>메인</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.table_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="table_warp">
		<form action="${path1 }/EditReviewCtrl" method="post" enctype="multipart/form-data">
			<h2 class="title is-3">메인 페이지</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>번호</th>
						<td>
						<span>${review.reno }</span>
						<input type="hidden" name="reno" value="${review.reno }" />
						</td>
					</tr>
					<tr>
						<th>별점</th>
						<td>
						<input type="number" min="1" max="5" name="best" value="${review.best }">
						</td>
					</tr>
					<tr>
						<th>글 제목</th>
						<td><input type="text" name="retitle" value="${review.retitle }" /></td>
					</tr>
					<tr>
						<th>글 내용</th>
						<td><textarea cols="80" rows="9" name="recontent" required>${review.recontent }</textarea></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>
						<span>${review.redate }</span>
						<input type="hidden" name="redate" value="${review.redate }" />
						</td>
					</tr>
					<tr>
						<th>리뷰이미지</th>
						<td>
						<img src="${path1 }/${review.reimg }">
						<input type="file" name="reimg" accept="*.jpeg,*.jpg, *.png, *.gif" />
						<input type="hidden" name="reimg" accept="*.jpeg,*.jpg, *.png, *.gif" value="${review.reimg }"/>
						</td>
					</tr>
					<tr>
						<th>상품번호</th>
						<td>
						<span>${review.gno }</span>
						<input type="hidden" name="gno" value="${review.gno }" />
						<input type="hidden" name="ono" value="${review.ono }" />
						</td>
					</tr>
					<tr>
					<td colspan="2">
					<input type="submit" value="수정" class="button is-info"/>
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