<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />


<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="http://pinnpublic.dothome.co.kr/cdn/example-min.js"></script>

<title>Address</title>
</head>
<body>
	<div class="list full"></div>

	<script>
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8090/apa/test',
			dataType: 'json',
			success: list => {
				$(list).each((index, item) => {
					let gender = item.gender == 'm' ? 'male' : 'female';
					
					$('.list').append(`
						<div class="item" onclick="view(\${item.seq});">
						<div class="name">
							\${item.name}
							<span class="material-symbols-outlined \${gender}">\${gender}</span>
						</div>
						<div class="address">\${item.address}</div>
					`);
				});
			},
			error: (a, b, c) => {
				console.log(a, b, c);
			}
		});
	</script>
</body>
</html>