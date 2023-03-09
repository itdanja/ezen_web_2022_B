<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file = "/header.jsp" %>
	
	<br/>
	아이디 : <input type="text"		class="mid">			<br/>	
	비밀번호 : <input type="password" class="mpwd">			<br/>	
	<button type="button" onclick="login()"> 로그인 </button>

	<!-- 정의 js  -->	
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
</body>
</html>