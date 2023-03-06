<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예제 1 : HTTP 메소드 </h3>
	<button onclick="doPOST()" 	type="button"> POST 메소드 </button>
	<button onclick="doGET()" 	type="button"> GET 메소드 </button>
	<button onclick="doPUT()" 	type="button"> PUT 메소드 </button>
	<button onclick="doDELETE()"type="button"> DELETE 메소드 </button>
	
	<h3> 예제 2 : 방문록 </h3>
	내용 : <input type="text"		class="content">		<br>
	작성자 : <input type="text"	class="writer">		<br>
	<button onclick="onwrite() " type="button"> 방문록 등록 </button>
	
	
	<!--  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!--  -->
	<script src="index.js" type="text/javascript"></script>

</body>
</html>


