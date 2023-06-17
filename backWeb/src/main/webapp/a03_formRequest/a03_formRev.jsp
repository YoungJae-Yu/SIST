<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>받은 과일정보</h1>
	<h2>받은 과일 이름:<%=request.getParameter("pname") %></h2>
	<h2>받은 과일 가격:<%=request.getParameter("price") %></h2>
</body>
</html>