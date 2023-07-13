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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		//$("h2").text("jquery 로딩 성공")
    		var proc = "${proc}"
    		if(proc=="upt"){
    			if(confirm("수정완료\n조회화면으로 이동하시겠습니까?")){
    				location.href="${path}/empList.do"
    			}
    		}
    		if(proc=="del"){
    			alert("삭제완료\n조회화면으로 이동하겠습니다.")
    			location.href="${path}/empList.do"
    			
    		}  		
    		
    		
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 상세</h2>
		<form method="post">
		  <div class="mb-3 mt-3">
		    <label for="empno" class="form-label">empno:</label>
		    <input type="number" value="${emp.empno}" class="form-control" id="empno" placeholder="Enter empno" name="empno">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="ename" class="form-label">ename:</label>
		    <input type="text" value="${emp.ename}"  class="form-control" id="ename" placeholder="Enter ename" name="ename">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="job" class="form-label">job:</label>
		    <input type="text" value="${emp.job}"   class="form-control" id="job" placeholder="Enter job" name="job">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="mgr" class="form-label">mgr:</label>
		    <input type="number" value="${emp.mgr}"  class="form-control" id="mgr" placeholder="Enter mgr" name="mgr">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="hiredateS" class="form-label">hiredate:</label>
		    <input type="text" value="${emp.hiredate}"  class="form-control" id="hiredateS" placeholder="Enter hiredate" name="hiredateS">
		   
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="sal" class="form-label">sal:</label>
		    <input type="number" value="${emp.sal}"   class="form-control" id="sal" placeholder="Enter sal" name="sal">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="comm" class="form-label">comm:</label>
		    <input type="number" value="${emp.comm}"   class="form-control" id="comm" placeholder="Enter comm" name="comm">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="deptno" class="form-label">deptno:</label>
		    <input type="number" value="${emp.deptno}"  class="form-control" id="deptno" placeholder="Enter deptno" name="deptno">
		  </div>
		  <button id="uptBtn" type="button" class="btn btn-warning">수정</button>
		  <button id="delBtn" type="button" class="btn btn-danger">삭제</button>
		  <button type="button"
		  	 id="goMain"		 
		  	 class="btn btn-info">메인화면</button>
		</form>
		<script type="text/javascript">
		 	$("#goMain").click(function(){
		   		location.href="${path}/empList.do"
		   	})
		 	$("#uptBtn").click(function(){
		   		$("form").attr("action","${path}/empUpdate.do")
		   		$("form").submit()
		   	})
		 	$("#delBtn").click(function(){
		 		if( confirm("삭제 하시겠습니까?") ){
		 			$("form").attr("action","${path}/empDelete.do")
		 			$("form").submit()
		 		}
		   	})
		   	
		   	
		</script>	
    </div>
</body>
</html>