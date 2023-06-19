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
    <h2>회원 등록</h2>
    <form action="z03_exp.jsp">
         <div class="mb-3 mt-3">
            <label for="name">이름:</label>
            <input type="text" class="form-control" 
              id="name" placeholder="이름 입력" name="name">
         </div>
       <div class="mb-3 mt-3">
      <label for="gender">성별:</label>
      <select class="form-control" id="gender"name="gender">
      <option>=성별 선택=</option>
      <option>남</option>
      <option>여</option>
      </select>
         <div class="mb-3 mt-3">
            <label for="pNum">휴대폰 번호:</label>
            <input type="number" class="form-control" 
              id="pNum" placeholder="ex) 01012341234" name="pNum">
         </div>      
         <button type="submit" class="btn btn-primary">등록</button>
     </form>
  </div>
</body>
</html>