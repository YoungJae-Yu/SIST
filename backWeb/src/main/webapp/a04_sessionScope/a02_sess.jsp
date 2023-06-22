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
    <div class="container mt-3">
    	<h2>세션 예제2</h2>
    	<table>
			   	<tr class="text-center">
			        <td onclick="location.href='a01_sess.jsp'">
			        <%= (int)session.getAttribute("session1")%> 클릭하세요</td>
				</tr>
		</table>      	
    </div>
</body>
</html>