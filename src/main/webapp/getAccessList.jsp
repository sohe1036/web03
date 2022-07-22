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
<title>접속자 통계 목록</title>
<%-- <jsp:include page="common.jsp"></jsp:include> --%>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.page_tit { border-bottom:1px solid #cdcdcd; margin-bottom:25px; }
#lst_tb2 { width:1280px; margin:20px; auto; }
#lst_tb2 li { clear:both; margin-right:15px; margin-top:15px; }
#lst_tb2 li div { float:left; min-width:80px; max-width:150px; }
#lst_tb2 li img { display:block; width:100%; }
#lst_tb2 li.nothing { width:100%; clear:both; text-align:center; font-weight:bold; 
height:60px; line-height:60px; border-top:1px solid #cdcdcd; border-bottom:1px solid #cdcdcd;
margin-top:20px; margin-bottom:15px; }
#btn_group { clear:both; }
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content" class="content_wrap">
	<section class="con_wrap">
		<div>
			
		</div>	
		<h2 class="page_tit">접속자 통계 목록</h2>
		<ul class="pro_lst" id="lst_tb2">
			<c:forEach items="${list }" var="vo" varStatus="status">
				<li>
					<div class="item1">${vo.no }</div>
					<div class="item2">${vo.request_uri }</div>
					<div class="item3">${vo.remote_address }</div>
					<div class="item4">${vo.server_name }</div>
					<div class="item5">${vo.session_id }</div>
					<div class="item6">${vo.response_time }</div>
					<div class="item7">${vo.reg_date }</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>