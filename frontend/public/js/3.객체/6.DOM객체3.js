
// 1. keyup 이벤트 : 키보드 키를 누르고 떼었을때
	// 1. <textarea> 마크업 객체화 
const textarea = document.querySelector('textarea')
const h3 = document.querySelector('h3')

	// 2. 해당 마크업의 이벤트 등록 [ 객체명.addEventListener ]
textarea.addEventListener( 'keyup' , ( 이벤트상태 ) => {
	// 3. 해당 마크업 사이에 html 대입 [ 객체명.innerHTML = html형식의 문자 ]
	h3.innerHTML = `글자 수 : ${ textarea.value.length }`
	// 4. 키 상태 확인 
		console.log( 이벤트상태 )
		console.log( '조합 alt 키 : ' + 이벤트상태.altKey )	
		console.log( '조합 ctrl 키 : ' + 이벤트상태.ctrlKey )
		console.log( '조합 shift 키 : ' + 이벤트상태.shiftKey )
		console.log( ' code 키 : ' + 이벤트상태.code )
		console.log( ' name 키 : ' + 이벤트상태.key )
})

	// css 조작 
	textarea.style.position = 'absolute' // static[작성배치] 기본값 위치불가능
	let x = 0	// x축	// 처음 위치 설정
	let y = 0	// y축	// 상위 마크업 시작점 기준
	let block = 30;	// 이동 단위

print(); // 위치 배치 1번 실행 
function print() { // 위치 배치 함수 
	textarea.style.left = `${ x*block }px`	// css left = (x*이동단위 )+'px'
	textarea.style.top = `${ y*block }px`	// css top = `${y*이동단위}px`
}

// 2. keydown 이벤트 : 키보드 키를 입력했을때
document.body.addEventListener( 'keydown' , ( e ) => {
	
	if( control ){ // 만약에 control 이 true 인 경우에만 아래 실행 
		let key = e.keyCode;			console.log( e.keyCode );
		if( key == 37  ){ x--; } // left-- 대입 // 왼쪽키 
		else if( key == 38 ){ y--; } // top-- 대입 // 위쪽키 
		else if( key == 39 ){ x++; } // left++ 대입 // 오른쪽키 
		else if( key == 40 ){ y++; }// top++ 대입 // 아래키
		print()
	}// if end 
	
}) // f end 

let control = true;	 // * 이벤트 제어 전역 변수 

// 3. 
document.querySelector('.moving').addEventListener('click' , ()=>{ 
	control = !control // 스위치 on/off 변경
})




