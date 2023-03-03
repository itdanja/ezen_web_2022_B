<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p> JSP 웹 프로젝트 시작 [ ctrl+f11 ] </p>
	<p> 강력 새로고침 [ ctrl+f5 ] </p>
	
	<h3> 예제1: [C:쓰기] 입력받은 데이터 -> JS -> 서블릿[JAVA] -> DAO </h3>
		<!-- <input> 입력 tag 	class : 식별자[ id , class , name ] -->
	data : <input type="text" class="inputdata"> 
		<!-- <button> 버튼 tag 	type="button"	onclick="js작성" -->
<!-- 	<button type="button" onclick="alert('클릭')"> 예제1 실행 </button> -->
	<button type="button" onclick="Ex1()"> 예제1 실행 </button>
	
	<h3> 예제2: [R : 읽기 ] DAO -> 서블릿[JAVA] -> JS -> HTML </h3>
	<div class="ex2box">
		<!-- 서블릿에게 받은 데이터 표시되는 구역 -->
	</div>
	
	<h3> 과제1 : </h3>
	<!-- 
	
	cmd -> ipconfig
	과제1 : 카카오톡 [ http://192.168.17.96:8080/jspweb/index.jsp   ]
	
		- HTML,JS,DAO 파일 그대로 , '서블릿' 만 새로 만들기 Q1
		[ C ]
			1. HTML 데이터 1개 입력받기
			2.HTML에서 입력받은 데이터를 JS 이동
			3. JS 데이터를 서블릿으로 이동[ AJAX 사용 ]
			4. 서블릿 데이터를 DAO 에게 전달 [ insert ]
		[ R ]
			1. DAO에서 모든 데이터를 호출 [ select ] 
			2. DAO에서 출력한 데이터를 서블릿으로 반환 
			3. DAO결과를 서블릿에서 JS로 이동 [ AJAX 사용 ]
			4. JS에서 HTML로 출력 
 
	 -->
	
	
	<!-- 최신 jquery[ js 라이브러리 ] 가져오기  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 JS 가져오기 [ 경로 : /프로젝트명/[webapp폴더생략]/폴더/파일명 ] -->
	<script src="index.js" type="text/javascript"></script>
	<!-- <script src="js/index.js" type="text/javascript"></script> -->
	

</body>
</html>