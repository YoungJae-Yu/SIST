<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="frontWeb.A05_MemberDao"
    import="frontWeb.vo.Member"
%>
<%
A05_MemberDao dao = new A05_MemberDao();
// ?id=@@@&pass=@@@
String id = request.getParameter("id");
String pass = request.getParameter("pass");
Member mem = dao.login(id, pass);
boolean isSuccess = mem!=null;// DB에 데이터 있는지 여부 확인
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// java+html ==> 네트워크 ==> html+js
	var isSuccess = <%=isSuccess%>; // java ==> js 전환
	if(isSuccess){
		alert("로그인 성공:")
	}else{
		alert("로그인 실패\n다시 로그인")
		// 페이지 이동 명령어..
		location.href="a04_login.html"
	}
</script>
</head>
<body>

    <h1>서버로 온 데이터</h1>
    <!-- 서버에서 요청값을 받아서 자바 데이터 + html 코드를 합쳐서
    다시 client에 전송 처리.. -->
	<h2>로그인한 아이디:${param.id}</h2>
	<h2>로그인한 패스워드:${param.pass}</h2>

</body>
</html>