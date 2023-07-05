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
    		$("#deptno").keyup(function(){
    			// enter키 입력시 수행
    			// 백앤드:/backendWeb/dept.do?deptno=20
    			// 1. url:"${path}/dept.do", 요청 url
    			// 2. data:"deptno="+$("#deptno").val(), 요청 값
    			// 3. success:function(dept){ 받는 객체
    			if(event.keyCode == 13){
    				$.ajax({
    					url:"${path}/dept.do",
    					type:"post",
    					data:"deptno="+$("#deptno").val(),
    					dataType:"json", // json 문자열 ==> 객체로 바꾸어준다.
    					success:function(dept){
    						console.log(dept)
    						var add = "<td>"+dept.deptno+"</td>"
    						add += "<td>"+dept.dname+"</td>"
    						add += "<td>"+dept.loc+"</td>"
    						$("#deptInfo").html(add)
    					},
    					error:function(err){
    						console.log(err)
    					}
    				})
    			}
    		})
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>부서정보검색</h2>
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="deptno" placeholder="부서번호 입력" name="deptno">
         	</div>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>부서번호</th>
				    <th>부서명</th>
				    <th>부서위치</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  id="deptInfo" class="text-center">
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>