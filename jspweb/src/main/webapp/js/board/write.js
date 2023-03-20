console.log( '함수');
console.log( memberInfo ) 

function bwrite(){
	
	// type="file" 에 직접적인 조작 불가능 
	// 1. 폼 문자열로 가져오기 
	let writeForm = document.querySelector('.writeForm')	
	console.log( writeForm );
	
	// 2. 폼 객체로 가져오기
	let writeFormAll = document.querySelectorAll('.writeForm');
	console.log( writeFormAll );
	
	// 3. 폼 객체 ---> new FormData 클래스 [ form 전송객체 ]
	let  writeFormData = new FormData( writeFormAll[0] );
	console.log( writeFormData )
	
	// 4. 
	$.ajax({
		url : "/jspweb/board/info" , 
		method : "post" ,
		data : writeFormData , 
		contentType : false , 	// 첨부파일 multipart/form-data
		processData : false , 
		success : (r) => {
			console.log('통신'); console.log( r );
			if( r == 'true'){ 
				alert('글쓰기 성공'); 
				location.href="/jspweb/board/list.jsp?cno="+document.querySelector('.cno').value; 
			}
			else{ alert('글쓰기 실패'); }
		}
	})
	
}


$(document).ready(function() {
        $('#summernote').summernote(
			{ heigth : 700 } 
		);
});
    
    
    