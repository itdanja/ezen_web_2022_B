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
	
	<%
		// 1. jsp 로그인 여부 제어 
		Object o = request.getSession().getAttribute("login");
		if( o == null ){
			response.sendRedirect("/jspweb/member/login.jsp");
		}
		// 2. HTTP URL 안에 있는 매개변수 bno 호출 
		String bno = request.getParameter("bno");
	%>
	<input type="hidden" name="bno" class="bno" value="<%=bno%>">
	<div class="container">
		<h3> 글수정 </h3>
		<form class="updateForm">
			<div>
				카테고리 : <select name="cno" class="cno">
							<option value="1"> 공지사항 </option>
							<option value="2"> 커뮤니티 </option>
							<option value="3"> QnA </option>
							<option value="4"> 노하우 </option>
						</select>
			</div>
			<div>
				제목	: <input name="btitle" class="btitle" type="text">
			</div>
			<div>
				내용 : <textarea name="bcontent" class="bcontent" rows="3" cols="30"></textarea>
			</div>
			<div>
				기존 첨부파일 : <span class="oldbfile"></span> 
				<button type="button">삭제</button>
				변경할 첨부파일 : 
				<input name="bfile" type="file">
			</div>
			<button onclick="bupdate()" type="button">수정</button>
		</form>
	</div>
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>

</body>
</html>