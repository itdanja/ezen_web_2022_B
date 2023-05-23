<%@page import="controller.Dao"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<center>
			<h3> 성적 입력 </h3>
			<form name="addForm" action="/HRD_2/add" method="post">
				<table border="1" style="border-collapse: collapse;">
					<tr> <td> 학번 </td> <td> <input type="text"  	class="sno"		name="sno" /> </td> </tr>
					<tr> <td> 국어점수 </td> <td> <input type="text" 	class="ekor" 	name="ekor" /> </td> </tr>
					<tr> <td> 수학점수 </td> <td> <input type="text" 	class="emath" 	name="emath" /> </td> </tr>
					<tr> <td> 영어점수 </td> <td> <input type="text" 	class="eeng" 	name="eeng" /> </td> </tr>
					<tr> <td> 역사점수 </td> <td> <input type="text" 	class="ehist" 	name="ehist" /> </td> </tr>
					<tr><td colspan="2"> <!-- 열병합 -->
							<center><button type="button" onclick="add()">등록하기</button></center>
						</td>
					</tr>
				</table>
			</form>
		</center>
	<%@ include file="footer.jsp" %>
	
	<script type="text/javascript" src="index.js"></script>
	
</body>
</html>










