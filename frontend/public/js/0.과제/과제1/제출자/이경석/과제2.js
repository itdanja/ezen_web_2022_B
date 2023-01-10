function Signup(){
	let check = document.querySelector('#Sbox2').value

	let check2 = studentArray.indexOf(check);
	
	if(check==0)
	{//공백이라면
	alert("공백란 입니다.")	
	}
	else if(check.length<=7)
	{//7자리 이하라면
		alert("8자리로 입력해주세요.")
	}else
	{//8자리 입력했다면
		if(check2>-1)
		{// 배열 존재시
		alert("존재하는 학번 입니다.")
		document.querySelector('.resultBox2').innerHTML="존재하는 학번 입니다.";
		}
		else
		{ //배열에 존재하지 않을시	
		studentArray.push(check)
		console.log(studentArray)
		alert("학번등록되었습니다")
		
		document.querySelector('#Sbox2').value = null;
		document.querySelector('.resultBox2').innerHTML="등록되었습니다.";
		}
	}
}

