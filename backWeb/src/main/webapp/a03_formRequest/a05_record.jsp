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
String nameS = request.getParameter("name");
String korS = request.getParameter("kor");
String engS = request.getParameter("eng");
String mathS = request.getParameter("math");

int kor = Integer.parseInt(korS); 
int eng = Integer.parseInt(engS); 
int math = Integer.parseInt(mathS); 
%>
	<h1>전송된 학생정보</h1>
	<h2>이름:<%=request.getParameter("nameS") %></h2>
	<h2>국어:<%=request.getParameter("kor") %></h2>
	<h2>영어:<%=request.getParameter("eng") %></h2>
	<h2>수학:<%=request.getParameter("math") %></h2>
	<h2>총점:<%=kor+eng+math%></h2>
	<h2>평균:<%=(kor+eng+math)/3%></h2>
</body>
</html>