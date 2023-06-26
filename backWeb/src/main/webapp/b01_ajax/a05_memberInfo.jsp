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
 <script type="text/javascript">
 	function call(){
 		var xhr = new XMLHttpRequest();
 		xhr.open("get","z05_json.jsp",false);
 		xhr.send();
 		var data = xhr.responseText;
 		console.log(typeof data)
 		var obj = JSON.parse(data)
 		console.log(typeof obj)
 		var tds = document.querySelectorAll("tbody td")
 		tds[0].innerText = obj.name
 		tds[1].innerText = obj.age
 		tds[2].innerText = obj.loc
 	}
 	// z05_json.jsp 회원정보 json 데이터 선언.
 	// a05_memberInfo.jsp 회원정보 가져오기 클릭시,
 	// 테이블에 선언된 회원정보 가져와서 출력
 
 </script>
<body>
    <div class="container mt-3">
    	<h2>회원정보</h2>
    	<form action="" method="post">
         	<button type="button"onclick="call()" class="btn btn-primary">json데이터 호출</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>이름</th>
				    <th>나이</th>
				    <th>사는곳</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td></td>
			        <td></td>
			        <td></td>
			   	</tr>
		 	</tbody>
		</table>
		</table>      	
    </div>
</body>
</html>