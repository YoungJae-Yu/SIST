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
<body>
    <div class="container mt-3">
    	<h2>부서정보</h2>
    	<form action="" method="post">

            
            <input type="number" class="form-control" 
      	     id="deptno" placeholder="부서번호 입력" name="deptno">
            <input type="text" class="form-control" 
      	     id="dname" placeholder="부서이름 입력" name="dname">
            <input type="text" class="form-control" 
      	     id="loc" placeholder="근무지역 입력" name="loc">
         	<button type="submit" class="btn btn-primary">조회</button>
     	</form>
     	<%--
     	deptno=10&dname=인사&loc=서울
     	setDeptno(int deptno)
     	setDname(String name)
     	setLoc(String loc)
     	 --%>
     	<jsp:useBean id="dept" class="backWeb.z01_vo.Dept"></jsp:useBean>
     	<jsp:setProperty property="*" name="dept"/>
     	<%-- 요청값을 자동할당 --%>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>부서번호</th>
				    <th>부서이름</th>
				    <th>근무지역</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td>${dept.deptno}</td>
			        <td>${dept.dname}</td>
			        <td>${dept.loc}</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>