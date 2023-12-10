<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- treatment.jsp -->

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
									<th>상세증상</th>
									<th>진료과목</th>
									<th>의사</th>
									<th>진료일시</th>
									<th>진행상태</th>
								</tr>
							</c:if>
						</thead>

						<tbody>
							<c:forEach items="${treatmentList}" var="dto">
								<tr
									onclick="location.href='/apa/hospital/${dto.hospitalId}/medi/all/treatment?appointmentSeq=${dto.appointmentSeq}';">
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
									<c:if test="${dto.symptom == null}">
										<td class="symptomNull">(미작성)</td>
									</c:if>
									<c:if test="${dto.symptom != null}">
										<td>${dto.symptom}</td>
									</c:if>

									<td>${dto.departmentName}</td>
									<td>${dto.doctorName}</td>
									<td>${dto.appointmentDate}</td>
									<c:if test="${dto.status == '진료중'}">
										<td class="status">${dto.status}</td>
									</c:if>
									<c:if test="${dto.status != '진료중'}">
										<td>${dto.status}</td>
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