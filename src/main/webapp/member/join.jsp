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
		<form action="${path1 }/AddMemberCtrl" method="post" name="join_form" onsubmit="return joinCheck(this)">
			<h2 class="title is-3">회원가입</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
						<c:if test="${empty uid }">		<!-- 아이디입력 안했을때  -->
						<input type="text" name="u_id" id="u_id" required>
						</c:if>
						<c:if test="${!empty uid }">	<!-- 아이디 입력했을때 -->
						<input type="text" name="u_id" id="u_id" value="${uid }" required>		
						</c:if>
						<input type="button" value="아이디중복확인" onclick="idCheck()">		<!-- 아이디 입력 후 중복확인 눌렀을때 이벤트로 IdCheckCtrl로 이동 -->
						<input type="hidden" name="uid">
						<c:if test="${!empty msg }">				<!-- msg 값이 있을 때 value에 msg-->
							<input type="hidden" name="ck" value="${msg }">
						</c:if>
						<c:if test="${empty msg }">				<!-- msg 값이 없을 때 value 값 없음-->
							<input type="hidden" name="ck" value="">
						</c:if>	
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="u_pw" id="u_pw" value="" required></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="u_pw2" id="u_pw2" value="" required></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" id="name" required></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" name="tell" id="tell" required></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="email" name="email" id="email" required></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="text" name="birth" id="birth" required></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
						<input type="text" name="postcode" id="postcode">
						<input type="text" name="addr1" id="addr1" required>
						<input type="text" name="addr2" id="addr2" placeholder="상세주소 입력" required>
						<input type="button" value="주소찾기" onclick="findAddr()" class="button is-info">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입" class="button is-primary">
							<input type="reset" value="취소" class="button is-primary">
						</td>
					</tr>
				</tbody>			
			</table>
		</form>	
<script>
	function idCheck() {
		var uid = document.join_form.u_id.value;		//uid는 폼에 입력한 u_id값
		if(uid == "") {		//입력한 아이디가 없을 때
			alert("아이디를 입력해주세요.");
			return false;
		}else {
			location.href="${path1}/IdCheckCtrl?uid="+uid;		//입력한 아이디 값이 있을 때 IdCheckCtrl에 입력한 아이디값 전달
		}
	}
</script>	
<script>
	function joinCheck(f){
		if(f.u_pw.value!=f.u_pw2.value){			//비밀번호값 불일치
			alert("입력한 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return  false;
		}
		
		if(f.ck.value!="yes"){
			alert("아이디 중복확인이 필요합니다.");
			return  false;
		}
	}
</script>
<script>
	function findAddr(){
		new daum.Postcode({
			oncomplete: function(data) {
				console.log(data);
				var roadAddr = data.roadAddress;			//도로명
				var jibunAddr = data.jibunAddress;		//지번
				document.getElementById("postcode").value = data.zonecode;
				if(roadAddr !== '') {
					document.getElementById("addr1").value = roadAddr;				
				} else if(jibunAddr !== ''){
					document.getElementById("addr1").value = jibunAddr;
				}
			}
		}).open();
	}
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>