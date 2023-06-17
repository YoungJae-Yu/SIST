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
ex) 국어, 영어, 수학 점수를 받아서 총점/평균 처리
1) 요청 형식 설정
2) 변수 지정(문자형-요청값)
3) 숫자형 변수 초기0
4) 조건문 null 아닐 때, 형변환
5) 총합 처리
6) 평균 처리
 --%>
 <%
 String korS = request.getParameter("kor");
 String engS = request.getParameter("eng");
 String mathS = request.getParameter("math");
 int kor = 0;
 int eng = 0;
 int math = 0;
 if (korS!=null) kor = Integer.parseInt(korS);
 if (engS!=null) eng = Integer.parseInt(engS);
 if (mathS!=null) math = Integer.parseInt(mathS);
 %>
 <h2>점수출력</h2>
 <h3>국어:<%=kor%></h3>
 <h3>영어:<%=eng%></h3>
 <h3>수학:<%=math%></h3>
 <h3>총점:<%=kor+eng+math %></h3>
 <h3>평균:<%=(kor+eng+math)/3 %></h3>
 

</body>
</html>