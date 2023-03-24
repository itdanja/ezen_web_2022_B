

/*
$.ajax({
	url : "/jspweb/product/info",
	method : "get" ,
	success : (r)=>{
		console.log(r)
	}
})

// 		VS

$.get( 
	"/jspweb/product/info"  ,
	 (r)=>{ console.log(r) } );
*/
let productList = null;
function produclistprint(  ){
    let html = '<h3>제품목록페이지</h3>';
    productList.forEach( (p) => {
		html += `<div> 
					<span> ${ p.pname } </span>
					<span> ${ p.pcomment }  </span>
					<span> ${ p.pprice }  </span>
					<span> ${ p.pstate }  </span>
					<span> ${ p.pview }  </span>
					<span> ${ p.pdate }  </span>
				</div>`
	});
	document.querySelector('.produclistbox').innerHTML = html;
}

var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표 
    level : 6 // 지도의 확대 레벨 
});
    
// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 7 // 클러스터 할 최소 지도 레벨 
});
// $.ajax( { url:"/jspweb/product/info" , success : (r) => { } );

$.get("/jspweb/product/info", (r) => {	console.log(r);
    // ------------ 사이드바 제품목록 --------------------------------
    productList = r;	// 제품목록 결과를 전역변수 담아주기 
	produclistprint(  );
   //------------ 마커 작업 ----------------------
    var markers = r.map( ( p ) => {		console.log( p )
		// 마커에 추가코드 작성하기 위해 변수화
        let marker = new kakao.maps.Marker({	
            position : new kakao.maps.LatLng( p.plat, p.plng)
        });
        // 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', function() {
		       let html = `<button onclick="produclistprint()"> <== </button> <h3>제품상세페이지</h3>`;
		      html += `<div> 
					<div> ${ p.pname } </div>
					<div> ${ p.pcomment }  </div>
					<div> ${ p.pprice }  </div>
					<div> ${ p.pstate }  </div>
					<div> ${ p.pview }  </div>
					<div> ${ p.pdate }  </div>
					<div> <button type="button"> ♡ </button> </div>
				</div>`
			document.querySelector('.produclistbox').innerHTML = html;
		});
        return marker;
    });

    // 클러스터러에 마커들을 추가합니다
    clusterer.addMarkers(markers);
    //-------------------------------------------------
});
	 
	 
	 
        // $(r).map( (인덱스,반복객체명) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // r.map( (반복객체명,인덱스) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // vs 
        // .forEach( (반복객체명,인덱스) => { } ) 	실행문에서 return X
	 
	 
	 
	 
	 
	 
	 
	 
	 