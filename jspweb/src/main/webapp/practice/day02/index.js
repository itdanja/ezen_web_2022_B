
// 1. JS 열렸을때
// document.querySelector(".data1").value

// 2. 특정 행동[이벤트] 있을때 코드집합소[함수] 실행
function ex1(){	// 함수 정의
	
	// 변수10개 --------> 객체 { 필드명 : 값 , 필드명 : 값 , 필드명 : 값 } 1개
	let info = {
		data1 : document.querySelector('.data1').value ,
		data2 : document.querySelector('.data2').value ,
		data3 : document.querySelector('.data3').value ,
		data4 : document.querySelector('.data4').value ,
		data5 : document.querySelector('.data5').value ,
		data6 : document.querySelector('.data6').value ,
		data7 : document.querySelector('input[name="data7"]:checked').value ,	// radio 에서 선택된 버튼의 value
		data8 : document.querySelector('.data8').checked ,					// 체크여부 [ true / false ]
		data9 : document.querySelector('.data9').value ,
		data10 : document.querySelector('.data10').value
	}
	console.log( info ) // dada8 외 모두 문자열 임.... [ 추후 형 변환 ]
	
	$.ajax({							// *. jquery 라이브러리 필수!!
		url : "/jspweb/Ex2",			// 1. 서블릿 주소 [ /프로젝트명/서블릿주소(@WebServlet("/서블릿주소") ) ]
		method : "post",				// 2. 메소드 방식 [ doGet vs doPost ]
		data : info ,					// 3. 보낼 데이터 [ 객체 vs { } ]
		success : function( result ){
			console.log( result );
			if( result == 'true' ){ alert('등록성공'); getData(); }
			else{ alert('등록실패');}
		} // 4.받을 데이터 
	})
	
} // end 
getData();
function getData(){
	$.ajax({
		url : "/jspweb/Ex2" ,
		method : "get" ,
		success : function( result ){
			//console.log( result );
			let html = `
						<table border="1">
							<tr>
								<th> data1 </th> <th> data2 </th> <th> data3 </th> <th> data4 </th>
								<th> data5 </th> <th> data6 </th> <th> data7 </th> <th> data8 </th>
								<th> data9 </th> <th> data10 </th> 
							</tr>
						`
						
			result.forEach( (o,i) => {	// 객체명.forEach( (반복변수,반복인덱스) => { 실행문 })
				
				html += `
							<tr>
								<th> ${ o.data1 } </th> <th> ${ o.data2 } </th> <th> ${ o.data3 } </th> 
								<th> ${ o.data4 } </th>	<th> ${ o.data5 } </th> <th> ${ o.data6 } </th> 
								<th> ${ o.data7 } </th> <th> ${ o.data8 } </th>	<th> ${ o.data9 } </th> 
								<th> ${ o.data10 } </th> 
							</tr>
						`
			}) // for end 
			html += `</table>`
			document.querySelector(".ex1_box").innerHTML = html;
			
			
		}
	})
}










