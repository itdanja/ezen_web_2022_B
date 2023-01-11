/*
	주제 : 방문록 게시판 구현
		조건1 :배열쓰기 => contentArray = [] 방문록 내용을 여러개 담는 배열 선언
		조건2 : 방문록 내용 작성<input>
		조건3 : 등록버튼<button> 클릭시 입력된 데이터가 배열에 저장 addContent()함수 실행
		조건4 : 현재 배열에 저장된 모든 방문록을 <table>에 출력
		
		<tr>
			<th>번호</th>
			<th>방문록</th>
		</tr>

*/

//방문록 내용을 담는 배열 선언
let contentArray = [];

//방문록 테이블 함수 밖 선언 -> 누적해야하기 때문
let tableRow = '<tr>'+'<th style="padding : 5px 20px;">'+ "번호"+'</th>'
		+'<th style="padding : 5px 20px;">'+ '방문록'+'</th>'+'</tr>';

//addContent 함수
function addContent(){
	//input에 넣은 데이터 값을 가져온다.
	let textContent = document.querySelector('.noticeBorad');
	let text = textContent.value;
	
	//등록한 내용을 contentArray배열에 저장
	contentArray.push(text);
	
	//등록한 내용의 인덱스를 찾고, 변수에 저장
	let tableIndex = contentArray.indexOf(text)
	
	tableRow += '<tr>'+'<td style="padding : 5px 20px;">'+ tableIndex+'</th>'
		+'<th style="padding : 5px 20px;">'+ contentArray[tableIndex]+'</th>'+'</tr>'

	let content = document.querySelector('.noticeTable');
	content.innerHTML = tableRow
	
	//방문록을 등록했다면 해당 input의 text를 초기화 해준다.
	document.getElementById("board").value ='';
}