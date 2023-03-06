
// 1. 
function doPOST(){
	alert('http POST 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" , 
		method : "post" , 
		success : ( result ) => { }
	})
}
// 2. 
function doGET(){
	alert('http GET 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" , 
		method : "get" , 
		success : function( result ){}
	})
}
// 3.
function doPUT(){
	alert('http PUT 메소드 실행합니다.');
	$.ajax({ 
		url:"/jspweb/Ex3" , 
		method : "put" , 
		success : ( result )=>{} 
	})
}
// 4. 
function doDELETE(){
	alert('http DELETE 메소드 실행합니다.');
	$.ajax({
		url : "/jspweb/Ex3" ,
		method : "delete",
		success : ( result  )=>{} 
	})
}
// ------------------------------------------------------ //
// 1. 등록 
function onwrite(){
	
	console.log( 'onwrite 함수 s ')
	let info = {
		content : document.querySelector('.content').value , 
		writer : document.querySelector('.writer').value
	}
	console.log( info )
	
	$.ajax({
		url : "/jspweb/Ex3/Board" , 
		method : "post" ,
		data :  info , 
		success : ( r )=> {
			console.log( 'post 응답성공');
			if( r == 'true' ){ 
				alert('등록성공'); 	onlist();
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
			}
			else{ alert('등록실패');}
		}  // succeess end 
	}) // ajax end 
} // 등록 end 


// 2. 모든 게시물출력 [ 1.js열릴때 2.글작성할때마다 ]
onlist();
function onlist(){
	
	$.ajax({
		url : "/jspweb/Ex3/Board" ,
		method : "get" ,
		success : ( r )=>{ 
			console.log( 'get 응답 성공 ');	console.log( r );
			// 1. 테이블 제목 구성 
			let html = 
						`<tr>
							<th> 번호 </th>
							<th> 제목 </th>
							<th> 작성자 </th>
							<th> 비고 </th>
						</tr>`;
			// 2. 테이블 내용 구성 
			r.forEach( (o,i) => {
				html += 
						`<tr>
							<td> ${ o.bno } </td>
							<td> ${ o.bcontent }</td>
							<td> ${ o.bwriter } </td>
							<td> 수정/삭제 </td>
						</tr>`;
				
			});
			// 3. 구성된 html 대입 
			document.querySelector('.boardtable').innerHTML = html;
					
		}
	})
	
}






























