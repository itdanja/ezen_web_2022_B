/*
	// 1. 버거객체 
	let burger = {
		name : ,			// 버거이름
		price : ,			// 버거가격
		img : ,				// 버거 이미지 
		category			// 버거 카테고리 
	}
	
	// 2. 주문객체 
	let order = { 
			no : ,
			itmes :  ,			// 카트배열 ---> 새로운배열 
			time :  ,			// new Date() : 현재 날짜/시간 호출   
			state :  ,			// true : 일단 주문	// false : 주문완료  
			complete :  ,		// 아직 주문 완료 되기전 
			price : 			// cartlist 배열내 버거객체들의 총금액 합계 
	}

*/

/* ------------ 공통데이터 : 모든 함수에서 공통으로 사용 할 예정 : 전역변수 [ JS 열릴때 선언 1번 ] ---------------------- */
// 등록된 카테고리 '문자열' 목록/배열 
let categoryList = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']
// 등록된 '버거객체' 목록/배열
let burgerList = [ 
	{ name : '기네스콰트로치즈와퍼' , price : 9500 , img : '기네스콰트로치즈와퍼.png' , category : '프리미엄' } ,
	{ name : '몬스터X' , price : 8000 , img : '몬스터X.png' , category : '프리미엄' } ,
	{ name : '치킨킹팩1' , price : 13000 , img : '치킨킹팩1.png' , category : '스페셜' } 
]
// 카트 등록된 '버거객체' 목록/배열 
let cartList = [  ] // 카트 목록
// '주문객체' 목록/배열 
let orderList = [  ] // 주문 목록
/* ------------------  공통 - DB end  -------------------------------- */

/* ------------------ js 열렸을때 1번 실행되는 함수들 ----------------------*/
category_print();		// 카테고리 출력 하는 함수 호출
categoey_select( 0 ); 	// 카테고리 선택시 css 변경/카테고리별 제품출력 함수 호출 / 기본값 : 프리미엄
/* ---------------------------------------------------------------------*/


// 1. 카테고리 출력하는 함수 	// [ 1.js열렸을때]
function category_print(){
	// 1.HTML 구성
	let html = `<ul>`
	//*
	for( let i = 0 ; i< categoryList.length ; i++ ){
		html += `<li 
					class="categoryli" 
					onclick="categoey_select( ${i} )"
					> ${ categoryList[i] } </li>`
	} // for end 
	html+= `</ul>`
	// 2 해당 마크업에 HTML 출력 
	document.querySelector('.categorybox').innerHTML = html	
} // f e 

// 2. 카테고리 선택 함수 
function categoey_select( i ){ // i : 선택된 카테고리 인덱스
	// 1. 모든 li 가져와서 배열 저장 
	let categoryli = document.querySelectorAll( ".categoryli")
	// 2. 모든 li 배열 반복문 
	for( let j = 0 ; j<categoryli.length ; j++ ){
		if( j == i ){ // 만약에 li배열에서 내가 선택횐 li의 인덱스와 같으면
			categoryli[j].classList.add( 'categoryselect' ) ; // 해당 마크업의 class 식별자 추가 
		}else{ // 선택되지 않은 li
			categoryli[j].classList.remove( 'categoryselect'  );// 해당 마크업의 class 식별자 제거 
		}
	}
	// 3. 제품목록 출력 렌더링 [ 화면 업데이트 ]
	product_print( i )  // i : 선택된 카테고리 인덱스를 product_print 함수로 전달 [ 함수 호출 ]
}
// 3. 제품출력 함수 // [ 1.js열렸을때[0:프리미엄] 2.카테고리 바뀌었때 ]
function product_print( selectcategoryindex ){  // categoey_select 함수로부터 받음 i -> 'selectcategoryindex'라는 이름 으로 받음 
	// 1. 기본 html 구성
	let html = '';
	// *
	for( let i = 0 ; i<burgerList.length ; i++ ){
		// i는 0번째 인덱스부터 마지막인덱스까지 버거 객체 가져온다.
		if( burgerList[i].category == categoryList[selectcategoryindex] ){
			// i번째 버거객체의 카테고리와 선택된 카테고리와 같으면 
			html += `<div onclick="cardadd( ${i} )" class="product">
						<img src="img/${ burgerList[i].img }" width="100%" />
						<div class="productinfo">
							<div class="ptitle"> ${ burgerList[i].name } </div>
							<div class="pprice"> ${ burgerList[i].price.toLocaleString() } 원 </div>
						</div>
					</div>`
		}
	}
	// 2. 구성된 html를 마크업 대입
	document.querySelector('.productbox').innerHTML = html;
}
// 4. 선택한 제품을 카트에 담기 
function cardadd( i ){ // f s 
	cartList.push( burgerList[i] ) // 1. 선택한 i번째 버거의 객체를 cartlist에 추가 
	cart_print();  // 카트내 제품 화면 렌더링[새로고침]
} // f e 

// 5. 주문 취소 버튼 
function cancel(){ // 모든 취소 이므로 i번째 인덱스 필요없음 
	alert('주문 취소합니다.'); cartList.splice(0); // 개수 생략시 모두 삭제 
	cart_print(); // 카트내 제품 화면 렌더링[새로고침]
} 

// 6. 주문 하기 버튼 
function order(){
	alert('주문 합니다.');
	// 1. 고유 한 주문번호 만들기  [ // 마지막인덱스 : 배열명.length-1 ]
	let no = 0;
	if( orderList.length == 0 ){ no = 1;} // 1. 만약에 길이가 0 이면 [ 주문 하나도 없으면 주문번호 1 ]
	else{ no = orderList[ orderList.length-1 ].no+1 } // 2. 아니면 마지막인덱스 주문객체의 주문번호+1 를 다운 주문번호 사용 
	
	// 2. 카트배열[전역변수] -> 새로운배열 [ 주문객체에 카트배열 대입시 카트배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 동일하기 때문에 ]
	let map배열 = cartList.map( (o) => { return o; } ) // map함수에서 trun 객체를 하나씩 새로운배열 대입 

	// 3. 총가격 만들기 
	let total = 0;
	for( let i = 0 ; i< map배열.length ; i++ ){ total += map배열[i].price }
	
	// 1. 주문
		// 1. order 객체 만들기 
		let order = { 
			no :  no ,				// 고유한 주문번호 [ 인덱스사용X ]
			itmes : map배열 ,			// 카트배열 ---> 새로운배열 
			time :  new Date() ,	// new Date() : 현재 날짜/시간 호출   
			state : true ,			// true : 일단 주문	// false : 주문완료  
			complete : 0 ,			// 아직 주문 완료 되기전 
			price : total			// cartlist 배열내 버거객체들의 총금액 합계 
		}
		// 2. order 객체 배열에 저장 
		orderList.push( order  ); console.log(  orderList )
	// 2. 주문완료 후 
	cartList.splice(0) // 전역변수내 초기화 // 그전에 안에 들어있는 데이터를 다른곳으로 옮기자 -> 주석 2번 코드 
	cart_print();
	order_print(); // (관리자)주문현황 테이블 렌더링
}

// 7. 카트내 버거 출력 [ 1. 제품 클릭할때마다 , 2.취소/주문 ]
function cart_print(){
	// 2. 버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length
	// 3. 버거 총 금액 
	let total = 0;
	for( let j = 0 ; j<cartList.length ; j++ ){ total += cartList[j].price } 
	document.querySelector('.ptotal').innerHTML = total.toLocaleString();
	// 4.
	let html = ''	// 1. 기본 html 구성 
	for( let j = 0 ; j<cartList.length ; j++ ){
		html += `<div class="item">
					<div class="ititle"> ${ cartList[j].name } </div>
					<div class="iprice"> ${ cartList[j].price.toLocaleString() }원</div>
				</div>`
	}
	document.querySelector('.cartbottom').innerHTML = html; // 2. 구성된 html 마크업에 대입 
}

/*
	for( let 반복변수 of 배열명 ) {  실행문; }		: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
	
	배열명.forEach( (반복변수) -> { 실행문; }  )		: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
	
	배열명.map( (반복변수) -> { 실행문; retrun 값; } )	: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
						* retrun 값을 새로운 배열 반환

	- 기존 배열 메모리를 새로운 배열메모리 할당 방법
		1. 
			let 새로운배열  = cartList.map( (o) => {console.log(o); return o; } )

		2. 
			let 새로운배열 = [ ]
			for( let i = 0 ; i<cartList.length ; i++ ){ 새로운배열.push( cartList[i] ) }

*/


/* ------------------------------------------------------ */
// 1. 버거 등록 
function onAdd(){ // f s
	console.log( 'onAdd 호출 ')
	// 1. 객체[ 여러개의 메모리를 하나의 메모리 ] 
	let burger = {
		 name : document.querySelector('.bname').value ,
		 category : document.querySelector('.bcategory').value ,
		 price : parseInt( document.querySelector('.bprice').value ) ,
		 img : document.querySelector('.bimg').value
	}; console.log( burger )
	// 2. 유효성검사 [ 배열명.includes( 데이터 ) : 해당 데이터가 배열내 포함 여부 / 존재하면 true / fasle ] 
		// ! : 부정 not  / true -> false / false -> true 
		// 1. 
	if( !categoryList.includes( burger.category ) ) { alert('등록 불가능한 카테고리 입니다.'); return;}
		// 2. // 문자이면 true / 숫자이면 false
	if( isNaN( burger.price) ) {  alert('가격은 숫자만 가능합니다.'); return; }
	// 2. 배열 저장 [ 여러개의 메모리를 저장 : 동일한 데이터유형 끼리 / 서로 다른 데이터유형 힘듬 ]
		// let 배열 = [ '김현수' , 10 , '여' , '유재석' , 20 , '남' ]
		// let 배열 = [ 사람객체1 , 사람객체2 ]
	burgerList.push( burger ); alert('버거등록완료');  console.log( burgerList );
	// 3. 키오스크 쪽 프론트 새로고침
	categoey_select( 0 ); print();
}// f e 

print();
// 2. 모든 버거 출력  // 1.js열렸을때 //2.버거 등록될때 // 3. 버거 삭제시 // 4. 버거 수정시
function print(){
	// 1. 기본 html 구성
	let html = `<tr> <th width="5%"> 제품번호 </th> 	<th width="10%"> 이미지 </th> 
					<th width="30%"> 버거이름</th> 	<th width="20%"> 카테고리 </th>
					<th width="15%"> 가격 </th>		<th width="20%"> 비고 </th>
				</tr>`
	// 2. 내용 html 구성   // o : i번째 객체   i : 인덱스 
	burgerList.forEach( ( o , i ) => { 
		html +=`<tr> <td> ${ i+1 } </td>
					<td> <img src="img/${ o.img }" width="100%"> </td>
					<td> ${ o.name } </td>
					<td> ${ o.category } </td>
					<td> ${ o.price.toLocaleString() } </td>
					<td>  
						<button onclick="onDelete( ${ i } )"> 삭제 </button>
						<button onclick="onUpdate( ${ i } )"> 수정 </button>
					</td>
				</tr>`
	})
	// 3. 구성 html 마크업 대입
	document.querySelector('.burgertable').innerHTML = html;
} // f e 
// 3. 버거 삭제 
function onDelete( i ){ console.log( i +'번 버거 삭제 ')
	burgerList.splice( i , 1 ); alert('버거가 삭제 되었습니다'); // 삭제 
	print();  categoey_select( 0 );  // 관리자쪽   // 고객쪽
}
// 4. 버거 수정 
function onUpdate( i ){ 	console.log( i +'번 버거 수정 ')
	let newprice = parseInt( prompt('새로운 금액 : ') )
	burgerList[i].price = newprice ; alert('버거 금액 변경 되었습니다.');
	print();  categoey_select( 0 );  // 관리자쪽   // 고객쪽
}

order_print();
// 5. 주문 현황 출력 
function order_print(){ // 1. js열렸을때 // 2. 주문[주문하기버튼-6] 들어올때마다 // 3. 수정[주문상태 변경]
	let html = `<tr>
					<th width="10%"> 주문번호 </th> <th width="30%"> 버거이름 </th>
					<th width="10%"> 상태 </th> 	<th width="30%"> 요청일/완료일</th> 
					<th width="20%"> 비고 </th>
				<tr>`
	orderList.forEach( ( order ,i) => { // 주문리스트 회전/반복
		order.itmes.forEach( ( burger , j ) => {	// 각 주문마다의 버거리스트 회전/반복 
			let time1 = order.time.getHours()+':'+order.time.getMinutes();
			html += `<tr>
						<th> ${ order.no } </th>
						<th> ${ burger.name } </th>
						<th> ${ order.state ? "주문요청" : "주문완료" } </th>
						<th> ${ time1 }</th>
						<th> 
							<button> 주문완료 </button>
						</th>
					<tr>`
		})
	})
	document.querySelector('.ordertable').innerHTML = html;
}

/*
	'숫자' 	: 문자	'10'	: 문자 
	
	* parseInt( 데이터 ) : 해당 데이터가 '숫자' 문자형 이면 ' ' 제거 숫자형 변환 아니면
	parseInt( '10' ) -> 10
	parseInt( 'a' ) -> NaN  [ 불가능 ]
	
	
	모든 조건을 검사 하고 여러개의 true 		
	if( 조건1 ){}
	if( 조건2 ){}
	if( 조건3 ){}
	
		vs								true인경우 return 사용하면 차이점 없음
		
	모든 조건을 검사 하고 하나의 true
	if( 조건1 ){}
	else if( 조건2 ){}
	else if( 조건3 ){}
	
	
	// 
	
	1. 배열명.forEach( ( 객체  ) => { } )
	1. 배열명.forEach( ( 객체 , i ) => { } )
	2. for( let i = 0 ; i<배열명.length ; i++ ){
		let 객체 = 배열명[i];
	}

*/





 
































