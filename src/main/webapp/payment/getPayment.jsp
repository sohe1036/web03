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
<title>판매상세보기</title>
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
			<h2 class="title is-3">판매상세보기</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>주문번호</th>
						<td>
							<span>${payment.ono }</span>
							<input type="hidden" name="ono" value="${payment.ono }" />
						</td>
					</tr>
					<tr>
						<th>결제정보</th>
						<td>
							<c:if test="${payment.paytype =='credit'}">	
							<span>신용카드</span>
							</c:if>
							<c:if test="${payment.paytype =='check'}">
							<span>체크카드</span>
							</c:if>
							<c:if test="${payment.paytype =='account'}">
							<span>무통장입금</span>
							</c:if>	
							<input type="hidden" name="paytype" value="${payment.paytype }">
						</td>
					</tr>
					<tr>
						<th>주문일</th>
						<td>
							<span>${payment.sdate }</span>
							<input type="hidden" name="sdate" value="${payment.sdate }" />
						</td>
					</tr>
					<tr>
						<th>상품번호</th>
						<td>
							<span>${payment.gno }</span>
							<input type="hidden" name="gno" value="${payment.gno }" />
						</td>
					</tr>
					<tr>
						<th>수량</th>
						<td>
							<span>${payment.pieces }</span>
							<input type="hidden" name="pieces" value="${payment.pieces }" />
						</td>
					</tr>
					<tr>
						<th>판매금액</th>
						<td>
							<span>${payment.money }</span>
							<input type="hidden" name="money" value="${payment.money }" />
						</td>
					</tr>
					<tr>
						<th>구매자 아이디</th>
						<td>
							<span>${payment.u_id }</span>
							<input type="hidden" name="u_id" value="${payment.u_id }" />
						</td>
					</tr>
					<tr>
						<th>수취인명</th>
						<td>
							<span>${payment.rname }</span>
							<input type="hidden" name="rname" value="${payment.rname }" />
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>
							<span>${payment.tel }</span>
							<input type="hidden" name="tel" value="${payment.tel }" />
						</td>
					</tr>
						<tr>
						<th>주소</th>
						<td>
							<P>${payment.postcode }</P>
							<P>${payment.addr1 }</P>
							<P>${payment.addr2 }</P>
							<input type="hidden" name="postcode" value="${payment.postcode }" />
							<input type="hidden" name="addr1" value="${payment.addr1 }" />
							<input type="hidden" name="addr2" value="${payment.addr2 }" />
						</td>
					</tr>
					<tr>
						<th>요청메세지</th>
						<td>
							<span>${payment.memo }</span><br>
							<input type="hidden" name="memo" value="${payment.memo }">
						</td>
					</tr>
					<tr>
						<th>송장번호</th>
						<td>
							<c:if test="${!empty payment.transno }">		
								<input type="text" name="transno" value="${payment.transno }"/>
							</c:if>
							<c:if test="${empty payment.transno }">		
								<input type="text" name="transno" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th>택배사</th>
						<td>
							<c:if test="${!empty payment.transco }">		
								<input type="text" name="transco" value="${payment.transco }"/>
							</c:if>
							<c:if test="${empty payment.transco }">		
								<input type="text" name="transco" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th>배송상태</th>
						<td>
								<select name="rstatus">
									<option value="배송시작">배송시작</option>
									<option value="배송중">배송중</option>
									<option value="배송완료">배송완료</option>
								</select>
						</td>
					</tr>
					<tr>
						<th>도착예정일</th>
						<td>
							<c:if test="${!empty payment.rdate }">
							<input type="text" name="rdate" value="${payment.rdate }">
							</c:if>
							<c:if test="${empty payment.rdate }">
								<input type="date" name="rdate">
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="운송장 입력" class="button is-info"/>
							<input type="reset" value="취소" class="button is-info"/>
							<a href="${path1 }/DelPaymentCtrl?ono=${payment.ono }&gno=${payment.gno }&pieces=${payment.pieces }" class="button is-info">판매 정보 삭제</a>
							<a href="${path1 }/GetPaymentListCtrl" class="button is-info">목록</a>
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