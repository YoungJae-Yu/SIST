<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<%
	// <jsp:param name="ename" value="himan"/>
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");

%>
<body>
    	<form action="a01_basic.jsp" method="post">
    	
         	<div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
      	     id="ename" value="<%=ename%>" 
      	     placeholder="사원명 입력" name="ename">
         	</div>
         	
         	<div class="mb-3 mt-3">
            <label for="job">직책:</label>
            <input type="text" class="form-control" 
      	     id="job" value="<%=job%>" 
      	     placeholder="직책 입력" name="job">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>    
    </body>
</html>