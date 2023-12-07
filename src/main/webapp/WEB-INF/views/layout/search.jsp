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
		border: 1px;
		position: fixed;
	    bottom: 10px;
	    height: 4rem;
	    width: 700px;
	    border-radius: 8px;
	   	font-weight: bold;
	   	font-size: 25px;
	   	box-shadow: 2px 2px 5px #000000;
	   	margin: 0 auto;
	   	left: 0;
	   	right: 0;
	   	z-index: 0;
	}
	
</style>
</head>
<body id="section_1">

	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>
	
	<tiles:insertAttribute name="footer"/>
	
	<script>
			var lists = [];
			var seqlist = [1,0,0,0,0,0,0,0];
			var count = 0;
			var onoff = false;
        	function selSystom(seq) {
        		var tag = document.getElementsByClassName("tag");
        		if (event.target.classList[1] === "clicked" || event.target.classList[2] === "clicked") {
        	          event.target.classList.remove("clicked");
        	          count--;
        	    } else {
        	    	if (count >= 8) {
	        	        	count = 0;
	        	        	lists[count].classList.remove("clicked");
        	    			lists[count] = event.target;
        	    			seqlist[count] = seq;
	        	        	lists[count].classList.add("clicked");
	        	        	onoff = true;
        	    	} else {
        	    		if (onoff) {          	    			
	        	        	lists[count].classList.remove("clicked");      	    			
	        	        	lists[count] = event.target;
        	    			seqlist[count] = seq;
		        	    	lists[count].classList.add("clicked");
        	    		} else {
        	    			lists[count] = event.target;
        	    			seqlist[count] = seq;
		        	    	lists[count].classList.add("clicked");
        	    		}
        	    	}
        	    }
    	    	load(seqlist);
        		count++;
			}
        	function load(seqlist) {
        		let obj = {
        				seq1 : seqlist[0],
    					seq2 : seqlist[1],
    					seq3 : seqlist[2],
    					seq4 : seqlist[3],
    					seq5 : seqlist[4],
    					seq6 : seqlist[5],
    					seq7 : seqlist[6],
    					seq8 : seqlist[7]	
        			};
        		$.ajax({
    				type: 'POST',
    				url: 'http://localhost:8090/apa/search/tagfind',
    				headers: {'Content-Type': 'application/json'},
    				data: JSON.stringify(obj),
    				dataType: 'json',
    				success: function(result) {
    					$('#hospital-list tbody').html('');
    					$(result).each((index, item) => {
    						let temp = `
    								<tr>
    									<td>
		    								<a href="/apa/search/view.do?seq=\${item.hospitalid}" >
		    								<div class="hospital-info-list">
			    								<h6>\${item.hospitalname}</h6>
			    				                <p>임시</p>
			    				                <p>\${item.hospitaladdress}</p>
						    				</a>
			    				                <div >		
				    								<a href="#">
				    				                	<div class="hospital-info-grid">
				    				                	`;
				    				                	if (item.face == 'y' || item.face == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">대면</p>
								    							`;
				    				                	}
				    				                	if (item.face == 'n' || item.face == 'N'){
				    				                		temp+=`
								    							<p class="box-content">대면</p>
								    							`;
				    				                	}
				    				                	if (item.unface == 'y' || item.unface == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">비대면</p>
								    							`;
				    				                	}
				    				                	if (item.unface == 'n' || item.unface == 'N'){
				    				                		temp+=`
								    							<p class="box-content">비대면</p>
								    							`;
				    				                	}
				    				                	if (item.housecall == 'y' || item.housecall == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">왕진</p>
								    							`;
				    				                	}
				    				                	if (item.housecall == 'n' || item.housecall == 'N'){
				    				                		temp+=`
								    							<p class="box-content">왕진</p>
								    							`;
				    				                	}
				    				                	if (item.ishealthcheck == 'y' || item.ishealthcheck == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">건강검진</p>
								    							`;
				    				                	}
				    				                	if (item.ishealthcheck == 'n' || item.ishealthcheck == 'N'){
				    				                		temp+=`
								    							<p class="box-content">건강검진</p>
								    							`;
				    				                	}
				    				                	if (item.vaccination == 'y' || item.vaccination == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">예방접종</p>
								    							`;
				    				                	}
				    				                	if (item.vaccination == 'n' || item.vaccination == 'N'){
				    				                		temp+=`
								    							<p class="box-content">예방접종</p>
								    							`;
				    				                	}
				    				                	if (item.ishospitalnightcare == 'y' || item.ishospitalnightcare == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">야간진료</p>
								    							`;
				    				                	}
				    				                	if (item.ishospitalnightcare == 'n' || item.ishospitalnightcare == 'N'){
				    				                		temp+=`
								    							<p class="box-content">야간진료</p>
								    							`;
				    				                	}
				    				                	if (item.ishospitalholiday == 'y' || item.ishospitalholiday == 'Y'){
				    				                		temp+=`
								    							<p class="box-content box-content-color">휴일진료</p>
								    							`;
				    				                	}
				    				                	if (item.ishospitalholiday == 'n' || item.ishospitalholiday == 'N'){
				    				                		temp+=`
								    							<p class="box-content">휴일진료</p>
								    							`;
				    				                	}
						    							temp+=`
						    							</div>
						    						</a>
						    						`;
						    						if ('${lv}' == '1'){
						    						temp += `
						    							<a href="#">
								    							<button class=""> 예약하기 </button>
						    							</a>	
						    							`;
						    						} else if ('${lv}' == '' || '${lv}' == null){
						    						temp += `
						    							<a href="#">
								    							<button class=""> 예약하기 </button>
						    							</a>
						    							`;
						    						}
						    							temp+= `
			    				                </div>
			    							</div>
    									</td>
    								</tr>
    								`;
						    	    $('#hospital-list tbody').append(temp);							
    					});
    				},
    				error: function(a,b,c) {
    					console.log(a,b,c);
    				}
    			});
			}
        	
        	$(".taglist-button").click(function() {
    			if ($(".hide-tag").is(":visible")){
    				$(".hide-tag").slideUp();
    				$(".taglist-button").val("증상 더보기");    				
    			} else {
    				$(".hide-tag").slideDown();
    				$(".taglist-button").val("증상 숨기기");    				
    				$(".tag").css('display','inline');
    			}
    		});
        	
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center: new kakao.maps.LatLng(37.49934, 127.0333), // 지도의 중심좌표
					level: 3 // 지도의 확대 레벨
				};
		
			// 지도를 생성합니다    
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