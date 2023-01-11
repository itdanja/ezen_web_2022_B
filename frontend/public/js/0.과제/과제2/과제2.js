
console.log( 'js실행') // 1. 확인

// 테이블의 첫행[제목] html 마크업 대입된 변수 
// let html변수명 = 'HTML마크업작성'		//! : 마크업 문자처리

// let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';		// 1번 실행 [ 결과 누적O ]

// 3. 
function onResult(){
	console.log('클릭했다.')// 3.확인
	
	let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	// 클릭할때마다 실행 [ 결과 누적X ]
	
	// 4. 단:<input> 곱<input> 에 입력된 value 각 변수에 저장 
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	
	/* 3. <table>의 행<tr> 반복문으로 만들기 */
	for( let 곱 = 1 ; 곱 <= gob ; 곱++  ){ // for s 
		// 곱은 1부터 입력받은 값 까지 1씩증가 반복처리 
		
		테이블행 += '<tr> <th> '+dan+' </th> <th>'+곱+'</th> <th>'+(dan*곱)+'</th> </tr>';
		
	} // for e
	
	// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기 
	document.querySelector('.gu_table').innerHTML = 테이블행
	
}
























