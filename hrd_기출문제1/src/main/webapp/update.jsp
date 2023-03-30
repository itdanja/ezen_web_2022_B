<%@page import="controller.MemberDto"%>
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
	<%
		// 1. 클릭된 회원번호 요청 
		int custno = Integer.parseInt( 
				request.getParameter("custno") );
		// 2. 회원번호를 가지고 DAO에게 DTO 응답받기 
		Dao dao = new Dao();
		MemberDto dto = dao.getmember(custno);	
	%>
	<center>
		<h3> 홈쇼핑 회원 정보 수정 </h3>
		<form name="updateform" action="/hrd_exam1/join" method="get">
			<table border="1">
				<tr> 
					<td> 회원번호(자동발생)</td> 
					<td> <input value="<%=dto.getCustno() %>" name="custno" type="text"> </td>
				</tr>
				<tr> <td> 회원성명 </td>	<td> <input value="<%=dto.getCustname()%>"  name="custname" type="text"> </td>
				</tr>
				<tr> 
					<td> 회원전화 </td>	<td> <input value="<%=dto.getPhone()%>" name="phone" type="text"> </td>
				</tr>
				<tr> 
					<td> 회원주소 </td>	<td> <input value="<%=dto.getAddress()%>" name="address" type="text"> </td>
				</tr>
				<tr> 
					<td> 가입일자 </td>		<td> <input value="<%=dto.getJoindate()%>" name="joindate" type="text"> </td>
				</tr>
				<tr> 
					<td> 고객등급[A:VIP,B:일반,C:직원]</td>	<td> <input value="<%=dto.getGrade()%>"  value="" name="grade" type="text"> </td>
				</tr>
				<tr> 
					<td> 도시코드</td>		<td> <input value="<%=dto.getCity()%>" name="city" type="text"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<button onclick="onupdate()" type="button">수정</button>
							<a href="view.jsp"><button type="button">조회</button> </a>
						</center>
					</td>
				</tr>
			</table>
		</form>
	</center>
	
	<script type="text/javascript">
		function onupdate() { document.updateform.submit(); alert('수정성공'); }	
	</script>
	
	<%@include file="footer.jsp" %>

</body>
</html>


















