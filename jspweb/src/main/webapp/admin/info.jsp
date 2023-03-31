<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<div class="container">
	
		<h3> char.js 사용 </h3>
		
		<div>
		  <canvas id="myChart"></canvas>
		</div>
		
		
	
		<h3> 모든 회원 명단 </h3>
		<table class="mListTable table">
		</table>
	</div>

	<!-- chart.js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>