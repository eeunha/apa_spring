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
	.tag{
		border: 1px solid #gray;
		border-radius: 2px;
	}
</style>
</head>
<body id="section_1">

	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>
	
	<tiles:insertAttribute name="footer"/>
	
	<script>
			var lists = [];
			var seqlist = [0,0,0,0,0,0,0,0];
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
        		$.ajax({
    				type: 'GET',
    				url: '/apa/search/tagfind.do',
    				data: {
    					seq1 : seqlist[0],
    					seq2 : seqlist[1],
    					seq3 : seqlist[2],
    					seq4 : seqlist[3],
    					seq5 : seqlist[4],
    					seq6 : seqlist[5],
    					seq7 : seqlist[6],
    					seq8 : seqlist[7]
    				},
    				dataType: 'json',
    				success: function(result) {
    					$('#hospital-list tbody').html('');
    					$(result).each((index, item) => {
    						let temp = `
    								<tr>
    									<td>
		    								<a href="/apa/find/view.do?id=\${item.id}">
		    								<div class="hospital-info">
			    								<h6 class="collapse-header">\${item.name}</h6>
			    				                <p class="info-text">\${item.deptname}</p>
			    				                <p class="info-text">\${item.address}</p>
						    				</a>
			    				                <div class="hospital-info-contentlist">		
				    								<a href="/apa/find/view.do?id=\${item.id}">
				    				                	<div>
				    				                	`;
				    				                	if (item.face == 'y' || item.face == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">대면</p>
								    							`;
				    				                	}
				    				                	if (item.face == 'n' || item.face == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">대면</p>
								    							`;
				    				                	}
				    				                	if (item.unface == 'y' || item.unface == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">비대면</p>
								    							`;
				    				                	}
				    				                	if (item.unface == 'n' || item.unface == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">비대면</p>
								    							`;
				    				                	}
				    				                	if (item.call == 'y' || item.call == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">왕진</p>
								    							`;
				    				                	}
				    				                	if (item.call == 'n' || item.call == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">왕진</p>
								    							`;
				    				                	}
				    				                	if (item.check == 'y' || item.check == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">건강검진</p>
								    							`;
				    				                	}
				    				                	if (item.check == 'n' || item.check == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">건강검진</p>
								    							`;
				    				                	}
				    				                	if (item.vaccin == 'y' || item.vaccin == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">예방접종</p>
								    							`;
				    				                	}
				    				                	if (item.vaccin == 'n' || item.vaccin == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">예방접종</p>
								    							`;
				    				                	}
				    				                	if (item.night == 'y' || item.night == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">야간진료</p>
								    							`;
				    				                	}
				    				                	if (item.night == 'n' || item.night == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">야간진료</p>
								    							`;
				    				                	}
				    				                	if (item.holiday == 'y' || item.holiday == 'Y'){
				    				                		temp+=`
								    							<p class="hospital-info-content hospital-info-content-color">휴일진료</p>
								    							`;
				    				                	}
				    				                	if (item.holiday == 'n' || item.holiday == 'N'){
				    				                		temp+=`
								    							<p class="hospital-info-content">휴일진료</p>
								    							`;
				    				                	}
						    							temp+=`
						    							</div>
						    						</a>
						    						`;
						    						if ('${lv}' == '1'){
						    						temp += `
						    							<a href="/apa/reservation/select.do?id=\${item.id}">
								    							<button class="reservation-button"> 예약하기 </button>
						    							</a>	
						    							`;
						    						} else if ('${lv}' == '' || '${lv}' == null){
						    						temp += `
						    							<a href="/apa/user/login.do">
								    							<button class="reservation-button"> 예약하기 </button>
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
        </script>

</body>
</html>