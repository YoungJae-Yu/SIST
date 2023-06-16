<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 주석은 client에 전달. -->
<%-- 
jsp 주석은 서버단에서 처리되기에 브라우저를 통해 전달되지 않는다.
1. 동적으로 자바코드가 처리되는 내용을 말하고,
	3가지 유형으로 구성된다.
	1) 선언부(declaration)
		<%!
		
		%>
		사이에 들어가는 변수/상수/메서드 선언부를 말한다.
		class 바로 밑에 선언 부분..
		
	2) 스크립트릿(scriptlet)
	3) 표현식(expression) : <%=변수/메서드%>
		html 혼합해서 출력할 때, 사용된다.
--%>
<%!
	// jsp가 java변경될 때, class명 밑에서 선언되는 부분
	// declaration
	String pname = "사과";
	String getName(){
		return pname;
	}
	// ex) 선언 연습 a03_jsp_declare.jsp 만들고,
	// 변수로 물건명 가격, 메서드로 물건명(가격) 형태로 리턴하는
	// 내용을 선언하여, 하단에서 h3로 변수와 메서드를 호출해보세요
	
%>
<h2>jsp의 스크립트</h2>
<h2>선언된 변수 호출:<%=pname %></h2>
<h2>선언된 메서드 호출:<%=getName()%></h2>
</body>
</html>