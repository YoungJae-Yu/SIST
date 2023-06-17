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
# form과 request의 관계
1. form의 하위 객체는 client가 서버에 query string으로
	데이터를 전송하게 해주는 UI(user interface)가 있는
	태그 및 객체이다.
2. 화면단에서 입력을 해서, 전송 이벤트로 처리시, query string을
	만들어 주는 태그가 form과 form하위 요소 객체들이다.
3. query string과 form요소 객체의 속성 비교..
	1) a02_formReceive.jsp?name=홍길동
	2) <form action="a02_formReceive.jsp">
		이름:<input name="name" value="홍길동"/>
		<input type="submit">
	3) 위 내용 전달하는 대상
		a02_formReceive.jsp? == action="a02_formReceive.jsp"
		name=홍길동 ==> name 속성값과, value 속성값 동일..
		submit라는 버튼을 클릭 시 위 querystring을 만들어 주어
		요청 처리한다.
 --%>
	<h2>전송 준비</h2> 
	<form action="a02_formReceive.jsp">
		전송할 이름:<input type="text" name="name"/><br>
		<input type="submit"/>
	</form>
	<%-- 
	ex) 전송2 연습
	a03_formRev.jsp?pname=사과&price=3000
	form요소를 만들어서 전송을 하고,
	a03_formRev.jsp에서는 pname과 price를 받아서 출력하세 하세요.
	 --%>
	<h2>과일 정보 전송</h2>
	<form action="a03_formRev.jsp">
		전송할 과일이름:<input type="text" name="pname"/><br>
		전송할 과일가격:<input type="text" name="price"/><br>
		<input type="submit"/>
	</form>
</body>
</html>


























