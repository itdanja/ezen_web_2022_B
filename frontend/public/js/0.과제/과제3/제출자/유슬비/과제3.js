console.log('실행')



let contentArray = [ ]
let 테이블행 =' <tr> <th> 번호 </th> <th> 방문록 </th> </tr>' ;




function addContent(){
	
	
	let textBox = document.querySelector('.textBox').value	
	
		console.log('클릭')
	
	contentArray.push(textBox)
	
	console.log( 'contentArray의 배열 :' + contentArray)
	
	let 번호 =contentArray.length
	
	테이블행 +=
	' <tr> <th> ' + 번호 + ' </th> <th>'+ textBox+ '</th> </tr>'
	document.querySelector('.vTable').innerHTML = 테이블행
	
	
	
	
	
}