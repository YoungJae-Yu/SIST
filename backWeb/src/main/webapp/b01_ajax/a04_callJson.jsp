<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<%--
# 서버의 json 데이터 가져오기
1. 일반적으로 json 형식의 서버에서 가져오는 경우가 많다.
2. json 형식
	{"key",value}
	key는 ""사이에
	value는 문자열일 때는""사이에, 숫자는 바로
3. 처리형식
	1) 메인 페이지 : XMLHttpRequest객체로 코드 처리
	2) 데이터 처리페이지 : {"key",value 형식 선언}
	3) 이벤트에 의해 호출
		- json형식으로 변경
			- eval("("+xhr.responseText+")")
			- JSON.parse(xhr.responseText)
		- 객체로 특정 DOM에 할당한다.
 --%>
 <script type="text/javascript">
 	function call(){
 		var xhr = new XMLHttpRequest();
 		xhr.open("get","z04_jsonData.jsp",false);
 		xhr.send();
 		var data = xhr.responseText;
 		console.log(typeof data)
 		var obj = JSON.parse(data) // 문자열을 json 객체로 변환
 		console.log(typeof obj)
 		var tds = document.querySelectorAll("tbody td")
 		tds[0].innerText = obj.name
 		tds[1].innerText = obj.price
 		tds[2].innerText = obj.cnt
 	}
 	// z05_json.jsp 회원정보 json 데이터 선언.
 	// a05_memberInfo.jsp 회원정보 가져오기 클릭시,
 	// 테이블에 선언된 회원정보 가져와서 출력
 
 </script>
<body>
    <div class="container mt-3">
    	<h2>json 데이터 호출 등록</h2>
    	<form action="" method="post">
         	<button type="button"onclick="call()" class="btn btn-primary">json데이터 호출</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>물건명</th>
				    <th>가격</th>
				    <th>갯수</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>