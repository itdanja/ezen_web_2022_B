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
	
	 <%
	 	// 1. HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기 
	 	String cno = request.getParameter("cno");
	 	// 2. 표현식을 이용한 input , div 등등 대입 
	 %>
	 <!-- cno 숨겨서 js에게 전달  -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<div class="container">
		<h3 class="cname"></h3>
		
		<a href="write.jsp">글쓰기</a>
		
		<table class="boardTable table table-hover">
			
		</table>
		
		<!-- 페이징처리 버튼들 -->
		<div class="pagebox">
			
		</div>
	
		<div>
			<select class="key">	<!-- select 시 사용되는 조건의 필드명 -->
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text">	<!-- select 시 사용되는 조건의 데이터 -->
			<button onclick="getsearch()" type="button">검색</button>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>

	
		<!-- 검색창  -->
				<!-- 
					select * from board where 필드명 = 데이터 
					select * from board where bno = 1;
					select * from board where key like '%keyword%';
				-->






