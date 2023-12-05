<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main>
	<div class="maindiv">
		<div id="tagList">
			<c:forEach items="${symtomlist}" var="dto">
				<c:if test="${dto.selfsymtomseq+0 >= 25}">
					<div id="tag${dto.selfsymtomseq}" class="tag hide-tag" onclick="selSystom(${dto.selfsymtomseq})">${dto.selfsymtomname}</div>
				</c:if>
				<c:if test="${dto.selfsymtomseq+0 <= 24}">
					<div id="tag${dto.selfsymtomseq}" class="tag" onclick="selSystom(${dto.selfsymtomseq})">${dto.selfsymtomname}</div>
				</c:if>
			</c:forEach>
		</div>
		<div>
			<input type="button" class="taglist-button" value="증상 더보기">
		</div>
		<hr>
		<%-- <table id="hospital-list">
			<tbody>
				<c:forEach items="${hosdto}" var="hosdto">
					<tr>
						<td><a href="/apa/find/view.do?id=${hosdto.id}">
								<div class="hospital-info">
									<h6 class="collapse-header">${hosdto.name}</h6>
									<p class="info-text">${hosdto.deptname}</p>
									<p class="info-text">${hosdto.address}</p>
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
									<a href="/apa/reservation/select.do?id=${hosdto.id}">
										<button class="reservation-button">예약하기</button>
									</a>
								</c:if>
								<c:if test="${lv == '' || lv == null}">
									<a href="/apa/user/login.do">
										<button class="reservation-button">예약하기</button>
									</a>
								</c:if>
							</div>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table> --%>
	</div>
</main>

