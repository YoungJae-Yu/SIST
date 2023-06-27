<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// z01_data.jsp?name=홍길동&fruit=사과
// 이 페이지는 위 형식으로 key=val로 넘겨주면 데이터를 받을 수 있다
String name = request.getParameter("name");
if(name==null)name="";
%>
    <td>안녕하세요</td>
    <td>이름:<%=name %></td>
    <td>과일명:${param.fruit }</td>