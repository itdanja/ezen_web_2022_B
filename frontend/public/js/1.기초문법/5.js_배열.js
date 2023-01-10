/*
	데이터[자료] : 문자,숫자,그림 형태의 단위
		자료 증가--> 메모리 증가 --> 돈 증가
	메모리[휘발성] : 사용중에만 저장 / 종료시 사라짐
	--
	변수와상수 : 데이터[자료] 1개를 메모리[주기억장치] 저장
	배열 : 데이터 여러개를 저장
		1. 배열 : [ ]
		2. 식별번호 : 인덱스 0번시작 
		3. 선언방법
			let	배열명 = [ 자료1 , 자료2  , 자료3 ]
			const 배열명 = [ 자료1 , 자료2 , 자료3 ]
		예시)
			let 학년3_2반 = [ '유재석' , '강호동' , '신동엽' , '김현수' ]
			인덱스[순서번호]		0 		 1  		2 		3
			마지막인덱스		3
			학생길이[수]		4
		4. 배열 길이
			학년3_2반.length	:	4
*/
// 1. 배열 선언 : [] 안에 , 구분해서 여러개의 자료 입력한다.
let 배열명 = [ '유재석' , '강호동' , '신동엽' , '김현수' ]
// 2. 배열 호출 
console.log( 배열명 )
document.write( 배열명 )
document.write('<h3>'+배열명+'</h3>')		// * HTML 마크업은 JS내에서는 문자열 처리 
// 3. 배열내 특정 요소만 호출 : 배열명[인덱스]
console.log( 배열명[0] + 배열명[1] + 배열명[2] + 배열명[3] ) 
document.write('<ol>')
document.write('<li>'+배열명[0]+'</li>')	// 변수/배열 문자열 처리X  // HTML 문자열처리 O
document.write('<li>'+배열명[1]+'</li>')	// 변수/배열 문자열 처리X  // HTML 문자열처리 O
document.write('<li>'+배열명[2]+'</li>')	// 변수/배열 문자열 처리X  // HTML 문자열처리 O
document.write('<li>'+배열명[3]+'</li>')	// 변수/배열 문자열 처리X  // HTML 문자열처리 O
document.write('</ol>')
// 4. 배열의 길이
console.log( 배열명.length +"명" )
document.write('<p>현재 인원수 : '+배열명.length+'명</p>')












