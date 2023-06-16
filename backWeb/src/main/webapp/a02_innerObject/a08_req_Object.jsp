<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "backWeb.z01_vo.Person"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
# 요청값으로 사용할 객체 생성과 객체 내용 출력
1. 요청값은 필요로 하는 객체로 변환하여 사용되는 경우가 많다.
2. 필요로 하는 요청값을 필요로 하는 객체로 할당하는 방법을 확인해보자.
3. 연습예제
	1) Person 객체로 할당하기
		- 요청값 : 이름, 나이, 사는곳
			?name=홍길동&age=25&loc=서울
		- 요청값이 있을 때, 객체 생성과 할당. 
		- 생성된 객체의 속성을 출력(get메서드)
		
--%>
<%
	String name = request.getParameter("name");if(name==null) name="";
	String age = request.getParameter("age");if(age==null) age="0";
	String loc = request.getParameter("loc");if(loc==null) loc="";
	Person p01 = new Person(name,Integer.parseInt(age),loc);
	
%>
	<h2>객체로 받은 요청값 내용</h2>
	<h3>이름:<%= p01.getName() %></h3>
	<h3>나이:<%= p01.getAge() %></h3>
	<h3>사는곳:<%= p01.getLoc() %></h3>
	</body>
</html>