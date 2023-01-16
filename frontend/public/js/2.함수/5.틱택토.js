//alert('1.js실행')
// 2. 함수 호출 : 
	// 1. js : 함수명()
	// 2. html : <마크업 이벤트속성="함수명()" />
//클릭이벤트()

// 4.배열선언 [ 버튼의 상태를 저장하는 배열 -> null : 빈자리 ]
let 버튼목록현황 = [ null , null , null , null , null , null ,null , null , null ]
// 1.사용자 버튼 클릭했을떄 실행되는 함수 / 1. 함수 정의/만들기
function 클릭이벤트( 버튼번호 ){ // f s 
	// 1. 선택된 번호와 알모양을 알두기 함수 전달하고 반환이 false이면 알두기 실패 / true 성공 후 컴퓨터 차례
		//  ! : 반대/부정 false->true   / true->false
	if( ! 알두기( 버튼번호 , 'O' ) ) { return; }
	
	// 2. 컴퓨터 차례  무한루프 [ 정상적으로 알 두기 전까지 ]
	while( true ){ // w s 
		let 컴퓨터번호 = parseInt( Math.random()*9 )+1 // 1~9 사이의 난수 생성
		if( 알두기( 컴퓨터번호 , 'X' ) ) { return; }
	} // w e 
	
} // f e 
// 2. 알두기 [ 반환값 : 알 정상적으로 두었는지 확인 false:0:'실패'  / true:1:'성공' -> 신호 번호 ]
function 알두기( 버튼번호 , 알모양 ){
	// 1. <div> 버튼 목록 가져와서 배열에 저장 [ div 9개 호출 ]
	let 버튼목록 = document.querySelectorAll('.버튼');	
	// 2.배열에 상태 변경  // * 만약에 빈자리 가 아니면 실패 false 반환 
	if( 버튼목록현황[버튼번호-1] !=  null ){ return false; }
	// 3. 알모양과 상태 변경 // 클릭된 번호의 div 찾기 [ 선택번호-1 ] // -1 : 인덱스 0부터 시작하니까
	버튼목록[버튼번호-1].innerHTML = 알모양 ; 버튼목록현황[버튼번호-1] = 알모양; 
	// 4. 성공 true 반환
	return true; // 성공했으면 true 반환
} // f e













