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
<%--
# session scope
1. jsp는 session의 범위를 총 4가지로 유지할 수 있게 한다.
	저장위치 : 서버단에 저장...
2. 범위 내용
	1) page영역 : 하나의 jsp페이지를 처리할 때 사용되는 영역
		실제 객체 : pageConext
		jsp script 에서 저장되는 영역..
	2) request영역 : 하나의 http요청을 처리할 때, 사용되는 영역
	3) session영역 : 하나의 웹브라우저와 관련된 영역
	4) application영역 : 하나의 웹 어플리케이션과 관련된 서버 영역
3. 설정 방법
	0) 저장 데이터는 기본 데이터유형, 배열, 객체...
	1) 저장
		범위객체.setAttribute("저장할키",저장할데이터)
	2) 저장된 내용 호출
		할당할 변수 = (타입casting)범위객체.getAttribute("저장된키")
	3) 삭제
		범위객체.removeAttribute("저장된키")
4. 각 범위에 따른 처리
	1) pageConext(page)
		페이지 범위까지만 처리된다.
	2) request
		request.getRequestDispatcher(이동할페이지).forward(request)
		특정 내용을 호출하여 이동할 페이지까지 전송이된다.
	3) session
		서버와 브라우저간에 연결 상태가 있을 때까지 지속되는 범위를 말한다.
		동일한 브라우저로 연결이 있는 상태에서는 a href,
			location.href로 호출하더라도 계속 연결이 되어 있기 떄문에
			설정된 session값을 가져올 수 있다.
	4) application
		서버가 살아 있는한 데이터를 지속적으로 저장하는 것을 말한다.
		
	
	
 --%>
<body>
    <div class="container mt-3">
    	<h2>session scope에 따른 데이터(page 범위)</h2>
    	<%
    	pageContext.setAttribute("page01", "페이지범위입니다^^");
    	request.setAttribute("request02", "리쿼스트범위입니다^^");
    	session.setAttribute("session03", "세션범위입니다^^");
    	application.setAttribute("application04", "어플리케이션범위입니다^^");
    	
    	%>
		
		<table class="table table-striped table-hover">
		    <tbody>
			   	<tr class="text-center">
			        <td><%= pageContext.getAttribute("page01")%></td>
			   	</tr>
			   	<tr class="text-center">
			        <td onclick="location.href='a02_request.jsp'"><%= request.getAttribute("request02")%>(확인하러가기)</td>
			   	</tr>
			   	<tr class="text-center">
			        <td onclick="location.href='a04_session.jsp'"><%= session.getAttribute("session03")%>(확인하러가기)</td>
			   	</tr>
			   	<tr class="text-center">
			        <td><%= application.getAttribute("application04")%></td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>