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
			<h3> 회원목록조회/수정 </h3>
			<table border="1">
				<tr> 	<th>회원번호 </th><th>회원성명 </th><th>전화번호 </th><th>주소 </th>
						<th>가입일자 </th><th>고객등급 </th><th>거주지역 </th>
				</tr>
				<%
					Dao dao = new Dao();		ArrayList<MemberDto> result = dao.getmemberlist();
					for( MemberDto dto : result ){ // for start
				%>
				<tr> 	<!-- a href="URL ? 변수명 = 데이터 & 변수명 = 데이터" -->
						<td><a href="update.jsp?custno=<%=dto.getCustno() %>"> <%=dto.getCustno() %></a> </td> 	
						<td><%=dto.getCustname() %> </td>	<td><%=dto.getPhone() %> </td> 		
						<td><%=dto.getAddress() %> </td>	<td><%=dto.getJoindate() %> </td> 	
						<td><%=dto.getGrade() %> </td>		<td><%=dto.getCity() %> </td>
				</tr>
					<%} // for end  %>
			</table>
		</center>
	<%@include file="footer.jsp" %>
</body>
</html>





