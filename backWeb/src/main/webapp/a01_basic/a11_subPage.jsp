<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// font단에서 처리할 모든 내용도
	// 공통 내용을 선언할 때, 활용할 수 있다.
	// jsp include 지시자를 사용하면 front단, back단의
	// 모든 코드도 공통으로 사용할 수 있다.
	// 포함될 공통 변수
	String name = "홍길동";
	%>
	<h2>포함될 공통 페이지</h2>
</body>
</html>