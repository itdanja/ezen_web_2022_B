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
	-문제1
	1. 국어 , 영어 , 수학 점수를 입력받아 3개의 변수에 저장
	2. 총점 출력 , 평균 출력
*/














