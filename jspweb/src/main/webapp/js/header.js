console.log('js열림');

// 로그인한 회원정보 호출 
getLogin();
function getLogin(){
	$.ajax({
		url : "/jspweb/login" ,
		method : "get" , 
		success : (r) => {
			console.log('통신성공');
			console.log( r );	// Dto1개회원 --> r객체1개 회원
			
			let html = '';	// 1. html 구성 
			if( r == null ){	// 2. 로그인 안했으면 
			
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a>`;
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`;
				
			}else{	// 3.로그인 했으면
			
				html += 
						`
						<div class="dropdown"> <!-- bs : 드롭다운 -->
							<button class="hpimghtn" type="button" data-bs-toggle="dropdown">
								<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg">
							</button>
							<ul class="dropdown-menu">	<!-- 드롭다운시 표기되는 구역 -->
								<li> <a class="dropdown-item" href="#"> 내프로필 </a></li>
								<li> <a class="dropdown-item" href="#"> 친구목록 </a></li>
								<li> <a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 </a></li>
							</ul>
						</div>	<!-- 드롭다운 end  -->
						${r.mid}님
						<a href="#"> 쪽지함 </a>
						<a href="#"> 포인트 </a>
						`
			
			
				if( r.mid == 'admin'){ // 관리자이면 
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
			
			}
			console.log( html );
			document.querySelector(".submenu").innerHTML = html;
		}
	})
}





