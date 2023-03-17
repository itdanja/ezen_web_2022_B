console.log( '함수');
console.log( memberInfo ) 
console.log( memberInfo ) 

let bno = document.querySelector(".bno").value;
console.log( "bno : "+ bno);

// 1. 수정할 게시물 출력 
getBoard();
function getBoard(){
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : { "type" : 2 , "bno" : bno } ,
		success : (r)=>{
			console.log(r);
			document.querySelector('.btitle').value = r.btitle;
			document.querySelector('.bcontent').value = r.bcontent;
			
			// document.querySelector('.cno').value = r.cno;
			// 1. 기존 select option 가져와서 selectd
			let cnoSelect = document.querySelector('.cno');
				console.log( cnoSelect ); // select 
				console.log( cnoSelect.options[0] );// select 안에 있는 첫번째 option
			for( let i = 0 ; i<cnoSelect.options.length ; i++  ){
				// i는 0 부터 옵션<option>태그 개수만큼 반복 
				if( cnoSelect.options[i].value == r.cno ){
					// i번째 옵션<option>태그의 값과 현재 게시물의 카테고리번호와 일치하면
					cnoSelect.options[i].selected = true;
				}
			}
			
			// 2. 첨부파일 있을때 / 없을때
			let html = ''
			if(r.bfile == null ){ // 없을때 
				html += `<div>첨부파일없음</div>`;
			}else{ // 있을때
				html += `<div>
						기존 첨부파일 : <span class="oldbfile"> </span> 
						<button onclick="bfiledelete()" type="button">삭제</button>
						</div>
						`
			}
			
			html += `변경할 첨부파일 : 	<input name="bfile" type="file">`
			document.querySelector('.bfilebox').innerHTML = html;
			
			document.querySelector('.oldbfile').innerHTML = r.bfile;
		}
	})
} // 
// 2. 
function bupdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0];
	// 1. form 안에 있는 데이터 객체화 했다.
	let updateFormData = new FormData( updateForm );
		// 2. form 밖에 있거나 js에 있는 추가 데이터는 formData.set 추가
		// formdata객체명.set( '변수명' , 데이터 );
		updateFormData.set( 'bno' , bno ); // 수정할 대상 
	$.ajax({
		url : "/jspweb/board/info",
		method : "put" ,
		data : updateFormData , 
		contentType : false , 	
		processData : false , 
		success : (r)=>{
			if( r == "true"){
				alert('업데이트성공');
				location.href="/jspweb/board/view.jsp?bno="+bno;
			}else{
				alert('업데이트성공');
			}
		}
	})
} // end 

// 3. 
function bfiledelete(){
	alert('첨부파일만 삭제합니다.');
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "delete" , 
		data : { "bno" : bno , "type":2 } , // 1:게시물삭제[첨부파일포함]  // 2:첨부파일만 삭제
		success: (r) => {
			if( r =="true"){
				// 특정 div만 reload[랜더링] 방법!
					// 주의점!! : location.href+'(띄어쓰기한번).클래스명 '
				$(".bfilebox").load(  location.href+' .bfilebox');
					// load() :  jquery 제공하는 랜더링[새로고침] 함수 
					
				// - 해당 클래스명을 가진 태그 객체화
				// jquery 	: $(".클래스명") 			
				// 		vs 
				// js 		: document.querySelector('.bfilebox');
				// 불가능 : document.querySelector('.bfilebox').load( location.href+' .bfilebox'); 
			}else{
				
			}
		}
	})
}





























