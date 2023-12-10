<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<!-- /reservation/subject.jsp -->
	<form action="/apa/reservation/detail.do" method="POST">
		<div class="hospital-info">
			<c:if test="${choicetype ne '건강검진'}">
				<h1 class="lineseedkr">진료 과목 선택</h1>
				<div class="subject-choice">			
					<c:forEach items="${deptlist}" var="list">	
						<input type="button" class="hospital-info-dept" value="${list.deptnames}">
					</c:forEach>
					<div id="subject-choice-dept">
					</div>
				</div>
				<hr>
				<h1 class="lineseedkr">의사 선택</h1>
				<div class="doctor-choice" id="doctor-choice">
				</div>
				<hr>
			</c:if>			
			<h1 class="lineseedkr">진료일 선택</h1>
			https://bbbootstrap.com/snippets/dark-themed-date-and-time-picker-76906698
			
			<input type="hidden" name="id" value="${id}">
			<input type="hidden" name="choicetype" value="${choicetype}">
		</div>
	</form>
	<script>
		$('.hospital-info-dept').click(function(event) {
			var deptname = $(event.target).val();
			$('.hospital-info-dept').css('opacity', '0.6');
			$('.hospital-info-dept').css('background-color', '#f0f0f0');			
			$(event.target).css('opacity', '1');
			$(event.target).css('background-color', '#999999');
			$('#subject-choice-dept').html('');
			$('#subject-choice-dept').append('<input type="hidden" id="choicedept" name="choicedept" value= "">');
			$('#choicedept').val($(event.target).val());
			$.ajax({
				type: 'GET',
				url: '/apa/reservation/finddoc.do',
				data: {
					deptname,
					seq : "${id}"
				},
				datatype: 'json',
				success: function(result) {
					$('#doctor-choice').html('');
					$(result).each((index, item) => {
						$('#doctor-choice').append(`
							<div>
								<img src="/apa/asset/images/doc/\${item.img}" name="choicedoc" class="docter-images" onclick="docchoice('\${item.seq}')" value="\${item.img}">
								<p class="hospital-doc-name">\${item.name}</p>										
							</div>
							<div id="hidden-choice-doc"></div>
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
		
	</script>
</body>