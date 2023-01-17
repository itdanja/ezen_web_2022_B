/*
	객체
	1.미리 만들어진 객체
		1. console객체
			console.log( )
		2. Math 클래스
			Math.random( )
		3. document객체 : DOM객체
			document.qeurySelector( )
		등등등
		
	2.사용자 정의 객체 
		
*/
// 1. DOM 객체 : HTML를 객체화
let h1 = `<h1>${ '안녕하세요' }</h1>`
document.body.innerHTML = h1

// 2. DOM 객체의 이벤트
	// 1. 기존 함수 적용 
function 함수1(){ console.log('문서열림1') }
window.onload = 함수1
document.addEventListener( 'DOMContentLoaded' , 함수1  )

	// 2. 익명[이름없는] 함수 적용 
window.onload = function(){ console.log('문서열림2') }
document.addEventListener( 'DOMContentLoaded' , function(){ console.log('문서열림2')  })

	// 3. 화살표[ ( 인수 ) => { 실행문 } ] 함수 적용 
window.onload = () => { console.log('문서열림3') }
document.addEventListener( 'DOMContentLoaded' , () => { console.log('문서열림3') } )

let 익명함수 = function ( ){ console.log('문서열림5') }
let 화살표함수 = ( ) => { console.log('문서열림4') }
let 객체 = { 행동 : ( )=>{ console.log('문서열림6') } }
































