<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- appointment.jsp -->

<style>
.sidebar-clicked {
	background-color: #dddfeb;
}

.list tr {
	height: 40px;
}

.list tbody tr:hover {
	cursor: pointer;
	background-color: #dddfeb;
}

.list th {
	text-align: center;
	border-right: 1px solid #CCC;
}

.list tr:first-child th {
	background-color: #edf0f7;
}

.list td {
	border-bottom: 1px solid #edf0f7;
	border-right: 1px solid #edf0f7;
	text-align: center;
}

.list th:last-child, .list td:last-child {
	border-right: none;
}

.list tr td button:hover {
	background-color: #CCC;
}

button {
	border: none;
	border-radius: 5px;
	color: #858796 cursor: pointer;
}

.null-msg {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

.sel-appointment-order-area {
	display: flex;
}

.sel-appointment-order-inner-area {
	margin-left: auto;
	margin-bottom: 10px;
}

#sel-appointment-order {
	border: 1px solid #CCC;
}

.list th:nth-child(1) {
	width: 50px;
}

.list th:nth-child(2) {
	width: 100px;
}

.list th:nth-child(3) {
	width: 100px;
}

.list th:nth-child(4) {
	width: 100px;
}

.list th:nth-child(5) {
	width: 100px;
}

.list th:nth-child(6) {
	width: 220px;
}

.list th:nth-child(7) {
	width: 100px;
}

.list th:nth-child(8) {
	width: 600px;
}

.list th:nth-child(9) {
	width: 250px;
}

.list th:nth-child(10) {
	width: 150px;
}

.list td:nth-child(8) {
	padding-left: 10px;
	text-align: left;
}

.pagebar {
	text-align: center;
	margin-top: 30px;
	margin-bottom: 20px;
	font-size: 1.1rem;
}

.pagebar>a {
	color: #858796;
}

.gray-font {
	color: #CCC;
}

#search {
	border: 1px solid #CCC;
}

.null-msg {
	text-align: center;
}
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
					<h5 class="m-0 font-weight-bold text-primary">오늘의 예약</h5>
					<div>
						<input type="text" name="search" id="search">
						<button type="button">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">

					<div class="sel-appointment-order-area"></div>

					<table class="list">
						<thead></thead>

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
										<td class="gray-font">(접수자)</td>
									</c:if>
									<td>${dto.treatmentWay}</td>
									<td>${dto.appointmentDate}</td>
									<td>${dto.doctorName}</td>
									<c:if test="${dto.symptom == null}">
										<td class="gray-font">(미작성)</td>
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


						</tbody>
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
	const hospitalId = 'yonse';
	
	//화면 초기화
	init();
	
	//수정하기
	function init(){
		$.ajax({
			type: 'GET',
			url: '/apa/api/hospital/' + hospitalId + '/medi/today/appointment',
			contentType: 'application/json',
			data: {page: 1},
			dataType: 'json',
			success: result => {
				
				//기존 내용 삭제
				//$('.card-body').html(''); 
				
				$('.sel-appointment-order-area').html(''); 
				$('.list thead').html(''); 
				$('.list tbody').html('');
				$('.pagebar').html('');
				
				
				if (result.length != 0) {
					
					//예약이 있을 경우
					
					// select
					const selectOrderData = `
						<div class="sel-appointment-order-inner-area">
							<select id="sel-appointment-order">
								<option value="appintmentSeq">예약번호순</option>
								<option value="newRegDate">최근 신청순</option>
								<option value="treatmentDate">예약날짜순</option>
								<option value=""></option>
							</select>
						</div>
					`;
					
					$('.sel-appointment-order-area').append(selectOrderData);
					
					
					// thead
					const theadData = `
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
					`;
					
					$('.list thead').append(theadData);
					
					
					$(result.list).each((index, item) => {
						
						console.log(item);
						console.log(item.rnum);
						
						// tbody
						const tbodyData = ``;
						
					});
					
					
					// pagebar
					$('.pagebar').html(result.pagebar);
					
					
				} else {
					
					//예약이 없을 경우
					
					const nullMessage = `
						<h4 class="null-msg">오늘 신청된 예약이 없습니다.</h4>
					`;
					
					$('.card-body').append(nullMessage);
					
				}
				
			},
			error: (a, b, c) => {
				console.log(a, b, c);
			}
		});
	}
</script>