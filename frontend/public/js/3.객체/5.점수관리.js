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
		kor : parseInt( document.querySelector('.kor').value ) ,
		eng : parseInt( document.querySelector('.eng').value ) ,
		mat : parseInt( document.querySelector('.mat').value )
	}
	// 2. 유효성검사 [ 데이터 체크 ]
	let check = true;	// 유효성검사 상태 저장하는 변수 [ 아래 4중 하나라도 충족하면 저장 실패]
		// 1. 이름 중복체크
	for( let i = 0 ; i< studentArray.length ; i++ ){
		if( studentArray[i].name == info.name ){
			alert('이미 등록된 이름입니다.'); check = false;
		} // if end 
	} // for end 
		// 2. 점수 0~100 사이만 입력 
	if( ( info.kor<0  || info.kor>100 ) ||
		( info.eng<0 || info.eng>100 ) || 
		( info.mat<0 || info.mat>100 ) ) {
		alert('입력할수 없는 점수 범위 입니다. [ 0~100 사이만 가능] '); check = false;
	}
		// 3. 이름이 3~5 사이만 입력 
	if( info.name.length < 3 || info.name.length > 5 ){
		alert('이름은 3~5글자 입력해주세요.') ; check = false;
	}
		// 4. 숫자 아닐경우 [ isNaN() : 숫자형식 체크 [ 문자이면 true or 숫자이면 false ] ]
	if( isNaN( info.kor ) || isNaN( info.eng ) || isNaN( info.mat ) ){
		alert('숫자형식으로 입력해주세요') ; check = false;
	}
	// 3. 저장 [ 위 유효성검사에서 하나라도 충족하지 않았을때 ]
	if( check ){ studentArray.push( info ); alert('학생점수 등록했습니다.'); printTable(); }
	
}) // addEvent end 

// 2. 배열내 객체 정보를 테이블에 출력하는 함수  [ 1.JS열렸을때 2.등록할때마다/업데이트 3.삭제 4.수정 ]
printTable(); // 함수 호출 
function printTable(){ // 함수 정의 
	// 1. html 구성
	let html = `<tr><th> 번호 </th><th> 이름 </th><th> 국어 </th>
					<th> 영어 </th><th> 수학 </th><th> 총점 </th>
					<th> 평균 </th><th> 순위 </th><th> 비고 </th>
				</tr>`
	// 2. 배열내 객체 정보를 html 대입 
	studentArray.forEach( ( o , i ) => {
		html+=`<tr>
					<td> ${ i+1 } </td>		<td> ${ o.name } </td>	<td> ${ o.kor } </td>
					<td> ${ o.eng } </td>	<td> ${ o.mat } </td>	<td> ${ o.kor+o.eng+o.mat } </td>
					<td> ${ parseInt( (o.kor+o.eng+o.mat)/3 ) } </td>	<td> 순위 </td>	<td> 비고 </td>
				</tr>`
	} )
	// 3. 
	document.querySelector('.listtable').innerHTML = html;
}

/*
	// 1. 
	studentArray.forEach( (object) => {
		if( object.name == info.name ){
			alert('이미 등록된 이름입니다.')
		}
	})
	// 2. 
	
*/





