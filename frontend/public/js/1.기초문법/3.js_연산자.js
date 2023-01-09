/*
	JS 연산자 
		1. 산술연산자 : +더하기 -빼기 *곱하기 /나누기 %나머지
		2. 연결연산자 : +
				숫자+숫자 : 산술	/	문자+숫자 : 연결	/	문자+문자 : 연결 
		
		3. 비교연산자 : 결과는 항상 true/false 참/거짓 맞다/틀리다
						>초과[크다] 			<미만[작다] 
						>=이상[크거나같다] 		<=이하[작거나같다]
						==같다[데이터만비교]		===같다[데이터/자료형 비교]
						!=같지않다[아니다/제외]	!==같지않다[데이터/자료형 비교]
						
		4. 관계연산자 : 비교연산자가 2개 이상일때
						&& : and 이면서 면서 이고 모두 그리고 	[비교연산자 결과가 모두 참이면 참]
							10<a<20 [ x ] ->  a>10 && a<20 [ x ]
						|| : or 이거나 거나 또는 하나라도 		[비교연산자 결과가 하나라도 참이면 참]
						! : 부정 반대 						[비교연산자 결과가 참이면 거짓 ]
			
*/
//1.산술연산자
console.log( 10+3 )	// 숫자+숫자 => 숫자 
console.log( '더하기 : ' 	+ 10+3 ) // 문자+숫자 => 문자 + 숫자 => 문자
console.log( '더하기 : ' 	+ (10+3) ) // (숫자+숫자) => 숫자 + 문자 => 문자
console.log( '빼기 : ' 	+ (10-3) )
console.log( '곱하기 : ' 	+ (10*3) )
console.log( '나누기 : ' 	+ (10/3) )	
console.log( '나머지 : ' 	+ (10%3) )	// 몫 제외한 나머지 !!
//2.비교연산자
console.log( '초과 : ' + (10>3) )		//t
console.log( '미만 : ' + (10<3) )		//f
console.log( '이상 : ' + (10>=3) )	//t 
console.log( '이하 : ' + (10<=3) )	//f 
console.log( '같다 : ' + (10==3) )	//f
console.log( '같지않다 : ' + (10!=3) )	//t
//3.관계연산자 
console.log( '이면서 : ' + ( 10>3 && 10>5 ) )	// T and T -> T		/  T and F -> F
console.log( '이거나 : ' + ( 10>3 || 3>5 ) )	// T or F -> T
console.log( '부정 : ' + !( 10>3) )			// T->F   /  F->T

/*
	-문제1 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
	-문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
	-문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
		- 54.5   84.3	결과 : 64%
	-문제4 : prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
	-문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
	-문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
			356789		결과 : 십만원3장 만원5장 천원6장 
	-문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
			결과 : true 출력 아니면 false 출력 
	-문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
*/

/*
// 1.문제
let 국어 = Number( prompt('국어점수 입력') )// '국어' 라는 이름으로 변수 선언하고 prompt 입력받은 문자 데이터를 저장
let 영어 = Number( prompt('영어점수 입력') )
let 수학 = Number( prompt('수학점수 입력') )
console.log( '합계 : ' + ( 국어+영어+수학 ) )
console.log( '평균 : ' + ( 국어+영어+수학 )/3 )
*/

/*
// 2.문제 
let 반지름 = Number( prompt('반지름') )	// 숫자형 입력받아서 변수에 저장 
console.log( '문제2 원넓이 : ' + ( 반지름*반지름*3.14) )
*/

/*

// 3.문제
let 실수1 = Number( prompt('실수1') )
let 실수2 = Number( prompt('실수2') )
console.log( '문제3 실수2의 실수1 백분율 : '+ (실수1/실수2)*100 +'%' )	
								// 1:100%  0.1:10%  0.01:1%
*/

/*
// 4.문제
let 정수1 = Number( prompt('정수1') )
console.log( '문제4 홀/짝 판단 : ' + ( 정수1%2==1 ) )		
			// 홀수찾기 : 수%2 == 1 나머지가 1이면 홀수 0이면 짝수 					
			// 짝수찾기 : 수%2 == 0 나머지가 0이면 짝수 1이면 홀수
*/

/*
// 5.문제 
let 정수2 = Number( prompt('정수2') )
console.log( '문제5 7배수 찾기 : ' + (정수2%7==0) )
			// 배수찾기 : 수/값 == 0 나머지가 0 이면 해당 값은 그 수의 배수 
*/

/*
// 6. 문제 [ 몫 구하기 : parseInt( 40/3 ) ] 
let 금액 = Number( prompt('금액 입력') )
console.log( '입력받은 금액 : ' + 금액 )
console.log( '십만원권 : ' + parseInt( 금액 / 100000 )+'장' )
		// 356789 / 100000 -> 3.56789 
		// parseInt( 3.56789 ) -> 3
// ! : 금액에서 십만원 권 제외
금액 = 금액 - parseInt( 금액/100000 ) * 100000
	// 356789 - 300000 -> 56789
 		 //연산순서
		//		1. ( 금액/100000 )			3.56789
		//		2. parseInt( 금액/100000 )	3
		//		3. * 100000					300000
		//		4. 금액 - 300000				56789
		//		5. 금액 = 56789				새로운값 변경 	
		
console.log( '만원권 : ' + parseInt(금액/10000) + '장' )
금액 = 금액 - parseInt(금액/10000) * 10000
console.log( '천원 : ' + parseInt(금액/1000) + '장' )

*/

// 문제7
let 아이디 = prompt('아이디')
let 비밀번호 = prompt('비밀번호')
console.log( '로그인상태 : ' + ( 아이디 == 'admin' && 비밀번호 == '1234') )

// 문제8
let 정수3 = Number( prompt('정수3') )
console.log( '홀수 이면서 7배수 : ' + ( 정수3%2==1 && 정수3%7 == 0 ) )




















