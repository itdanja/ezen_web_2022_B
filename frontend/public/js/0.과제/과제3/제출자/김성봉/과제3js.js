/* ----------------------- 과제3 ----------------------- 
주제 : 방문록 게시판 구현

	조건1 : 방문록 내용을 여러개 담는 배열 선언 : let contentArray = [ ]
	조건2 : 내용작성 <input> 입력받기
	조건3 : 등록버튼 <button> 클릭 시 입력된 데이터가 배열에 저장하는 addContent() 함수 실행
	조건4 : 현재 배열에 저장 된 모든 방문록을 <table> 에 출력

		<tr>
			<th>게시물번호</th> <th>방문록</th>
		</tr>

파일 : 과제3.html / 과제3.js
*/

let contentArray = []														// 방문록 Content 담을 배열 선언


function addContent(){														// onclick 함수 선언
	
	let table_data = '<tr> <th>번호</th> <th>방문록</th> </tr>'					// 테이블을 구성할 변수 선언
		
	contentArray.push( document.querySelector('.txt').value )				// input 으로 입력받은 값을 contentArray 배열에 push 하여 추가
	
	for( let i=1 ; i<=contentArray.length ; i++ ){	// for start
		// i 가 contentArray의 길이보다 작거나 같을때까지 반복 하여 1씩 i 증가
		table_data +=
		"<tr> <td>" + i + "</td> <td>" + contentArray[i-1] + "</td> </tr>"
		// 조건이 True 일때 위 해당문 실행 [ i 를 글번호로 활용하고 contentArray[i-1] = contentArray[0] 불러오기]
		// 글번호 1번부터 시작하기 위함 		
	} // for end
	
	document.querySelector('.cont_table').innerHTML = table_data			// 중첩된 table_data 를 HTML 에 표시
	document.querySelector('.txt').value = ''								// input 박스에 입력한 value 값 초기화
}






