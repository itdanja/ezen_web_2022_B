/*방명록 배열*/
let contentArrays = []; 


/*버튼 기능 */
function addContent(){
	
	/*방명록 배열 넣기 */
	contentArrays.push(document.querySelector('#box').value);

/*초기 방명록 테이블 헤드 ※같은내용 반복안되게 초기화*/
let table = ' <table> <tr> <th> 번호 </th> <th> 방문록 </th> </tr>'	


	/*방명록 배열 길이까지 행 늘리기 */
	for(let i = 0 ; i < contentArrays.length ; i ++)
	{
		table += '<tr>'
			table += '<td>'+ (i+1) +'</td>'
			table += '<td>'+ contentArrays[i] +'</td>'
		table += '</tr>'
		
	}
	
	/*방명록 테이블 끝*/
	table += '</table>'

	/*덮어쓰기*/
	document.querySelector('#write').innerHTML = table;

}