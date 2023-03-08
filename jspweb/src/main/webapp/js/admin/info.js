// js -> admin -> info.js

console.log( 'js열림')

getMemberList();
function getMemberList(){
	$.ajax({
		url: "/jspweb/member",
		method : "get",
		//data : "" ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th> 번호 </th>
							<th> 프로필 </th>
							<th> 아이디 </th>
							<th> 이메일주소 </th>
							<th> 비고 </th>
						</tr>`
			r.forEach( (o,i) =>{
				// 2. 테이블 내용물 추가 구성 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> ${ o.mimg } </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
							<td> </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.mListTable').innerHTML = html;
			
		}
	})
}







