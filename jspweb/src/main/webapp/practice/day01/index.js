
// JS 함수 
// function 함수명 ( 매개변수 ){ 실행코드 }
function Ex1( ){
	let data = document.querySelector('.inputdata').value;
	console.log( data );
	
	$.ajax({
		url : "/jspweb/Ex1" ,		// 통신할 서블릿 주소 
		method : "post" , 								// HTTP 메소드 
		data : { "data" : data } , 						// 데이터 보내기 
		success : function(result){   					// 데이터 받기 
			console.log( result );
			Ex2();
		}
	});
}
//
Ex2( ); // 페이지 열리면 데이터호출 
function Ex2(){
	$.ajax({
		url : '/jspweb/Ex1' ,
		method: "get" , 
		// data : { } , 
		success : function(result){
			console.log( result );
			document.querySelector('.ex2box').innerHTML = result;
		}
	 });
}

	
	// JS --> 서블릿 이동 
	// 0. $ : jqeury 표현식 [ jqery 라이브러리 필요 ]
	// 1. ajax 메소드 사용 : $.ajax( );
	// 2. ajax 매개변수[속성:객체형태] : {  }	-- >  $.ajax( {  })
	// 3. 속성 
		// 1. url : 통신할 경로[ 서블릿(클래스) 주소 : /프로젝트명[@WebServlet]("/Indextest") ]
			/*
				url : "http://localhost:8080/jspweb/Indextest" 
				url : "http://192.168.17.96:8080/jspweb/Indextest"
				url : "/jspweb/Indextest"
			*/
		// 2. method : http 메소드방식
			/*
				get	
				post 
			*/
		// 3. data : 통신할때 데이터 보내기 
			/*
				js객체 형태 : { 매개변수명1 : 데이터 , 매개변수명2 : 데이터 ~~  }
			*/
		// 4. success : 통신후 응답 데이터 받기 	
			/*
				1. success : function( 매개변수 ){}
				2. success : ( 매개변수 ) => { }
			*/ 
	/* 
		$.ajax({ 
			url : "" , 
			method : "" , 
			data : { 매개변수명 : 데이터 } , 
			success : function( result ){
				
			}
		});
	*/
	
	

	// document : 미리 만들어진 DOM객체
		// 1. querySelector( 식별자 ) : tag 1개  -> 변수/객체 에 저장 
			// 1. document.querySelector('.classname')
			// 2. document.querySelector('#idname')
			// 3. document.querySelector('tagname[name="namename"]')
		// 2. querySelectorAll( 식별자 ) : tag 여러개	-> 배열/리스트 에 저장
		
		// 3. querySelector().속성명
			// 1.   querySelector().value		: input , select , textarea [ div x table x ]
			// 2.   querySelector().innerHTML	: div , span , td 등등
			
