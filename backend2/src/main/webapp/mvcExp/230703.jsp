<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
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
    		
    		$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
<%--
[1단계:코드] 1. 1부터 10까지의 숫자 중 홀수만 출력하세요.
[1단계:코드] 2. 배열에 저장된 동물 이름을 출력하세요.
[1단계:코드] 3. JSTL을 사용하여 나이를 입력받아, age 변수가 18 이상인 경우 "성인입니다"라는 메시지를 출력하고, 
   그렇지 않은 경우 "미성년자입니다"라는 메시지를 출력해야 합니다.
[1단계:코드] 4. backendWeb.a01_dao.A05_MemberDao의 
 List<Member> mlist() 메서드를 이용하여, 
 MVC패턴으로 회원정보를 출력하세요.
 --%>
    <div class="container mt-3">
    	<h2></h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
         	<%-- [1단계:코드] 3. JSTL을 사용하여 나이를 입력받아, age 변수가 18 이상인 경우 "성인입니다"라는 메시지를 출력하고, 
   그렇지 않은 경우 "미성년자입니다"라는 메시지를 출력해야 합니다. --%>
            <label for="age">나이:</label>
            <input type="number" class="form-control" 
      	     id="age" placeholder="나이 입력" name="age">
         	</div>
         	<button type="submit" class="btn btn-primary">입력</button>
     	</form>
		<table class="table table-striped table-hover">
		
		<%-- [1단계:코드] 1. 1부터 10까지의 숫자 중 홀수만 출력하세요. --%>
		    <tbody>
			   	<tr  class="text-center">
			   		<c:forEach var="cnt" begin="1" end="10" step="2">
			        <td>${cnt }</td>
			        </c:forEach>
			   	</tr>
			   	<%-- [1단계:코드] 2. 배열에 저장된 동물 이름을 출력하세요. --%>
<%
				request.setAttribute("animal",new String[]{"문어","강아지","고양이"});
%> 	
			   	<tr  class="text-center">
			   		<c:forEach var="animal" items="${animal }">
			        <td>${animal}</td>
			        </c:forEach>
			   	</tr>
			   	<%-- [1단계:코드] 3. JSTL을 사용하여 나이를 입력받아, 
			   	age 변수가 18 이상인 경우 "성인입니다"라는 메시지를 출력하고, 
			    그렇지 않은 경우 "미성년자입니다"라는 메시지를 출력해야 합니다.
			    --%>
			    <c:if test="${not empty param.age}">
			   	<tr  class="text-center">
			        <td>
			        	<c:choose>
			        		<c:when test="${param.age>18}">성인입니다.</c:when>
			        		<c:otherwise>미성년자입니다.</c:otherwise>
			        	</c:choose>
			        </td>
			   	</tr>
			   </c:if>	
			   <%--	
			   [1단계:코드] 4. backendWeb.a01_dao.A05_MemberDao의 
				 List<Member> mlist() 메서드를 이용하여, 
				 MVC패턴으로 회원정보를 출력하세요.
				// MVC
				// 1. 요청값 처리
				// 없음.
				
				// 2. 모델 데이터
				A05_MemberDao dao = new A05_MemberDao();
				request.setAttribute("memList", dao.mlist());
				
				// 3.view단(jsp) 호출
				String page = "230703.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
				 --%>
			   <c:forEach var="mem" items="${memList }">
			   	<tr  class="text-center">
			        <td>${mem.id}</td>
			        <td>${mem.pass}</td>
			        <td>${mem.name}</td>
			        <td>${mem.point}</td>
			        <td>${mem.auth}</td>
			        <td>${mem.regdate}</td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		 	
		</table>      	
    </div>
</body>
</html>