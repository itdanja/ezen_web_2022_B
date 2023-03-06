
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
		} 
	})
	
}






























