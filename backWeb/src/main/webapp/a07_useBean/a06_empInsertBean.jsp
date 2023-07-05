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
    	<h2>사원정보 등록</h2>
    	<form action="" method="post">
            <input type="number" class="form-control" 
      	     id="empno" placeholder="사원번호 입력" name="empno">
            <input type="text" class="form-control" 
      	     id="ename" placeholder="사원명 입력" name="ename">
            <input type="text" class="form-control" 
      	     id="job" placeholder="직책 입력" name="job">
            <input type="number" class="form-control" 
      	     id="mgr" placeholder="관리자번호 입력" name="mgr">
            <input type="date" class="form-control" 
      	     id="hiredateS" placeholder="입사일 입력" name="hiredateS">
            <input type="number" class="form-control" 
      	     id="sal" placeholder="급여 입력" name="sal">
            <input type="number" class="form-control" 
      	     id="comm" placeholder="보너스 입력" name="comm">
            <input type="number" class="form-control" 
      	     id="deptno" placeholder="부서번호 입력" name="deptno">
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>사원번호</th>
				    <th>사원명</th>
				    <th>직책</th>
				    <th>관리자번호</th>
				    <th>입사일</th>
				    <th>급여</th>
				    <th>보너스</th>
				    <th>부서번호</th>
		      	</tr>
		    </thead>
		    <jsp:useBean id="dao" class="backWeb.a01_dao.A04_PreParedDao"></jsp:useBean>
		    <jsp:useBean id="emp" class="backWeb.z01_vo.Emp"></jsp:useBean>
		    <jsp:useBean id="list" class="java.util.ArrayList" scope="session"></jsp:useBean>
     		<jsp:setProperty property="*" name="emp"/>
			<c:if test="${not empty emp.empno}">
				${dao.insertEmp(emp) }
			</c:if>
		    <tbody>
		    	<c:forEach var="emp" items="${dao.elist() }">
			   	<tr  class="text-center">
			        <td>${emp.empno}</td>
			        <td>${emp.ename}</td>
			        <td>${emp.job}</td>
			        <td>${emp.mgr}</td>
			        <td>${emp.hiredateS}</td>
			        <td><fmt:formatNumber value=" ${emp.sal}"></fmt:formatNumber></td>
			        <td>${emp.comm}</td>
			        <td>${emp.deptno}</td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>