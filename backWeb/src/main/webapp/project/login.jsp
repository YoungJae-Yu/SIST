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
    	<h2>이메일 로그인</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="empno">이메일:</label>
            <input type="number" class="form-control" 
      	     id="empno" placeholder="이메일을 입력해주세요" name="empno">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">비밀번호:</label>
            <input type="text" class="form-control" 
      	     id="ename" placeholder="비밀번호를 입력해주세요" name="ename">
         	</div>
         	<button type="submit" class="btn btn-primary">로그인</button>
     	</form>  	
    </div>
</body>
</html>