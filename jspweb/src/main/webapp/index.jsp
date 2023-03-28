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

			<div class="chatbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/product/pimg/default.jpg" class="hpimg">
						<span class="pname"> 커피포트 팝니다. </span>
					</div>
					<div>
						<button onclick="produclistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				<div class="chatcontent">
					<div class="sendbox">구매 가능할까요? </div>
					<div class="receivebox"> 네 구매 가능 합니다.</div>
				</div>
				
				<div class="chatbtn">
					<textarea rows="" cols=""></textarea>
					<button type="button">전송</button>
				</div>
			</div>


 -->


<!-- 

		
			<div class="pviewbox">
				
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/member/pimg/default.webp" class="hpimg">
						<span class="mid"> qweqweqwe </span>
					</div>
					<div>
						<button class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/jspweb/product/pimg/default.jpg" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/default.jpg" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/default.jpg" class="d-block w-100" alt="...">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				
				
				<div class="pdate"> 2023-03-28 </div>
				<div class="pname"> 커피포트 팝니다. </div>
				<div class="pcomment"> 내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물 </div>
				<div class="pstate"> <span class="pbadge">판매중</span> </div>
				<div class="pprice"> 3,000원 </div>
				<div class="petc"> 
					<i class="far fa-eye"></i> 30
					<i class="far fa-thumbs-up"></i> 5
					<i class="far fa-comment-dots"></i> 2
				 </div>
				<div class="pviewbtnbox">
					<button type="button"> <i class="far fa-heart"></i> </button>
					<button type="button"> 채팅 </button>
				</div>
			</div>


 -->

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
