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

/* 위로 테스트 */
	.reservation-modal {
	  background: #fff;
	  width: 100%;
	  height: 100%;
	  margin: 0;
	  padding: 0;
	  transition: all 600ms cubic-bezier(0.86, 0, 0.07, 1);
	  top: 100%;
	  position: fixed;
	  left: 0;
	  text-align: left;
	}
	.container.modal-open .reservation-modal {
	  top: 50%;
	  z-index: 999;
	}
	.js-close-modal {
		opacity: 0;
	}
	.hide-tag{
		display: none;
	}
	#tagList{
		display: grid;
		grid-template-columns: repeat(8, 1fr);
	}
	.hospital-info-list{
		border: 1px solid #000000;
	}
	.tag{
		border: 1px solid #000000;
		border-radius: 3px;
		margin: 1px 3px;
	}
	.hospital-info-grid {
		display: flex;
	}
	.box-content{
		border: 1px solid #000000;
		border-radius: 3px;
		margin: 1px 3px;
		padding: 1px 3px;
		text-align: center;
	}
	.box-content-color{
		background-color: #5bc1ac;
	}
	.docter-images {
		width: 150px;
		height: 150px;
		border-radius: 50%;
	}
	.review-grid{
		display: flex;
		justify-content: space-between;
	}
	.reservation-button {
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
		box-shadow: 2px 2px 5px #000000;
		margin: 0 auto;
		left: 0;
		right: 0;
		z-index: 888;
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
		width: 350px;
		font-weight: bold;
		box-shadow: 2px 2px 5px #000000;
		background-color: #ffffff;
	}
	.review-progress-bar {
	    width: 100%;
	    height: 30px;
	    background-color: #dedede;
	    font-weight: 600;
	    font-size: .8rem;
	}
	
	.review-progress-bar .review-progress {
	    width: 50%;
	    height: 30px;
	    padding: 0;
	    text-align: center;
	    background-color: #4F98FF;
	    color: #111;
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