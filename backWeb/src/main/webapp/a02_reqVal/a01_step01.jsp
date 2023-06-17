<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
1. query string vs request.getParameter("")
	1) 페이지명?key=value
	2) String val = requst.getParameter("key")
	
	1) 1개 매개변수
	2) 2개 매개변수
	3) 숫자형 매개변수 넘기기
	4) 배열형 매개변수
	5) 객체형 매개변수
2. query string은 클라이언트에 서버로 데이터를 전송해주기 위한 목적.

 --%>
 	<%--
 	a01_step01.jsp?food=짜장면
 	 --%>
 	<h2>초기 요청 페이지</h2>
 	<%= request.getParameter("food") %>
 	<%
 	String food = request.getParameter("food");
 	%>
 	<h3>받은 음식물 :<%=food %></h3>
 	<%--
 	a01_step01.jsp?fruit=수박
 	문자열 변수 fruit로 받아서
 		받은 과일 : @@@ 로 출력되게 하세요.
 	--%>
 	<%= request.getParameter("fruit") %>
 	<%
 	String fruit = request.getParameter("fruit");
 	%>
 	<h3>받은 과일:<%=fruit%></h3>
 	<%--
 	a01_step01.jsp?food=짜장면&fruit=수박
 	
 	ex)물건의 가격과 갯수를 받아서 출력되게 하세요 
 	?price=4000&cnt=5 
 	 --%>
 	  	<%= request.getParameter("price") %>
 	  	<%= request.getParameter("cnt") %>
 	<%
 	String price = request.getParameter("price");
 	String cnt = request.getParameter("cnt");
 	// 안넘어오면 0, 넘어오면 형변환 처리..(숫자형 안정성)
 	int priceInt = 0;
 	if(price!=null) // null 프로세스 처리 안됨.
 		priceInt = Integer.parseInt(price);
 	int cntInt = 0;
 	if(cnt!=null)
 		priceInt = Integer.parseInt(cnt);
 	%>
 	<h3>가격:<%=priceInt%></h3>
 	<h3>갯수:<%=cntInt%></h3>
 	<h3>총계:<%=priceInt*cntInt%></h3>

</body>
</html>































