// 1. userbox / logbox / monbox  Dom객체 가져오기
let userbox = document.querySelector('.userbox');
let monbox = document.querySelector('.monbox');

let logbox = document.querySelector('.logbox');
let logbox2 = document.querySelector('.logbox2');

// * userbox [기본/처음] 위치/좌표
let u_left = 10;	// 유저 
let m_left = 910;	// 몬스터 

// 2. 문서 안에서 키 입력 이벤트  keydown
document.addEventListener( 'keydown' , (e)=>{
	let key = e.keyCode;	// 입력된 키 코드를 변수에 저장 
	if( key == 37 ){ // 왼쪽키 -> 이동 
		u_left -= 10; 	// 왼쪽 좌표 -10 차감 
		u_left = u_left < 0 ? 0 : u_left ;  // 만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 적용
	}else if( key == 39 ){ // 오른쪽키 -> 이동 
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left ;
		userbox.style.backgroundImage = `url(img/캐릭터2_이동.png)` // 이동 모션 
		userbox.style.backgroundSize = `110%`;
	}else if( key == 65 ){ // a키 -> 공격 
		userbox.style.backgroundImage = `url(img/캐릭터3_공격.png)`// 공격 모션
		// * 
		alert('공격')
	}
	userbox.style.left = `${ u_left }px`	// * 키 입력후에 css : left 변경 
	// * 현재 좌표를 로그에 출력 
	logbox.innerHTML = `<div> 캐릭터 좌표 : ${ u_left }</div>`
} )
// 2. 문서 안에서 키 떼였을때 이벤트  keyup 
document.addEventListener( 'keyup' , (e)=>{ 
	userbox.style.backgroundImage = `url(img/캐릭터1.png)`
	userbox.style.backgroundSize = `90%`;
})

// 3. 몬스터 이동 난수[랜덤 -> 1초]
	// 특정 시간마다 함수 실행해주는 함수 : setInterval( ()=>{} , 밀리초(1000/1초) )

setInterval( mon_moving , 500 );

function mon_moving(){ 
	// 1. 난수 +-10
	let rand = parseInt( Math.random()*50+1); // 1~50	// 이동거리
	let rand2 = parseInt( Math.random()*2 ); // 0 또는 1  // 이동방향
	if( rand2 == 1 ) m_left += rand
	else m_left -= rand
	// 2. 게임 화면 고정 
	if( m_left < 0 ) m_left = 0;
	if( m_left > 910 ) m_left = 910;
	// 3. 
	monbox.style.left = `${ m_left }px`
	// * 현재 좌표를 로그에 출력 
	logbox2.innerHTML = `<div> 몹 좌표 : ${ m_left }</div>`
}

/*
	함수 형태 
		1.일반함수 : function 함수명(){ }
		2.익명함수 : function(){ }
		3.람다식함수: ( ) => { }
		4.변수함수 : let 변수명 = () => { }
	Math.random()
		Math.random() : 0~1 사이의 실수 
		Math.random()*10 : 0~10 사이의 실수
		 
		
*/












