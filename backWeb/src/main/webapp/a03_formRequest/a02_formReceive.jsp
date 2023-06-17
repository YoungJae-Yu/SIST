<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>form 으로 받았습니다!</h1>
	<h2>받은 이름:<%=request.getParameter("name") %></h2>
</body>
</html>