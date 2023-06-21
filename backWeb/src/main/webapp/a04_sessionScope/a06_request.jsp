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
    	<%
    	pageContext.setAttribute("page01", "사과^^");
    	request.setAttribute("request02", "바나나^^");
    	session.setAttribute("session03", "딸기^^");
    	application.setAttribute("application04", "수박^^");
    	String page01="a07_showRequestPage.jsp";
    	RequestDispatcher rd = 
    			request.getRequestDispatcher(page01);
    	rd.forward(request, response);
    	%>

    </div>
</body>
</html>