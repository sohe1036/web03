<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />  		<!-- 현재 디렉토리 : web03 -->
<%
	String sid = "";
	if(session != null){
		sid =  (String)session.getAttribute("sid");		//세션에서 sid 값 받아와
	}
%>
<header id="header" >
	<div class="hd_wrap">
		<nav class="navbar" role="navigation" aria-label="main navigation">
		  <div class="navbar-brand">
		    <a class="navbar-item" href="${path }/index.jsp">
		      <img src="${path }/img/logo.svg" width="112" height="28">
		    </a>
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		  <div id="gnb" class="navbar-menu">
		    <div class="navbar-start">
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link" href="${path }/GetGoodsListCtrl?gtype=luggage">
		          캐리어
		        </a>
		        <div class="navbar-dropdown">
		          <a class="navbar-item" href="${path }/GetGoodsListCtrl?gtype=luggage&gsize=76CM">
		            대형캐리어
		          </a>
		          <a class="navbar-item">
		            중형캐리어
		          </a>
		          <a class="navbar-item">
		            소형캐리어
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link" href="${path }/GetGoodsListCtrl?gtype=backpack">
		          백팩
		        </a>
		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            대형백팩
		          </a>
		          <a class="navbar-item">
		            중형백팩
		          </a>
		          <a class="navbar-item">
		            소형백팩
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          가방
		        </a>
		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            서류가방
		          </a>
		          <a class="navbar-item">
		            크로스백
		          </a>
		          <a class="navbar-item">
		            보스턴백
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          고객센터
		        </a>
		
		        <div class="navbar-dropdown">
		          <a class="navbar-item"  href="${path }/GetBoardListCtrl">
		            공지사항
		          </a>
		          <c:if test="${!empty sid }">	
		          <a class="navbar-item">
		            1:1 문의
		          </a>
		          </c:if>
		          <a class="navbar-item">
		            자주하는 질문 및 답변
		          </a>
		        </div>
		      </div>
		    </div>
				<c:if test="${empty sid }">		<!-- sid값이 없을때 :회원가입하거나 로그인 가능 -->
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		          <a class="button is-primary" href="${path }/member/agree.jsp">
		            <strong>회원가입</strong>
		          </a>
		          <a class="button is-primary" href="${path }/member/login.jsp">
		            로그인
		          </a>
		        </div>
		      </div>
		    </div>
		    	</c:if>
		    	<c:if test="${!empty sid }">		<!-- sid값이 있을때(로그인 된 상태) -->
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		          <a href="${path }/MypageCtrl?u_id=${sid }" class="button is-primary">
		            <strong>마이페이지</strong>
		          </a>
		            <a href="${path }/GetBasketListCtrl?u_id=${sid }" class="button is-primary">
		            <strong>장바구니</strong>
		          </a>
		           <a href="${path }/LogOutCtrl" class="button is-primary">
		            로그아웃
		          </a>
		        </div>
		      </div>
		    </div>
		    	</c:if>
		    		<c:if test="${sid=='admin' }">		<!-- sid값이 admin일 때 (관리자가 로그인) -->
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		          <a href="${path }/GetBoardListCtrl" class="button is-primary">
		            <strong>공지 관리</strong>
		          </a>
		          <a href="${path }/GetMemberListCtrl" class="button is-primary">
		            회원관리
		          </a>
		          <a href="${path }/GetGoodsListCtrl" class="button is-primary" >
		            제품관리
		          </a>
		          <a href="${path }/AccessListCtrl" class="button is-primary">
		            접속자관리
		          </a>    
		        </div>
		      </div>
		    </div>
		    	</c:if>
		  </div>
		</nav>
	</div>
</header>