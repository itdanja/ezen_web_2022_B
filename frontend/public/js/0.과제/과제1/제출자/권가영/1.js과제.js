/*
	과제1 : 학번[8자리] 입력시 배열에 존재하면
		로그인 성공 출력/ 로그인 실패
		
		[조건1]
		const studentArray = ['20230110', '20230109', '20230108']
		[조건2]
		입력 <input> 사용해서 학번 입력받기
		[조건3]
		로그인 <button>
		
	과제2 : 입력상자에 학번[8자리] 등록 입력후에
		배열에 저장했으면 성공 출력, 아니면 실패 출력
		
		[조건1] 
		studentArrray 배열에 push 등록한다.
		[조건2]
		만약에 배열에 존재하는 학번이면 '실패'
		[조건3]
		등록 <button> 사용해서 등록 이벤트 실행
		
		+ 
		1. 만약에 입력상자에 공백이면 학번을 입력해주세요~  과제 1, 과제 2 둘다 ['']
		2. 등록이나 로그인 성공시에 input 박스의 value값을 다시 공백으로 초기화. [value]
		3. 입력상자[input]에 입력한 데이터가 8자리가 아니면 8자리로 입력해주세요. [length]

*/

/*
	*카멜표기법 : 가장 첫글자는 소문자로 하되, 두번째 글자 첫글자는 대문자로 표기한다. 
			   ex) studentMember, userId 등등
	
	배열 선언
		1. 함수 안에 선언(함수 실행마다 선언 - 누적 저장 X)
		2. 함수 밖에 선언(JS 실행 1번 선언 - 누적 저장 O)
*/
//배열 선언과 동시에 3개의 요소 저장
const studentArray = ['20230110', '20230109', '20230108'] //학생 학번이 들어있는 배열

/*-------------------------------과제1------------------------------------ */
function onLogin(){ //조회 버튼 클릭시 실행 메서드 
	
	//입력받은 데이터를 가져온다. <input> 가져와서 변수에 저장
	let studentNumber = document.querySelector('.studentNumber');
	//입력 받은 데이터의 값을 변수 sNumber에 저장 
	let sNumber = studentNumber.value;
	//입력받은 데이터의 값이 studentArray에 있을 경우 해당 인덱스를 반환함.
	//만약 없다면 -1를 반환 -> 배열의 인덱스는 0부터 시작하기 때문
	let hasNumber = studentArray.indexOf(sNumber);
	
	if(hasNumber != -1){ //-1이 아닌 경우가 해당 학번이 있다는 것이니까 로그인 성공
		console.log("로그인 성공")
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : blue">' + "로그인 성공" + '</h4>'
		
		//학번을 HTML body에 list로 출력
		let sList = document.querySelector('#studentList'); 
		sList.innerHTML = '<li>' + studentArray + '</li>'
		//HTML에서 text를 타입으로 가지는 <input>이면서 id가 student_Number인 요소의 값을 ''로 바꿈.
		//텍스트 적는 곳을 초기화하겠다는 뜻. 
		document.getElementById("student_Number").value ='';
	}
	//trim() : 공백을 모두 제거해주는 메서드. -> 공백을 모두 제거 했는데 '' (빈값)이면 아무것도 작성하지 X
	//이렇게 한 이유는 공백으로 8자리를 채울때와 등록을 하게 되면서 문제가 생길 것 같아서.
	else if(sNumber == '' || sNumber.trim() == ''){ //텍스트 입력란에 공백이나 아무것도 적지 않으면
		console.log("학번을 입력해주세요~")
	}
	else if(sNumber.length != 8){ // 학번이 8자리보다 크거나 작으면(초과 or 미만)
		console.log("8자리로 입력해주세요.")
	}
	else{ //그 외
		console.log("로그인 실패.")
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : red">' + "로그인 실패" + '</h4>'
	}
}

/*-------------------------------과제2------------------------------------ */
function onAdd(){ //등록 버튼 클릭시 실행 메서드
	
	let studentNumber = document.querySelector('.studentNumber');
	
	let sNumber = studentNumber.value;
	
	let hasNumber = studentArray.indexOf(sNumber);
	
	if(hasNumber != -1){
		
		console.log("[실패]등록된 학번입니다.")
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : red">' + "등록 실패" + '</h4>'
		
	}
	else if(sNumber == '' || sNumber.trim() == ''){
		
		console.log("학번을 입력해주세요~")
	}
	else if(sNumber.length != 8){
		
		console.log("8자리로 입력해주세요.")
	}
	else{
		studentArray.push(sNumber);
		console.log("등록이 성공되었습니다.");
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : blue">' + "등록 성공" + '</h4>'
		
		let sList = document.querySelector('#studentList');
		sList.innerHTML = '<li>' + studentArray + '</li>'
		
		document.getElementById("student_Number").value ='';
	}
}


function onDelete(){ //삭제버튼 클릭 시 실행 메서드
	
	let studentNumber = document.querySelector('.studentNumber');
	
	let sNumber = studentNumber.value;
	
	let deleteIndex = studentArray.indexOf(sNumber);
	
	if(deleteIndex != -1){
		console.log("삭제 성공하였습니다.")
		
		studentArray.splice(deleteIndex, 1); //해당 학번의 인덱스부분에 해당하는 요소 1개를 삭제
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : blue">' + "삭제 성공" + '</h4>'
		
		let sList = document.querySelector('#studentList');
		sList.innerHTML = '<li>' + studentArray + '</li>'
		
		document.getElementById("student_Number").value ='';
	}
	else if(sNumber == '' || sNumber.trim() == ''){
		console.log("학번을 입력해주세요~")
	}
	else if(sNumber.length != 8){
		console.log("8자리로 입력해주세요.")
	}
	else{
		console.log("삭제 실패하였습니다.")
		
		let state = document.querySelector('#resultBox');
		state.innerHTML = '<h4 style = "color : red">' + "삭제 실패" + '</h4>'
	}
	
}