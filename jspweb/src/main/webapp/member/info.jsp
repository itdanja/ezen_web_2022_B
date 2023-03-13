<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<!-- 모달 css -->
	<link href="/jspweb/css/modal.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>

	<div class="container"> 
	
		<h3> 회원정보 </h3>
		<div>
			<div>
				<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>
			<div>
				<div> 아이디 </div>
				<div class="mid"></div>
			</div>
			<div>
				<div> 이메일 </div>
				<div class="memail"></div>
			</div>
			<div>
				<div> 보유포인트 </div>
				<div class="mpoint"> 3000 </div>
			</div>
			
			<a href="/jspweb/member/update.jsp"><button type="button">회원수정</button></a>
			<button onclick="onpenModal()" type="button"> 회원탈퇴 </button>
		</div>
	</div>
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				회원탈퇴
			</h3>
			<div class="modal_content">
				정말 회원탈퇴 하시겠습니까? 
				<br>
				비밀번호 : <input type="password" class="mpwd" >
			</div>
			<div class="modal_btns">
				<button onclick="setDelete()" class="modal_check" 	type="button">탈퇴하기</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">취소</button>
			</div>
		</div>
	</div>
	
	<!-- 모달 js -->
	<script src="/jspweb/js/modal.js" type="text/javascript"></script>
	
	<script src="/jspweb/js/member/info.js" type="text/javascript"></script>
	
	

</body>
</html>

	<!-- 
		동일한 HTML에서 열리는 JS 파일은 메모리 공유
		* 단 먼저 호출된 js순
		* 주의 ajax
			1. $.ajax({})	비동기통신 [ 요청보내고 응답의 결과를 기다리지 않음 ] 
			
				요청				응답
				요청1-------- >
				|				요청1 처리
				|
				|
				|
				요청2-------- >	요청2	  처리 
				|
				|
				|
				|<-----------  요청2 응답 
				|
				|
			2. $.ajax({ async : false }) : 동기통신 
					요청				응답
				요청1-------- >
								요청1 처리
								|
								|
								|
					<----------	요청1 응답
				|
				|
				요청2-------- >	요청2	  처리 
								|
								|
								|
								|
				|<-----------  요청2 응답 
			
				
							 
			
	 -->















