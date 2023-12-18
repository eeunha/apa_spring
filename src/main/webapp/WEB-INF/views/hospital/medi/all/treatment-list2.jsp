<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- treatment.jsp -->

<style>
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
	width: 100px;
}

#history-list th:nth-child(7) {
	width: 600px;
}

#history-list th:nth-child(8) {
	width: 190px;
}

#history-list th:nth-child(9) {
	width: 100px;
}

#history-list td:nth-child(7) {
	padding-left: 15px;
	text-align: left;
}

.pagebar {
	text-align: center;
	margin-top: 30px;
	margin-bottom: 20px;
	font-size: 1.1rem;
}

.pagebar > a {
	color: #858796;
}

.gray-font {
	color: #CCC;
}

.status {
	color: tomato;
}

#search {
	border: 1px solid #CCC;
}

.sel-treatment-order-area {
	display: flex;
}

.sel-treatment-order-inner-area {
	margin-left: auto;
	margin-bottom: 10px;
}

#sel-treatment-order {
	border: 1px solid #CCC;
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
					<div>
						<input type="text" name="search" id="search">
						<button type="button">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
				<!-- Card Body -->
				<div class="card-body">
				
					<div class="sel-treatment-order-area"></div>
					
					<table id="history-list" class="list">
						<thead></thead>
						<tbody></tbody>
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
	
	//const pageData = ${page};
	
	//화면 초기화
	load(${page}, 'old-regdate');
//	load(pageData, 'oldRegDate');
//	load(pageData, ${order});
	
//	console.log(${page});
	
	function load(pageNum, order){
//	console.log(typeof order);
		
		const loadData = {page: pageNum, order: order};
		
		$.ajax({
			type: 'GET',
			url: '/apa/api/hospital/' + hospitalId + '/medi/all/treatment',
			contentType: 'application/json',
			data: loadData,
			dataType: 'json',
			success: result => {
				
				//사이드바 css설정
				$('#side-main-all > a').addClass('collapsed');
				$('#side-main-all > a').css('background-color', '#dddfeb');
				$('#side-main-all > a').attr('aria-expanded', 'true');
				$('#side-main-all > div').addClass('show');
				$('#side-sub-all-treatment').css('background-color', '#dddfeb');
				
				
				//기존 내용 삭제
				$('.sel-treatment-order-area').html('');
				$('.list thead').html(''); 
				$('.list tbody').html('');
				$('.pagebar').html('');
				$('.null-msg').html('');

				
				if (result.length != 0) {
					
					//예약이 있을 경우
					
					//select
					let selectData = `
						<div class="sel-treatment-order-inner-area">
							<select id="sel-order" onchange="handleOrderChange();">
					`;
					
					if (order == 'old-regdate') {
						selectData += `<option value="old-regdate" selected>오래된 진료일순</option>`;
					} else {
						selectData += `<option value="old-regdate">오래된 진료일순</option>`;
					}
					
					if (order == 'lastRegDate') {
						selectData += `<option value="last-regdate" selected>최근 진료일순</option>`;
					} else {
						selectData += `<option value="last-regdate">최근 진료일순</option>`;
					}
					
					if (order == 'appointmentseq') {
						selectData += `
									<option value="appointmentseq" selected>예약번호순</option>
								</select>
							</div>
						`;
					} 
					else {
						selectData += `
									<option value="appointmentseq">예약번호순</option>
								</select>
							</div>
						`;
					}
					
					$('.sel-treatment-order-area').append(selectData);
					
					// thead
					const theadData = `
						<tr>
							<th>번호</th>
							<th>예약번호</th>
							<th>환자</th>
							<th>진료방식</th>
							<th>진료과목</th>
							<th>의사</th>
							<th>상세증상</th>
							<th>진료시간</th>
							<th>진행상태</th>
						</tr>
					`;
					
					$('.list thead').append(theadData);
					
					
					$(result.list).each((index, item) => {
						
						// tbody
						let tbodyData = `
							<tr onclick="location.href='/apa/hospital/\${item.hospitalId}/medi/all/treatment/\${item.appointmentSeq}';">
								<td>\${item.rnum}</td>
								<td>\${item.appointmentSeq}</td>
						`;
						
						if (item.childName == null) {
							tbodyData += `<td>\${item.userName}</td>`;
						} else {
							tbodyData += `<td>\${item.childName}</td>`;
						}
						
						tbodyData += `
							<td>\${item.treatmentWay}</td>
							<td>\${item.departmentName}</td>
							<td>\${item.doctorName}</td>
						`;
						
						if (item.symptom == null) {
							tbodyData += `<td class="gray-font">(미작성)</td>`;
						} else {
							tbodyData += `<td>\${item.symptom}</td>`;
						}
						
						tbodyData += `<td>\${item.appointmentDate}</td>`;
						
						if (item.status == '진료대기') {
							
							tbodyData += `<td>\${item.status}</td></tr>`;
							
						} else if (item.status == '진료중') {
							
							tbodyData += `<td class="status">\${item.status}</td></tr>`;
							
						} else if (item.status == '진료완료') {
							
							tbodyData += `<td class="gray-font">\${item.status}</td></tr>`;
						}
							
						$('.list tbody').append(tbodyData);
						
					});
					
					// pagebar
					$('.pagebar').html(result.pagebar);
					
				} else {
					
					//예약이 없을 경우
					
					const nullMessage = `<h4 class="null-msg">오늘 신청된 예약이 없습니다.</h4>`;
					
					$('.card-body').append(nullMessage);
					
				}
			},
			error: (a, b, c) => {
				console.log(a, b, c);
			}
		});
	}
	
	function handleOrderChange() {
		
		const selectedValue = $('#sel-order').val();

		load(1, selectedValue);
		
		//console.log(selectedValue);
		
	}
	
	
</script>