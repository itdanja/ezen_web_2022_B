<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">	<!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height: 100%">
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div 
		style="position: fixed; left: 10px; top: 40%; z-index : 100;
			width: 200px; height: 200px; background-color: white; ">
		검색창
	</div>
	
	<div style="display: flex; width: 100%; height: 80%">
		<!-- 지도 -->
		<div id="map" style="width:80%;height:100%;"></div>
		<!-- 사이드바 -->
		<div class="produclistbox" style="width: 20%"></div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b7c0acb1395b016fc6b2661dad73840f&libraries=clusterer"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>

</body>
</html>
