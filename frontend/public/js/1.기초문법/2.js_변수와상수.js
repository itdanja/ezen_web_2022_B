/*
	- 데이터 1개 저장할수 있는 메모리 공간 
	- 준비물 : 
		1. 자료형키워드
		2. 변수/상수 명
		3. 저장할 데이터  
		4. = : 대입연산자 [ 오른쪽 데이터를 왼쪽에 넣기 ]
		
	변수 : 변하는 수
		1. let 키워드 사용  
		2. 형태 : let 변수명 = 데이터 
		3. 대입 후 에 변경 가능
	상수 : 고정된 수 
		1. const 키워드 사용 
		2. 형태 : const 변수명 = 데이터 
		3. 대입 후 에 변경 불가능 
		
	선언 방법
		1. let or const 
		2. 변수명 정의[만들기]
		3. =	 대입연산자
		4. 데이터 
		
	변수 호출 
		1. 변수명 이용한 호출
		
	변수 값 변경
		1. 변수명 = 새로운 데이터
		
*/
// 1. 변수 선언 
let value1 = 10						// 'value1' 이라는 변수 상자에 10 대입했
// 2. 변수 값 호출
console.log( '변수값 : ' + value1 )	// 'value1' 이라는 변수 상자에 값 을 호출 
// 3. 변수 값 변경
	// let value1 = 20	// 'value1' 이라는 변수명이 존재하기때문에 오류 발생
value1 = 20							// 'value1' 이라는 변수 상자에 새로운 값 대입했다.
console.log( '변수값 수정후 : ' + value1 )
// 4. 변수 연산
console.log( '변수값 더하기 5 : ' + value1+5 )		// 문자열 + 숫자 + 숫자 
console.log( '변수값 더하기 5 : ' + (value1+5) )	// 문자열 + ( 숫자 + 숫자 )
let value2 = 30
let result = value1 + value2
console.log( '변수들 간에 연산 : ' + result ) 

// 1. 상수 선언 
const data1 = 10		
console.log( '상수값 : ' + data1 )
//data1 = 20				//!! : 변경 불가 [ 상수 ]
const data2 = 20
const result2 = data1 + data2
console.log( '상수들 간에 연산 : ' + result2 )


// + : 1.더하기[산술]	2.붙이기[연결]

//		숫자+숫자 => 숫자	[ 산술 ]
//		문자+숫자 => 문자	[ 연결 ]

















	



