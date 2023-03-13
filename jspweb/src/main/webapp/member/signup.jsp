<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/signup.css" rel="stylesheet">
	
</head>
<body>
	<%-- <%@ include file="../header.jsp" %> --%> <!-- 상대경로 -->
	<%@ include file="/header.jsp" %>	<!--  (webapp이하생략)절대경로 -->
	
	<div class="container"> <!-- bs : 박스권 -->
		<form class="signupForm">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		
			<h3> Ezen Community </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다 </p>
			
			<div class="title">아이디</div>
			<input onkeyup="idcheck()" maxlength="30" type="text" name="mid" 	class="mid" >
			<div class="checkconfirm"></div>
			
			<div class="title">비밀번호</div>
			<input onkeyup="pwdcheck()" 		maxlength="20"	type="password" name="mpwd" class="mpwd" >		
				
			<div class="title">비밀번호 확인 </div>
			<input onkeyup="pwedconfromcheck()" maxlength="20"	type="password" name="mpwdconfirm" 	class="mpwdconfirm">	
			<div class="checkconfirm"></div>
			
			<div class="title" >이메일</div>
			<div class="emailbox">
				<input onkeyup="emailcheck()" type="text" name="memail" 	class="memail">	
				<button onclick="getauth()" class="authbtn" type="button" disabled > 인증 </button>
			</div>
			
			<!-- 인증코드 입력 구역  -->
			<div class="authbox">
				<!-- js 들어가는 자리 -->
			</div>
			<div class="checkconfirm"></div>
			
			<div class="title"> 프로필 </div>
			<div class="pimgbox">
				<input onchange="premimg(this)" type="file" name="mimg"	 		class="mimg">		
				<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>
			
			<button class="signupbtn" onclick="signup()" type="button"> 가입 </button>
		</form>
	
	
	</div>
	
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				환영합니다.
			</h3>
			<div class="modal_content">
				회원가입 축하 포인트 100 지급
			</div>
			<div class="modal_btns">
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	

	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>


