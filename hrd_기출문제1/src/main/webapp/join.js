console.log('join.js열림');

function join(){
	console.log('join')
	// 유효성검사 
	if( document.joinform.custno.value ==""){
		alert('custno 입력해주세요');
		document.joinform.custno.focus(); // 커서이동
		return false;
	}if( document.joinform.custname.value ==""){
		alert('회원성명를 입력해주세요');
		document.joinform.custname.focus(); // 커서이동
		return false;
	}if( document.joinform.phone.value ==""){
		alert('phone 입력해주세요');
		document.joinform.phone.focus(); // 커서이동
		return false;
	}if( document.joinform.address.value ==""){
		alert('address 입력해주세요');
		document.joinform.address.focus(); // 커서이동
		return false;
	}if( document.joinform.joindate.value ==""){
		alert('address 입력해주세요');
		document.joinform.joindate.focus(); // 커서이동
		return false;
	}if( document.joinform.grade.value ==""){
		alert('grade 입력해주세요');
		document.joinform.grade.focus(); // 커서이동
		return false;
	}if( document.joinform.city.value ==""){
		alert('city 입력해주세요');
		document.joinform.city.focus(); // 커서이동
		return false;
	}
	// 폼 전송 
	document.joinform.submit();
	alert('회원 등록이 되었습니다.')
}
