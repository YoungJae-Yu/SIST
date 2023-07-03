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
    		
    		$("h2").text("사원정보(MVC)")
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2></h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="ename" placeholder="사원명 입력" value="${param.ename}" name="ename"  aria-label="Search">
	            <input type="text" class="form-control me-2" 
	      	     id="job" placeholder="직책명 입력"  value="${param.job}"  name="job"  aria-label="Search">
	         	<button type="submit" class="btn btn-primary" style="width:200px;">조회</button>
	     	</form>
	 	    </div>
	 	</nav>	    	
     	
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>사원번호</th>
				    <th>사원명</th>
				    <th>직책명</th>
				    <th>관리자번호</th>
				    <th>입사일</th>
				    <th>급여</th>
				    <th>보너스</th>
				    <th>부서번호</th>
		      	</tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="emp" items="${empList}">
			   	<tr  class="text-center">
			        <td>${emp.empno}</td>
			        <td>${emp.ename}</td>
			        <td>${emp.job}</td>
			        <td>${emp.mgr}</td>
			        <td>${emp.hiredate}</td>
			        <td>${emp.sal}</td>
			        <td>${emp.comm}</td>
			        <td>${emp.deptno}</td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		</table>  
	    	
    </div>
</body>
</html>