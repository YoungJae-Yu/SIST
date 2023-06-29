<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="project.janjan.DAO.*"
	import="project.janjan.VO.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
							<li><a href="index.html"><img src="./img/logo.png"
									class="logo"></a></li>
							<li><a href="sub.html">구독</a></li>
							<li><a href="store.html">스토어</a></li>
						</ul>
					</div>
					<div class="gnbR">
						<ul>
							<li><a href="login.html">로그인/회원가입</a></li>
							<li><a href="bag.html"><img src="./img/bag.png"
									class="bag"></a></li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<%
		MemberDao dao = new MemberDao();
		String id = request.getParameter("id");
		if (id == null)
			id = "";
		String pwd = request.getParameter("pwd");
		if (pwd == null)
			pwd = "";
		String pwdCk = request.getParameter("pwdCk");
		if (pwdCk == null)
			pwdCk = "";
		String name = request.getParameter("name");
		if (name == null)
			name = "";
		String address = request.getParameter("address");
		if (address == null)
			address = "";
		String contact = request.getParameter("contact");
		if (contact == null)
			contact = "";
		String email = request.getParameter("email");
		if (email == null)
			email = "";

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
    	function checkId() {// AJAX 아이디 중복확인
    	  var id = document.querySelector("#id").value;
    	  // 서버로 아이디 중복 확인 요청을 보냄
    	  var xhr = new XMLHttpRequest();
    	  xhr.open("post", "checkId.jsp", true);//checkId.jsp 비동기 연결
    	  xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    	  xhr.send("id=" + id);
    	  xhr.onreadystatechange = function() {
    		  if (xhr.readyState == 4 && xhr.status == 200) {
    	        var ckId = xhr.responseText.trim();
    	        if (ckId==='Y') {
	    	       alert("사용가능한 아이디입니다.")
    	        } else {
	    	       alert("이미 사용중인 아이디입니다.")
    	        }
    	      }
    	    }
    	 };
    	  var codeVal; // 전역 변수로 선언하여 인증번호를 저장
    	  function reqCode() {
    	      // 인증번호 발송
    	      codeVal = rdCode(); // 인증번호를 변수에 저장
    	      alert("인증번호: " + codeVal);
    	  }

    	  function rdCode() {
    	      // 6자리 랜덤 숫자 생성
    	      var code = Math.floor(Math.random() * 900000 + 100000);
    	      return code;
    	  }

    	  function ckCode() {
    	      // 인증번호 일치 확인
    	      var numCk = document.querySelector("#numCk").value;
    	      if (numCk == codeVal) {
    	          alert("인증 완료");
    	      } else {
    	          alert("인증번호가 틀립니다.");
    	      }
    	  }
</script>
		<div class="inner">
			<section>
				<div class="joinInner">
					<!--sns 로그인-->
					<h2 style="text-align: center;">회원가입</h2>
					<div class="kakao">
						<input type="button" value="3초만에 카카오로 가입하기" name="" id="">
					</div>
					<!--정보입력-->
					<div class="inputInfo">
						<form action="" method="post">
							<label for="name">이름</label> <input type="text" id="name"
								class="name" name="name" placeholder="이름을 입력하세요"> 
							 <label for="id">아이디</label>
                            <div class="phoneCh">
                                <input type="text" name="id" id="id" class="phoneNum" placeholder="아이디를 입력하세요">
                                <input type="button" onclick="checkId()" value="아이디 중복 확인">
                            </div>
							<label for="pwd">비밀번호</label> <input
								type="password" name="pwd" id="pwd" class="pass" minlength="8"
								maxlength="16" placeholder="비밀번호를 입력하세요"> <label
								for="pwdCk">비밀번호 확인</label> <input type="password" name="pwdCk"
								id="pwdCk" class="pass" maxlength="16"
								placeholder="위와 동일한 비밀번호를 입력하세요"> <label for="contact">휴대번호</label>
							<div class="phoneCh">
							    <input type="text" name="contact" id="contact" class="phoneNum" maxlength="14" 
							    placeholder="휴대번호 입력(010-0000-0000)">
							    <input type="button" class="numCh" value="인증번호 요청" onclick="reqCode()">
							</div> 
							<div class="phoneCh">
							    <input type="number" id="numCk" class="doubleCh" placeholder="인증번호를 입력하세요">
							    <input type="button" value="인증번호 확인" onclick="ckCode()">
							</div>
							<label for="email">이메일</label> <input type="text" name="email"
								id="email" class="gener" placeholder="이메일을 입력하세요"> <label
								for="address">주소</label> <input type="text" name="address"
								id="address" class="gener" placeholder="주소를 입력하세요">
							<!-- 동의 체크 -->
							<div class="checkG">
								<div class="checkAll" id="checkAll">
									<input type="checkbox" name="check_all" id="check_all">
									<label for="check_all">전체 동의</label>
								</div>
								<div>
									<input type="checkbox" name="agree" id="check_1" class="normal">
									<label for="check_1">[필수] 서비스 이용 약관 동의</label>
								</div>
								<div>
									<input type="checkbox" name="agree" id="check_2" class="normal">
									<label for="check_2">[필수] 개인정보 수집 및 이용에 동의</label>
								</div>
								<div>
									<input type="checkbox" name="agree" id="check_3" class="normal">
									<label for="check_3">[필수] 긴급할인 등 정보·혜택 수신 동의</label>
								</div>
							</div>
							</div>
							<div class="loginBtn">
							<input type="submit" value="회원가입 완료">
					</div>
					</form>
				</div>
			</section>
		</div>
	</div>
	<script src="./js/index.js"></script>
</body>
</html>