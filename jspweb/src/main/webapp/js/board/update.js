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
			document.querySelector('.oldbfile').innerHTML = r.bfile;
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
			console.log(r);
		}
	})
	
}






























