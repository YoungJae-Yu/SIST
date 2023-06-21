<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Person"%>
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
# session scope의 객체는 key, value  형식으로 저장되는데,
일반 단일 변수뿐만 아니라 객체형/배열형으로 저장이 된다.
1. 기본형식
	session.setAttribute("p01",new Person("홍길동",25,"서울")
2. 가져오는 형식
	저장은 Object 형태로 저장이 되기에 가져올 때는 type casting을 하여야 한다.
	Preson p01 = (Person)sessoin.getAttribute("p01");

 --%>
 <%
 	session.setAttribute("p01",new Person("홍길동",25,"서울"));
 
 %>
<body>
    <div class="container mt-3">
    	<h2 onclick="location.href='a09_session.jsp'">
    	다른 페이지에서 session 값 가져오기</h2>    	
    </div>
</body>
</html>