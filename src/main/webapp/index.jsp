<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>메인</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
	<h2 class="title is-3">메인 페이지</h2>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>