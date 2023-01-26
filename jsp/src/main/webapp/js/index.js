
let productList = [
	{ img : 'p1.gif' , title : '소느아 숄카라 퍼장식 롱 패딩 코트' , size : '[ M , L ]' , price : 189000 , discount : 0.23 , like : 21 , review : 10 } , 
	{ img : 'p2.gif' , title : '포드 언발 카라 스트라이프 셔츠' , size : '[ FREE ]' , price : 200000 , discount : 0.1 , like : 0 , review : 1 } , 
	{ img : 'p3.gif' , title : '로라 오프 숄더 셔츠' , size : '[ M , L ]' , price : 1563300 , discount : 0.9 , like : 45 , review : 4 } , 
	{ img : 'p4.gif' , title : '라움 리본 포켓 피치기모 여리핏 셔츠 원피스' , size : '[ FREE ]' , price : 8000 , discount : 0.5 , like : 10 , review : 20 } , 
	{ img : 'p5.gif' , title : '모앤 꽈배기 V넥 루즈핏 가디건' , size : '[ M , L ]' , price : 123500 , discount : 0.4 , like : 8 , review : 412 } , 
	{ img : 'p6.gif' , title : '블린 랩 버튼 하프밴딩 피치기모 카라 원피스' , size : '[ FREE ]' , price : 789000 , discount : 0.2 , like : 32 , review : 780 } 
]

product_print();
// 1. 제품 출력 // 1. js 열릴떄 
function product_print(){
	let html = ``
	productList.forEach( ( o , i ) => { 
		html += `
			<div class="item"> 					<!-- 제품 1개 -->
				<img src="img/${ o.img }"><!-- 제품이미지 -->
				<div class="item_info"><!-- 제품정보 구역 -->
					<div class="item_title">${ o.title }</div>	<!-- 제품명 -->
					<div class="item_size">${ o.size }</div>	<!-- 제품사이즈 -->
					<div class="item_price">${ o.price.toLocaleString() } 원</div>	<!-- 원가 -->
					<div>
						<span class="item_sale">${ ( o.price*o.discount).toLocaleString() } 원</span>	<!-- 판매가 -->
						<span class="item_discount">${ o.discount*100 }%</span>	<!-- 할인율 -->
					</div>
				</div>
				<div class="item_bottom">	<!-- 제품정보 하단 구역  -->
					<div>
						<span class="badge rounded-pill text-bg-warning">주문폭주</span> <!-- 배지 -->
						<span class="badge rounded-pill text-bg-danger">1+1</span>
					</div>
					<div class="item_review"> 찜 ${ o.like } 리뷰수 ${ o.review }</div>	
				</div>
			</div>`
	} )
	document.querySelector('.itembox').innerHTML = html;
}