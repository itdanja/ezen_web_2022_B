let 변수 = 10;
const 상수 = 10;
let 배열 = [ 10 , 20 , 30 ]
let 객체 = { 나이 : 10 , 성별 : '남' }
function 함수(){ console.log('함수호출') }
// 1. 객체 { } 선언 
let 객체1 = { // 객체선언 s
	이름 : '유재석' , 	// 직접 데이터 작성
	나이 : 변수 ,		// 변수 대입 
	점수 : 배열 ,		// 배열 대입 
	정보 : 객체 ,		// 객체 대입
	행동 : 함수		// 함수 대입
} // 객체선언 e 
// 2. 객체 호출 
console.log( '객체 호출 : ' + 객체1 ); // [object Object] 출력
console.log( 객체1 );				// undefined : 정의되지않음
// 3. 객체내 속성 호출 [ .접근연산자 ]
console.log( 객체1.이름 );
console.log( 객체1.나이 );
console.log( 객체1.점수 ); console.log( 객체1.점수[2] )
console.log( 객체1.정보 ); console.log( 객체1.정보.성별 )
console.log( 객체1.행동 ); 객체1.행동()




















