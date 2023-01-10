const studentArray = ['20230110','20230111','20230112'];     //학번	

function login() { //로그인 함수
let student = document.querySelector('#Sbox').value;
//인풋 값 넣기

let check = studentArray.indexOf(student);
//인풋 값과 배열 일치 확인하기 

if(student==0)
	{ //공백이라면
	alert("공백란 입니다.")	
		}else if(student.length<=7)
			{//7자리 이하라면
			alert("8자리로 입력해주세요.")
			}else
				{//8자리 입력했다면
					if (check>-1){ //배열에 존재한다면
					alert("성공!")
					document.querySelector('#Sbox').value = null; //인풋값 초기화
					document.querySelector('.resultBox').innerHTML="로그인 성공";
					}
						else
					{
						alert("실패!")
						document.querySelector('.resultBox').innerHTML="로그인 실패";
					}
			
				}
}		

