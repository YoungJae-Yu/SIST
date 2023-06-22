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
    	int num01=0;
    	if(session.setAttribute("num01")==null){
    		session.setAttribute("num01", 0);
    	}else{
    		num01 = (Integer)session.getAttribute("num01");
    		num01 ++;
    		out.println("번호:"+num01);
    		session.setAttribute("num01", num01);
    	}
    	%>
<body>
    <div class="container mt-3">
    	<h2>세션 예제1</h2>
    	<table>
			   	<tr class="text-center">
			        <td onclick="location.href='a02_sess.jsp'">
			        <%= (int)session.getAttribute("session1")%> 클릭하세요</td>
			    </tr>
		</table>      	
    </div>
</body>
</html>