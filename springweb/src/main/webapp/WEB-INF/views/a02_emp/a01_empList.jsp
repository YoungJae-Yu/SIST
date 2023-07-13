<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<c:set var="path" 
	value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	.btn{width:200px;}
    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   	
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	$(document).ready( function(){
 	    	$("#regBtn").click(function(){
 	    		location.href="${path}/empInsert.do"
 	    	})
    	});
    </script>      
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 조회</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="ename" placeholder="사원명 입력" value="${emp.ename}" name="ename" aria-label="Search">
	            <input type="text" class="form-control me-2" 
	      	     id="job" placeholder="직책명 입력" value="${emp.job}" name="job"  aria-label="Search">

	      	    <%--
	      	    <style type="text/css">
			    	.btn{width:200px;}
			    </style>
	      	     --%> 
	         	<button type="submit" class="btn btn-primary" >조회</button>
	         	<button id="regBtn" type="button" 
	         		class="btn btn-success" >등록</button>
	     	</form>
	 	    </div>
	 	    <script type="text/javascript">

	 	    </script>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>사원번호</th>
				    <th>사원명</th>
				    <th>직책명</th>
				    <th>급여</th>
				    <th>부서번호</th>
		      	</tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="emp" items="${empList}">
			   	<tr ondblclick="goPage(${emp.empno})" class="text-center">
			        <td>${emp.empno}</td>
			        <td>${emp.ename}</td>
			        <td>${emp.job}</td>
			        <td>${emp.sal}</td>
			        <td>${emp.deptno}</td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		</table>      	
		<script type="text/javascript">
			function goPage(empno){
				location.href="${path}/empDetail.do?empno="+empno
			}
		</script>
    </div>
</body>
</html>