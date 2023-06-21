<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<body>

<%--
	ex)
	fruit01 : 사과 (page범위 설정)
	fruit02 : 바나나 (request범위 설정)
	fruit03 : 딸기 (session범위 설정)
	fruit04 : 수박 (application범위 설정)
--%>
    	<%
    	pageContext.setAttribute("page01", "사과^^");
    	request.setAttribute("request02", "바나나^^");
    	session.setAttribute("session03", "딸기^^");
    	application.setAttribute("application04", "수박^^");
    	
    	%>
    <div class="container mt-3">
    	<h2>session scope에 따른 데이터(page 범위)</h2>
		<table class="table table-striped table-hover">
		    <tbody>
			   	<tr class="text-center">
			        <td><%= pageContext.getAttribute("page01")%></td>
			   	</tr>
			   	<tr class="text-center">
			        <td onclick="location.href='a06_request.jsp'"><%= request.getAttribute("request02")%>(확인하러가기)</td>
			   	</tr>
			   	<tr class="text-center">
			        <td onclick="location.href='a08_session.jsp'"><%= session.getAttribute("session03")%>(확인하러가기)</td>
			   	</tr>
			   	<tr class="text-center">
			        <td><%= application.getAttribute("application04")%></td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>