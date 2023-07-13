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
    		var proc= "${proc}"
    		if(proc=="ins"){
    			if(confirm("등록 성공\n조회화면 이동하시겠습니까?")){
    				location.href="${path}/empList.do";
    			}
    		}
    		//$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
		<form method="post">
		  <div class="mb-3 mt-3">
		    <label for="empno" class="form-label">empno:</label>
		    <input type="number" class="form-control" id="empno" placeholder="Enter empno" name="empno">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="ename" class="form-label">ename:</label>
		    <input type="text" class="form-control" id="ename" placeholder="Enter ename" name="ename">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="job" class="form-label">job:</label>
		    <input type="text" class="form-control" id="job" placeholder="Enter job" name="job">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="mgr" class="form-label">mgr:</label>
		    <input type="number" class="form-control" id="mgr" placeholder="Enter mgr" name="mgr">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="hiredateS" class="form-label">hiredate:</label>
		    <input type="date" class="form-control" id="hiredateS" placeholder="Enter hiredate" name="hiredateS">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="sal" class="form-label">sal:</label>
		    <input type="number" class="form-control" id="sal" placeholder="Enter sal" name="sal">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="comm" class="form-label">comm:</label>
		    <input type="number" class="form-control" id="comm" placeholder="Enter comm" name="comm">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="deptno" class="form-label">deptno:</label>
		    <input type="number" class="form-control" id="deptno" placeholder="Enter deptno" name="deptno">
		  </div>
		  <button type="submit" class="btn btn-success">등록</button>
		  <button type="button"
		  	 id="goMain"		 
		  	 class="btn btn-info">메인화면</button>
		</form>
		   <script type="text/javascript">
		   	$("#goMain").click(function(){
		   		location.href="${path}/empList.do"
		   	})
		   </script>
    </div>
</body>
</html>