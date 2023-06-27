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
    <%--
    # ajax 단계별 처리
    1. 클라이언트 호출 서버 화면 전송
    2. 클라이언트 호출(요청) 서버 요청값처리 화면 전송
    3. 클라이언트 호출(요청) 서버 요청값처리 DB처리 화면 전송
    
    # 공통 처리
    1. 특정 대상(DOM)에 이벤트 핸들러 함수 선언
    	ex) <button onclick="callAjax()"
    2. 이벤트 핸들러 함수
    	1) ajax로 서버 호출(특정페이지)
    		xhr.open("get","z01_data.jsp",false);
    	
    	2) 서버의 결과값 받기
    		xhr.responseText;
    	3) 서버에서 받은 결과값을 특정 DOM  할당해서 출력.
    	
     --%>
	<script type="text/javascript">
	
		function getSyn(page) {
			var xhr = new XMLHttpRequest();
			xhr.open("get", page, false);
			xhr.send()
			return xhr.responseText;
		}
		function callAjax(){
			// name=오길동&fruit=바나나
			// 입력된값을 할당해서 문자열을 만들면 변경이 된다.
			var name = document.querySelector("#name").value
			var fruit = document.querySelector("#fruit").value
			var show = document.querySelector("#show");
			show.innerHTML =
				getSyn("z01_data.jsp?name="+name+"&fruit="+fruit)
		}
	
	</script>
</head>
<body>
    <div class="container mt-3">
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="name">이름:</label>
            <input type="text" class="form-control" 
      	     id="name" placeholder="이름 입력" name="name">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="fruit">과일:</label>
            <input type="text" class="form-control" 
      	     id="fruit" placeholder="과일 입력" name="fruit">
         	</div>
         	<button onclick="callAjax()" type="button" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>Firstname</th>
				    <th>Lastname</th>
				    <th>Email</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr id="show" class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>