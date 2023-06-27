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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="./css/reset.css">
    <link rel="stylesheet" href="./css/global.css">
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
    if(id==null) id="";
    String pwd = request.getParameter("pwd");
    if(pwd==null) pwd="";
    String pwdCk = request.getParameter("pwdCk");
    if(pwdCk==null) pwdCk="";
    String name = request.getParameter("name");
    if(name==null) name="";
    String address = request.getParameter("address");
    if(address==null) address="";
    String contact = request.getParameter("contact");
    if(contact==null) contact="";
    String email = request.getParameter("email");
    if(email==null) email="";

    String rs = ""; // 회원가입 결과 메시지 초기화

    if (id != "") {
        // 패스워드 일치 여부 확인
        if (pwd.equals(pwdCk)) {
            // 회원 정보 생성
            Member member = new Member(id, pwd, name, address, contact, email);
            // 회원가입
            dao.join(member);
            rs = "회원가입이 완료되었습니다.";
            // 회원가입 성공 시 로그인 페이지 이동
            response.sendRedirect("login.jsp");
        } else {
        	rs = "패스워드와 패스워드 확인이 일치하지 않습니다.";
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
			<section>
				<!--로그인-->
				<div class="container mt-3">
					<h2>회원가입</h2>
					<form action="" method="post">
						<div class="mb-3 mt-3">
							<label for="id">아이디</label>
							<input type="text" class="form-control" id="id" placeholder="아이디 입력" name="id">
						</div>
						<div class="mb-3 mt-3">
							<label for="pwd">패스워드</label> 
							<input type="password"
								class="form-control" id="pwd" placeholder="패스워드 입력" name="pwd">
						</div>
						<div class="mb-3 mt-3">
							<label for="pwdCk">패스워드확인</label> 
							<input type="password"
								class="form-control" id="pwdCk" placeholder="패스워드확인 입력" name="pwdCk">
						</div>
						<div class="mb-3 mt-3">
							<label for="name">이름</label> 
							<input type="text"
								class="form-control" id="name" placeholder="이름 입력" name="name">
						</div>
						<div class="mb-3 mt-3">
							<label for="address">주소</label> 
							<input type="text"
								class="form-control" id="address" placeholder="주소 입력" name="address">
						</div>
						<div class="mb-3 mt-3">
							<label for="contact">휴대폰 번호</label>
							<input type="text"
								class="form-control" id="contact" placeholder="휴대폰 번호 입력(010-0000-0000)" name="contact">
						</div>
						<div class="mb-3 mt-3">
							<label for="email">이메일</label> 
							<input type="text"
								class="form-control" id="email" placeholder="이메일 입력(aa@aa.aa)" name="email">
						</div>
						<button type="submit" class="btn btn-primary">회원가입</button>
					</form>
			</section>
		</div>
	</div>
</body>
</html>