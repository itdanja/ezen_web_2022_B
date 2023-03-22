<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%@include file = "/header.jsp" %>	<!-- modal.css , moodal.js 포함 -->

		
		<!-- 모달 HTML -->
		<div class="modal_wrap">
			<div class="modal_box">
				<h3 class="modal_title">
					<!-- 제목이 들어가는 자리  -->
				</h3>
				<div class="modal_content">
					<!-- 내용이 들어가는 자리  -->
				</div>
				<div class="modal_btns">
					<button class="modal_check" 	type="button">확인</button>
					<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
				</div>
			</div>
		</div>
		

	<div class="container">
		<div id="clickLatlng"></div> <!-- 클릭한 위치의 좌표 찾기 -->
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:700px;"></div>
	</div>
	
	<!-- 카카오지도 에 필요한 클래스/메소드 가지고 있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b7c0acb1395b016fc6b2661dad73840f&libraries=clusterer"></script>
	
	
	
	
	<script src="/jspweb/js/api/api2.js" type="text/javascript">	</script>
	

</body>
</html>