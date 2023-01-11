console.log('JS실행'); // 확인용
/*
	*오류메시지 : ~~ is not defined
	1. 정의X 2.이름오타 3.저장/새로고침 적용X
*/
/*
	*카멜 표기법 : 
		studentarray 	-> 	studentArray
		onlogin			->	onLogin
*/

/* 4. 배열선언 위치 
		1.함수안에서 선언(함수실행마다 선언 - 누적 저장X) 
		2.함수밖에서 선언(JS실행 1번 선언 - 누적 저장O)
*/
// 4. 배열 선언과 동시에 3개의 요소 저장 
let studentArray = ['20230110' , '20230109' , '20230108']
// ---------------------------- 1.과제1 함수 ---------------------//
// 3. HTML : onclick="onLogin()" 에 대한 함수 정의[만들기]
function onLogin(){ // 함수[onLogin] 시작 점 
		console.log('onLogin함수 실행;') // 확인용
	// 5. <input> 마크업를 js변수로 가져오기 [ DOM객체 ]
	let sno = document.querySelector('.sno')
	// 5. <input> 마크업에 입력된 데이터 호출 
	let snoValue = sno.value;
		console.log('5번체크 : '+  snoValue ) // * 확인
	// 6. 찾기 [ 만약에 배열내 입력한 값이 존재하면 찾은 인덱스 / 존재하지않으면 -1 ]
	let sIndex = studentArray.indexOf( snoValue )
		console.log('6번체크 : ' + sIndex ) // * 확인 
	// 7. 논리
	if( sIndex == -1 ){  // if s
		//alert('로그인실패') 
		 // 8. 출력 [ innerHTML 이용한 '문구' 출력 ]
		document.querySelector('.resultBox').innerHTML = '알수없는 학번입니다.!'
	} // if e 
	else{  // else s 
		//alert('로그인성공'); 
		document.querySelector('.resultBox').innerHTML = '로그인성공!'
	}  // else s
}// 함수[onLogin] 끝

// ---------------------------- 2.과제2 함수 ---------------------//

function onAdd(){ // 1. 함수 시작 

		console.log('1.함수 실행') // 1. 확인
	
	// 2. <input> 마크업 가져와서 변수에 저장 [ Dom 객체 ]
	let sno2 = document.querySelector('.sno2')
	
		console.log( sno2 ) //2. 확인
	
	// 2.2 <input> 마크업 에 입력된 value[값] 가져와서 변수에 저장 
	let sno2Value = sno2.value
	
		console.log('2. 입력값 : ' + sno2Value ) //2. 확인
	
	// ! 검사 변수 [ 유효성검사 체크리스트 ]
	let confirm = 0;
	// ! 추가코드 1. 만약에 입력된 값이 공백이면 
	if( sno2Value == '' ){ console.log('공백이네요.~'); confirm++; }
	// ! 추가코드 2. 만약에 입력된 값이 8자리 아니면 
		console.log('2. 입력값 길이 : ' + sno2Value.length );
	if( sno2Value.length !=8 ){ console.log('8자리 아니네요~'); confirm++; }
	// 3. 유효성검사[ 중복체크 ]
		// 입력받은 값[sno2Value]이 있고 기존에 있는 값들[studentArray] 과 비교
		// 경우의수 2가지 [ 중복이 있다 or 없다 ] 
	// 지역변수 : 해당 지역{ } 에서 선언되면 { } 안으로 이동가능 / { } 밖으로 이동 불가능 
	// if{} 와 else {} 에서 같이 사용할 변수 이기에 if 밖에 선언 
	let resultBox2 = document.querySelector('.resultBox2') 
	
	if( confirm == 0 ){ // 만약에 confirm 0 일때만 아래 코드  실행
		if( studentArray.indexOf(sno2Value) == -1 ){ // 중복 없다 
				console.log('학번 등록했습니다.')
			studentArray.push( sno2Value )
				console.log( resultBox2 )
			resultBox2.innerHTML = '학번 등록했습니다.'
			// !추가코드 3. 만약에 등록을 성공했으면 <input> value 초기화
			sno2.value = ''
		} // if end 
		else{ // 중복 있다.
			console.log('이미 등록된 학번 입니다.') 
			resultBox2.innerHTML = '이미 존재하는 학번입니다..' // resultBox2 is not defined
		}// else end 
	}
} // 함수 끝
