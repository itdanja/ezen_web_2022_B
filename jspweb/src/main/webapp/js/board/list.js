console.log('js열림')

getBoardList();
function getBoardList(){
	$.ajax({
		url : "/jspweb/board/info",
		method : "get" ,
		data : { "type" : 1 } ,	// 1:전체출력 2:개별출력
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
			let html = `	<tr>
						<th> 번호 </th> <th> 제목 </th><th> 작성자 </th><th> 작성일 </th>
						<th> 조회수 </th>	<th> 좋아요 </th> <th> 싫어요 </th> </tr>`
			r.forEach( ( o , i ) => {
				html += `	<tr>
						<td> ${ o.bno } </td> 
						<td> <a href="/jspweb/board/view.jsp?bno=${ o.bno }">${ o.btitle }</a></td>
						<td> ${ o.mid } </td>
						<td> ${ o.bdate } </td>
						<td> ${ o.bview } </td>
						<td> ${ o.bup } </td> 
						<td> ${ o.bdown } </td> </tr>`
			})
			document.querySelector('.boardTable').innerHTML = html;
		}
	})

}

/*
	- 클릭한 pk[식별자] 이동하는 경우의수
		1. HTTP get메소드 방식의 a태그 이용한 pk 이동 
				<a href="/jspweb/board/view.jsp>
				http://localhost:8080/jspweb/board/view.jsp
				---> 추가 a태그에 변수 넘기기 
				<a href="/jspweb/board/view.jsp?변수명=데이터>
				<a href="/jspweb/board/view.jsp?변수명=데이터&변수명=데이터&변수명=데이터>
				<a href="/jspweb/board/view.jsp?bno=${o.bno}" >
				http://localhost:8080/jspweb/board/view.jsp?bno=1
				
*/