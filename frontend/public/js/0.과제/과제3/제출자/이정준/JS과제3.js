/*
과제3 방문록 게시판 구현

	조건1 : 방문록 내용을 여러개 담는 배열 선언 : let contentArray = [ ]
	조건2 : 내용작성 <input> 입력받기
	조건3 : 등록버튼<button> 클릭시 입력된 데이터가 배열에 저장
	조건4 : 현재 배열에 저장된 모든 방문록을 <table>에 출력
	
		<tr>
			<th> 번호 </th> <th> 방문록 </th>
		</tr>*/
		

		
let contentArray = []


function addContent() {
let table1 = '<tr> <th>번호</th> <th>방문록</th>';
let centent = document.querySelector('.centent').value

contentArray.push(centent)
console.log(contentArray)

let num = contentArray.length
console.log(num)

for(let 번호 = 0 ; 번호<=(num-1) ; 번호++){

	
	table1 += '<tr> <th>'+번호+' </th> <th>'+contentArray[번호]+'</th></tr>';
	
}	

document.querySelector('.방문록').innerHTML = table1
}