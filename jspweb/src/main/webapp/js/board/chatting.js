/*

	코드 작성 = 요리사				JS = 개발자
	코드 실행 = 먹는사람				JS = 유저	

	소켓 : 두 프로그램간의 양방향 통신 종착점[ 도착지 ]
	서버소켓 		: [JAVA] 서버가 가지고 있는 소켓
	클라이언트소켓 	: [JS] 클라이언트 가 가지고 있는 소켓 [ 각 클라이언트마다 ]
	
	카카오톡유저							카카오톡 본사/서버실
	클라이언트								서버
	new WebSocket(서버소켓URL)				@ServerEndpoint("/서버소켓URL")
		1.클라이언트소켓.onopen		<-----연결------>		@OnOpen
		2.클라이언트소켓.sned()		------보내기----->	@OnMessage
		3.클라이언트소켓.onmessage	<------보내기----		세션객체.getBasicRemote().sendText( )		
		4.클라이언트소켓.onmessage 	<-----연결끊기---> 	@OnClose
		
	유재석	안녕------------------->
	(소켓)	<-------------------- 안녕
	안산			
			
	강호동								(서버소켓) 채팅방( 유재석,강호동,신동엽 )
	(소켓)	<-------------------- 안녕	제주도
	수원	
			
	신동엽
	(소켓)	<-------------------- 안녕
	서울
			
			
	JS WebSocket
		1. JS 에서 제공하는 클래스 WebSocket
		2. 소켓 객체 만들기 
			let 클라이언트소켓 = new WebSocket(ws://서버소켓URL);
		3. 소켓이 서버소켓과 연동 
			1. WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
	JAVA serverSocket
		1. 임의의 클래스 생성 
		2. 서버소켓 만들기 
			클래스위에 @ServerEndpoint("ws://ip:포트번호/프로젝트명/서버소켓경로URL")
			- @ServerEndpoint 	: WS 의 URL 만들기 
			- @WebServlet		: HTTP 의 URL 만들기 
		3. 클라이언소켓이 서버소켓[엔드포인트] 으로 접속했을때 
			@OnOpen : 클라이언트소켓이 접속했을때 매핑[연결]
			
			
*/
/* 채팅창 내용들이 출력되는 상자 */
let contentbox = document.querySelector('.contentbox')

let 클라이언트소켓 = null

if( memberInfo.mid == null ){ // memberInfo : 헤더js 존재하는 객체
	alert('로그인하고 들어오세요~'); location.href="/jspweb/member/login.jsp";
}else{
	// 1. 클라이언트소켓 생성 과 서버소켓 연결[@OnOpen]
	클라이언트소켓 = new WebSocket('ws://192.168.17.96:8080/jspweb/chatting/'+memberInfo.mid );	
	// 클라이언트소켓 = new WebSocket('ws://localhost:8080/jspweb/chatting/'+memberInfo.mid );	
	클라이언트소켓.onopen = function(e){ 서버소켓연결(e) } // 클라이언트소켓 객체에 정의한 함수 대입
	클라이언트소켓.onmessage = function(e){ 메시지받기(e); }
	클라이언트소켓.onclose = function(e){ 연결해제(e) }
	클라이언트소켓.onerror = function(e){ alert('문제발생:관리자에게문의'+e) }
}
// 2. 클라이언트소켓이 접속했을때 이벤트/함수 정의
function 서버소켓연결( e ){ 
	
	//
	자료보내기( memberInfo.mid +"님 이 채팅방에 접속하셨습니다."  , "alarm");
	
}	// 접속했을때 하고 싶은 함수 정의
 		
// 3. 클라이언트소켓이 서버에게 메시지를 보내기 [  @OnMessage  ] ( 1. 보내기버튼 눌렀을때 2.입력창에서 엔터했을때 ) type = msg
function 보내기(){
	let msgbox = document.querySelector('.msgbox').value;
	// ** 서버소켓에게 메시지 전송하기
		// JSON형식의 문자열 타입 만들어서 문자열로 타입으로 전송 
		// 	JSON.parse( JSON형식의 문자열타입 )	:	JSON 형식[모양]의 String 타입 --> JSON 타입으로 변환
		//	JSON.stringify( JSON객체 )		: 	JSON타입 --> JSON 형식[모양]의 String 타입으로 변환  
		let msg = {
			type : 'msg',
			msgbox : msgbox
		} 
	클라이언트소켓.send( JSON.stringify( msg )  ); // ----> @OnMessage
	// 전송 성공시 채팅 입력창 초기화
	document.querySelector('.msgbox').value = '' ;
}

// 4-2 type 에 따른 html 구별 
function 메시지타입구분( msg ){
	
	let json = JSON.parse( msg );
	
	let html = '';
	if( json.type == 'msg'){
		html += `<div class="content"> ${ json.msgbox } </div>`
	}else if( json.type == 'emo'){
		html += `<div class="content emocotent"> <img src="/jspweb/img/imoji/emo${json.msgbox}.gif" > </div>`
	}
	return html;
	
} 

// 4. 서버로부터 메시지가 왔을때 메시지 받기
function 메시지받기( e ){	// <------  e <----- getBasicRemote().sendText(msg)
	console.log( e) ; console.log( e.data ); // e.data : 문자열타입  vs JSON.parse( e.data ) : 객체타입
	console.log( JSON.parse( e.data ) ); // 문자열json -> 객체json 형변환 
	
	let data = JSON.parse( e.data );	// 전달받은 메시지 dto 
		console.log( data );
	
	// 명단[여러개=list/Array] vs 메시지정보[1개=dto/object]
		// Array 타입 확인 : Array.isArray( 객체 ) : 해당 객체가 배열/리스트이면 true
	if( Array.isArray( data ) ){
		let html ='';
		data.forEach( (o)=>{
			html += `
					<div class="connetbox"> <!-- 접속 명단 1명기준 -->
						<div> 
							<img alt="" src="/jspweb/member/pimg/${ o.frommimg ==null ? 'default.webp' :  o.frommimg }" class="hpimg">
						</div>
						<div class="name"> ${ o.frommid } </div>
					</div>
					`
		} );
		document.querySelector('.connectlistbox').innerHTML = html;
	}
	else if( JSON.parse( data.msg ).type == 'alarm'){
		contentbox.innerHTML += `
						<div class="alarm">
										<span> ${ JSON.parse( data.msg ).msgbox } </span>
						</div>
						` 
	}
	// 보낸사람과 현재 유저와 일치하면 [ 내가 보낸 메시지 ]
	else if( data.frommid == memberInfo.mid ){
		contentbox.innerHTML += `<div class="secontent">
									<div class="date"> ${ data.time } </div>
									${ 메시지타입구분( data.msg ) }
								</div>`
	}else{ // [내가 받은 메시지]
		contentbox.innerHTML += `<div class="tocontent">
									<div><img src="/jspweb/member/pimg/${ data.frommimg==null ? 'default.webp' : data.frommimg  }" class="hpimg"></div>
									<div class="rcontent">
										<div class="name"> ${ data.frommid } </div>
										<div class="contentdate">
											${ 메시지타입구분( data.msg ) }
											<div class="date"> ${ data.time } </div>
										</div>
									</div>
								</div>`
	}
	// --------- * 스크롤 하단으로 내리기 -----------// 
	//let top = contentbox.scrollTop;	// 현재 스크롤의 상단 위치 좌표
		//	console.log( top );
	//let height = contentbox.scrollHeight; // 현재 스크롤 전체 의 높이 [ 기본값 contentbox height ];
		//	console.log( height )
	// 스크롤막대의 상단위치를 스크롤막대의 가장아래의 위치로 대입 
	contentbox.scrollTop =  contentbox.scrollHeight;
}

// 5. 서버와 연결이 끊겼을때. [ 클라이언소켓 객체가 초기화될때 -> F5 , 페이지 전환할때 등등 ]
function 연결해제(e){ 
	// 이미 세션이 종료후에 발생하는 함수이므로 아래 코드는 다른 세션에게 전달 불가능 
	// 자료보내기( memberInfo.mid +"님 이 채팅방에 나갔습니다 ."  , "alarm");
}

// 6. 엔터키를 눌렀을때
function enterkey(){
	// 만약에 입력한 키 코드가 13[엔터] 이면 메시지전송
	if( window.event.keyCode == 13 ){
		보내기();
	}
}

// 7. 이모티콘 출력 
getemo();
function getemo( ){
	let html = '';
	for( let i = 1 ; i<=43 ;i++ ){
		html+=`<img onclick="자료보내기( ${i} , 'emo' )" alt="" src="/jspweb/img/imoji/emo${i}.gif" width="60px">`
	}
	document.querySelector('.enolist').innerHTML = html;
}
// 8. 타입형 메시지 전송하기 
function 자료보내기( msgbox , type ){
	let msg = {
		type : type,
		msgbox : msgbox
	} 
	클라이언트소켓.send( JSON.stringify( msg )  ); // ----> @OnMessage
}
 


/*
	클라이언트소켓 필드 								서버소켓 
		onopen		=
		onclose		=
		onmessage	=
		
		// 통신 결과 
		클라이언트소켓.onclose = function(e){ console.log( '연결해제'); }
				vs
		클라이언트소켓.onclose = (e)=>{ console.log( '연결해제'); }	
				vs 
		function 함수명( e ){ console.log( '연결해제'); }
		클라이언트소켓.onclose = (e)=>{ 함수명(e) }
		
	AJAX 필드({
		// 통신 결과 
			success : function(r){}
			success : (r)=>{}
		}) 
*/










