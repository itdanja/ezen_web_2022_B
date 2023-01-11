/*	주제: 방문록 게시판 구현

	조건1> 방문록 내용을 여러개 담는 배열 선언: let contentArray = []
	조건2> 내용작성 <input> 통해 데이터 입력받기
	조건3> 등록버튼 클릭시, 입력된 데이터가 배열에 저장
	조건4> 현재 배열에 저장된 모든 방문록을 table 태그에 출력
		<tr>
			<th> 번호 </th>	<th> 방문록 </th>
		</tr>	
*/

let contentArray = [];	// --- 조건1>
// 해석: JS 배열 선언 (현재 배열에 모든 방문록 table 태그 출력을 위해 변수 함수 밖에 선언)

function confirm(){	// --- 조건3>

		console.log('입력완료');	// --- 기능 확인 (정상 입력됨)
	
	let tableContent = '<tr> <th>번호</th> <th>방문록</th> </tr>';		// --- 조건4>
	// 해석: JS 변수 tableContent 선언
	
	let textArea = document.querySelector( '.textArea' );
	// 해석: HTML 클래스 textArea JS 사용 선언 [DOM 객체화]
	
	contentArray.push( textArea.value );
	// 해석: HTML 클래스 textArea값을 JS 배열 contentArray에 저장

		console.log(contentArray);	// --- 배열 확인
	// 해석: HTML 클래스 textArea에 입력된 값을 JS 배열 contentArray에 저장
	
	for( let i = 0 ; i < contentArray.length; i++ ){	// --- 조건4>

		tableContent += '<tr> <th> '+(i+1)+' </th> <th> '+contentArray[i]+' </th> </tr>'
		document.querySelector('.tablecontent_HTML').innerHTML = tableContent
		textArea.value = null;
	}
}