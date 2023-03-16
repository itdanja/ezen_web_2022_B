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
		
		<table class="boardTable table table-hover">
			
		</table>
		
		<!-- 페이징처리 버튼들 -->
		<div>
			<button onclick="getBoardList(1)" type="button"> 1 </button>
			<button onclick="getBoardList(2)"  type="button"> 2 </button>
			<button onclick="getBoardList(3)" type="button"> 3 </button>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>






