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
		    <a class="navbar-item" href="${path }index.jsp">
		      <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
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
		        <a class="navbar-link">
		          쇼핑몰
		        </a>

		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            쇼핑몰 소개
		          </a>
		          <a class="navbar-item">
		            쇼핑몰 안내
		          </a>
		          <a class="navbar-item">
		            쇼핑몰 알아보기
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          제품안내
		        </a>
		        <div class="navbar-dropdown">
		          <a class="navbar-item">
		            제품1
		          </a>
		          <a class="navbar-item">
		            제품2
		          </a>
		          <a class="navbar-item">
		            제품3
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
		          <a class="navbar-item">
		            1:1 문의
		          </a>
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
		            Log in
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
		            <strong>my page</strong>
		          </a>
		           <a href="${path }/LogOutCtrl" class="button is-primary">
		            Log out
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
		           <a class="button is-primary" >
		            제품관리
		          </a>
		        </div>
		      </div>
		    </div>
		    	</c:if>
		  </div>
		</nav>
	</div>
</header>