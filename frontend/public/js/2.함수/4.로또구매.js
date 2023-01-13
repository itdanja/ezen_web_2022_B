// 1. 숫자 버튼 출력하는 함수 
function 버튼출력(){ // f s 
	let 버튼목록 = '';		// for 밖에 만든 이유 : 45개의 버튼을 저장할려고 
	for( let i = 1 ; i<=45 ; i++ ){ // for s  // i는 1부터 45까지 1씩증가 반복처리 
		
		버튼목록 += `<button onclick="버튼클릭(${i})">${i}</button>`
		
		if( i % 5 == 0 ){ 버튼목록 += '<br/>'}  // 만약에 i가 5배수이면 줄바꿈
	
	} // for e
	
	// 해당 <div> 에 버튼목록 넣어준다.
	document.querySelector('.버튼목록상자').innerHTML = 버튼목록
	
	// 취소 버튼 보이게 활성화
	document.querySelector('.취소버튼').style.display = 'inline'
	
} // f e 

// 2. 숫자 버튼 없애는 함수
function 버튼출력취소(){ // f s
	// 해당 <div> 에 ''공백으로 변경하기 
	document.querySelector('.버튼목록상자').innerHTML = ''
	
	// 취소 버튼 안보이게 비활성화
	document.querySelector('.취소버튼').style.display = 'none'
	
} // f e 

// 1. 선택한 숫자를 6개 저장하는 배열
let 선택번호목록 = [ ]

// 3. 버튼 클릭 함수 
function 버튼클릭( 번호 ){
	console.log( 번호 +" 번호 를 선택했군요.")
	
	// 1. 중복검사	/취소 [ 배열명.indexOf(찾을데이터) : 찾은데이터의 인덱스번호 반환 , 없으면 -1]
	if( 선택번호목록.indexOf( 번호 ) >= 0 ){ // if s 
		alert('이미 선택한 번호 입니다.')
		return ;	// 반환값은 없지만 함수를 끝낼수 있다. [ 더이상 아래로 코드가 실행되지 않는다.]
	} // if e
	// 2. 6개까지만 저장 [ 배열명.length : 배열내 데이터 총 개수 ]
	if( 선택번호목록.length == 6 ){	// 배열내 숫자가 6개 존재하면
		alert('이미 모두[6개]를 선택했습니다.')
		return ;	
	} // if e 
	
	// 위 2가지 유효성검사를 충족하지 않았을때 저장 
	선택번호목록.push( 번호 )
	document.querySelector('.선택번호상자').innerHTML=선택번호목록
}
























	// 1. 문자열 처리 
		// '<button onclick="버튼클릭('+i+')">'+i+'</button>
		// 'html문자열~~~~~~~~~~~~'+변수+'html문자열'+변수+'html문자열
	// 2. 백틱 이용한 문자열처리
		//  `(백틱 - esc 아래 ) : 작은따옴표 아님
		// 1. 전체를 백틱으로 감싼다.
		// 2. 변수/수식 는 ${변수/수식} 감싼다.

