<%@page import="controller.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp" %>
	
	<center>
		<h3> 회원 매출 조회 </h3>
		<table border="1">
			<tr> <td>회원번호</td><td>회원성명</td><td>고객등급</td><td>매출</td> </tr>
			<%	Dao dao = new Dao();
				ArrayList<MemberDto> result = dao.getsum();
				for( MemberDto dto : result  ){ // for s 
			%>
			<tr> <td><%=dto.getCustno() %></td>	<td><%=dto.getCustname() %></td>
				<td><%=dto.getGrade() %></td>	<td><%=dto.getPsum() %></td>
			</tr>
				<%} %>
		</table>
	</center>
	
	
	<%@include file="footer.jsp" %>

</body>
</html>



