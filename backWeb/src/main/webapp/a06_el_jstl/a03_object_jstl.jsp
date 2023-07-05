<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Person"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<%--
# jstl 객체 선언과 사용
1. jstl에서는 기본적으로 mvc에서 넘겨온 vo객체를 el태그형태로 사용한는
	것이 일반적이다.
		1) controller단
			request.getAttribute("p01", dao.getPerson());
		2) view단(session범위로 변수 설정)
			<c:set var="person" value="${p01}" scope="session"/>
			${p01.name} property로 호출 처리(request범위)
			${person.name} property로 호출 처리(session범위)
		3) 데이터 변경 처리..	
			<c:set target="person" property="age" value="30"/>
			${person.age}
		
2. 하지만, script를 통해서 객체를 선언하고 property를 통해 데이터를
	할당하여 처리하는 방법도 사용된다.

 --%>
 <%
 // controller단 설정가정
 	request.setAttribute("p01", new Person("홍길동",25,"서울"));
 %>
<html>
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
    	<%--
    	jsp scope와 함께 변수를 설정
    	page|request|session|application
    	1. MVC
    		controller request .setAttribute
    		requset범위로 설정된다.
    	--%>
    	<h3>request범위 p01:${p01.name}</h3>
    	<%--
    	2. request범위 Person객체를 session로 이름을 변경해서 할당.
    	 --%>
    	<c:set var="person" value="${p01}" scope="session"/>
    	<h3>session범위 person:${person.name}</h3>
    	<h3>session범위 person:${person.age}</h3>
    	<%--
    	3. 속성 변경
    		1) 주의 property get/setXXX
    			person.setAge(21);
    				person.getAge(21);
    	 --%>
    	<c:set target="${person}" property="age" value="21" />
    	<h3>session범위 변경된 age:${person.age}</h3>
    	<h3>request범위 변경된 age:${p01.age}</h3>
    	<%-- ex) a04_object.jsp 
    		Product를 클래스 prod로 request로 설정하고,
    		session범위로 prodSess로 처리하여 호출하세요.
    		물건가격 변경 처리..
    	--%>
    	
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
		      	<tr  class="text-center">
				    <th>Firstname</th>
				    <th>Lastname</th>
				    <th>Email</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>