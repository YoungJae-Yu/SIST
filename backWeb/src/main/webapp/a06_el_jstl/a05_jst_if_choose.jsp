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
    		
    		$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
<%--
# jstl을 통한 조건문 처리
1. jstl은 scriptlet 없이도 조건에 따른 데이터 처리가 가능하다.
2. 기본형식
	<c:if test="${조건}">
		해당 조건에 해달할 때 처리할 화면 /process 내용..
	</c:if>
 --%>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
      	     id="ename" placeholder="사원명 입력" name="ename">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>등록여부</th>
		      	</tr>
		    </thead>
		    <%--
		    form
		    name="ename"을 입력해서 submit 클릭시, 요청값을
		    ${param.ename}으로 받을 수 있다.
		    요청값에 따라서
		    	등록된 회원이 아닙니다. (기본값 regMsg)
		    	등록된 회원입니다. (조건문에 의해 himan일 때)		    
		     --%>
		    <c:set var="regMsg" value="등록된 회원이 아닙니다."/>
		    <c:if test="${param.ename=='himan'}">
		    	<c:set var="regMsg" value="등록된 회원입니다."/>
		    </c:if>
		    <%--
		    param.ename이 공백이나 null이 아닐 때 el태그
		    	empty param.ename : null이거나 입력값이 없을 때
		     
		     a06_jstl_if.jsp
		     	물건가격과 갯수를 입력받아
		     		총계가 100,000이상일 때, 할인대상자입니다.
		     		그렇지 않을 때, 할인대상자가 아닙니다. 출력..	
		    
		     --%>
		    <%-- param.ename이 공백이나 null이 아닐 때 el태그 --%>
		    <c:if test="${not empty param.ename}">
		    <tbody>
			   	<tr  class="text-center">
			        <td>${regMsg}</td>
			   	</tr>
		 	</tbody>
		 	</c:if>
		</table>      	
    </div>
</body>
</html>