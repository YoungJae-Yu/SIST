<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="java.net.URLEncoder"
    import="java.net.URLDecoder"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
	<c:set var="path" 
	value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		//$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>구매 물품명 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <input type="text" class="form-control" 
      	     id="pname" placeholder="물건명 입력" name="pname">
         	</div>
         	<button type="submit" class="btn btn-primary">구매</button>
     	</form>
	    <%
	    	//입력받은 물건명
	    	String pname = request.getParameter("pname");
	   		if(pname==null) pname="";
	   		// 물건리스트
	   		String plist = "";
	    	if(!pname.equals("")) {
		   		Cookie cks[] = request.getCookies();
		   		for(Cookie  ck : cks){
		   			if(ck.getName().equals("pname")){ 
		   				plist += URLDecoder.decode(ck.getValue(),"utf-8")+" ";
		   			}
		   		}
	    	plist+=pname;
	    	response.addCookie(new Cookie("pname",
	    			URLEncoder.encode(plist,"utf-8")));
	    	}
		   	// ex) 구매한 물건을 누적해서 출력하게 하세요..
			// 구매 물건명 : [   ]
			// 구매한 물품리스트 : @@@ @@@ (쿠키값)
			// a13_buyList.jsp
		%>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>입력한 물건명</th>
				    <th>등록된 물건</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td><%=pname %></td>
			        <td><%=plist %></td>
					 
			   	</tr>
		 	</tbody>
		</table>
    </div>
</body>
</html>