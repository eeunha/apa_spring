<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

	.list {
		text-align: center;
	}
	
	.list > thead > tr > th {
	    color: #858796;
		font-size: 1.3rem;
	    background-color: #edf0f7;
	    font-weight: lighter;
	    border-right: 1px solid #CCC;
    }

	.list > tbody > tr > td {
		font-size: 1.2rem;
		color: #858796;
		padding-top: 8px;
		padding-bottom: 8px;
		border-bottom: 1px solid #edf0f7;
		border-right: 1px solid #edf0f7;
	}
	
	.list > thead > tr > th:last-child, .list > tbody > tr > td:last-child {border-right: 0;}

	#mlist > thead > tr > th:nth-child(1) { width: 150px; }
	#mlist > thead > tr > th:nth-child(2) { width: 250px; }
	#mlist > thead > tr > th:nth-child(3) { width: 130px; }
	
	#qlist > thead > tr > th:nth-child(1) { width: 150px; }
	#qlist > thead > tr > th:nth-child(2) { width: 300px; }
	#qlist > thead > tr > th:nth-child(3) { width: 200px; }
	#qlist > thead > tr > th:nth-child(4) { width: 100px; }
	#qlist > thead > tr > th:nth-child(5) { width: 100px; }

	#clist > thead > tr > th:nth-child(1) { width: 250px; }
	#clist > thead > tr > th:nth-child(2) { width: 200px; }
	#clist > thead > tr > th:nth-child(3) { width: 100px; }
	#clist > thead > tr > th:nth-child(4) { width: 100px; }
	#clist > thead > tr > th:nth-child(5) { width: 100px; }
	#clist > thead > tr > th:nth-child(6) { width: 100px; }
	#clist > thead > tr > th:nth-child(7) { width: 70px; }
	
	.btn {
	    background-color: #edf0f7;
	    color: #858796;
	    border: 0;
	    border-radius: 5px;
	    padding-left: 10px;
	    padding-right: 10px;
	    padding-top: 5px;
	    padding-bottom: 5px;
	}
	
</style>
<div class="container-fluid">

	<!-- Content Row -->

	<div class="row">

		<!-- Area Chart -->
		<div class="col-xl-12">
			<div class="card shadow mb-5">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold">의학테스트 결과 보관함</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<table id="mlist" class="list">
						<thead>
							<tr>
								<th>테스트명</th>
								<th>테스트 날짜</th>
								<th>결과</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-xl-12">
			<div class="card shadow mb-5">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold">의학 상담 보관함</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<h5 class="m-0 font-weight-bold" style="padding-bottom: 20px;">내 글 보관함</h5>
					<table id="qlist" class="list">
						<thead>
							<tr>
								<th>진료과목</th>
								<th>제목</th>
								<th>등록 날짜</th>
								<th>상세 보기</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${qdto.departmentName}</td>
								<td>${qdto.counselTitle}</td>
								<td>${qdto.regdate}</td>
								<td><button onclick="viewDetailQ(${qdto.mediCounselQuestionSeq})" class="btn">상세 보기</button></td>
								<td><button onclick="delQ(${qdto.mediCounselQuestionSeq},${qdto.mediCounselAnswerSeq})" class="btn">삭제</button></td>
							</tr>
						</tbody>
					</table>
					<h5 class="m-0 font-weight-bold" style="padding-top: 20px; padding-bottom: 20px;">타인 글 보관함</h5>
					<table id="qlist" class="list">
						<thead>
							<tr>
								<th>진료과목</th>
								<th>제목</th>
								<th>등록 날짜</th>
								<th>상세 보기</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${bdto.departmentName}</td>
								<td>${bdto.counselTitle}</td>
								<td>${bdto.regdate}</td>
								<td><button onclick="viewDetailQ(${bdto.mediCounselQuestionSeq})" class="btn">상세 보기</button></td>
								<td><button onclick="delB(${bdto.mediCounselBoxSeq})" class="btn">삭제</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-xl-12">
			<div class="card shadow mb-5">
				<!-- Card Header - Dropdown -->
				<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
					<h5 class="m-0 font-weight-bold">커뮤니티 보관함</h5>
				</div>
				<!-- Card Body -->
				<div class="card-body">
					<table id="clist" class="list">
						<thead>
							<tr>
								<th>제목</th>
								<th>날짜</th>
								<th>댓글 수</th>
								<th>좋아요 수</th>
								<th>상세 보기</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${cdto.communityTitle}</td>
								<td>${cdto.communityDate}</td>
								<td>${cdto.communityCommentCount}</td>
								<td>${cdto.communityLikeCount}</td>
								<td><button onclick="viewDetailC(${cdto.communitySeq})" class="btn">상세 보기</button></td>
								<td><button onclick="delC(${cdto.communitySeq})" class="btn">삭제</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden" name="userSeq" value="${seq}">

<script>

	const myPage = document.getElementById('myPage');
	const myInfo = document.getElementById('myInfo');
	const myChild = document.getElementById('myChild');
	const myMedi = document.getElementById('myMedi');
	const myBookmark = document.getElementById('myBookmark');
	const myBox = document.getElementById('myBox');
	const myReview = document.getElementById('myReview');
	const userSeq = $('input[name=userSeq]').val();
	
	loadLink(userSeq);
	
	function loadLink(seq) {
	    myPage.setAttribute('href', '/apa/user/' + seq + '/mypage.do');
	    myInfo.setAttribute('href', '/apa/user/' + seq + '/mypage.do');
	    myChild.setAttribute('href', '/apa/user/' + seq + '/mychild.do');
	    myMedi.setAttribute('href', '/apa/user/' + seq + '/mymedi.do');
	    myBookmark.setAttribute('href', '/apa/user/' + seq + '/mybookmark.do');

	    myBox.setAttribute('href', '/apa/user/' + seq + '/mybox.do');
	    myBox.style.backgroundColor = '#DDDFEB';
	    
	    myReview.setAttribute('href', '/apa/user/' + seq + '/myreview.do');
	}
	
	mediTest(${seq});
	
	function mediTest(seq) {
		
		$('#mlist > tbody').html('');
		
		$.ajax ({
			type: 'GET',
			url: 'http://localhost:8090/apa/api/user/' + seq + '/mybox/meditest',
			dataType: 'json',
			success: list => {
				$(list).each((index, item) => {
					
					$('#mlist > tbody').append(`
							
						<tr>
							<td>\${item.mediTestName}</td>
							<td>\${item.testTime}</td>
							<td><button onclick="viewTestDetail(\${item.mediTestSaveSeq})" class="btn">결과 확인</button></td>
						</tr>			
						
					`);
					
				});
			},
			error: (a,b,c) => {
				console.log(a,b,c);
			}
		});		
	}


	function viewDetail(seq) {
		
        var winHeight = 1000;
        var winWidth = 800;
        var winTop = (screen.height / 2) - (winHeight / 2);
        var winLeft = (screen.width / 2) - (winWidth / 2);
        window.open('http://localhost:8090/apa/user/' + seq + '/myrecord.do', '진료 내역', 'height=' + winHeight + ',width=' + winWidth + ',top=' + winTop + ',left=' + winLeft);		
		
	}	

</script>