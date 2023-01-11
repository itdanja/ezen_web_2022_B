
// 예1) i는 1부터 10이하까지 1씩 증가 반복	[ 한줄씩 출력 ]
console.log('-------------예1--------------')
for( let i = 1 ; i<=10 ; i++ ){ // for s 
	console.log( i )
} // for e 

// 예2) i는 1부터 10이하까지 1씩 증가 반복 	[ 한줄에 모두 출력 ]
console.log('-------------예2--------------')
let output = '' 			// 문자 변수 선언 [ 깡통 ]
for( let i = 1 ; i<=10 ; i++ ){ // for s 
	output += i+"\t";	// vs output = output + i // 누적 기록 
} // for e 
console.log( output )

// 예3) i는 1부터 10이하까지 1씩 증가 반복 	[ html 출력 ]
console.log('-------------예3--------------')
output = ''					// 위에서 사용했기 때문에 지우고 '' 으로 변경[수정]
for( let i = 1 ; i<=10 ; i++ ){ // for s 
	output += i+"\t"
} // for e 
document.querySelector('body').innerHTML = output 

// 예4) i는 1부터 10이하까지 1씩 증가 반복 누적합계
console.log('-------------예4--------------')
let sum = 0 ;	// 숫자변수
for( let i = 1 ; i<=10 ; i++ ){ sum += i }
console.log( sum )

// 예5) 1부터 100까지 7배수 누적합계
console.log('-------------예5--------------')

// 1. [i+=7]
sum = 0;	
for( let i = 7 ; i<=100 ; i+=7 ){ sum += i }
console.log( sum )

// 2.  if( i % 7 == 0 )
sum = 0;	
for( let i = 1 ; i<=100 ; i++ ) {  // for s 
	if( i % 7 == 0 ){ // if s 
		sum+=i 
	} // if e 
} // for e 
console.log( sum )













