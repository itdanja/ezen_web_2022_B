console.log('js실행')

getBoard();
function getBoard(){ 
	console.log( '함수실행' );
	
	let bno = document.querySelector('.bno').innerHTML;
	console.log( "bno : " + bno );
	
	$.ajax({
		url : "/jspweb/board/info",
		method: "get" ,
		data : { "type" : 2 , "bno" : bno },
		success : (r)=>{
			console.log('통신');
			console.log(r);
		}
		
	})
	
}