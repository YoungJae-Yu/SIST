<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Person"%>
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
# 조별 토론 및 실습과제
[1단계:개념확인] 1. 조별로 el 태를 활용한 session scope범위와 실제 코드에 대하여 알고 있는지 확인
            ajax를 처리하기 위해 필요한 기본 형식과 기본 데이터와 json데이터 가져오는 처리형식을 아는지 확인
[1단계:코드] 2. el 태그를 이용하여 4가지 session scope의 범위를 기본 변수로 설정하여 호출해보자.--%>
<%
	pageContext.setAttribute("name","홍길동");
	request.setAttribute("age",30);
	session.setAttribute("loc","서울");
	application.setAttribute("email","aa@naver.com");
%>
<body>
	<h2>page:${name}</h2>
	<h2>request:${age}</h2>
	<h2>session:${loc}</h2>
	<h2>application:${email}</h2>
</body>
<%--
[1단계:코드] 3. el을 이용하여 클래스 Person을 객체로 session scope로 설정하고 호출해 보자. --%>
<%
	session.setAttribute("p01", new Person("홍길동",30,"서울"));
%>
<body>
   	<h3>이름:${p01.age}</h3>
   	<h3>나이:${p01.age}</h3>
   	<h3>사는곳:${p01.loc}</h3>
</body>
<%-- 
[1단계:코드] 4. el을 이용하여 form으로 물품명과 가격과 갯수을 입력해서 해당 내용을 출력처리하자.--%>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="name">물품명:</label>
            <input type="text" class="form-control" 
      	     id="name" placeholder="물품명 입력" name="name">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="price">가격:</label>
            <input type="number" class="form-control" 
      	     id="price" placeholder="가격 입력" name="price">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="cnt">갯수:</label>
            <input type="number" class="form-control" 
      	     id="cnt" placeholder="갯수 입력" name="cnt">
         	</div>
         	<button type="submit" class="btn btn-primary">구매</button>
     		<h2>물품명:${param.name}</h2>
     		<h2>물건총금액:${param.price*param.cnt}</h2>
     	</form>
<%-- 
[1단계:코드] 5. ajax처리 순서를 기술하고, 서버에 선언된 데이터(하나데이터,배열데이터, json 데이터)를
 				동기적으로 가져오는 처리를 하여 화면에 할당하세요.
 				ajax 처리순서 : 
 				1) XMLHttpRequest 객체 생성
 				2) 옵션 설정 xhr.open
 				3) 전송처리 xhr.send()
 				4) 서버에서 해당 자원을 전송해주는 데이터를 받는 속성 xhr.responseText
 				5) 비동기식일 때, 처리하는 이벤트 및 이벤트 핸들러 함수
 					xhr.onreadyStatechange=function(){
 						xhr.readyState
 						xhr.status
 					}
--%>		
<script type="text/javascript">
	// 단일데이터
	function ajaxExp1(){
		var xhr = new XMLHttpRequest()
		xhr.open("get","Exp_data.jsp",false);
		xhr.send()
 		document.querySelector("#show").innerText=xhr.responseText
	}	
	// 배열데이터
	function ajaxExp2(){
		var xhr = new XMLHttpRequest()
		xhr.open("get","Exp_data.jsp",false);
		xhr.send()
 		var arry = xhr.responseText.split(",")
 		var h4Obj = document.querySelectorAll("h4")
 		arry.forEach(function(prod,idx){
 			h4Obj[idx].innerText = prod
 		})
 	}
	//json데이터
	function ajaxExp3(){
		var xhr = new XMLHttpRequest()
		xhr.open("get","Exp_data_jaon.jsp",false);
		xhr.send()
 		var data = xhr.responseText
 		var obj = JSON.parse(data)
 		var h5Obj = document.querySelectorAll("h5")
 		h5Obj[0].innerText = obj.name
 	}
</script>
<body>
	<h2 onclick="ajaxExp1()">단일 데이터</h2>
	<h3 id="show"></h3>
	<h2 onclick="ajaxExp2()">배열 데이터</h2>
	<h4></h4>
	<h4></h4>
	<h4></h4>
	<h2 onclick="ajaxExp3()">json데이터</h2>
	<h5></h5>
</body>

</html>



















