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
    		
    		$("h2").text("직책검색")
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="title" placeholder="직책ID 입력" value="${param.title}" name="title"  aria-label="Search">
	            <input type="number" class="form-control me-2" 
	      	     id="min_sal1" placeholder="최소급여 최소값"  value="${param.min_sal1}"  name="min_sal1"  aria-label="Search">
	            <input type="number" class="form-control me-2" 
	      	     id="min_sal2" placeholder="최소급여 최대값"  value="${param.min_sal2}"  name="min_sal2"  aria-label="Search">
	         	<button type="submit" class="btn btn-primary" style="width:200px;">조회</button>
	     	</form>
	 	    </div>
	 	</nav>	  
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>직책ID</th>
				    <th>직책명</th>
				    <th>최소급여</th>
				    <th>최대급여</th>
		      	</tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="job" items="${jobList}">
			   	<tr  class="text-center">
			        <td>${job.job_id}</td>
			        <td>${job.job_title}</td>
			        <td>${job.min_salary}</td>
			        <td>${job.max_salary}</td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>