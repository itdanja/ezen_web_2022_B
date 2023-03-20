<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/list.css" rel="stylesheet">
	<link href="/jspweb/css/view.css" rel="stylesheet">
	

</head>
<body>

	<%@include file ="/header.jsp" %>
	<%
		/* JAVA 코드 들어가는 자리 */
		
		// 1. jsp 이용한 http url 변수 호출 
		String bno = request.getParameter("bno");
	%>
		<!-- JAVA코드를 HTML에 출력하는 자리 -->
		
	<input class="bno" type="hidden" value="<%=bno%>">
	
	<div class="container">
		<div class="boardbox">
		
			<div class="viewtop">
				<div>
					<img src="" class="hpimg mimg">
				</div>
				<div class="rviewtop">
					<div class="mid">  </div>
					<div>
						<span class="bdate"> </span>
						<span> <i class="far fa-eye"></i> <span class="bview"></span> </span>
						<span onclick="bIncrease(2)" > <i class="far fa-thumbs-up"></i> <span class="bup"></span> </span>
						<span onclick="bIncrease(3)" > <i class="far fa-thumbs-down"></i><span class="bdown"> </span> </span>
					</div>
				</div>
			</div>
			
			<div class="btitle"> </div>
			
			<div class="bcontent"> </div>
			
			<div class="bfile"> </div>
			
			<div class="btnbox">  </div>
			
			<div class="replycount">  </div>
			
			<div class="replywritebox"> 
				<textarea class="rcontent" rows="" cols=""></textarea>
				<button class="rwritebtn bbtn" onclick="rwrite()" type="button">댓글작성</button>
			</div>
			
			<div class="replylistbox"> </div>
			
		</div>
	</div>
	
	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>

</body>
</html>

















