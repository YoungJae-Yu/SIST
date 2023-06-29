<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.janjan.DAO.*"
    import="project.janjan.VO.*"
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./css/login.css">
    <title>잔잔</title>
</head>
<body>
    <div class="wrap">
        <header>
            <!--gnb-->
            <div class="inner">
                <div class="gnb">
                    <div class="gnbL">
                        <ul>
                            <li><a href="index.html"><img src="./img/logo.png" class="logo"></a></li>
                            <li><a href="sub.html">구독</a></li>
                            <li><a href="store.html">스토어</a></li>
                        </ul>
                    </div>
                    <div class="gnbR">
                        <ul>
                            <li><a href="login.html">로그인/회원가입</a></li>
                            <li><a href="bag.html"><img src="./img/bag.png" class="bag"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
<%
MemberDao dao = new MemberDao();
String id = request.getParameter("id");
if(id==null)id="";
String pwd = request.getParameter("pwd");
if(pwd==null)pwd="";
String rs = ""; // 로그인 결과 메시지 초기화
// 아이디와 비밀번호 정규식 검사
String idR = "^[a-zA-Z0-9]{4,20}$";
String pwdR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,20}$";
if (id != "" && pwd != "") {
    if (!id.matches(idR)) {
    	rs = "아이디는 영문 대소문자, 숫자로 이루어진 4자이상 20자이하로 입력해주세요.";
    } else if (!pwd.matches(pwdR)) {
    	rs = "비밀번호는 영문 대소문자, 숫자, 특수문자 중 최소 1개씩을 포함하고, 8자 이상 20자 이하로 입력해주세요.";
    } else {
        Member member = dao.login(id, pwd);
        if (member != null) {
            // 로그인 성공
            session.setAttribute("member", member);// 로그인 정보 저장
            response.sendRedirect("index.html"); // 로그인 성공 시 메인 페이지 이동
        } else {
            // 로그인 실패
            rs = "아이디와 패스워드를 확인해주세요.";
        }
    }
}
%>
<script type="text/javascript">
    var rs = "<%=rs%>";
    if (rs !== "") {
        alert(rs);
    }
</script>
        <div class="inner">
            <section><!--로그인-->
    <div class="container mt-3">
    	<h2>로그인</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="id">아이디</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="아이디 입력" name="id">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="pwd">패스워드</label>
            <input type="password" class="form-control" 
      	     id="pwd" placeholder="패스워드 입력" name="pwd">
         	</div>
         	<button type="submit" class="btn btn-primary">로그인</button>
     	</form>
            </section>
        </div>
    </div>
</body>
</html>