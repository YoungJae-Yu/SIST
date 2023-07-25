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
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		$("#job_id, #job_title").keyup(function(){
    			
    			//alert( $("form").serialize() )
    			$.ajax({
    				type:"post",
    				url:"${path}/jobListData2.do",
    				data:$("form").serialize(),
    				dataType:"json",
    				success:function(jobs){
    					console.log(jobs)
    					var add = ""
        					jobs.forEach(function(job){
        						console.log(job)
        						add+="<tr  class='text-center'>"
        						add+="<td>"+job.job_id+"</td>"
        						add+="<td>"+job.job_title+"</td>"
        						add+="<td>"+job.min_salary.toLocaleString()+"</td>"
        						add+="<td>"+job.max_salary.toLocaleString()+"</td>"
        						add+="</tr>"
        					})
        					$("#show").html(add);
    				},
    				error:function(err){
    					console.log(err)
    				}
    			})
    			
    		})
    		//$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>

    <div class="container mt-3">
    	<h2>ajax로 화면 처리!!!@@@</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="job_id" placeholder="직책아이디 입력" name="job_id"  aria-label="Search">
	            <input type="text" class="form-control me-2" 
	      	     id="job_title" placeholder="직책명 입력" name="job_title"  aria-label="Search">

	         	<button type="button" class="btn btn-primary" style="width:200px;">조회</button>
	     	</form>
	 	    </div>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>직책아이디</th>
				    <th>직책명</th>
				    <th>최소급여</th>
				    <th>최대급여</th>
		      	</tr>
		    </thead>
		    <tbody id="show">
			   	
		 	</tbody>
		</table>      	
    </div>
</body>
</html>