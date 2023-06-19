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
<body>

    <div class="container mt-3">
    <h2>부서정보 등록</h2>
    <form action="a15_showDept.jsp">
         <div class="mb-3 mt-3">
            <label for="deptno">부서번호:</label>
            <input type="number" class="form-control" 
              id="deptno" placeholder="부서번호 입력" name="deptno">
         </div>
         
       <div class="mb-3 mt-3">
      <label for="dname">부서명:</label>
      <select class="form-control" id="dname"name="dname">
      <option>=부서명 선택=</option>
      <option>ACCOUNTING</option>
      <option>RESEARCH</option>
      <option>SALES</option>
      <option>OPERATIONS</option>
      </select>
      
       <div class="mb-3 mt-3">
      <label for="loc">부서지역:</label>
      <select class="form-control" id="loc"name="loc">
      <option>=부서지역 선택=</option>
      <option>NEW YORK</option>
      <option>DALLAS</option>
      <option>CHICAGO</option>
      <option>BOSTON</option>
      </select>
         <button type="submit" class="btn btn-primary">등록</button>
     </form>
  </div>


</body>
</html>