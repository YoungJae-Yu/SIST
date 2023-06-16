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
	// ex) 선언 연습 a03_jsp_declare.jsp 만들고,
	// 변수로 물건명 가격, 메서드로 물건명(가격) 형태로 리턴하는
	// 내용을 선언하여, 하단에서 h3로 변수와 메서드를 호출해보세요
 --%>
 <%!
	String pname = "바나나";
	int price = 3300;
	String getProdInfo(){
		return pname+"("+price+")";
	}
	String getProdInfo(int cnt){
		return pname+"("+price*cnt+")";
	}

 %>
 <h2>물건 정보 !!!</h2>
 <h2>물건명:<%=pname%></h2>
 <h2>가격:<%=price%></h2>
 <h2>물건명:<%=pname%></h2>
 <h2>메서드(가격):<%=getProdInfo()%></h2>
 <h2>메서드(총계):<%=getProdInfo(5)%></h2>
</body>
</html>