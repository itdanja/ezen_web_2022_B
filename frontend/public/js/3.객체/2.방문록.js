console.log('1.js실행')

// * 배열선언 [ board 객체 여러개를 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장]
let boardArray = [ ]
	// 예시 :  [ { 속성:값 } , { 속성:값 } , { 속성:값 } , { 속성:값 } ]
	
// 1. 작성 버튼 클릭시 실행되는 함수
function 작성(){ // onclick="작성()"
	console.log( '2.함수실행' )
	// 1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.작성자').value;
		console.log( '3.작성자 : ' + 작성자 )
	let 내용 = document.querySelector('.내용').value;
		console.log( '3.내용 : ' + 내용 )
	// 2. 입력받은 2개의 데이터를 하나로 객체화 
	let board = { writer : 작성자 , content : 내용 }
		console.log( board )
	// 3. 객체를 배열에 저장 [ 여러개 객체를 저장 ]
	boardArray.push( board )
		console.log( boardArray )
	// 4. 배열내 객체 출력 
		// 1. 테이블의 제목행 만들기  
	let html = `<tr><th>번호</th><th>내용</th><th>작성자</th></tr>`;
		// 2. 반복문 이용한 배열내 모든 요소를 행 만들기[누적]
			// 1. 반복 이용해서 배열내 객체 하나씩 호출 : boardArray[i]
			// 2. 객체내 속성 호출 					: boardArray[i].속성명
	for( let i = 0 ; i<boardArray.length ; i++ ){
		html += `<tr> 
					<td> ${ i+1 } </td>
					<td> ${ boardArray[i].content }</td>
					<td> ${ boardArray[i].writer }</td>
				 </tr>`;
	}// for end 
		// 3. 반복문 종료시 누적된 html 해당 table 출력 
	document.querySelector('.게시물테이블').innerHTML = html;
	
} // f e 






