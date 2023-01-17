// * 학생들의 점수객체를 여러개 저장하는 배열 
let studentArray = [ ]
// 1. JS 열렸을때 <button> 객체 가져오기 
let addbtn = document.querySelector('.addbtn')
// 2. 해당 버튼에 클릭 이벤트 
addbtn.addEventListener( 'click' , () => {
	
	// 1. 입력받은 데이터를 하나씩 가져와서 객체화
		// * input 숫자를 입력해도 value는 무조건 문자열 가져온다. 형변환 필요!!
	let info = {
		name : document.querySelector('.name').value ,
		kor : parseInt(  document.querySelector('.kor').value ) ,
		eng : parseInt( document.querySelector('.eng').value ) ,
		mat : parseInt( document.querySelector('.mat').value )
	}
	// 2. 유효성검사 [ 데이터 체크 ]
		// 1. 이름 중복체크
	for( let i = 0 ; i< studentArray.length ; i++ ){
		if( studentArray[i].name == info.name ){
			alert('이미 등록된 이름입니다.')
		} // if end 
	} // for end 
	
		// 2. 점수 0~100 사이만 입력 
	if( ( info.kor<0  || info.kor>100 ) ||
		( info.eng<0 || info.eng>100 ) || 
		( info.mat<0 || info.mat>100 ) ) {
		alert('입력할수 없는 점수 범위 입니다. [ 0~100 사이만 가능 ')
	}
	
	
}) // addEvent end 


/*
	studentArray.forEach( (object) => {
		if( object.name == info.name ){
			alert('이미 등록된 이름입니다.')
		}
	})
*/





