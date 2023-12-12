<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- treatment.jsp -->

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
	color: #858796
}

.null-msg {
	text-align: center;
}

#history-list th:nth-child(1) {
	width: 50px;
}

#history-list th:nth-child(2) {
	width: 80px;
}

#history-list th:nth-child(3) {
	width: 100px;
}

#history-list th:nth-child(4) {
	width: 100px;
}

#history-list th:nth-child(5) {
	width: 120px;
}

#history-list th:nth-child(6) {
	width: 600px;
}

#history-list th:nth-child(7) {
	width: 100px;
}

#history-list th:nth-child(8) {
	width: 180px;
}

#history-list th:nth-child(9) {
	width: 100px;
}


#history-list td:nth-child(6) {
	padding-left: 15px;
	text-align: left;
}

#pagebar {
	text-align: center;
	margin-top: 20px;
	font-size: 1.1rem;
}

#pagebar > a {
	color: #858796;
}

.gray-font {
	color: #CCC;
}

.status {
	color: tomato;
}
</style>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Content Row -->

	<div class="row">
		<!-- Area Chart -->
		<div class="col-xl-12 col-lg-7">
			<div class="card shadow mb-4">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold text-primary">모든 진료 내역</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<table id="history-list" class="list">
						<thead>
							<c:if test="${treatmentList.size() != 0}">
								<tr>
									<th>번호</th>
									<th>예약번호</th>
									<th>환자</th>
									<th>진료방식</th>
									<th>진료과목</th>
									<th>상세증상</th>
									<th>의사</th>
									<th>진료일시</th>
									<th>진행상태</th>
								</tr>
							</c:if>
						</thead>

						<tbody>
							<c:forEach items="${treatmentList}" var="dto">
								<tr
									onclick="location.href='/apa/hospital/${dto.hospitalId}/medi/all/treatment/${dto.appointmentSeq}';">
									<td>${dto.rnum}</td>
									<td>${dto.appointmentSeq}</td>
									<td>
										<c:if test="${dto.childName == null}">
											${dto.userName}
										</c:if> 
										<c:if test="${dto.childName != null}">
											${dto.childName}
										</c:if>
									</td>
									<td>${dto.treatmentWay}</td>
									<td>${dto.departmentName}</td>

									<c:if test="${dto.symptom == null}">
										<td class="gray-font">(미작성)</td>
									</c:if>
									<c:if test="${dto.symptom != null}">
										<td>${dto.symptom}</td>
									</c:if>

									<td>${dto.doctorName}</td>
									<td>${dto.appointmentDate}</td>
									<c:if test="${dto.status == '진료대기'}">
										<td>${dto.status}</td>
									</c:if>
									<c:if test="${dto.status == '진료중'}">
										<td class="status">${dto.status}</td>
									</c:if>
									<c:if test="${dto.status == '진료완료'}">
										<td class="gray-font">${dto.status}</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>

					</table>


					<!-- 페이지바 -->
					<c:if test="${treatmentList.size() != 0}">
						<div id="pagebar">${pagebar}</div>
					</c:if>

					<c:if test="${treatmentList.size() == 0}">
						<h4 class="null-msg">진료 내역이 없습니다.</h4>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->