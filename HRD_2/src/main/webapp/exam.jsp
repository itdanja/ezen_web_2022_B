<%@page import="java.text.DecimalFormat"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
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
	<%@ include file="header.jsp" %>
		<center>
			<h3> 학생성적</h3>
			<table border="1" style="border-collapse: collapse; text-align: center; width: 700px;">
				<tr>
					<th> 학년 </th> <th> 반 </th> <th> 번호 </th>
					<th> 이름 </th> <th> 국어 </th> <th> 수학 </th>
					<th> 영어 </th> <th> 역사 </th> <th> 합계 </th>
					<th> 평균 </th> <th> 순위 </th>
				</tr>
				
				<!-- ------ 반복문이 들어갈 자리 ---------  -->
				<%
					Dao dao = new Dao();
					List<Dto> list = dao.getExamList();
					
					// 과목 별 합계 / 평균 6개
					// 배열 선언 : 자료형[] 배열명 = { 초기값1 , 초기값2 };
					// 배열 선언 : 자료형[] 배열명 = new 자료형[길이];
					
					double[] sumArray = { 0.0 , 0.0 , 0.0 , 0.0 ,0.0 ,0.0};
					double count = 0; // 점수가 있는 학생개수 ;
					
					for( int i = 0 ; i<list.size() ; i++ ){
						Dto dto = list.get(i);
						// 과목별 누계 
						sumArray[0] += dto.getEkor(); 
						sumArray[1] += dto.getEmath(); 
						sumArray[2] += dto.getEeng(); 
						sumArray[3] += dto.getEhist(); 
						sumArray[4] += dto.getSum(); 
						sumArray[5] += dto.getAvg(); 
						// 점수가 있는 학생 
						if( dto.getEkor() != 0 ) count++;
						
						// 점수가 없으면
						if( dto.getEkor() == 0 ){
				%>
				<tr>
						<td> <%=dto.getSno1() %> </td> <td> <%=dto.getSno2() %> </td> <td> <%=dto.getSno3() %> </td>
						<td> <%=dto.getSname() %> </td> <td> </td> <td>  </td>
						<td></td> <td></td> <td> </td>
						<td>  </td> <td>  </td>
					</tr>
				<% 		
						// 점수가 있으면	
						}else{
				%>
					<tr>
						<td> <%=dto.getSno1() %> </td> <td> <%=dto.getSno2() %> </td> <td> <%=dto.getSno3() %> </td>
						<td> <%=dto.getSname() %> </td> <td> <%=dto.getEkor() %> </td> <td> <%=dto.getEmath() %> </td>
						<td> <%=dto.getEmath() %> </td> <td> <%=dto.getEhist() %> </td> <td> <%=dto.getSum() %> </td>
						<td> <%=dto.getAvg() %> </td> <td> <%=dto.getRank() %> </td>
					</tr>
				<% 			
						}
				%>
				<% 
					}
				%>
				<!-- --------------------------------- -->
				<tr>
					<td colspan="4">총 합</td> 
					
					<% DecimalFormat df = new DecimalFormat("#.#"); %>
					
					<% for( int i = 0 ; i<=5 ; i++ ){ %>
						<td><%= df.format( sumArray[i] ) %></td>
					<%} %>
					<td></td>
				</tr>
				
				<tr>
					<td colspan="4">총 평균</td>
					<% for( int i = 0 ; i<=5 ; i++ ){ %>
						<td><%= df.format(  sumArray[i]/count ) %></td>
					<%} %>
					<td></td>
				</tr>
				
			</table>
		</center>
	<%@ include file="footer.jsp" %>
</body>
</html>














