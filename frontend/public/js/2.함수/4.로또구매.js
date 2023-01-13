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

	// 1. 문자열 처리 
		// '<button onclick="버튼클릭('+i+')">'+i+'</button>
		// 'html문자열~~~~~~~~~~~~'+변수+'html문자열'+변수+'html문자열
	// 2. 백틱 이용한 문자열처리
		//  `(백틱 - esc 아래 ) : 작은따옴표 아님
		// 1. 전체를 백틱으로 감싼다.
		// 2. 변수/수식 는 ${변수/수식} 감싼다.

