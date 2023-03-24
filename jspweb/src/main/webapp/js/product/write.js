
// 전역변수 
let plat = 0;
let plng = 0;

let filebox = []

// 제품 등록 함수 
function onwrite(){
	
	// 1. 폼 객체  
	let writeForm = document.querySelectorAll('.writeForm')[0];
	// 2. 폼 데이터 객체 선언 
	let writeFormData = new FormData( writeForm );
	// 3. 좌표[위도/경도]추가 
	// 폼 데이터 객체 에 필드 추가 
	writeFormData.set( "plat" , plat );
	writeFormData.set( "plng" , plng );
	
	if( plat == 0 || plng == 0 ){ alert('위치 선택후 등록해주세요.'); return; }
	
	$.ajax({
		url : "/jspweb/product/info" ,
		method : "post",
		data : writeFormData , 
		contentType : false ,
		processData : false , 
		success : (r)=>{
			if(r=="true"){
				alert('등록성공'); location.href="/jspweb/index.jsp"
			}else{ alert('등록실패'); }
		}
	})
	
	
}

// --------------------------  카카오 지도를 표시할 div 객체 ----------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표.
        level: 6 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// ---------------------------- 지도를 클릭한 위치에 표출할 마커입니다 ----------------------
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// ----------------------------- 지도에 클릭 이벤트를 등록합니다 ---------------------------------
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    var latlng = mouseEvent.latLng;   // 클릭한 위도, 경도 정보를 가져옵니다 
    marker.setPosition(latlng); // 마커 위치를 클릭한 위치로 옮깁니다
    plat = latlng.getLat();		 console.log(   "위도: "+latlng.getLat() )
    plng = latlng.getLng();		 console.log(   "경도: "+latlng.getLng() )
});



