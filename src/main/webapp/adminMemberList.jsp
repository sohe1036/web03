<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {	border-collapse: collapse; }
td, th {	border: #ABF200 solid; padding:14px; }
</style>
</head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>	
	$(document).ready(function() {		
		$("#con").hide();		
		$("#b").click(function() {						
			$.ajax({				
				url : "MemberJSONCtrl", // MemberJSONCtrl의 JSONObject 값을 가져옴
				dataType : "json", // 데이터 타입을 json
				cache : false, // true : 새로 고침 동작을 하지 않고, 저장된 캐시에서 불러오게됨, false:새로 불러옴 
				success : function(data) {
					$("#con").empty(); //id가 con을 초기화					
					$("<table>").css({						
						backgroundColor : "#ececec",						
						border : "solid 3px gold",
						margin : "20px auto",
						}).appendTo("#con"); // 테이블을 생성하고 그 테이블을 div에 추가함					
						var key = Object.keys(data["memberList"][0]); // 키값(항목명)을 가져옴					
						$("<tr>" , {												
							html : "<th>"+key[8]+"</th>"+  // 컬럼명들								
							"<th>" + key[6] + "</th>"+								
							"<th>" + key[9] + "</th>"+								
							"<th>" + key[7] + "</th>"											
							}).appendTo("table") // 이것을 테이블에붙임					
							$.each(data.memberList, function(index, memberList) { // 이치를 써서 모든 데이터들을 배열에 넣음												
								var items = [];						
								items.push("<td>" + memberList.userid + "</td>"); // 여기에 id pw addr tel의 값을 배열에 넣은뒤						
								items.push("<td>" + memberList.userpw + "</td>");						
								items.push("<td>" + memberList.email + "</td>");						
								items.push("<td>" + memberList.tel + "</td>");						
								$("<tr/>", {							
									html : items // 티알에 붙임,						
								}).appendTo("table"); // 그리고 그 tr을 테이블에 붙임					
							});//each끝				
						}			
				});
				$("#con").fadeToggle("slow")											
			});	
		});
</script>
<body>	
<input type="button" id="b" value="회원정보보기">	
<div id="con"></div>
</body>
</html>