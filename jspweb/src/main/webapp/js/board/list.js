console.log('js열림')

getBoardList();
function getBoardList(){

	$.ajax({
		url : "/jspweb/board/info",
		method : "get" ,
		success : (r)=>{
			console.log('통신');
			console.log(r);
			
		}
	})

}