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
    		
    		// ex) 가격을 입력해서 서버에서 전송해서
    		//		출력내용을 가격 @@@을 처리하게 하세요.
    		$("#btn").click(function(){
    			// alert( $("#frm").serialize() )
    			// form 하위에 name/value 기준으로 자동으로
    			// query string를 생성해준다.
    		
    			var priceVal = $("#price").val()
    			$.ajax({
    				url:"${path}/prodCalcu.do",
    				data:"price="+priceVal+"&cnt="+$("#cnt").val(),
    				type:"post",
    				dataType:"text",
    				success:function(data){
    					alert(data)
    				},
    				error:function(err){
    					console.log("#에러발생#")
    					console.log(err)
    				}
    			})
    		})
    	});
    </script>
</head>
<body>
    <div class="container mt-3">
    	<h2>서버를 호출</h2>
    	<form id="frm" action="" method="post">
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="price" placeholder="가격 입력" name="price">
         	</div>
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="cnt" placeholder="갯수 입력" name="cnt">
         	</div>
         	<button type="button" id="btn"class="btn btn-primary">입력</button>
     	</form>
      	
    </div>
</body>
</html>