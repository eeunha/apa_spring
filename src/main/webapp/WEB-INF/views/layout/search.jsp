<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<tiles:insertAttribute name="asset"/>
<style>
	#hospital-list{
		width: 100%;
	}
	.bookmark-icon-link{
		background: #fff;
		color: #000000;
		border: 1px solid #fff; 
	}
	.rezuser-choice-hide{
		display:none;
	}
	.oneclickhide{
		display:none;
	}
	.type-button{
		border: 1px solid #edf0f7;
		border-radius: 50px;
		background-color: #edf0f7;
		width: 50%;
		height: 20%;
		margin: 10px 0;
	}
	.reservation-modal {
	  width: 100%;
	  height: 100%;
	  padding: 20px 0;
	  transition: all 600ms cubic-bezier(0.86, 0, 0.07, 1);
	  background-color : rgba(255,255,255);
	  top: 100%;
	  position: fixed;
	  left: 0;
	  text-align: center;
	  z-index: 200;
	}
	.container.modal-open .reservation-modal {
	  top: 60%;
	  z-index: 999;
	}
	.js-close-modal {
		opacity: 0;
	}
	.hide-tag{
		display: none;
	}
	.dept-hide-tag{
		display: none;
	}
	#tagList{
		display: grid;
		grid-template-columns: repeat(8, 1fr);
	}
	#deptList{
		display: grid;
		grid-template-columns: repeat(8, 1fr);
	}
	.hospital-info-list{
		border: 1px solid #000000;
	}
	.tag{
		padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);
		background-color: #fff;
		color: #000;
		border: 1px solid #000000;
		border-radius: 3px;
		margin: 1px 3px;
	}
	.hospital-name-dept{
		display: flex;
	}
	.hospital-info-dept{
		background-color: #fff;
		color: #000;
		border: 1px solid #000000;
	}
	.dept-tag{
		padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);
		background-color: #fff;
		color: #000;
		border: 1px solid #000000;
		border-radius: 3px;
		margin: 1px 3px;
	}
	.hospital-info-grid {
		margin-top: 10px;
		display: flex;
	}
	.hospital-info-flex {
		display: flex;
	    align-items: flex-end;
	    justify-content: space-between;
	}
	.box-content{
		border: 1px solid #5bc1ac;
		border-radius: 3px;
		margin: 1px 3px;
		padding: 1px 3px;
		text-align: center;
	}
	.dept-box-content{
		border: 1px solid #fff;
	}
	.box-content-color{
		background-color: #5bc1ac;
		color: #fff;
	}
	.docter-images {
		width: 150px;
		height: 150px;
		border-radius: 3px;
		opacity: 0.6;
	}
	.docter-images:hover {
		opacity: 1;
	}
	.review-grid{
		display: flex;
		justify-content: space-between;
	}
	.reservation-button {
		color: #000000;
		background-color: #fff;
		text-align:center;
		font-size: 30px;
		border-radius: 40px;
		padding: 10px 25px;
		display: inline-block;
		transition: all .4s ease;
		cursor: pointer;
		border: 1px;
		position: fixed;
		bottom: 10px;
		height: 4rem;
		width: 700px;
		font-weight: bold;
		box-shadow: 1px 1px 5px #000000;
		margin: 0 auto;
		left: 0;
		right: 0;
		z-index: 888;
	}
	.select-opacity {
		opacity: 0.4;
	}
	.reservation-modal-button-list {
		text-align:center;
		left: 0;
		right: 0;
		position: fixed;
		bottom: 10px;
	}
	.reservation-modal-button {
		text-align:center;
		font-size: 30px;
		border-radius: 40px;
		padding: 10px 25px;
		display: inline-block;
		transition: all .4s ease;
		cursor: pointer;
		border: 1px;
		height: 4rem;
		width: 330px;
		margin: 0 20px;
		font-weight: bold;
		box-shadow: 2px 2px 5px #000000;
		background-color: #ffffff;
	}
	.review-progress-bar {
	    width: 50%;
	    height: 30px;
	    background-color: #dedede;
	    font-weight: 600;
	    font-size: .8rem;
	    border: 1px solid #ffffff;
	    border-radius: 50px;
	    display: inherit;
	}
	.review-progress-negative{
		padding-top: 5px;
		text-align: center;
	}
	.review-progress-bar .review-progress {
	    width: 50%;
	    height: 30px;
	    padding: 0;
		padding-top: 5px;
	    text-align: center;
	    background-color: #5bc1ac;
	    color: #111;
	    border: 1px solid #ffffff;
	    border-radius: 50px;
	}
	.clicked {
		background-color: #5bc1ac;
		color: #fff;
		border: #5bc1ac;
	}
	.more-button {
		border: 0;
		background-color: #fff;
		font-size: 18px;
	}
	.more-button-div {
		text-align: center;
	}
	.hospital-info-list {
		border: 1px solid #c5c5c5;
		border-radius: 10px;
		padding: 10px 20px;
		margin: 3px 5px;	
	}
	.hospital-info-info{
		margin: 0;
	}
	#doctor-choice{
		display: flex;
		justify-content: space-evenly;
		text-align: center;
		margin: 0 100px;
	}

</style>

</head>
<body id="section_1">

	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>
	
	<tiles:insertAttribute name="footer"/>
	
	<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center: new kakao.maps.LatLng(37.49934, 127.0333), // 지도의 중심좌표
					level: 3 // 지도의 확대 레벨
				};
		
			// 지도를 생성합니다    2
			var map = new kakao.maps.Map(mapContainer, mapOption); 
	
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
	
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('${dto.hospitaladdress}', function(result, status) {
	
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
	
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
	
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			}); 
        </script>
        
        

</body>
</html>