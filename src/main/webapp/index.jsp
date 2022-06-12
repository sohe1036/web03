<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="path" value="${pageContext.request.contextPath }" />  	  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<style>
#content { margin-top: 10px; }
</style>
<title>메인</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
	<div class="main_img">
		<img src="${path }/img/main1.jpg">
	</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>