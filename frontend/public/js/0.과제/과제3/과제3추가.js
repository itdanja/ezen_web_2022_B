console.log( '1.js작동')

let contentArray = [ ] // 누적 기록 
// 1. 등록 버튼 클릭 했을때 이벤트 함수
function addContent(){ // f s
	let content = document.querySelector('.content').value // 2. <input> 에서 입력받은 데이터[value] 가져와서 변수에 저장 
	contentArray.push( content ) // 3. 배열내 입력받은 변수 저장 
	printContent( )
} // f e
// 2. 삭제 버튼을 클릭했을때 함수 
function onDelete( dno ){ // f s 
	contentArray.splice( dno , 1 )
	printContent( )
} // f e 
// 3. 배열내 존재하는 요소들을 출력하는 함수 [ 1. 등록했을때 2.삭제했을때 ]
function printContent( ){
	// 4. 출력할 html 구성 [ + vs ` ]
	let html = `<tr>			
					<th>번호</th>
					<th>방문내용</th>
					<th>비고</th>
				</tr>` 			
	for( let i = 0 ; i<contentArray.length; i++ ){ // 5. 내용추가 [ 반복 이용한 배열내 요소 출력 ]
		html += `<tr>
					<td>${ i+1 }</td>
					<td>${ contentArray[i] }</td>
					<td><button onclick="onDelete( ${i} )">삭제</button></td>
				</tr>`	
												/* onDelete( 삭제할번호 ) */
	} // for end 
	document.querySelector('.contentTable').innerHTML = html // 6. 위에서 구성된 html를 해당 마크업에 대입
}









 
