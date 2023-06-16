<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
// java 코드 영역(scriptlet)
	String name = "홍길동";
%>
<body>
	<h2>안녕하세요<%=name%> jsp 시작!</h2>
	<%-- jsp주석 expression 처리 : 변수를 화면에 출력 --%>
	<!-- 
	# jsp 코드 처리 과정
	1. jsp는 WAS에서 다음과 같은 과정으로 처리된다.
		1) 작성시
			jsp : java + html
		2) 변환과정
			jsp ==> servlet JSP로 만들어진다.
			.jsp ==> .java
		3) 컴파일
			.java ==> .class
		4) url로 client에서 호출시.
			서블릿에서 .class에 지정된 내용에 따라
			response객체에 의해 최종 html로 만들 내용을 전달.
		5) 서버의 html ==> 클라이언트에 전달되어
			브라우저를 통해 랜더링한 내용을 화면에서 볼 수 있다.
	# serlvet jsp
	1. jsp의 원본 java 파일..
	2. jsp도 실제 java로 전환되어 손쉽게 코드하기 위한 처리
		방법 중에 하나이다.
	3. servlet은 java로 만들어서 컨테이너 안에서 java+html을
		html로 최종적으로 만들어 client에 전달한다.
	
	 -->
</body>
</html>
















































