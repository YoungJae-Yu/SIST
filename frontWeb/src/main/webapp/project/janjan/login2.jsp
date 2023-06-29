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
            <section><!--여기에 콘텐츠 넣으시면 됩니다.-->
                <div class="logInner"> <!--sns 로그인-->
                    <h2 style="text-align: center;">로그인·회원가입</h2>
                    <div class="kakao">
                        <input type="button" value="카카오로 계속하기" name="" id="kakaologin">
                    </div>
                    <div class="apple">
                        <input type="button" value="Apple로 계속하기" name="" id="applelogin">
                    </div>
                    <form action="" method="post">
                    <h2 style="text-align: center;">회원 로그인</h2>
                    <div class="idInput">
                        <input type="text" value="" placeholder="아이디를 입력하세요" name="id" id="id">
                    </div>
                    <div class="passInput">
                        <input type="password" value="" placeholder="비밀번호를 입력하세요" 
                        name="pwd" id="pwd" maxlength="16" minlength="8">
                    </div>
                    <div class="findData">
                        <a href="#">아이디 찾기 |</a>
                        <a href="#">비밀번호 찾기</a>
                    </div>
                    <div class="loginBtn">
                         <input type="submit" value="로그인">
                    </div>
                    </form>
                    <a class="goJoin" href="./join.jsp"><p>아직 회원이 아니신가요? 회원가입</p></a>
                </div>
            </section>
        </div>
    </div>
</body>
</html>