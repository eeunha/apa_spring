<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<div class="maindiv">
		<div>
			<h6>${dto.hospitalname}</h6>
			<div class="social-icon-item">
            	<div class="bookmark-icon-link bi-star-fill" style="color: yellow;"></div>
			</div>
			<div class="hospital-info-grid">
				<c:if test="${dto.face == 'y' or dto.face == 'Y'}">
					<p class="box-content box-content-color">대면</p>
				</c:if>
				<c:if test="${dto.face == 'n' or dto.face == 'N'}">
					<p class="box-content">대면</p>
				</c:if>
				<c:if test="${dto.unface == 'y' or dto.unface == 'Y'}">
					<p class="box-content box-content-color">비대면</p>
				</c:if>
				<c:if test="${dto.unface == 'n' or dto.unface == 'N'}">
					<p class="box-content">비대면</p>
				</c:if>
				<c:if test="${dto.housecall == 'y' or dto.housecall == 'Y'}">
					<p class="box-content box-content-color">왕진</p>
				</c:if>
				<c:if test="${dto.housecall == 'n' or dto.housecall == 'N'}">
					<p class="box-content">왕진</p>
				</c:if>
				<c:if test="${dto.ishealthcheck == 'y' or dto.ishealthcheck == 'Y'}">
					<p class="box-content box-content-color">건강검진</p>
				</c:if>
				<c:if test="${dto.ishealthcheck == 'n' or dto.ishealthcheck == 'N'}">
					<p class="box-content">건강검진</p>
				</c:if>
				<c:if test="${dto.vaccination == 'y' or dto.vaccination == 'Y'}">
					<p class="box-content box-content-color">예방접종</p>
				</c:if>
				<c:if test="${dto.vaccination == 'n' or dto.vaccination == 'N'}">
					<p class="box-content">예방접종</p>
				</c:if>
				<c:if
					test="${dto.ishospitalnightcare == 'y' or dto.ishospitalnightcare == 'Y'}">
					<p class="box-content box-content-color">야간진료</p>
				</c:if>
				<c:if
					test="${dto.ishospitalnightcare == 'n' or dto.ishospitalnightcare == 'N'}">
					<p class="box-content">야간진료</p>
				</c:if>
				<c:if
					test="${dto.ishospitalholiday == 'y' or dto.ishospitalholiday == 'Y'}">
					<p class="box-content box-content-color">주말진료</p>
				</c:if>
				<c:if
					test="${dto.ishospitalholiday == 'n' or dto.ishospitalholiday == 'N'}">
					<p class="box-content">주말진료</p>
				</c:if>
			</div>
		</div>
		<hr>
		<div>
			<p>영업시간: ${dto.opentime} ~ ${dto.closetime}</p>
		</div>
		<div>
			<p>휴게시간: ${dto.restopentime} ~ ${dto.restclosetiem}</p>
		</div>
		<div>
			<p>주간 휴무일: ${dto.hospitaldayoff}</p>
		</div>
		<hr>
		<div>
			<c:forEach items="${deptlist}" var="list">
				<div style="display: flex; padding-left: 0;">
					<p style="width: 100px;">${list.departmentname}</p>
					<div style="display: flex;">
						<c:forEach items="${doclist}" var="doc">
							<c:if test="${list.departmentname == doc.departmentname}">
								<img class="docter-images"
									src="/apa/resources/images/doc/${doc.doctorImage}">
								<p class="" style="margin-right: 30px;">${doc.doctorName}</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
		<hr>
		<div>
			<p class="hospital-info-info">${dto.hospitalemail}</p>
			<p class="hospital-info-info">${dto.hospitaltel}</p>
		</div>
		<hr>
		<div>
			<p class="hospital-info-info">${dto.hospitaladdress}</p>
			<div id="map" style="width: auto; height: 400px;"></div>
			<!-- 지도를 담을 영역 만들기 -->
		</div>
		<c:if test="${lv == '1'}">
			<div style"width=100%">
				<a href="#">
					<button class="reservation-button">예약하기</button>
				</a>
			</div>
		</c:if>
		<c:if test="${lv == '' || lv == null}">
			<div class="button-div">
				<a href="#">
					<button class="reservation-button">예약하기</button>
				</a>
			</div>
		</c:if>
		<hr>
		<div>
			<div class="review-progress-bar">       
   				<div class="review-progress" style="width: ${positive}%";></div>
			</div>
			<div>
				<c:forEach items="${reviewlist}" var="reviewlist">
					<div class="review-grid">
						<div>${reviewlist.userId}</div>
						<div class="hospital-info-grid reviewtaglist">
							<c:forEach items="${reviewtaglist}" var="reviewtaglist">
								<c:if test="${reviewtaglist.reviewSeq == reviewlist.reviewSeq}">
									<p class="box-content">${reviewtaglist.tagContent}</p>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<p>${reviewlist.reviewContent}</p>
				</c:forEach>
			</div>
		</div>
	</div>
</main>
<script>
</script>