<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main>
	<div class="maindiv">
		<div id="tagList">
			<c:forEach items="${symtomlist}" var="dto">
				<c:if test="${dto.selfsymtomseq+0 >= 25}">
					<div id="tag${dto.selfsymtomseq}" class="tag hide-tag"
						onclick="selSystom(${dto.selfsymtomseq})">${dto.selfsymtomname}</div>
				</c:if>
				<c:if test="${dto.selfsymtomseq+0 <= 24}">
					<div id="tag${dto.selfsymtomseq}" class="tag"
						onclick="selSystom(${dto.selfsymtomseq})">${dto.selfsymtomname}</div>
				</c:if>
			</c:forEach>
		</div>
		<div>
			<input type="button" class="taglist-button" value="증상 더보기">
		</div>
		<hr>
		<table id="hospital-list">
			<tbody>
				<c:forEach items="${hosdto}" var="hosdto">
					<tr>
						<td>
							<a href="/apa/find/view.do?id=${hosdto.id}">
								<div class="hospital-info">
									<h6 class="collapse-header">${hosdto.name}</h6>
									<p class="info-text">${hosdto.deptname}</p>
									<p class="info-text">${hosdto.address}</p>
								</div>
							</a>
							<div class="hospital-info-contentlist">
								<a href="/apa/find/view.do?id=${hosdto.id}">
									<div>
										<c:if test="${hosdto.face == 'y' or hosdto.face == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">대면</p>
										</c:if>
										<c:if test="${hosdto.face == 'n' or hosdto.face == 'N'}">
											<p class="hospital-info-content">대면</p>
										</c:if>
										<c:if test="${hosdto.unface == 'y' or hosdto.unface == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">비대면</p>
										</c:if>
										<c:if test="${hosdto.unface == 'n' or hosdto.unface == 'N'}">
											<p class="hospital-info-content">비대면</p>
										</c:if>
										<c:if test="${hosdto.call == 'y' or hosdto.call == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">왕진</p>
										</c:if>
										<c:if test="${hosdto.call == 'n' or hosdto.call == 'N'}">
											<p class="hospital-info-content">왕진</p>
										</c:if>
										<c:if test="${hosdto.check == 'y' or hosdto.check == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">건강검진</p>
										</c:if>
										<c:if test="${hosdto.check == 'n' or hosdto.check == 'N'}">
											<p class="hospital-info-content">건강검진</p>
										</c:if>
										<c:if test="${hosdto.vaccin == 'y' or hosdto.vaccin == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">예방접종</p>
										</c:if>
										<c:if test="${hosdto.vaccin == 'n' or hosdto.vaccin == 'N'}">
											<p class="hospital-info-content">예방접종</p>
										</c:if>
										<c:if test="${hosdto.night == 'y' or hosdto.night == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">야간진료</p>
										</c:if>
										<c:if test="${hosdto.night == 'n' or hosdto.night == 'N'}">
											<p class="hospital-info-content">야간진료</p>
										</c:if>
										<c:if test="${hosdto.holiday == 'y' or hosdto.holiday == 'Y'}">
											<p class="hospital-info-content hospital-info-content-color">주말진료</p>
										</c:if>
										<c:if test="${hosdto.holiday == 'n' or hosdto.holiday == 'N'}">
											<p class="hospital-info-content">주말진료</p>
										</c:if>
									</div>
								</a>
								<c:if test="${lv == '1'}">
									<a href="#">
										<button class="reservation-button">예약하기</button>
									</a>
								</c:if>
								<c:if test="${lv == '' || lv == null}">
									<a href="#">
										<button class="reservation-button">예약하기</button>
									</a>
								</c:if>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</main>
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
			beforeSend : function(xhr){
				xhr.setRequestHeader('${_csrf.headerName}', '${_csrf.token}');
			},
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
        	
</script>
