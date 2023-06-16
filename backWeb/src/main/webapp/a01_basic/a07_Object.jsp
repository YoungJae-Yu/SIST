<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Member"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- # 단일 객체를 가져와서 화면에 처리하기
1. 단일 객체가 필요로 하는 화면 확인
2. 해당 화면에 필요한 속성들 정의
3. 속성들을 class 객체로 선언 set/get 처리
4. 상단 directive 부분 <%@ 에서
	외부 클래스 impor로 선언
5. 객체 생성 및 데이터 할당 
6. 객체의 getXXX() 메서드를 통해서 화면에 출력
--%>
	<%
	Member m = new Member("himan","7777","홍길동","관리자",8000);
	%>
	<h2>내정보 화면</h2>
	<table border>
		<col width = "30%"><col whidth = "60%">
		<tr><th>아이디</th>
		<th><input type="text" value="<%=m.getId()%>" size="5"></th></tr>
		<tr><th>패스워드</th>
		<th><input type="password" value="<%=m.getPwd()%>" size="5"></th></tr>
		<tr><th>이름</th>
		<th><input type="text" value="<%=m.getName()%>" size="5"></th></tr>
		<tr><th>권한</th>
		<th><input type="text" value="<%=m.getAuth()%>" size="5"></th></tr>
		<tr><th>포인트</th>
		<th><input type="text" value="<%=m.getPoint()%>" size="5"></th></tr>
		<tr><th colspan="2">
		<input type = "submit" value="변경">
		<input type = "reset" value="초기화">
		</th></tr>
	
	</table>
</body>
</html>