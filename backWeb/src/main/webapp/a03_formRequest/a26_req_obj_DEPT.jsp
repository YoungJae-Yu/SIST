<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Dept"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
	<%--
	ex) 부서정보를 입력받아서 처리하여 VO객체에 할당하고,
		getXXX()로 로그를 출력하세요
	 --%>
	 <%
	 String deptnoS = request.getParameter("deptno");
	 String dname = request.getParameter("dname");
	 String loc = request.getParameter("loc");
	 if(deptnoS!=null){
		 int deptno = Integer.parseInt(deptnoS);
		 Dept d = new Dept(deptno,dname,loc);
		 log("# 부서등록 VO로 성공#");
		 log("부서번호:"+d.getDeptno());
		 log("부서명:"+d.getDname());
		 log("부서위치:"+d.getLoc());
	 }
	 
	 %>
    <div class="container mt-3">
    	<h2>부서정보 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="deptno">부서번호:</label>
            <input type="number" class="form-control" 
      	     id="deptno" placeholder="부서번호 입력" name="deptno">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="dname">부서명:</label>
            <input type="text" class="form-control" 
      	     id="dname" placeholder="부서명 입력" name="dname">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="loc">부서위치:</label>
            <input type="text" class="form-control" 
      	     id="loc" placeholder="부서위치 입력" name="loc">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		  	
    </div>
</body>
</html>