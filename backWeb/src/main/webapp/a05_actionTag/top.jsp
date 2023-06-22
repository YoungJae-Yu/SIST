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
 	String id = request.getParameter("id"); if(id==null)id="";
 	String pass = request.getParameter("pass"); if(pass==null)pass="";
 	String isLog = "I";
 	if(id!=null){
 		if(id.equals("himan")&&pass.equals("7777")){
 			isLog = "T";
 		}else{
 			isLog = "F";
 		}
 	}
 	
 %>
 <script type="text/javascript">
 	var isLog = "<%=isLog%>"
 	var id = "<%=id%>"
 	
 	if(id!=='I'){
 		if(isLog=='T'){
 			alert("<%=id %> 로그인 중")
 		}
 		if(isLog=='F'){
 			alert("로그인 하세요")
 		}
 	}
 </script>
<body>
    <div class="container mt-3">
    	<h2>상단페이지</h2>
    </div>
</body>
</html>