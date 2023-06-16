<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.cls01{ background-color:yellow;}
	td{text-align:center; font-size:30pt;}
</style>
</head>
<script type="text/javascript">
	var price = 3000;
	var cnt = 5;
</script>
<body>
<%-- ex) a12_main.jsp 아래 내용을 include지시자에 의해 호출
						및 변수 사용..
a13_sub.jsp(js, java 변수 선언, 화면2x2테이블) --%>
<% String name = "유영재";
String name1 = "사과";%>
<table border>
<tr><td onclick="call()"></td><td onclick="call()"></td></tr>
<tr><td onclick="call()"></td><td onclick="call()"></td></tr>
</table>

<br>
<table width="30%" border>
<tr><td></td><td></td><td></td></tr>
<tr><td></td><td></td><td></td></tr>
<tr><td></td><td></td><td></td></tr>

</table>

</body>
<script>
function call(){
	alert("방가방가루");
}
</script>
</html>