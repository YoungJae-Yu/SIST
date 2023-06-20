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
<%--
# form형식의 post 방식 전송
1. 서버에 요청값을 전송할 때,
2. url에 요청값을 보이지 않고,
	데이터를 http요청의 본문에 포함시켜 전송하여
	url에 데이터가 노출되지 않고, 요청을 통해 전송하기 떄문에
	데이터를 노출시키지 않는 안정성이 있다.
3. 많은 데이터를 전송할 때, 사용하는 방식이다.
	get방식(데이터 길이 제한)과 달리 데이터의 길이 제한 없다.
	즉, http 요청의 본문에 데이터를 포함시키기 때문이다.
	대용량의 데이터를 전송할 수 있다.
	
4. 주요 처리내용
	1) <form method = "post"
		ps) method방식을 설정하지 않을 때는 get방식으로 처리된다.
	2) 받는 페이지
		한글 encoding 처리 : request.setCharacterEncoding("key")
		

 --%>
    <div class="container mt-3">
    <h2>사원정보 등록(post방식)</h2>
    <form action="a17_post_rev.jsp" method="post">
         <div class="mb-3 mt-3">
            <label for="empno">사원번호:</label>
            <input type="number" class="form-control" 
              id="empno" placeholder="사원번호 입력" name="empno">
         </div>
                  <div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
              id="ename" placeholder="사원명 입력" name="ename">
         </div>
         <button type="submit" class="btn btn-primary">등록</button>
     </form>
  </div>
<%--
a17_post.jsp
==> a18_rev.jsp
이름:				이름   국어   영어   수학   총계   평균
[    ]			   @@  @@  @@  @@  @@  @@
국어:

영어
수학
[성적등록]

 --%>

</body>
</html>