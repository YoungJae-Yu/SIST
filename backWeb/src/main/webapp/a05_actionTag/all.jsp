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
2. include로 all.jsp 하위에 top.jsp, main.jsp, bottom.jsp를 만들어서 포함 시켜 출력하되
   request.getParameter(), request.setAttribute()데이터 설정으로 main.jsp에서 로그인 id pass를 만들어서
   all.jsp를 호출하게 할때, himan//7777이면  top.jsp에서는 id를 보내어 @@ 로그인 중 그외는 login하세요 라고
   표시되게 처리
   all.jsp --%>
 <%
 	String id = request.getParameter("id"); if(id==null)id="";
 	String pass = request.getParameter("pass"); if(pass==null)pass="";
 %>
    <div class="container mt-3">
    	<h2>ALL</h2>
    	<jsp:include page="top.jsp"/>
    	    	<jsp:include page="main.jsp">
    		<jsp:param name="id" value="<%=id %>"/>
    		<jsp:param name="pass" value="<%=pass %>"/>
    	</jsp:include>      	
    	<jsp:include page="bottom.jsp"/>
    </div>
    <%--
    top.jsp
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
    	main.jsp
        <h2>메인페이지 로그인</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="id">아이디:</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="아이디 입력" name="id">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="pass">패스워드:</label>
            <input type="password" class="form-control" 
      	     id="pass" placeholder="패스워드 입력" name="pass">
         	</div>
         	<button type="submit" class="btn btn-primary">로그인</button>
     	</form>  
     --%>
    

 
</body>
</html>

































