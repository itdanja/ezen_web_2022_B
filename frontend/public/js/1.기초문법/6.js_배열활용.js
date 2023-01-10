
alert('JS실행합니다.') // 1번 실행

/* 1. 추가 버튼을 눌렀을때 클릭 이벤트 함수 */
function onAdd(){ 
	// 1. function : 함수정의 키워드
	// 2. onAdd : 함수명[ 아무거나 ]
	// 3. ( ) : 인수 [ 함수안으로 전달받은 데이터 ]
	// 4. { } : 함수가 실행되는 구역 
	alert('클릭함수 실행합니다.')
	
	/*2. 입력받은 input value[값] 을 가져오기 */
	let sname= document.querySelector('.sname')
		// sname 변수에 input 마크업 저장
	/*3. 마크업에서 값 가져오기 */
	alert( sname.value )
	
}