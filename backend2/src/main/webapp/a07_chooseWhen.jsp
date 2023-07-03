<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
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
# choose when 구문
1. 여러가지 분기분으로 처리할 때 활용한다.
2. 기본형식
	<c:choose>
		<c:when text="${조건1}">
		<c:when text="${조건2}">
		<c:when text="${조건3}">
		<c:other>
	</c:choose>
	ex) 임의의 숫자를 설정해서 해당 숫자보다 큰지 작은지 같은지를 출력하세요.
 --%>
    <div class="container mt-3">
    	<h2>숫자 맞추기 게임</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="point">임의의 숫자는?(1~5)</label>
            <input type="number" class="form-control" 
      	     id="point" placeholder="숫자 입력" name="point">
         	</div>
         	<button type="submit" class="btn btn-primary">정답확인</button>
     	</form>
     	   <%
			request.setAttribute("rN",(int)(Math.random()*5+1));
		    %>
		    <c:set var="rN" value="${rN }"/>
     	<c:if test="${not empty param.point }">
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>컴퓨터의 숫자</th>
				    <th>정답확인</th>
		      	</tr>
		    </thead>
		    <tbody>

			   	<tr  class="text-center">
			        <td>${rN}</td>
			        <td>
			        	<c:choose>
			        		<c:when test="${param.point>rN}">유저 승리</c:when>
			        		<c:when test="${param.point<rN}">컴퓨터 승리</c:when>
			        		<c:when test="${param.point==rN}">무승부</c:when>
			        	</c:choose>
			        </td>
			   	</tr>
		 	</tbody>
		</table>    
		</c:if>  	
    </div>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="point">점수:</label>
            <input type="number" class="form-control" 
      	     id="point" placeholder="점수 입력" name="point">
         	</div>
         	<button type="submit" class="btn btn-primary">등급확인</button>
     	</form>
     	<c:if test="${not empty param.point }">
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>점수</th>
				    <th>등급</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td>${param.point }</td>
			        <td>
			        	<c:choose>
			        		<c:when test="${param.point>=90 }">A등급</c:when>
			        		<c:when test="${param.point>=80 }">B등급</c:when>
			        		<c:when test="${param.point>=70 }">C등급</c:when>
			        		<c:when test="${param.point>=60 }">D등급</c:when>
			        		<c:otherwise>F등급</c:otherwise>
			        	</c:choose>
			        
			        </td>
			   	</tr>
		 	</tbody>
		</table>    
		</c:if>  	
    </div>
</body>
</html>