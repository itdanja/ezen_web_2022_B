let studentArray = [ '20230110', '20230109', '20230108' ];	//---- 기본옵션1)
	console.log(studentArray)	// --- 기능확인(배열확인)

// 과제1)
function onLogin(){
	
	// [입력부]
	let sNum = document.querySelector( '.sNum' ); 	// --- 기본옵션2)
	// HTML sNum 클래스를 JS 사용 선언
	
	let cNum = sNum.value;
	// JS 변수 cNum 정의 (기능: sNum.value값 저장)
		console.log( cNum );	// --- 기능확인(입력 확인)
		
	let cindex = studentArray.indexOf( cNum );
	// JS 변수 cindex 선언 (기능: 배열 studentArray에서 cNum값 찾아 저장)
		console.log( cindex );	// --- 기능확인(index값으로 확인됨, if조건에서 index값 활용)
	
	
	// [출력부]
	if(sNum.value == '' ) {
			alert( "학번을 입력해주세요.(오류: 학번 미입력)" );	// --- 추가옵션1)
			sNum.value=null;							// --- 추가옵션2)
	}
	else if( sNum.value.length != 8 ){
			alert( "학번을 다시 확인해주세요(오류: 학번(8자리) 불일치)" );	// --- 추가옵션3)
			sNum.value=null;									// --- 추가옵션2)
	}
	else if( cindex == -1 ){
		alert( "로그인 실패(오류: 학번 미등록)" );		// --- 기본옵션3)
		sNum.value=null;						// --- 추가옵션2)
	}
	else{
		alert( "로그인 성공" );	// --- 기본옵션3)
		sNum.value=null;		// --- 추가옵션2)
	}							
}

// 과제2)
function onRegist(){
	// [입력부]
	let sNum = document.querySelector( '.sNum' );	// --- 기본옵션2)
	
	let rNum = sNum.value;
	
	let rcindex = studentArray.indexOf( rNum );

	// [출력부]
	if ( sNum.value == '' ){
		alert( "학번을 입력해주세요.(오류: 학번 미입력)" );	// --- 추가옵션1)
		sNum.value=null;							// --- 추가옵션2)
	}
	else if ( sNum.value.length != 8 ){
		alert( "학번을 다시 확인해주세요.(오류: 학번(8자리) 불일치)" );		// --- 추가옵션3)
		sNum.value=null;										// --- 추가옵션2)
	}
	else if ( rcindex == -1 ){
		studentArray.push( sNum.value ); 	// --- 기본옵션1)
		alert( "학번이 정상 등록되었습니다." ); 	// --- 기본옵션3)
		sNum.value=null;					// --- 추가옵션2)
			console.log( studentArray );	// --- 기능 확인(배열 확인)		
	}
	else{
		alert( "학번을 다시 확인해주세요.(오류: 학번 중복)" );	// --- 기본옵션3)
		sNum.value=null;								// --- 추가옵션2)
	}
}

// 추가> 데이터 삭제
function onDelete(){
	// [입력부]
	let sNum = document.querySelector( '.sNum' );	// --- 기본옵션2)
	
	let dNum = sNum.value;
	
	let dcindex = studentArray.indexOf( dNum );

	// [출력부]
	if ( sNum.value == '' ){
		alert( "학번을 입력해주세요.(오류: 학번 미입력)" );	// --- 추가옵션1)
		sNum.value=null;							// --- 추가옵션2)
	}
	else if ( sNum.value.length != 8 ){
		alert( "학번을 다시 확인해주세요.(오류: 학번(8자리) 불일치)" );		// --- 추가옵션3)
		sNum.value=null;										// --- 추가옵션2)
	}
	else if ( dcindex == -1 ){
		alert( "학번을 다시 확인해주세요.(오류: 미등록)" );	// --- 기본옵션3)
		sNum.value=null;							// --- 추가옵션2)	
	}
	else{
		studentArray.splice( dcindex, 1 );  						// --- 기본옵션1)
		alert( "정보가 정상 삭제되었습니다." + "입력학번: " + sNum.value ); 	// --- 기본옵션3)
		sNum.value=null;											// --- 추가옵션2)
			console.log( studentArray );							// --- 기능 확인(배열 확인)
	}
}
