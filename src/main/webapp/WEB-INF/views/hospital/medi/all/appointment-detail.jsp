<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- appointment.jsp -->
<link href="/apa/resources/css/hospital-medi.css" rel="stylesheet">


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
					<h5 class="m-0 font-weight-bold text-primary">예약 내역 상세 보기</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<div id="container">
						<div id="detail-appointmentseq">
							예약 번호: ${dto.appointmentSeq}
						</div>
						<table>
							<c:if test="${dto.childSeq == null}">
								<tr>
									<th>환자 번호</th>
									<td>${dto.userSeq}</td>
								</tr>
								<tr>
									<th>이름</th>
									<td>${dto.userName}</td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td>${dto.userTel}</td>
								</tr>
								<tr>
									<th>주민등록번호</th>
									<td>${dto.userSSN}</td>
								</tr>
								<tr>
									<th>주소</th>
									<td>${dto.userAddress}</td>
								</tr>
							</c:if>

							<c:if test="${dto.childSeq != null}">
								<tr>
									<th>접수자 번호</th>
									<td>${dto.userSeq}</td>
								</tr>
								<tr>
									<th>접수자 이름</th>
									<td>${dto.userName}</td>
								</tr>
								<tr>
									<th>환자와의 관계</th>
									<td>${dto.userRelation}</td>
								</tr>
								<tr>
									<th>접수자 전화번호</th>
									<td>${dto.userTel}</td>
								</tr>
								<tr>
									<th>접수자 주소</th>
									<td>${dto.userAddress}</td>
								</tr>
								<tr>
									<th>환자 번호</th>
									<td>${dto.childSeq}</td>
								</tr>
								<tr>
									<th>환자 이름</th>
									<td>${dto.childName}</td>
								</tr>
								<tr>
									<th>환자 주민등록번호</th>
									<td>${dto.childSSN}</td>
								</tr>
							</c:if>
							<tr></tr>
							<tr>
								<th>예약일시</th>
								<td>${dto.appointmentDate}</td>
							</tr>
							<tr>
								<th>진료방식</th>
								<td>${dto.treatmentWay}</td>
							</tr>
							<tr>
								<th>진료과목</th>
								<td>${dto.departmentName}</td>
							</tr>
							<tr>
								<th>의사</th>
								<td>${dto.doctorName}</td>
							</tr>
							<tr>
								<th>상세증상</th>
								<td>${dto.symptom}</td>
							</tr>
							<tr>
								<th>신청일시</th>
								<td>${dto.regdate}</td>
							</tr>
							<tr></tr>
							<tr>
								<th>예약 상태</th>
								<td>${dto.status}</td>
							</tr>

						</table>

						<div id="btnArea">
							<c:if test="${dto.status == '대기'}">
								<button type="button" name="btnApproval" id="btnApproval"
									onclick="approvalRegister('${dto.appointmentSeq}');">승인</button>
								<button type="button" name="btnDecline" id="btnDecline"
									onclick="declineRegister('${dto.appointmentSeq}');">거절</button>
							</c:if>
							<button type="button"
								onclick="location.href='/apa/hospital/${dto.hospitalId}/medi/all/appointment';">뒤로가기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->