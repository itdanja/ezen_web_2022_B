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
		/* JAVA 코드 들어가는 자리 */
		
		// 1. jsp 이용한 http url 변수 호출 
		String bno = request.getParameter("bno");
	%>
		<!-- JAVA코드를 HTML에 출력하는 자리 -->
	
	<div class="container">
		<h3> 게시물 개별 조회/보기 </h3>
		<div> 
			<div> 게시물번호  </div>
			<div class="bno"><%=bno %></div>
		</div>
		<div> 
			<div> 작성일 / 조회수 / 좋아요 / 싫어요  </div>
			<div class="infobox">  </div>
		</div>
		<div>
			<div> 작성자[프로필]  </div>
			<div class="pimgbox">  </div>
		</div>
		<div> 
			<div> 제목  </div>
			<div class="btitle">  </div>
		</div>
		<div> 
			<div> 내용  </div>
			<div class="bcontent">  </div>
		</div>
		<div> 
			<div> 첨부파일  </div>
			<div class="bfile">  </div>
		</div>
		<div class="btnbox">
		
		</div>
		
		<div>
			<textarea class="rcontent" rows="" cols=""></textarea>
			<button onclick="rwrite()" type="button">댓글작성</button>
		</div>
		
		<div class="replylistbox"> </div>
	
	</div>
	
	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>

</body>
</html>

















