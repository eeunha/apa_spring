<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- treatment.jsp -->

<style>

</style>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Content Row -->

	<div class="row">
		<!-- Area Chart -->
		<div class="col-xl-12 col-lg-7 rgst-div">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold text-primary">오늘의 진료</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
				
					<table id="today-treatment-list" class="list">
						<thead></thead>
						<tbody></tbody>
					</table>
					
					<!-- 페이지바 -->
					<div class="pagebar"></div>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

<script>
	console.log('start');
	
	const hospitalId = 'yonse';
	
	//화면 초기화
	load(${page});
	
	function load(pageNum){
		$.ajax({
			type: 'GET',
			url: '/apa/api/hospital/' + hospitalId + '/medi/today/treatment',
			contentType: 'application/json',
			data: {page: pageNum},
			dataType: 'json',
			success: result => {
				
				console.log(result);
				
				//기존 내용 삭제
				$('.list thead').html(''); 
				$('.list tbody').html('');
				$('.pagebar').html('');

				
				if (result.length != 0) {
					
					//예약이 있을 경우
					
					// thead
					const theadData = `
						<tr>
							<th>번호</th>
							<th>예약번호</th>
							<th>환자</th>
							<th>진료방식</th>
							<th>진료과목</th>
							<th>의사</th>
							<th>상세증상</th>
							<th>예약시간</th>
							<th>진행상태</th>
							<th>변경</th>
						</tr>
					`;
					
					$('.list thead').append(theadData);
					
					
					/* $(result.list).each((index, item) => {
						
						// tbody
						let tbodyData = `
							<tr onclick="location.href='/apa/hospital/\${item.hospitalId}/medi/today/appointment/\${item.appointmentSeq}';">
								<td>\${item.rnum}</td>
								<td>\${item.appointmentSeq}</td>
								<td>\${item.userName}</td>`;
						
						if (item.childName != null) {
							tbodyData += `
								<td>\${item.childName}</td>
							`;
						} else {
							tbodyData += `
								<td class="gray-font">(접수자)</td>
							`;
						}
						
						tbodyData += `
							<td>\${item.treatmentWay}</td>
							<td>\${item.appointmentDate}</td>
							<td>\${item.doctorName}</td>
						`;
						
						if (item.symptom == null) {
							tbodyData += `
								<td class="gray-font">(미작성)</td>
							`;
						} else {
							tbodyData += `
								<td>\${item.symptom}</td>
							`;
						}
						
						tbodyData += `
								<td>\${item.regdate}</td>
								<td>
									<button type="button" name="btnApproval" id="btnApproval"
										onclick="approveAppointment('\${item.appointmentSeq}');">승인</button>
									<button type="button" name="btnDecline" id="btnDecline"
										onclick="declineAppointment('\${item.appointmentSeq}');">거절</button>
								</td>
							</tr>
						`;
						
						$('.list thead').append(tbodyData);
						
					});
					
					// pagebar
					$('.pagebar').html(result.pagebar); */
					
				} else {
					
					//예약이 없을 경우
					
					const nullMessage = `<h4 class="null-msg">오늘 신청된 예약이 없습니다.</h4>`;
					
					$('.card-body').append(nullMessage);
					
				}
			},
			error: (a, b, c) => {
				console.log(a, b, c);
			}
		});
	}

</script>