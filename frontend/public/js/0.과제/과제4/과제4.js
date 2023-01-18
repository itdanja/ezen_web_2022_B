console.log('js작동') // 연동 확인용

// 1. 배열[ 동일한 데이터유형 저장 ]선언 
let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ] // 등록된 도서명 목록 
let 대여목록 = [ '혼자공부하는자바' ] // 등록된 도서명 목록중에 대여중인 도서명 목록

// 2. 등록 함수 [ 1. 등록버튼 클릭했을때 ]
function 등록(){
	console.log('함수실행')
	// 1. 입력받은 도서명
	let 도서명 = document.querySelector('.도서명').value
	// 2. 유효성검사
		// 1. 중복검사 [ 배열검사 .indexOf , .includes ]
		if( 도서목록.includes( 도서명 ) ){
			// 만약에 등록된도서목록중에 입력받은 도서명과 같으면 
			alert('이미 등록된 도서명 입니다.')
			return false; // 함수종료 반환값 없다.
		} // if end 
		// 2. 도서명 길이 체크 
		if( 도서명.length < 5 || 도서명.length > 10  ){
			// 만약에 입력받은 도서명이 5글자보다 작거나 10보다 크면 실패
			alert('도서명은 5~10 사이 글자만 등록 가능합니다.')
			return false;
		} // if end 
	// 3. 입력받은 도서명을 배열에 등록처리 
	도서목록.push( 도서명 ); 도서현황();
		console.log( 도서목록 )
} // f e 

도서현황();
// 2. 등록된 도서목록 현황 출력 [ 1. JS 열렸을때 2. 등록했을때 3. 삭제했을때 ]
function 도서현황(){
	// 1. html 기본 구성 
	let html = `<tr>
					<th>번호</th> <th>도서명</th>
					<th>도서대여여부</th> <th>비고</th>
				<tr>`
	// 2. html 구성 추가 
	for( let i = 0 ; i< 도서목록.length ; i++ ){
		// i는 0부터 도서목록길이 미만까지 1씩증가 
		html += `<tr>
					<td>${i+1}</td> 
					<td>${ 도서목록[i] }</td>
					<td>${ 대여목록.includes( 도서목록[i] ) ? '대여중' : '대여가능' } </td> 
					<td><button onclick="삭제( ${i} )">삭제</button></td>
				<tr>`
							// <button onclick="삭제( ${i} )">삭제</button> : js가 버튼를 생성하기 전
							/*
								js가 버튼 생성한 후
								<button onclick="삭제( 0 )">삭제</button>
								<button onclick="삭제( 1 )">삭제</button>
								<button onclick="삭제( 2 )">삭제</button>
							*/ 
	}
	// 3. 마크업에 html 대입
	document.querySelector('.관리자테이블').innerHTML = html;	
}
// 3. 도서 삭제 함수 
function 삭제( i ){
	// 1. 대여중 확인 
	if( 대여목록.includes( 도서목록[i] ) ){
		alert('대여중 이므로 삭제불가능 합니다.')
		return false;
	}
	// 2. 삭제처리 
	도서목록.splice( i , 1 )
	// 3. 렌더링[화면 업데이트]
	도서현황()
}



























