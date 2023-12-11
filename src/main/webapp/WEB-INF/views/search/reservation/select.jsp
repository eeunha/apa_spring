<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css"> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
<style>
.card {
	box-shadow: 0px 0px 4px 0px #000000;
}

::placeholder {
	color: #fff;
	opacity: 1;
}

:-ms-input-placeholder {
	color: #fff;
}

::-ms-input-placeholder {
	color: #fff;
}

.datepicker {
	background-color: #fff !important;
	color: #000 !important;
	border: none;
	padding: 10px !important;
	border-radius: 30px;
}

.datepicker-dropdown:after {
	border-bottom: 6px solid #000;
}

thead tr:nth-child(3) th {
	color: #000 !important;
	font-weight: bold;
	padding-top: 20px;
	padding-bottom: 10px;
}

.dow, .old-day, .day, .new-day {
	width: 40px !important;
	height: 40px !important;
	border-radius: 0px !important;
}

.old-day:hover, .day:hover, .new-day:hover, .month:hover, .year:hover,
	.decade:hover, .century:hover {
	border-radius: 6px !important;
	background-color: #eee;
	color: #000;
}

.disabled {
	color: #c7c7c7 !important;
}

.prev, .next, .datepicker-switch {
	border-radius: 0 !important;
	padding: 20px 10px !important;
	text-transform: uppercase;
	font-size: 20px;
	color: #000 !important;
	opacity: 0.8;
}

.prev:hover, .next:hover, .datepicker-switch:hover {
	background-color: inherit !important;
	opacity: 1;
}

.cell {
	border: 1px solid #BDBDBD;
	margin: 2px;
	cursor: pointer;
}

.cell:hover {
	border: 1px solid #3D5AFE;
}

.cell.select {
	background-color: #3D5AFE;
	color: #000;
}

.fa-calendar {
	color: #000;
	font-size: 30px;
	padding-top: 8px;
	padding-left: 5px;
	cursor: pointer;
}

.datepicker::placeholder {
	color: black;
}
</style>
<body>
	<!-- /reservation/subject.jsp -->
	<div class="maindiv">
		<form action="/apa/search/reservation/detail.do" method="GET">
			<div class="hospital-info">
				<c:if test="${choicetype ne '건강검진'}">
					<h1 class="lineseedkr">진료 과목 선택</h1>
					<div class="subject-choice">
						<c:forEach items="${deptlist}" var="list">
							<input type="button" class="hospital-info-dept"
								value="${list.departmentname}">
						</c:forEach>
						<div id="subject-choice-dept"></div>
					</div>
					<hr>
					<h1 class="lineseedkr">의사 선택</h1>
					<div class="doctor-choice" id="doctor-choice"></div>
					<hr>
				</c:if>
				<h1 class="lineseedkr">진료일 선택</h1>

				<div class="container-fluid px-0 px-sm-4 mx-auto">
					<div class="row justify-content-center mx-0">
						<div class="col-lg-10">
							<div class="card border-0">
								<div class="card-header bg-dark">
									<div class="mx-0 mb-0 row justify-content-sm-center justify-content-start px-1">
										<input type="text" id="dp1" class="datepicker" placeholder="원하시는 진료 날짜를 선택하세요." name="choicedate" readonly>
										<span class="fa fa-calendar"></span>
									</div>
								</div>
								<div class="card-body p-3 p-sm-5" id="card-body">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="hidden-choice-doc"></div>
				<div class="time-choice" id="time-choice"></div>
				<input type="hidden" name="seq" value="${dto.hospitalid}"> 
				<input type="hidden" name="choicetype" value="${choicetype}"> 
				<input type="hidden" name="userseq" value="1"> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<button type="submit">다음으로</button>
			</div>
		</form>
	</div>
	<script>
		timeload();
		$('.cell').click(function() {
			$('.cell').css('opacity', '0.6');
			$(event.target).css('opacity', '1');
			$('#time-choice').html('');
			$('#time-choice').append('<input type="hidden" id="choicetime" name="choicetime" value="">');
			$('#choicetime').val($(event.target).text());
		});
		
		$(document).ready(function(){
			$('.datepicker').datepicker({
			    format: 'yyyy-mm-dd',
			    autoclose: true,
			    startDate: '0d'
			});
	
			$('.cell').click(function(){
			    $('.cell').removeClass('select');
			    $(this).addClass('select');
			});
	
		});
	
	
		$('.hospital-info-dept').click(function(event) {
			let departmentname = $(event.target).val();
			$('.hospital-info-dept').css('opacity', '0.6');
			$('.hospital-info-dept').css('background-color', '#f0f0f0');			
			$(event.target).css('opacity', '1');
			$(event.target).css('background-color', '#999999');
			$('#subject-choice-dept').html('');
			$('#subject-choice-dept').append('<input type="hidden" id="choicedept" name="choicedept" value= "">');
			$('#choicedept').val($(event.target).val());
			let obj = {
				departmentname,
				hospitalId : '${dto.hospitalid}'
			};
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8090/apa/search/reservation/finddoc',
				headers : {'Content-Type' : 'application/json'
				},
				beforeSend : function(xhr) {
					xhr.setRequestHeader('${_csrf.headerName}', '${_csrf.token}');
				},
				data : JSON.stringify(obj),
				dataType: 'json',
				success: function(result) {
					$('#doctor-choice').html('');
					$(result).each((index, item) => {
						$('#doctor-choice').append(`
							<div>
								<img src="/apa/resources/images/doc/\${item.doctorImage}" name="choicedoc" class="docter-images" onclick="docchoice('\${item.doctorSeq}')" value="\${item.doctorImage}">
								<p class="hospital-doc-name">\${item.doctorName}</p>										
							</div>
						`);
					});
					
				},
				error: function(a,b,c) {
					console.log(a,b,c)
				}
			});
		});
		function docchoice(seq) {
			$('.docter-images').css('opacity', '0.6');
			$(event.target).css('opacity', '1');
			$('#hidden-choice-doc').html('');
			$('#hidden-choice-doc').append('<input type="hidden" id="choicedoc" name="choicedoc" value= "">');
			$('#choicedoc').val(seq);
			$('.reservation-button').attr("disabled", false);
			
		}
		
		function timeload() {
			var count = 1;
			var opentime = '${dto.opentime}';
			var closetime = '${dto.closetime}';
			var openH = Number(opentime.substring(0,2));
			var openM = Number(opentime.substring(3));
			var closeH = Number(closetime.substring(0,2));
			var closeM = Number(closetime.substring(3));
			$('#card-body').html('');
			let temp =``;
			for(openH; openH<closeH; openH++){
				console.log(openH+':'+openM);
				if (count%6 == 1){
					temp += `<div class="row text-center mx-0">`;
				}
				temp += `<div class="col-md-2 col-4 my-1 px-2"><div class="cell py-1">`;
				temp += openH+':'+openM+'0';
				temp += `</div></div>`;
				if (count%6 == 0){
					temp += `</div>`;
					$('#card-body').append(temp);
					temp =``;
				} 
				if (openM == 0) {
					openM = 3;
					openH --;
				} else if (openM == 3) {
					openM = 0;
					if (openH+1>=closeH){
						temp += `</div>`;
						$('#card-body').append(temp);
					}
				}
				count++;
			}
		}
		
	</script>
</body>