console.log( '1.js열림')

// * 함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리 사용 
let contents = [ ]
onprint()
	// 이벤트함수 
		// 1. <button type="button" onclick="onwrite()"> 글 등록 </button>
			// function onwrite(){} 
		// 2. <button type="button" class="onwritebtn"> 글 등록 </button>
			// document.querySelector('.onwritebtn').addEventListener( 'click' , (e) => {} )

// 1. 글 등록 함수 
function onwrite(){ //  f s // 1.글 등록버튼을 눌렀을떄
	console.log('2.onwrite 함수 열림')
	// 1. 입력받은 4개 데이터를 하나의 객체 선언  
	let info = { // let 객체명(아무거나) = { 속성명:데이터 , 속성명:데이터 , 속성명 : 데이터 }
		bwriter : document.querySelector('.bwriter').value , 
		bpassword : document.querySelector('.bpassword').value ,
		btitle : document.querySelector('.btitle').value , 
		bcontent : document.querySelector('.bcontent').value 
	}
	console.log( info ) // 객체 정보 출력시 문자열 연결연산자 금지
	// 2. 유효성검사	//  객체명.속성명
		// 1. 입력받은 데이터 길이 체크 
	if( info.bwriter.length <= 0 || info.bpassword.length <= 0 || 
		info.btitle.length <= 0 || info.bcontent.length <= 0 ){
		alert('작성이 안된 구역이 있습니다. 작성해주세요');
		return ; //함수 종료 ... 
	}
	// 3. 배열에 저장 *추후 : 백엔드에게 통신해서 데이터 전달 [ 백엔드 : java , db ]
	contents.push( info )
	alert('글 등록 성공')
	onprint()
	console.log( contents )
	// 4. input 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
} // f e 

// 2. 글 목록 출력 함수 
function onprint(){ // f s // 1. js 열렸을때 2.글 등록했을때 3.글삭제 4.글수정
	console.log('onprint 열림')
	// 1. 기본 html 구성
	let html = `<tr><th>번호</th><th>제목</th><th>작성자</th></tr>`
	// 2. 내용 html 구성
	for( let i = 0 ; i<contents.length ; i++ ){
		html += `<tr onclick="onview( ${i} )">
					<th>${ i+1 }</th>
					<th>${ contents[i].btitle }</th>
					<th>${ contents[i].bwriter }</th>
				</tr>`
	} 	
	// 3. 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML = html;
} // f 
// 3. 글 보기 함수
function onview( i ){ // f s // 1. 글 목록에서 해당 행을 클릭했을때
	console.log( i )
	let html = `<div> 제목 : ${ contents[i].btitle }</div>
				<div> 내용 : ${ contents[i].bcontent } </div>
				<div> 작성자 : ${ contents[i].bwriter } </div>
				<div> <button onclick="ondelete( ${ i } )">삭제</button>  </div>
				`
	document.querySelector('.viewbox').innerHTML = html;
} // f e 
// 4. 글 삭제 함수 
function ondelete( i ){
	let password = prompt('비밀번호 : ')
	if( password == contents[i].bpassword ){
		alert('삭제 성공')
		contents.splice( i  , 1 )
		onprint();	
		document.querySelector('.viewbox').innerHTML = '';
	}else{
		alert('삭제 실패')
	}
}



































