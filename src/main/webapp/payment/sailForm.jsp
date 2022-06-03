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
<title>결제정보입력</title>
<style>
.navbar-link:not(.is-arrowless)::after { display:none; }
.form_warp { width: 800px; margin: 0 auto;}
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div id="content">
	<div class="form_warp">
		<form action="${path1 }/AddPatmentCtrl" method="post">
			<h2 class="title is-3">결제 정보입력</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>상품명</th>
						<td>
						<input type="text" name="gname" value="${goods.gname }" readonly>
						<input type="hidden" name="gno" value="${goods.gno }" >	<!-- 값을 받아와야하나 페이지에 나타낼 필요없으므로 hidden처리 -->
						<c:if test="${!empty bno }">		<!-- bno값이 공백이 아니면 -->
						<input type="hidden" name="bno" value="${bno }">		
						</c:if>
						</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>
						<input type="number" name="price" value="${goods.price }" readonly>
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td>
							<input type="number" name="pieces" value="1" min="1" max="${goods.pieces }" required>
						</td>
					</tr>
					<tr>
						<th>수취인 이름</th>
						<td>
							<input type="text" name="rname" id="rname" required >
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<input type="tel" name="tel" id="tel" required >
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<p><input type="text" name="postcode" id="postcode"></p>
							<p><input type="text" name="addr1" id="addr1" required></p>
							<p><input type="text" name="addr2" id="addr2" placeholder="상세주소 입력" required>
							<input type="button" value="주소찾기" onclick="findAddr()" class="button is-info"></p>
						</td>
					</tr>
					<tr>
						<th>배송메모</th>
						<td>
							<input type="text" name="memo" id="memo" >
						</td>
					</tr>
					<tr>
						<th>결제방식</th>
						<td>
							<select name="paytype" required>
								<option value="credit">신용카드</option>
								<option value="check">체크카드</option>
								<option value="account">무통장입금</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>카드사/은행명</th>
						<td><input type="text" name="payname" id="payname" ></td>
					</tr>
					<tr>
						<th>카드번호/계좌번호</th>
						<td><input type="text" name="payno" id="payno" ></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="주문" class="button is-primary">
							<input type="reset" value="취소" class="button is-primary">
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