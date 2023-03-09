<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 모든페이지 공통 css -->
	<link href="/jspweb/css/index.css" rel="stylesheet">

</head>
<body>

	<h3> 헤더 입니다. </h3>
	<!-- 모든페이지 공통 메뉴 -->
	
	<div class="header">
		<!-- js 들어갈 자리 -->
	</div>
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 모든페이지 공통 js -->
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
	
	
</body>
</html>

<%-- 	
	<% 
		String login = 
		(String)request.getSession().getAttribute("login"); 
	%>
	<a href="/jspweb/index.jsp"> 홈 </a>
	<%
		if( login == null ){ // 로그인 안했다.
	%>
			<a href="/jspweb/member/signup.jsp">회원가입</a>
			<a href="/jspweb/member/login.jsp">로그인</a>	
	<% 	
		}else if( login.equals("admin") ){ // 로그인 했지만 관리자 아이디 이면 
	%>
			관리자 모드 
			<a href="/jspweb/admin/info.jsp">관리자페이지</a>
	<% 	
		}else{ // 그외 로그인한 회원들 
	%>	
			<%=login %>님 안녕하세요 
			<a href="/jspweb/member/logout.jsp"> 로그아웃 </a>
	<%	
		}
	%> 
--%>