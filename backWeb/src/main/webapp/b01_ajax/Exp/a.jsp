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
# 실습과제
[1단계:개념] 1. ajax처리 순서를 기술하세요(h01_show.jsp vs z11_data.jsp 두 페이지간 기준)
    # ajax 단계별 처리
    1. 클라이언트 호출 서버 화면 전송
    2. 클라이언트 호출(요청) 서버 요청값처리 화면 전송
    3. 클라이언트 호출(요청) 서버 요청값처리 DB처리 화면 전송
    
    # 공통 처리
    1. 특정 대상(DOM)에 이벤트 핸들러 함수 선언
    	ex) <button onclick="callAjax()">
    2. 이벤트 핸들러 함수
    	1) ajax로 서버 호출(특정페이지)
    		xhr.open("get","z11_data.jsp",false);
    	2) 서버의 결과값 받기
    		xhr.responseText;
    	3) 서버에서 받은 결과값을 특정 DOM  할당해서 출력.
    		h01_show.jsp
    		
[1단계:코드] 2. ajax로 [화면호출]로 서버에 있는 <h3>반가워요</h3> 처리
	-- a.jsp --
 	<script type="text/javascript">
		function getSyn(page) {
			var xhr = new XMLHttpRequest();
			xhr.open("get", page, false);
			xhr.send()
			return xhr.responseText;
		}
		function callAjax(){
		 	document.querySelector("#show")
			show.innerHTML = getSyn("a_data.jsp")
		}
	</script>
	<h3  id="show" ></h3>
	<button onclick="callAjax()"type="button">화면호출</button>
	-- a_data.jsp --
	<h3>반가워요</h3>
	
[1단계:코드] 2. ajax로 물건명[  ]가격[   ][전송 및 화면호출]로 서버에 있는 <h3>@@는 @@@원입니다.</h3> 
		-- a.jsp --
	<script type="text/javascript">
		function getSyn(page) {
			var xhr = new XMLHttpRequest();
			xhr.open("get", page, false);
			xhr.send()
			return xhr.responseText;
		}
		function callAjax(){
			var name = document.querySelector("#name").value
			var price = document.querySelector("#price").value
			show.innerHTML = getSyn("a_data.jsp?name="+name+"&price="+price)
		}
	</script>
    	<h2>물건정보</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="name">물건명:</label>
            <input type="text" class="form-control" 
      	     id="name" placeholder="물건명 입력" name="name">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="price">가격:</label>
            <input type="number" class="form-control" 
      	     id="price" placeholder="가격 입력" name="price">
         	</div>
         	<h3 id="show"></h3>
         	<button onclick="callAjax()"type="button">전송 및 화면호출</button>
     	</form>
     	-- a_data.jsp --
     	<h3>${param.name }는 ${param.price }원 입니다.</h3>
     	
[1단계:코드] 2. ajax로 [데이터화면호출]로 서버에 table형식의 화면 호출(DAO - public List<Manager> getManager())
		-- a.jsp --
 	<script type="text/javascript">
		function getSyn(page) {
			var xhr = new XMLHttpRequest();
			xhr.open("get", page, false);
			xhr.send()
			return xhr.responseText;
		}
		function callAjax(){
			document.querySelector("#managerList").innerHTML = getSyn("a_data.jsp");
		}
	</script>
			<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>사원번호</th>
				    <th>사원명</th>
				    <th>부서명</th>
		      	</tr>
		    </thead>
		    <tbody id="managerList">
		 	</tbody>
		</table>
		-- a_data.jsp --
<%
A04_PreParedDao dao = new A04_PreParedDao();
for (Manager m : dao.getManager()) {
%>
<tr class="text-center">
	<td><%=m.getEmpno()%></td>
	<td><%=m.getEname()%></td>
	<td><%=m.getDname()%></td>
<%
}
%>
[1단계:코드] 3. ajax로 id[  ]pass[  ] [로그인]  table형식으로 회원이 없던지 table로 출력

 --%>
 	<script type="text/javascript">
		function getSyn(page) {
			var xhr = new XMLHttpRequest();
			xhr.open("get", page, false);
			xhr.send()
			return xhr.responseText;
		}
		function callAjax(){
			var id = document.querySelector("#id").value
			var pass = document.querySelector("#pass").value
			
			document.querySelector("#login").innerHTML = 
				getSyn("a_data.jsp?id="
					+ id + "&pass=" + pass);
			
		}
	</script>
<body>
    <div class="container mt-3">
    <h3></h3>
    	<h2>로그인</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="id">id:</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="id 입력" name="id">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="pass">pass:</label>
            <input type="password" class="form-control" 
      	     id="pass" placeholder="pass 입력" name="pass">
         	</div>
         	<h3 id="show"></h3>
         	<button onclick="callAjax()" type="button">전송 및 화면호출</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>아이디</th>
				    <th>비밀번호</th>
				    <th>이름</th>
				    <th>포인트</th>
				    <th>권한</th>
		      	</tr>
		    </thead>
		    <tbody id="login">

		 	</tbody>
		</table>      	
    </div>
</body>
</html>