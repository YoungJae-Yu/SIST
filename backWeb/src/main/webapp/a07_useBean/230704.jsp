<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
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
<%--
[확인과제]
[개념] 1. useBean 기본 속성을 정리하고, 활용방법을 예시를 통해서 정리하세요
	-기본속성-
 	id : jsp 페이지에서 자바빈 객체에 접근할 때 사용할 이름
 	class : 패키지 이름을 포함한 자바빈 클래스의 완전한 이름
 	scope : 자바빈 객체가 저장될 영역을 지정 page, request, session, application
 	- 예시 - 
 	물건 vo를 활용해서 객체 생성 및 속성 설정하고, el로 출력하기
 	<jsp:useBean  id="prod" class = "물건vo" scope="session"/>
 	<jsp:setProperty property="name" name="prod" value="사과"/>
 	${prod.setPrice(5000) }
 	<h3>물건명:${prod.name }</h3>
    <h3>가격:${prod.price }</h3

[확인] 2 useBean을 이용하여 구구단 수학문제를 입력(사칙연산혼합)하고 등록리스트를 출력하게 하세요
	    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <input type="text" class="form-control" 
      	     id="gugu" placeholder="구구단 수학문제를 입력(사칙연산혼합)" name="gugu">
            <input type="number" class="form-control" 
      	     id="guguCor" placeholder="정답 입력" name="guguCor">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
     	<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>문제</th>
				    <th>답</th>
		      	</tr>
		    </thead>
		    <jsp:useBean id="gu" class="backWeb.z01_vo.gugu"></jsp:useBean>
     		<jsp:setProperty property="*" name="gu"/>
		    <tbody>
			   	<tr  class="text-center">
			        <td>${gu.gugu}</td>
			        <td>${gu.guguCor}</td>
			   	</tr>
		 	</tbody>
		</table>

[확인] 3 useBean을 이용하여 id, pass입력하여 인증여부를 Dao에서 확인하세요(A05_MemberDao.java)
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <input type="text" class="form-control" 
      	     id="id" placeholder="아이디" name="id">
            <input type="password" class="form-control" 
      	     id="pass" placeholder="비밀번호" name="pass">
         	</div>
         	<button type="submit" class="btn btn-primary">로그인</button>
     	</form>
		     <jsp:useBean id="dao" class="backWeb.a01_dao.A05_MemberDao"></jsp:useBean>
		    <jsp:useBean id="mem" class="backWeb.z01_vo.Member"></jsp:useBean>
		    <jsp:setProperty property="*" name="login"/>
		<c:if test="${mem.id}">
		    <h2>회원인증완료</h2>
		</c:if>
		<c:if test="${not mem.id}">
		    <h2>인증불가</h2>
		</c:if>
     	
[확인] 4 useBean을 이용하여 insertDepartments메서드로 등록하고 출력하세요(A04_PreparedDao.java)
    	<h2>부서정보 등록</h2>
    	<form action="" method="post">
            <input type="number" class="form-control" 
      	     id="department_id" placeholder="부서아이디 입력" name="department_id">
            <input type="text" class="form-control" 
      	     id="department_name" placeholder="부서이름 입력" name="department_name">
            <input type="number" class="form-control" 
      	     id="manager_id" placeholder="매니저아이디 입력" name="manager_id">
            <input type="number" class="form-control" 
      	     id="location_id" placeholder="지역아이디 입력" name="location_id">
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>부서아이디</th>
				    <th>부서이름</th>
				    <th>매니저아이디</th>
				    <th>지역아이디</th>
		      	</tr>
		    </thead>
		    <jsp:useBean id="dao" class="backWeb.a01_dao.A04_PreParedDao"></jsp:useBean>
		    <jsp:useBean id="dept" class="backWeb.z01_vo.Departments"></jsp:useBean>
		    <jsp:useBean id="list" class="java.util.ArrayList" scope="session"></jsp:useBean>
     		<jsp:setProperty property="*" name="dept"/>
			<c:if test="${not empty dept.department_id }">
				${dao.insertDepartments(dept) }
			</c:if>
		    <tbody>
			   	<tr  class="text-center">
			        <td>${param.department_id}</td>
			        <td>${param.department_name}</td>
			        <td>${param.manager_id}</td>
			        <td>${param.location_id}</td>
			   	</tr>
		 	</tbody>
		</table>  
 --%>
<body>
    <div class="container mt-3">
    	<h2>부서정보 등록</h2>
    	<form action="" method="post">
            <input type="number" class="form-control" 
      	     id="department_id" placeholder="부서아이디 입력" name="department_id">
            <input type="text" class="form-control" 
      	     id="department_name" placeholder="부서이름 입력" name="department_name">
            <input type="number" class="form-control" 
      	     id="manager_id" placeholder="매니저아이디 입력" name="manager_id">
            <input type="number" class="form-control" 
      	     id="location_id" placeholder="지역아이디 입력" name="location_id">
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>부서아이디</th>
				    <th>부서이름</th>
				    <th>매니저아이디</th>
				    <th>지역아이디</th>
		      	</tr>
		    </thead>
		    <jsp:useBean id="dao" class="backWeb.a01_dao.A04_PreParedDao"></jsp:useBean>
		    <jsp:useBean id="dept" class="backWeb.z01_vo.Departments"></jsp:useBean>
		    <jsp:useBean id="list" class="java.util.ArrayList" scope="session"></jsp:useBean>
     		<jsp:setProperty property="*" name="dept"/>
			<c:if test="${not empty dept.department_id }">
				${dao.insertDepartments(dept) }
			</c:if>
		    <tbody>
			   	<tr  class="text-center">
			        <td>${param.department_id}</td>
			        <td>${param.department_name}</td>
			        <td>${param.manager_id}</td>
			        <td>${param.location_id}</td>
			   	</tr>
		 	</tbody>
		</table>       	
    </div>
</body>
</html>