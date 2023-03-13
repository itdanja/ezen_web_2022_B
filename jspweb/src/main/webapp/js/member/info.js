console.log('js열림');
console.log( memberInfo );

// * 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if( memberInfo.mid == null ){
	alert('로그인하고 오세요~');
	location.href="/jspweb/member/login.jsp";
}
// 1. header.js에서 ajax 동기식으로 회원정보 가져온 상태  [ memeberInfo ]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src=`/jspweb/member/pimg/${ memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg  }`
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;

// 2. 회원탈퇴 
// function delete(){} // 불가능 [ js 이미 사용중인 키워드 ]
function setDelete(){
	console.log('setDelete()함수 열림')
	$.ajax({
		url : "/jspweb/member" , 
		method : "delete" , 
		data : { "mpwd" : document.querySelector('.mpwd').value } ,
		success : (r)=>{	console.log( '통신' ); console.log(r);
			if( r == 'true'){
				alert('회원탈퇴성공');
				location.href="/jspweb/member/logout.jsp"; // 로그아웃 처리 
			}else{ alert('탈퇴할 계정의 비밀번호가 다릅니다.'); }
		}
	})
}











