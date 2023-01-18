/*
	
 */

// 1. select 변경 이벤트 
let selectbox = document.querySelector('.selectbox')
selectbox.addEventListener( 'change' , (e) => {
	console.log( e ) // e : 이벤트 결과 정보 
	// 1. 선택된 option
	console.log( e.currentTarget )  // 이벤트 실행한 타켓[마크업] : selectbox
	
	let options = e.currentTarget.options		// select의 모든 옵션들을 배열로 가져오기 
	console.log( e.currentTarget.options )
	
	let index = e.currentTarget.options.selectedIndex // select에서 선택한 인덱스 가져오기 
	console.log( e.currentTarget.options.selectedIndex  )
	
	console.log( options[index].value )
	
	document.querySelector('h3').innerHTML 
				= `선택한 옵션 : ${ options[index].value }`
})
// 2. checkbox 변경 이벤트 
let checkbox = document.querySelector('.checkbox')
checkbox.addEventListener( 'change' , (e) => {
	console.log( e )
	// 1. 체크 여부 확인 
	console.log( e.currentTarget )
	console.log( e.currentTarget.checked )
})

// 3. 타이머 예제
let timer = 0 // 타이머 시간(초) 저장하는 변수 
let timerId = 0 // 전역변수 

let timerbox = document.querySelector('.timerbox')
let timerspan = document.querySelector('.timerspan')
timerbox.addEventListener( 'change' , (e)=>{
	
	if( e.currentTarget.checked ){ 	// 만약에 체크박스에 체크가 되어 있으면 
		// setInterval : 특정 시간마다 함수 실행 
		// setInterval( 함수명 , 시간( 밀리초 = 1000/1초  ) )
		// setInterval( ()=>{ 실행문 } , 1000 ) : 1초마다 화살표함수 실행 
		// clearInterval( 변수명 ) : Interval 초기화
			// let 변수명 = setInterval( 함수명 , 시간( 밀리초 = 1000/1초  ) )
		timerId =  setInterval( ()=>{
			timer++;
			timerspan.innerHTML = timer +'초'
		} , 1000) 	
	}else{
		clearInterval( timerId ) 
	}
})






































