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
ex) a03_req.jsp?name=마길동&kor=70
이름:@@@
국어(+10):@@@ 

ex) a04_req.jsp?pname=사과&price=3000&cnt=5

구매물품:@@
구메가격:@@
구매갯수:@@
총액:@@
1. 우선 데이터를 구매갯수까지 출력하고
2. 가격과 갯수를 형변환처리하여 총액을 변수에 할당 후,
3. 총액과 함께 전체 데이터를 요청값에 의해 출력하세요.
--%>
	<%
	String name = request.getParameter("name");
	String korS = request.getParameter("kor");
	int kor = 0;
	if(korS!=null){
		kor = Integer.parseInt(korS);
	}
	%>
	<h2>query string 통해서 데이터 받기</h2>
	<h3>이름:<%=name %></h3>
	<h3>국어(+10):<%=kor+10%></h3>

</body>
</html>