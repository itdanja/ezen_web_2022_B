console.log('js열림')

getBoardList(1); // js열릴때 페이지1 기본값 설정
function getBoardList( page ){
	// 해당 함수로부터 페이징번호 받기 = page
	console.log('해당 페이지 주세요 : ' + page);
	$.ajax({
		url : "/jspweb/board/info",
		method : "get" ,
		data : { "type" : 1 , "page" : page } ,	// 1:전체출력 2:개별출력 / page : 표시할 페이징번호
		success : (r)=>{
			console.log('통신'); console.log(r);
			
			// --------------------- 테이블 출력  ----------------------- //
			let html = `	<tr>
						<th> 번호 </th> <th> 제목 </th><th> 작성자 </th><th> 작성일 </th>
						<th> 조회수 </th>	<th> 좋아요 </th> <th> 싫어요 </th> </tr>`
			r.boardList.forEach( ( o , i ) => {
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
			// -------------------- 페이징 버튼 출력 --------------------- //
			html = ''; // 기존에 들어있던 내용 제거 
			// 이전 [ 만약에 현재 페이지가 1 이하 이면 이전페이지 없음 ]
			html += page <= 1 ?
					`<button onclick="getBoardList(${ page })" type="button"> 이전 </button>`
					:
					` <button onclick="getBoardList(${ page-1 })" type="button"> 이전 </button> `
			// 페이징 번호 버튼 들 
			for( let i = r.startbtn ; i<=r.endbtn ; i++ ){ // 시작버튼번호 부터 마지막버튼번호 까지 버튼 생성 
				html += `
					<button onclick="getBoardList(${i})" type="button"> ${i} </button>
					`
			}
			// 다음 [ 만약에 현재 페이지가 총페이지수 이상이면 다음페이지 없음 ]
			html += page >= r.totalpage ?
					`<button onclick="getBoardList(${ page })" type="button"> 다음 </button>`
					:
					`<button onclick="getBoardList(${ page+1 })" type="button"> 다음 </button>`
			document.querySelector('.pagebox').innerHTML = html;
		} // success end 
	}) // ajax end 
} // method end 

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