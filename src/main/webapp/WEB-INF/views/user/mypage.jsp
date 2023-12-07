<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

	input {
		border: 1px solid #c6c6c6;
	    text-align: center;
	    border-radius: 5px;
	    outline-color: #1cc88a;
	}

	#message {
		width: 250px;
		border: 0;
		text-align: left;
		font-weight: bold;
		margin-left: 10px;
		background-color: white;
	}

	#id {
		cursor: not-allowed;
		background-color: #d3d3d3;
	}

	#ssn1 {
		cursor: not-allowed;
		background-color: #d3d3d3;
	}
	
	#ssn2 {
		cursor: not-allowed;	
		background-color: #d3d3d3;
	}

	#address {
		width: 25em;
	}

	#my-info {
		display: flex;
		align-items: center;
    	margin-bottom: 30px;
    	justify-content: flex-start;
	}

	#my-info-name {
    	color: #666666;
		height: 400px;
		display: grid;
		font-weight: bold;
		align-items: center;
		margin-right: 100px;
	}

	.my-info-name-child {
		height: 20px;
	}

	.my-info-name-child:last-child {
		margin-bottom: 0px;
	}
	
	#my-info-input {
		height: 400px;
		display: grid;
		align-items: center;
	}

	#info-update-btn {
		text-align: center;
	}
	
	#update-btn {
		border: 0;
		width: 7em;
		height: 2em;
 		color: #858796;
		font-size: 1em;
		border-radius: 0.35rem;
		background-color: #edf0f7;
	}
	
	#update-btn:hover {
		background-color: #dddfeb;
	}

	#delete-user {
		border: 0;
		color: #CCC;
		float: right;
		outline: none;
		font-size: small;
		background-color: white;
	}

	#delete-user:hover {
		text-decoration: none;
	}

</style>
<!-- <nav
	class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	Sidebar Toggle (Topbar)
	<button id="sidebarToggleTop"
		class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>

	Page Heading
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800 hansans" style="padding-top: 28px;">내
			정보 관리</h1>
	</div>
</nav> -->
<div class="container-fluid">

	<!-- Content Row -->

	<div class="row">

		<!-- Area Chart -->
		<div class="col-xl-12">
			<div class="card shadow mb-5">
				<!-- Card Header - Dropdown -->
				<div
					class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold">내 정보</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<form name="form" method="POST" action="/apa/user/info/edit.do"
						onsubmit="return checkAll()">
						<div id="my-info">
							<div id="my-info-name">
								<div class="my-info-name-child">이름</div>
								<div class="my-info-name-child">아이디</div>
								<div class="my-info-name-child">비밀번호</div>
								<div class="my-info-name-child">비밀번호 확인</div>
								<div class="my-info-name-child">주민등록번호</div>
								<div class="my-info-name-child">연락처</div>
								<div class="my-info-name-child">이메일</div>
								<div class="my-info-name-child">주소</div>
								<div class="my-info-name-child">현재 비밀번호</div>
							</div>
							<div id="my-info-input">
								<div class="my-info-input-child">
									<input type="text" name="name" value="${dto.userName}"
										id="name" maxlength="10">
								</div>
								<div class="my-info-input-child">
									<input type="text" value="${seq}" id="id" disabled>
								</div>
								<div class="my-info-input-child">
									<input type="password" name="pw" value="${dto.userPw}" id="pw"
										maxlength="16">
								</div>
								<div class="my-info-input-child">
									<input type="password" name="pw-confirm" id="pw-confirm"
										maxlength="16s"><input type="text" id="message"
										disabled>
								</div>
								<div class="my-info-input-child">
									<input type="text" value="${dto.userSSNs}" size="7" id="ssn1"
										disabled> - <input type="text" value="${maskingSSN}"
										size="9" id="ssn2" disabled>
								</div>
								<div class="my-info-input-child">
									<input type="text" name="tel1" value="${dto.userTels}" size="4"
										maxlength="3"> - <input type="text" name="tel2"
										value="${dto.userTelm}" size="4" maxlength="4"> - <input
										type="text" name="tel3" value="${dto.userTele}" size="4"
										maxlength="4">
								</div>
								<div class="my-info-input-child">
									<input type="text" name="email" value="${dto.userEmail}"
										required>
								</div>
								<div class="my-info-input-child">
									<input type="text" name="address" value="${dto.userAddress}"
										id="address" required maxlength="70">
								</div>
								<div class="my-info-input-child">
									<input type="password" name="inputCurrentPw"
										id="inputCurrentPw" required maxlength="16">
								</div>
							</div>
						</div>
						<input type="hidden" name="id" value="${dto.userId}" id="id">
						<input type="hidden" name="currentPw" value="${dto.userPw}"
							id="currentPw"> <input type="hidden" name="ssn1"
							value="${dto.userSSNs}" size="7" id="ssn1"> <input
							type="hidden" name="ssn2" value="${dto.userSSNe}" size="9"
							id="ssn2"> <input type="hidden" name="seq"
							value="${dto.userSeq}">
						<div id="info-update-btn">
							<button id="update-btn">수정하기</button>
						</div>
					</form>

					<form method="GET" action="/apa/user/info/edit.do" id="delete-form">
						<button id="delete-user" type="button">회원 탈퇴</button>
						<input type="hidden" name="seq" value="${dto.userSeq}">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>