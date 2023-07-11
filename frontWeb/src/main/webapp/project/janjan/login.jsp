<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.janjan.DAO.*"
    import="project.janjan.VO.*"
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	
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
                        <a class="goJoin" type="button" class="btn btn-primary" 
                    	data-bs-toggle="modal" data-bs-target="#myModal">아이디 찾기 | 비밀번호 찾기</a>
                    </div>
                    <div class="loginBtn">
                         <input type="submit" value="로그인">
                    </div>
                    </form>
                    <!--  -->
                    <a  href="./join.jsp" >
                    <p>아직 회원이 아니신가요? 회원가입</p></a>
                </div>
            </section>
        </div>
    </div>
    <!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">아이디 찾기</h4>
					<button type="button" class="btn-close" 
					id="modalClsBtn" data-bs-dismiss="modal"></button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="mb-3 mt-3"> <input
							type="text" class="form-control" id="name" 
							placeholder="이름 입력"
							name="name">
					</div>
				</div>
				<div class="modal-body">
					<div class="mb-3 mt-3"> <input
							type="text" class="form-control" id="contactId" 
							placeholder="휴대폰 번호 입력"
							name="contactId">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success"
						onclick="ajaxSchId()">아이디 찾기</button>
				</div>
				
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">비밀번호 찾기</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="mb-3 mt-3"><input
							type="text" class="form-control" id="id" 
							placeholder="아이디 입력"
							name="id">
					</div>
				</div>
				<div class="modal-body">
					<div class="mb-3 mt-3"><input
							type="text" class="form-control" id="contactPwd" 
							placeholder="휴대폰 번호 입력"
							name="contactPwd">
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success"
						onclick="ajaxSchPwd()">비밀번호 찾기</button>
				</div>
			</div>
		</div>
	</div>
    	<script type="text/javascript">
	function ajaxSchId(){
		var name=document.querySelector(".modal-body #name").value
		var contactId=document.querySelector(".modal-body #contactId").value
		var qStr = "name="+name+"&contact="+contactId
		var xhr = new XMLHttpRequest()
		xhr.open("post","/frontWeb/schId",true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qStr);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result = xhr.responseText
				console.log(result)
				if(result!="null"){
					alert("등록된 아이디는" + result + "입니다.")
					if(confirm("로그인페이지로 이동할까요?")){
						// 창닫기 처리
						document.querySelector("#modalClsBtn").click()
					}
				}else{
					alert("등록된 계정이 없습니다.")
				}
			}
		}
	}
	function ajaxSchPwd(){
		var id=document.querySelector(".modal-body #id").value
		var contactPwd=document.querySelector(".modal-body #contactPwd").value
		var qStr = "id="+id+"&contact="+contactPwd
		var xhr = new XMLHttpRequest()
		xhr.open("post","/frontWeb/schPwd",true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qStr);
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result = xhr.responseText
				console.log(result)
				if(result!=""){
					alert("등록된 비밀번호는" + result + "입니다.")
					if(confirm("로그인페이지로 이동할까요?")){
						// 창닫기 처리
						document.querySelector("#modalClsBtn").click()
					}
				}else{
					alert("등록된 계정이 없습니다.")
				}
			}
		}
	}
	</script>
</body>
</html>