<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	<!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class="searchbox">
		검색창
	</div>
	
	<div class="contentbox" >
		<!-- 지도 -->
		<div id="map" style="width:75%;height:100%;"></div>
		<!-- 사이드바 -->
		<div class="produclistbox">
		

	
		</div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b7c0acb1395b016fc6b2661dad73840f&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>

</body>
</html>

<!-- 

			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/default.jpg">
				</div>
				<div class="pcontentbox">
					<div class="pdate"> 2023-03-28 </div>
					<div class="pname"> LG 노트북 팝니다. </div>
					<div class="pprice"> 3,000 원 </div>
					<div class="petc">
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2
					</div>
				</div>
			</div>
	


 -->
