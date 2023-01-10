console.log('JS실행')//확인용

//4.
let studentArray = ['20230110', '20230109', '20230108']
//3. 
function onLogin(){//끝
	console.log('onLogin실행')//확인용
	
	//5. <input>마크업을 js변수로 가져오기[DOM 객체]
	let sno = document.querySelector('.sno')
	//5. <input> 입력된 데이터 호출
	let snoValue = sno.value;
	console.log('5확인' + snoValue)//확인용
	
	//6. 배열에 같은게 있는지 찾기[없으면 -1이 나옴]
	let sIndex = studentArray.indexOf(snoValue)
	console.log('6확인' + sIndex)//확인용
	
	//7. 길이 확인용 
	let length = snoValue.length
	console.log('길이 확인' + length)//확인용
	
	//8. 길이가 0이면 학번을 입력하세요 출력
	if(length==0){document.querySelector('.resultBox').innerHTML = '학번을 입력해 주세요.';}
	
	//9. 길이가 8이 아니면 8자리로 입력해주세요 출력
	else if(length != 8){
		 document.querySelector('.resultBox').innerHTML = '8자리로 입력해 주세요';
	}
	
	//10. 배열에 같은게 있으면 로그인 성공
	else if(sIndex != -1){
		document.querySelector('.resultBox').innerHTML = '로그인 성공';
	}
	
	//11. 배열에 같은게 존재하지 않으면 로그인 실패
	else {
		document.querySelector('.resultBox').innerHTML = '알 수 없는 학번입니다.';
	}
	sno.value = '';
}//끝

function onAdd(){
	//5. <input>마크업을 js변수로 가져오기[DOM 객체]
	let idAdd = document.querySelector('.idAdd')
	//5. <input> 입력된 데이터 호출
	let idAddValue = idAdd.value;
	console.log('5확인' + idAddValue)//확인용
	
	//6. 배열에 같은게 있는지 찾기[없으면 -1이 나옴]
	let iIndex = studentArray.indexOf(idAddValue)//6
	console.log('6확인' + iIndex)//확인용
	
	//7. 길이 확인용 
	let length = idAddValue.length
	
	//8. 길이가 0이면 학번을 입력하세요 출력
	if(length==0){document.querySelector('.resultBox2').innerHTML = '학번을 입력해 주세요.';}
	
	//9. 길이가 8이 아니면 8자리로 입력해주세요 출력
	else if(length != 8){document.querySelector('.resultBox2').innerHTML = '8자리로 입력해 주세요';}
	
	//10. 배열에 같은게 없으면 등록 성공
	else if(iIndex == -1 ){
		 studentArray.push(idAdd.value)
		 document.querySelector('.resultBox2').innerHTML = '등록 완료';
		 console.log(studentArray)
	}
	
	//11. 배열에 같은게 존재하면 등록 실패
	else { document.querySelector('.resultBox2').innerHTML = '존재하는 학번입니다.';}
	idAdd.value = '';
}
