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
String name = request.getParameter("name");
String korS = request.getParameter("kor");
String engS = request.getParameter("eng");
String mathS = request.getParameter("math");
int kor = 0,eng = 0,math = 0;
if(korS!=null)kor = Integer.parseInt(korS);
if(engS!=null)eng = Integer.parseInt(engS); 
if(mathS!=null)math = Integer.parseInt(mathS); 
%>
	<h1>전송된 학생정보</h1>
	<h2>이름:<%=name%></h2>
	<h2>국어:<%=kor%></h2>
	<h2>영어:<%=eng%><1/h2>
	<h2>수학:<%=math%></h2>
	<h2>총점:<%=kor+eng+math%></h2>
	<h2>평균:<%=(kor+eng+math)/3%></h2>
</body>
</html>