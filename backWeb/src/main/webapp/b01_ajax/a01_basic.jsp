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
# ajax(asynchronized javascript)
1. 비동기적으로 서버와의 통신을 javascript로 처리하여 화면 전환없이
	데이터를 받아와서 처리하는 방식을 말한다.
2. 동기방식과 비동기 방식
	1) 동기 : 서버와 클라이언트가 같은 속도로 연계하는 것을 말한다.
		- 편지를 우체통에 넣고 답장 올 때까지 기다리고 오면 다른
		일을 하는 것을 말한다.
		- 웹 화면에서 는 form 데이터를 입력하고, submit후 다시
		화면이 전환되면 서버에서 만들어진 화면을 사용하는 경우
		- 파일 업로드시, 파일을 서버에 다 올려서 해당 파일 정보와
		실제 파일이 있을 때, 다운로드 하거나 이미지를 볼 수 있게
		하는 것 등..
	2) 비동기 : 서버와 클라이언트가 같은 속도로 연계하지 않음
		- 편지를 우체통에 넣기만하고 다른 일을 하다가 오면 처리하는 것을
		- 검색처리하고, 다른 기능을 처리하면서 검색이 완료되었을 때,
			화면에 로딩되어 보이기 하는 것을 말한다.
		- 비동기식으로 처리하면 해당 비동기 처리 과정의 이벤트 처리와
			이에 맞는 이벤트 핸들러 함수를 선언하여야 한다.
3. 주요 핵심 코드
	1) XMLHttpRequest
		화면 전환없이 서버에 있는 자원들을 가지고 오는 js 내장 객체
		(동기/비동기 기능)
		var xhr = new XMLHttpRequest()
	2) 옵션 설정 메서드
		xhr.open("get/post방식","서버의자원",동기/비동기여부 bool)
	3) 전송처리 메서드
		xhr.send()
	4) 서버에서 해당 자원을 전송해주는 데이터를 받는 속성
		xhr.responseText
	5) 비동기식일 때, 처리하는 이벤트 및 이벤트 핸들러 함수
		xhr.onreadyStatechange=function(){
			xhr.readyState : 서버와 토인을 단계별로 코드값을 가져온다
				0 : 객체를 만든다
				1, 2 : 서버에서 데이터를 받을 준비
				3 : 서버에서 데이터를 일부 받음
				4 : 서버에서 데이터를 모두 받음
			xhr.status : http응답 코드 200~299(정상적으로 받음)
				일반적으로 200으로 설정 안에서 정상적으로 다
				데이터가 있을 때, 처리한다.
		}
 --%>
 <script type="text/javascript">
 	function goAjax(){
 		var xhr = new XMLHttpRequest()
 		//alert(xhr)//객체 생성 확인
 		xhr.open("get","z01_data.jsp",false);//동기방식
 		xhr.send()
 		document.querySelector("#show").innerText=
 			xhr.responseText
 	}
 	//ex) a02_callData.jsp  클릭시 호출해서 테이블에 데이터 넣기
 	//z02_data.jsp 물건명 가격 갯수 선언
 </script>
<body>
    <div class="container mt-3">
    	<h2 onclick="goAjax()">XMLHttpRequest 통신의 나라로(클릭)</h2>
    	<h3 id="show"></h3>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="empno">사원번호:</label>
            <input type="number" class="form-control" 
      	     id="empno" placeholder="사원번호 입력" name="empno">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
      	     id="ename" placeholder="사원명 입력" name="ename">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
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