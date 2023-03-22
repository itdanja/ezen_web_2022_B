<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file ="/header.jsp" %>
	
	<div class="container">
			<!-- 채팅 내용물이 표시되는 구역 -->
		<div class="contentbox"></div>
			<!-- 채팅 입력창 -->
		<textarea class="msgbox" rows="" cols=""></textarea>
			<!-- 채팅 전송 버튼 -->
		<button onclick="보내기()" type="button">보내기</button>
	</div>
	
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>

</body>
</html>