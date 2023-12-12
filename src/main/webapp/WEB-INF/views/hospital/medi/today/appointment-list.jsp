<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- appointment.jsp -->

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
					<h5 class="m-0 font-weight-bold text-primary">오늘의 예약</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<table class="list">
						<thead>
							<c:if test="${appointmentList.size() != 0}">
								<tr>
									<th>번호</th>
									<th>예약번호</th>
									<th>접수자</th>
									<th>환자</th>
									<th>진료방식</th>
									<th>예약일시</th>
									<th>의사</th>
									<th>상세증상</th>
									<th>신청일시</th>
									<th>확인</th>
								</tr>
							</c:if>
						</thead>

						<tbody>
							<c:forEach items="${appointmentList}" var="dto">
								<tr
									onclick="location.href='/apa/hospital/${dto.hospitalId}/medi/today/appointment/${dto.appointmentSeq}';">
									<td>${dto.rnum}</td>
									<td>${dto.appointmentSeq}</td>
									<td>${dto.userName}</td>
									<c:if test="${dto.childName != null}">
										<td>${dto.childName}</td>
									</c:if>
									<c:if test="${dto.childName == null}">
										<td class="symptomNull">(접수자)</td>
									</c:if>
									<td>${dto.treatmentWay}</td>
									<td>${dto.appointmentDate}</td>
									<td>${dto.doctorName}</td>
									<c:if test="${dto.symptom == null}">
										<td class="symptomNull">(미작성)</td>
									</c:if>
									<c:if test="${dto.symptom != null}">
										<td>${dto.symptom}</td>
									</c:if>
									<td>${dto.regdate}</td>
									<td>
										<button type="button" name="btnApproval" id="btnApproval"
											onclick="approvalRegister('${dto.appointmentSeq}');">승인</button>
										<button type="button" name="btnDecline" id="btnDecline"
											onclick="declineRegister('${dto.appointmentSeq}');">거절</button> 
									</td>
								</tr>
							</c:forEach>

							<c:if test="${appointmentList.size() == 0}">
								<h4 class="null-msg">오늘 신청된 예약이 없습니다.</h4>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->


<script>

	//화면 초기화
	init();
	
	//수정하기
	function init(){
		$.ajax({
			type: 'GET',
			url: '/apa/api/hospital/${dto.hospitalId}/medi/today/appointment',
			data: 'department_id=' + id,
			dataType: 'json',
			success: function(result) {
				
				$('#list tbody').html(''); //기존 내용 삭제
				
				//값 출력하기
				$(result).each((index, item) => {
					
					let temp = `
						<tr>
							<td>\${item.employee_id}</td>
							<td>\${item.name}</td>
							<td>\${item.job_id}</td>
							<td>\${item.hire_date}</td>
						</tr>
					`;
					
					$('#list tbody').append(temp);
				});
				
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
	}
</script>