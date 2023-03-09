<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%@ include file="../header.jsp" %> --%> <!-- 상대경로 -->
	<%@ include file="/header.jsp" %>	<!--  (webapp이하생략)절대경로 -->
	<h3> 회원가입 </h3>
	
	<form class="signupForm">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		아이디 : 	<input onkeyup="idcheck()" maxlength="30" type="text" name="mid" 	class="mid" >			
			<span class="checkconfirm">x</span> <br/>
			
		비밀번호 :			<input onkeyup="pwdcheck()" 		maxlength="20"	type="password" name="mpwd" 			class="mpwd" >		
			<br/>
		비밀번호 확인 :  	<input onkeyup="pwedconfromcheck()" maxlength="20"	type="password" name="mpwdconfirm" 	class="mpwdconfirm">	
			<span class="checkconfirm">x</span> <br/>
		
		이메일 :			<input type="text" name="memail" 		class="memail">	
			<span class="checkconfirm">x</span> <br/>
		프로필 : 			<input type="file" name="mimg"	 		class="mimg">		<br/>
		<button onclick="signup()" type="button"> 가입 </button>
	</form>
	
	
	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>


