<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form action="/apa/search/reservation/subject.do" method="POST">
		<div class="hospital-info">
			<div>
				<c:if test="${dto.face == 'y' || dto.face == 'Y'}">
					<div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 type-button-div">
	                   <div class="featured-block d-flex justify-content-center align-items-center type-button-div">
							<button type="button" class="type-button lineseedkr" onclick="typechoice()" value="${dto.face}">대면</button>
	                	</div>
					</div>			
				</c:if>
				<c:if test="${dto.unface == 'y' || dto.unface == 'Y'}">
					<div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 type-button-div">
	                   	<div class="featured-block d-flex justify-content-center align-items-center type-button-div">			
							<button type="button" class="type-button lineseedkr" onclick="typechoice()" value="${dto.unface}">비대면</button>
							</div>
					</div>
				</c:if>
				<c:if test="${dto.housecall == 'y' || dto.housecall == 'Y'}">
					<div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 type-button-div">
	                	<div class="featured-block d-flex justify-content-center align-items-center type-button-div">		
							<button type="button" class="type-button lineseedkr" onclick="typechoice()" value="${dto.housecall}">왕진</button>
							</div>
					</div>
				</c:if>
				<c:if test="${dto.ishealthcheck == 'y' || dto.ishealthcheck == 'Y'}">		
					<div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 type-button-div">
	                   	<div class="featured-block d-flex justify-content-center align-items-center type-button-div">
							<button type="button" class="type-button lineseedkr" onclick="typechoice()" value="${dto.ishealthcheck}">건강검진</button>
							</div>
					</div>
				</c:if>
				<c:if test="${dto.vaccination == 'y' || dto.vaccination == 'Y'}">			
					<div class="col-lg-3 col-md-6 col-12 mb-4 mb-lg-0 type-button-div">
	                   	<div class="featured-block d-flex justify-content-center align-items-center type-button-div">
							<button type="button" class="type-button lineseedkr" onclick="typechoice()" value="${dto.vaccination}">예방접종</button>
							</div>
					</div>
				</c:if>
			</div>
			<div id="choice-type"></div>
			<button type="submit" class="reservation-button" disabled="disabled"> 다음으로 </button>
			<input type="hidden" name="seq" value="${dto.hospitalid}">
		</div>
	</form>
	<script>
	
	</script>
</body>