<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<style>
.vertical{
	border: 1px solid #D0E5E1;
	width: 1300px;
	height: 500px;
	background-color: #D0E5E1;

}
#title{
	font-size:1.5rem;
	text-align: center;
	height: 90px;
	width: 120px;
	border-right: 8px solid #EEF5F3;
	border-bottom: 8px solid #EEF5F3;
}
#content1{
	font-size:1.5rem;
	text-align: center;
	border-right: 8px solid #EEF5F3;
	
}
#subject{
	width: 95%;
	height: 50px;
	border-radius: 4px;
	margin-left: 15px;
	border: 1px solid #D0E5E1;

}	
#content{
	width: 95%;
	height: 90%;
	border-radius: 4px;
	margin-left: 15px;
	border: 1px solid #D0E5E1;
}

.back, .add{
	border-radius: 4px;
	border: 1px solid  #D0E5E1;
	background-color: #D0E5E1;
}

.btn1{
	margin-top: 20px;
	text-align: right;
}

#main > form > table > tbody > tr:nth-child(1) > td{
	border-bottom: 8px solid #EEF5F3;
}
</style>
<main id="main">
<div class="maindiv">
		<h1 class="hansans">Community <small>글쓰기</small></h1>
		<p> 저작권,명예훼손, 청소년유해자료, 음란물, 선거법 등 위법 자료를 게시하거나 배포할 경우 관련법에 의거하여 처벌을 받을 수 있습니다.</p>
		
		
		<table class="vertical">
			<tr>
				<th id="title">제목</th>
				<td><input type="text" name="subject" id="subject" required class="full" autofocus></td>
			</tr>
			<tr>
				<th id="content1">내용</th>
				<td><textarea name="content" id="content" required class="full"></textarea></td>
			</tr>
		</table>
		<div class="btn1">
			<button type="button" class="back" onclick="location.href='/apa/community/list.do';">돌아가기</button>
			<button type="submit" class="add" onclick="add();">글쓰기</button>
		</div>
		
		
		
		
</div>
</main>

<script>
function add(){
	
	let obj ={
		userseq: <sec:authentication property="principal.dto1.userseq"/>,
		communitytitle: $('input[name=subject]').val(),
		communitycontent: $('textarea[name=content]').val()
	};
	//alert(JSON.stringify(obj));
	$.ajax({
		type: 'POST',
		url: '/apa/community/add',
		headers: {'Content-Type':'application/json'},
		beforeSend : function(xhr) {
			xhr.setRequestHeader('${_csrf.headerName}', '${_csrf.token}');
		},
		data: JSON.stringify(obj),
		dataType: 'json',
		success: result => {
			//alert(result);
			if(result == 1){
				location.href = '/apa/community/list.do';
			} else {
				alert('failed');
			}
		},
		error: (a,b,c) => {
			console.log(a,b,c);
		}
	});
}
</script>

