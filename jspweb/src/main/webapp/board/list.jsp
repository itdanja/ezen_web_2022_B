<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "/header.jsp" %>
	
	<div class="container">
		<h3> 게시물 목록 </h3>
		<a href="write.jsp">글쓰기</a>
		
		<table class="boardTable table">
			
		</table>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>