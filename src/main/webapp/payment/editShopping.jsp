<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<%
	String sid = "";
	if(session != null){
		sid =  (String)session.getAttribute("sid");		//세션에서 sid 값 받아와
	}
%> 	
<%
	if(request.getParameter("bno")!=null){
		int bno = Integer.parseInt(request.getParameter("bno"));
	}
%> 	  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<title>결제정보 및 수정</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.form_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="form_warp">
		<form action="${path1 }/EditPaymentCtrl" method="post">
			<h2 class="title is-3">결제정보</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>주문번호</th>
						<td>
							<input type="text" name="ono" value="${payment.ono }" readonly>
							<input type="hidden" name="paytype" value="${payment.paytype }">		
							<input type="hidden" name="payno" value="${payment.payno }">
							<input type="hidden" name="money" value="${payment.money }">
							<input type="hidden" name="sdate" value="${payment.sdate }">
							<input type="hidden" name="pieces" value="${payment.pieces }">
							<input type="hidden" name="u_id" value="${payment.u_id }">
							<input type="hidden" name="transno" value="">
							<input type="hidden" name="transco" value="">
							<input type="hidden" name="rstatus" value="">
							<input type="hidden" name="rdate" value="">
						</td>
					</tr>
					<tr>
						<th>상품번호</th>
						<td><input type="text" name="gno" value="${payment.gno }" readonly></td>
					</tr>	
					<tr>
						<th>수취인명</th>
						<td><input type="text" name="rname" value="${payment.rname }" required></td>
					</tr>	
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="tel" value="${payment.tel }" required></td>
					</tr>	
					<tr>
						<th>주소</th>
						<td>
							<p><input type="text" name="postcode" value="${payment.postcode }" id="postcode"></p>
							<p><input type="text" name="addr1" id="addr1" value="${payment.addr1 }" required></p>
							<p><input type="text" name="addr2" id="addr2" value="${payment.addr2 }" placeholder="상세주소 입력" required>
							<input type="button" value="주소찾기" onclick="findAddr()" class="button is-info"></p>
						</td>
					</tr>	
					<tr>
						<th>배송메모</th>
						<td><input type="text" name="memo" value="${payment.memo }"></td>
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