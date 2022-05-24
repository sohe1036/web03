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
<header id="header" class="panel-heading">
	<div class="hd_wrap">
		<nav class="navbar" role="navigation" aria-label="main navigation">
		  <div class="navbar-brand">
		    <a class="navbar-item" href="index.jsp">
		      <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
		    </a>
		
		    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		      <span aria-hidden="true"></span>
		    </a>
		  </div>
		  <div id="navbarBasicExample" class="navbar-menu">
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
		          <hr class="navbar-divider">
		          <a class="navbar-item">
		            쇼핑몰 찾아가기
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
		          <hr class="navbar-divider">
		          <a class="navbar-item">
		            제품4
		          </a>
		        </div>
		      </div>
		      <div class="navbar-item has-dropdown is-hoverable">
		        <a class="navbar-link">
		          고객센터
		        </a>
		
		        <div class="navbar-dropdown">
		          <a class="navbar-item"  href="GetBoardListCtrl">
		            공지사항
		          </a>
		          <a class="navbar-item">
		            1:1 문의
		          </a>
		          <a class="navbar-item">
		            자주하는 질문 및 답변
		          </a>
		          <hr class="navbar-divider">
		          <a class="navbar-item">
		            반품안내
		          </a>
		        </div>
		      </div>
		    </div>
		
		    <div class="navbar-end">
		      <div class="navbar-item">
		        <div class="buttons">
		          <a class="button is-primary">
		            <strong>Sign up</strong>
		          </a>
		          <a class="button is-light">
		            Log in
		          </a>
		        </div>
		      </div>
		    </div>
		  </div>
		</nav>
	</div>
</header>