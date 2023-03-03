
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
		success : function(result){
			console.log( result );
			if( result == 'true' ){ alert('등록성공');}
			else{ alert('등록실패');}
		} // 4.받을 데이터 
	})
	
	
}









