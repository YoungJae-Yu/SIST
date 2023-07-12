<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    	<h2>요청 모델 연습</h2>
    	<form action="" method="post">
    	
         	<div class="mb-3 mt-3">
            <input type="text" class="form-control" value="${names}"
      	     id="name" placeholder="이름 입력" name="name">
      	     </div>
      	    

         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>     	
     	<%--
     	 // /mvc03.do?age=
     	 // 클릭시, +1 입력한 나이보다 증가하게 처리.
     	 --%>
    </div>
</body>
</html>



























