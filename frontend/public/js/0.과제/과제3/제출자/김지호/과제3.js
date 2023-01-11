console.log('JS실행')//확인용

let contentArray = []


function addContent(){
	console.log('onLogin실행')//확인용
	let write = document.querySelector('.write')
	let writeValue = write.value
	console.log('방문록 써지나' + writeValue)//확인용
	
	contentArray.push( writeValue )
	console.log('방문록 배열에 써지나' + contentArray)//확인용
	
	let 테이블행 = 	'<tr>'+
					'<th>'+'번호'+'</th>'+
					'<th>'+'방문록'+'</th>'+
				'</tr>'

	for(let i = 0 ; i<contentArray.length ; i++){

	테이블행 +=  '<tr>'+
					'<td>'+(i+1)+'</td>'+
					'<td>'+contentArray[i]+'</td>'+
				'</tr>'
	}
document.querySelector('.table').innerHTML = 테이블행	
}