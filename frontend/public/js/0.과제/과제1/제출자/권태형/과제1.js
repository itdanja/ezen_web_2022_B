/*
과제1 : 입력 상자에 학번[8자리] 입력후 로그인 버튼 클릭시 배열에 존재하면 로그인 성공 출력 / 로그인 실패
	[조건 1] const studentArray = ['20230110' , '20230109' , '20230108' ]
	[조건 2] 입력 < input > 사용
	[조건 3] <button> 사용해서 로그인 이벤트 실행


과제2 :  입력 상자에 학번[8자리] 입력 후에 배열에 저장했으면 성공, 아니면 실패 출력
	[조건 1] const studentArray 배열에 push 등록한다.
	[조건 2] 만약에 동일한 학번이 존재하면 '실패' 출력 아니면 성공 출력
	[조건 3] 등록 <button> 사용해서 등록 이벤트 실행
----------------------------------------------------------------------
	*추가
	 	1. 만약에 입력상자에 공백이면 '학번을 입력해주세요' 출력					[' ']
		2. 등록이나 로그인 시 성공시에 입력상자에 input에 value 다시 공백으로 초기화	[value]
		3. 입력상자[input]에 입력한 데이터가 8자리가 아니면 8자리로 입력해주세요.		[length]
 */

const studentArray = ['20230110' , '20230109' , '20230108' ]

function onLogin(){ 
	//<input> 마크업을 js변수로 가져오기 [DOM 객체]
	let class_num = document.querySelector('.class_num')

	// <input>마크업에 입력된 데이터 호출
	let sname = class_num.value
	//길이 알기
	let long = sname.length
	// 찾기 [ 만약에 배열내 입력한 값이 존재하면]
	let dindex = studentArray.indexOf(sname);
	// 입력한것이 없으면 학번입력
	if(sname=="") 
		document.querySelector('.resultBox').innerHTML = '학번을 입력해주세요!';
	// 입력한 숫자가 8자리가 아니면 8자리 입력하라는 출력
	else if(long!=8)
		document.querySelector('.resultBox').innerHTML = '학번을 8자리로 입력해주세요!';
	// 배열내에 입력한 값이 존재했으면 로그인 성공
	else if(dindex!=-1){
		document.querySelector('.resultBox').innerHTML = '로그인성공!';
		// 로그인 성공 시 input의 데이터 공백으로 초기화
		
		}
	//배열내에 입력한 값이 존재하지 않았으면 로그인 실패
	else 
		document.querySelector('.resultBox').innerHTML = '알수없는 학번입니다!'
	// 배열 확인용
	console.log(studentArray)
	
}


function join(){
	let class_num2 = document.querySelector('.class_num2')
	let sname2 = class_num2.value
	let long2 = sname2.length
	console.log(long2)
	let dindex2 = studentArray.indexOf(sname2);
	if(sname2=="")
		document.querySelector('.resultBox2').innerHTML = '학번을 입력해주세요!';
	else if(long2!=8)
		document.querySelector('.resultBox2').innerHTML = '학번을 8자리로 입력해주세요!';
	else if(dindex2 != -1) 
		document.querySelector('.resultBox2').innerHTML = '이미 있는 학번입니다!';
	else {
		studentArray.push(class_num2.value); 
		document.querySelector('.resultBox2').innerHTML = '학번 등록 성공!'; 
		}
	console.log(studentArray)
}





