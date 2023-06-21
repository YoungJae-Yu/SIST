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
    	<%
    	pageContext.setAttribute("page01", "페이지범위입니다^^");
    	request.setAttribute("request02", "리쿼스트범위입니다^^");
    	session.setAttribute("session03", "세션범위입니다^^");
    	application.setAttribute("application04", "어플리케이션범위입니다^^");
    	String page01="a03_showRequestPage.jsp";
    	RequestDispatcher rd = 
    			request.getRequestDispatcher(page01);
    	rd.forward(request, response);
    	%>
<body>

</body>
</html>