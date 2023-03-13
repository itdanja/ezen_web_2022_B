<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container"> 
		<h3> 회원수정 </h3>
		<div>
			<div>
				<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>
			<div>
				<div> 아이디 </div>
				<div class="mid"></div>
			</div>
			<div>
				<div> 현재비밀번호 </div>
				<input class="">  </input>
			</div>
			<div>
				<div> 새 비밀번호 </div>
				<input class=""> </input>
			</div>
			<div>
				<div> 새 비밀번호 확인 </div>
				<input class=""> </input>
			</div>
			<div>
				<div> 이메일 </div>
				<input class="memail"></input>
				<button type="button">인증</button>
			</div>
			<a href="/jspweb/member/update.jsp"><button type="button">회원수정</button></a>
		</div>
	</div>

</body>
</html>