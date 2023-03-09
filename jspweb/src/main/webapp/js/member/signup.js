console.log( 'js 열림');

/* 
	JS 정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어 
		-- 문법 
			/^		: 정규표현식 시작 
			$/		: 정규표현식 끝
			[a-z]	: 소문자 a~z 패턴
			[A-Z]	: 대문자 A~Z 패턴
			[0-9]	: 숫자 0~9 패턴 	<------------> \d
			[가-힣]	: 한글 패턴 
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴 
			+ : 앞 에 있는 패턴 1개 이상 반복 
			? : 앞 에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞 에 있는 패턴 0개 반복
			
			\ : 이스케이프 문자
			
			----
			[a-zA-Z] 		: 영문 입력
			[a-zA-Z0-9] 	: 영문 + 숫자 입력
			[a-zA-Z0-9가-힣] : 영문 + 숫자 + 한글 입력 
			----
			1개 이상 문자가 포함되어야 하는 경우 
				(?=.*[ 패턴문자 ] )	: 해당 패턴문자가 한개 이상 입력 
			(?=.*[a-z])	:		소문자 한개 이상 입력  
			(?=.*[A-Z])	: 		대문자 한개 이상 입력 
			(?=.*[0-9])	:		숫자 한개 이상 입력 
			(?=.*[!@#$%^&*]):	해당 하는 특수문자 한개 이상 입력
			----
			/^ (?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20} $/
			1. (?=.*[A-Za-z])					: 영대소문자 한개 이상 입력 
			2. (?=.*\d) vs (?=.*[0-9])			: 숫자 한개 이상 입력 
			3. [ A-Za-z\d ] vs [ A-Za-z0-9 ]	: 영문+숫자 
			--> 영문1개 + 숫자1개 필수로 갖는 5~20글자 사이
			
			/^ (?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{5,20} $/
			--> 영대문자1개 + 영소문자1개 + 숫자1개 필수로 갖는 5~20글자 사이 
			
			/^ (?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,20} $/
			--> 영대문자1개 + 영소문자1개 + 숫자1개 + 특정특수문자 1개 필수로 갖는  5~20글자 사이
		
		-- 패턴 검사 함수 
			정규표현식.test( 데이터 )	: 패턴이 적합하면 true / 아니면 false 
			ex)
			/^[a-z]$/.test( qwe )	--> true 
			/^[a-z]$/.test( QWE )	--> false
*/

//* 첨부파일 이미지 미리보기  [ 업로드 와 상관없음 ]
	// 정책 : 사용자[클라이언트JS]에 운영체제[폴더경로] 접근 불가 
function premimg( object ){	//  object : 해당 함수를 실행시킨 태그객체
	console.log( '첨부파일 바뀜'+object );
	console.log( object.files[0] );	// 현재 이벤트를 실행한 input의 등록한 파일명 호출 
	// 해당 class의 input 에 등록한 파일명 호출 
	console.log( document.querySelector('.mimg').files[0] )
	
	// 1. JS 파일클래스 선언  
	let file = new FileReader();	// 파일 읽기 클래스 
	// 2. 해당 첨부된 파일 읽어오기 ( file.readAsDataURL(첨부파일)  )
	file.readAsDataURL( object.files[0] )	// 해당 파일 읽어오기   / files[0] : 첨부파일 1개
	// 3. 읽어온 파일 꺼내기 바이트단위
	file.onload = (e)=>{ 
		console.log( e.target.result )	
		// e.target -> file.onload	: 읽어온 파일 
		// e.target.result		  	: 읽어온 파일의 바이트 결과 
		// 4. 이미지 태그의 src 이미지 바이트 대입 
		document.querySelector('.premimg').src = e.target.result;
	}
}

// * checkconfirm span 모두 가져오기 --> 여러개의 span이 배열/리스트 객체에 대입
let checkconfirm = document.querySelectorAll('.checkconfirm')	

// 2. 아이디 유효성검사 [ 1. 문자 패턴 체크 2.중복검사 ]
function idcheck(){ // onkeyup : 키 누르고 떼었때
	console.log( '입력중' );
	// 1. 입력할때마다 입력값 가져오기 
	let mid = document.querySelector('.mid').value;
	console.log( mid );
	// 2. 정규표현식    [ 영문(소문자)+숫자  길이 : 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/	
	// 3. 정규표현식 검사 
		console.log( midj.test( mid ) )
	if( midj.test( mid ) ){	// 정규표현식 패턴이 true 이면 
		// 아이디 중복검사 [ js->서블릿->dao 에게 해당 아이디 검색 select ]
		$.ajax({
			url : "/jspweb/mconfirm" ,
			method : "get" , 
			data : { "mid" : mid } ,			// 입력받은 아이디 보내기 
			success : (r)=>{ 
				console.log( 'ajax통신');
				console.log( r )	// 응답 결과 [ 중복있으면 true / 없으면 false ]
				if( r == 'true'){ 
					checkconfirm[0].innerHTML = '사용중인 아이디입니다.';
				}else{
					checkconfirm[0].innerHTML = 'O';
				}
			}
		}) // ajax end 
		
	}else{ // 정규표현식 패턴이 false 이면 
		checkconfirm[0].innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
} // end 

// 3. 비밀번호 유효성검사 
function pwdcheck(){ 
		console.log('pwdcheck s')
	let mpwd = document.querySelector('.mpwd').value; // 1. 입력받은 값 가져오기 
		console.log( ' mpwd : ' + mpwd)
	// 2. 정규표현식 : 영대소문자+숫자 조합 5~20 글자 
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
		console.log( mpwdj.test( mpwd ) )
	// 3. 제어
	if( mpwdj.test( mpwd ) ){
		checkconfirm[1].innerHTML = 'O'; pwedconfromcheck();
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20 글자'
	}
} // end 
// 4. 비밀번호 확인 유효성검사 
function pwedconfromcheck(){
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
		console.log( ' mpwdconfirm : ' + mpwdconfirm)
	// 2. 정규표현식 : 영대소문자+숫자 조합 5~20 글자 
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	// 3. 제어
	if( mpwdj.test( mpwdconfirm) ){
		if( mpwd != mpwdconfirm ){ // 두 비밀번호간의 동일성 체크 [ 두 비밀번호가 서로 다르면 ]
			checkconfirm[1].innerHTML = '두 비밀번호가 일치하지 않습니다.'
		}else{ // 같으면
			checkconfirm[1].innerHTML = 'O'
		}
	}else{ checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20 글자' }
} // f end

// 5. 이메일 형식 확인 유효성검사 
function emailcheck(){
		console.log( 'emailcheck() 함수 열림');
	let memail = document.querySelector('.memail').value;
		console.log( 'memail : ' + memail);
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
		console.log( memailj.test(memail) );
	if( memailj.test(memail) ){ checkconfirm[2].innerHTML = 'O' }
	else{ checkconfirm[2].innerHTML = '이메일 형식으로 입력해주세요' }
} // f end 

// 1. 회원가입 
function signup(){
	// * 유효성검사에 대한 체크 
	let count = 0 ;
	for( let i = 0 ; i<checkconfirm.length ; i++ ){
		if( checkconfirm[i].innerHTML == 'O' ){ count++ }
	} // for end 
	if( count != 3 ){ alert('정상적으로 입력되지 않는 데이터가 있습니다.'); return; } 
	// 
	
	console.log( 'signup 함수 열림');
	// 1. [ 첨부파일 있을때 ] html 에 file input 직접적으로 조작 불가능 
		// document.querySelector(".mimg").value ,  -- 불가능 
		// 1. form 객체 가져오기 
	let signupForm = document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기 
		// 2. form 안에 있는 data 객체 호출  [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData )
	// 2. [ 첨부파일 있을때 ] ajax 
	$.ajax({
		url : "/jspweb/member",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : signupFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원가입실패') }
		}
	})
} // end 



	
/*	
	// 1. [첨부파일 없을떄] 입력받은 값 모두 가져와서 객체화 
	let info = {
		mid : document.querySelector(".mid").value , 
		mpwd : document.querySelector(".mpwd").value , 
		mpwdconfirm : document.querySelector(".mpwdconfirm").value , 
		memail : document.querySelector(".memail").value , 
		mimg : document.querySelector(".mimg").value , 
	};console.log( info );
			
	// 2. [ 첨부파일 없을때 ] ajax 통신을 이용한 서블릿에게 데이터 보내고 응답 받기 
	$.ajax({
		url : "/jspweb/member" ,	// 서블릿 클래스의 @WebServlet("/member")
		method : "post" ,			// 메소드 선택
		data : info ,
		success : (r)=>{ 
			console.log('ajax응답'); 
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원가입실패') }
		} // success end 
	}) // ajax end 
	
*/