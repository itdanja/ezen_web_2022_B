
//*
if( memberInfo.mid == null ){
	alert('로그인하고 오세요');
	location.href="/jspweb/member/login.jsp"
}

document.querySelector('.mid').innerHTML = memberInfo.mid
document.querySelector('.memail').value = memberInfo.memail
document.querySelector('.mimg').src 
	= `/jspweb/member/pimg/${ memberInfo.mimg == null ? 'default.webp' :  memberInfo.mimg }`
	
// 1. 
function setUpdate(){
	// 2.첨부파일 있을때
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData( updateForm );
	// 3. 폼에 데이터 추가
		// 1. 체크박스 체크여부 확인 
	let defaultimg = document.querySelector('.defaultimg').checked
	updateFormData.set( "defaultimg" , defaultimg );

	$.ajax({
		url : "/jspweb/member" , 
		method : "put" , 
		data : updateFormData ,
		contentType : false ,	// ! 
		processData : false ,	// !
		success : (r) => {
			console.log( '통신' ); console.log(r);
			if( r =='true'){
				alert('수정성공 : 다시 로그인');
				location.href="/jspweb/member/logout.jsp"
			}else{
				alert('수정실패 : 기존 비밀번호가 틀렸습니다.');
			}
		}
	})
	
}

/*
	// 1. 첨부파일 없을때
	let info = {
		'mpwd' : document.querySelector('.mpwd').value ,
		'newmpwd' : document.querySelector('.newmpwd').value ,
		'memail' : document.querySelector('.memail').value 
	}; console.log( info );
	$.ajax({
		url : "/jspweb/member" , 
		method : "put" , 
		data : info ,
		success : (r)=>{
			console.log( '통신' ); console.log(r);
		}
	})
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	