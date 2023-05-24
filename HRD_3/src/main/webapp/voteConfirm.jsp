
<%@page import="java.time.LocalDate"%>
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

	<%@include file="header.jsp" %>
		<center>
			<h3>투표검수조회</h3>
				<table border="1" style="border-collapse: collapse; width: 700px; text-align: center;">
					<tr>
						<th> 성명 </th><th> 생년월일 </th>
						<th> 나이 </th><th> 성별 </th>
						<th> 후보번호 </th><th> 투표시간 </th>
						<th> 유권자확인 </th>
					</tr>
					
					<%
						Dao dao = new Dao();
						List<Dto> list = dao.getVoteConfirm();
						
						for( int i = 0 ; i<list.size(); i++ ){
							Dto dto = list.get(i);
					%>
						<tr>
							<th> <%=dto.getV_name() %> </th>
							<th> <%=
							
									dto.getV_jumin().substring(0,2)+"년"+
									dto.getV_jumin().substring(2,4)+"월"+
									dto.getV_jumin().substring(4,6)+"일생"
									
									%> </th>
									
									<!-- 
										LocalDate.now() : 현재 날짜 구하기 
										LocalDate.now().getYear() : 현재 날짜의 연도 구하기
										"19"+주민등록번호 앞 자리 : 1984
										
									 -->
							<th> <%=
							
									"만 " + ( LocalDate.now().getYear() - Integer.parseInt( "19"+dto.getV_jumin().substring(0,2) ) ) +"세"
							
									%> </th>
									
							<th> <%=dto.getV_jumin().charAt(6) == '1' ? "남" :"여" %> </th>
							<th> <%=dto.getM_no() %> </th>
							<th> 
								<%= dto.getV_time().substring(0,2)+":"+ dto.getV_time().substring(2,4) %>  
							</th>
							<th> 
								<%= dto.getV_confirm().equals("Y") ? "확인" : "미확인 " %> 
							</th>
						</tr>
					<%
						}
					%>
					
				</table>
		</center>
	<%@include file="footer.jsp" %>
</body>
</html>









