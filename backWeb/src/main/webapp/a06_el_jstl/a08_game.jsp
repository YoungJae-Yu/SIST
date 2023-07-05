<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
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
    		
    		$("h2").text("숫자 맞추기 게임(1~10)")
    	});
    </script>      
    
    
</head>
<%
	request.setAttribute("rno",(int)(Math.random()*10+1));
%>
<body>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
    	<form action="" method="post">
    		<input type="hidden" name="ranNum"
    			 value="${rno}"/>
         	<div class="mb-3 mt-3">
            <label for="no">no:</label>
            <input type="number" class="form-control" 
      	     id="no" placeholder="맞출 번호 입력" name="no">
         	</div>
         	<button type="submit" class="btn btn-primary">
         		정답확인</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>결과</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td><c:choose>
			        		<c:when test="${empty param.no }">값을 입력하세요!</c:when>
			        		<c:when test="${param.no>param.ranNum }">보다 크다</c:when>
			        		<c:when test="${param.no<param.ranNum }">보다 작다</c:when>			        	
			        		<c:when test="${param.no==param.ranNum }">정답</c:when>
			        		<c:otherwise>숫자형 데이터 입력하세요</c:otherwise>			        	
			        	</c:choose>
			        
			        </td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>