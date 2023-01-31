
/* ------------ 전역변수 : 모든 함수{ } 공용으로 사용되는 메모리 [변수] -------------------- */
// 1. js열렸을때 현재 연도와 월을 구해서 변수에 저장 
let year = new Date().getFullYear(); 	// 기본값 : 현재 연도	// 이전/다음 버튼 클릭에 따른  변경
let month = new Date().getMonth()+1 ;  //  기본값 : 현재 월 	// 이전/다음 버튼 클릭에 따른  변경
// 2. 캘린더 표시 함수 [ 1. js열렸을때 2.이전/다음 버튼 클릭할때마다]
cal_print();
function cal_print(){
	// 1. 현재 캘린더 설정된 날짜를 상단에 월/일 표시 
	document.querySelector('.top_date').innerHTML = `${ year }년 ${ month}월`;
	// 2. html '요일' 기본 구성 
	let html = `<div class="day weekday sunday"> 일 </div> <div class="day weekday"> 월 </div>
				<div class="day weekday"> 화 </div> <div class="day weekday"> 수 </div>
				<div class="day weekday"> 목 </div> <div class="day weekday"> 금 </div>
				<div class="day weekday"> 토 </div>`
				
	// * 현재 캘린더 설정된 날짜의 마지막 일 구하기
	let lastday = new Date( year , month , 0 ).getDate(); console.log(' 현재 캘린더 마지막 일  : ' + lastday );
	// *  현재 캘린더 설정된 날짜의 1일 시작 요일 구하기  
	let weekday = new Date( year , month-1 , 1  ).getDay(); console.log(' 현재 캘린더 시작일 요일  : ' + weekday );
	
	// * 2. 시작 요일 전에 공백 만들기 
	for( let b = 1 ; b<=weekday ; b++ ){
		html += `<div class="day"></div>`
	} //for end 
	// * 1. 일 만들기  [  1 ~ 마지막 일[ new Date( year , month , 0 ).getDate()  ] 까지 ] 
	for( let day = 1 ; day<=lastday; day++ ){
		html += `<div class="day"> ${ day } </div>`
	} // for end 
	
	// 3. html 마크업 출력
	document.querySelector('.cal_day').innerHTML = html;	
	
} // f e 
// 3. 이전달 다음달 버튼 클릭 이벤트에 따른 연도 와 월이 변경 
document.querySelector('.previousbtn').addEventListener( 'click', (e)=>{ console.log('이전달 버튼 클릭')
	month--; // 1. '월' 1차감 했을경우 만약에 월 1보다 작으면 '연도' 1차감 '월' 12 설정 
	if( month < 1 ){ year--; month = 12;}
	cal_print();
} ) // fe 
document.querySelector('.nextbtn').addEventListener( 'click', (e)=>{ console.log('다음달 버튼 클릭')
	month++; // 1. '월' 1증가 했을경우 만약에 월 12보다 크면 '연도' 1증가 '월' 1 설정
	if( month > 12 ){ year++; month = 1 ; }
	cal_print();
} ) // fe 

/*
	new Date()  날짜/시간 관련된 클래스 
		1. let date = new Date() 					: 현재 날짜/시간 객체 
		2. let date = new Date( 2023 , 01 , 31 )	: 사용자정의 날짜 객체  
		3. let date = new Date( 연도 , 월 , 0 )		: 사용자정의 연도와 월 날짜에 따른 마지막 일 날짜
			1. get 함수 제공 
				1. .getFullYear() 	: 연도
				2. .getMonth() 		: 월 [ 0~11  0:1월 ~ 11:12월 ]
				3. .getDate()		: 일 
				4. .getDay()		: 요일 [ 0 ~ 6	0:일요일 ~ 6:토요일 ]

let date = new Date(); console.log( 'date : ' + date )
let date2 = new Date( 2020 , 1 , 31 ); console.log( 'date2 : '+ date2 )
console.log( '연도 : ' + date.getFullYear() );
console.log( '월 : ' + date.getMonth() );
console.log( '일 : ' + date.getDate() ); 
console.log( '요일 : ' + date.getDay() );

*/
