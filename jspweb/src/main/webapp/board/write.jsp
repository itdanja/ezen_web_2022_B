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
		<h3> 글쓰기 </h3>
		<form class="writeForm">
			카테고리 : <select name="cno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 커뮤니티 </osption>
						<option value="3"> QnA </option>
						<option value="4"> 노하우 </option>
					</select>
			제목	: <input name="btitle" type="text">
			내용 : <textarea name="bcontent" rows="3" cols="3"></textarea>
			첨부파일 : <input name="bfile" type="file">
			<button onclick="bwrite()" type="button">쓰기</button>
		</form>
	</div>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
	
	<!-- 
		
		HTML ---- > form [ 동기식 : 페이지전환이 있음 ] 
		<form action="통신할URL" method="HTTP메소드" >
		<form method="post" action="서블릿URL" enctype="multipart/form-data">
			1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송타입 
			2. enctype="multipart/form-data"
		- 주의 form 태그 안에 있는 <button> type 생략시 type="submit"( 폼보내기 )
			- form 태그 안에 있는 <button> type="button" 명시 
			
		vs JS ---- > AJAX [ 비동기식 , 동기식 ] 
		
	 -->

</body>
</html>