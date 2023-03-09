console.log('js열림')

function login(){
	console.log('login() 열림');
	// 1. 입력받은 값 
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2. 
	$.ajax({
		url : "/jspweb/login" ,
		method : "post" ,
		data : { "mid" : mid , "mpwd" : mpwd } ,
		success : (r)=>{
			console.log( '통신');
			console.log( r );
		}
	})
	
	
}