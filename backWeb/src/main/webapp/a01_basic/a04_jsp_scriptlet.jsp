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
# scriptlet
1. jsp에서 가장 많이 활용되는 java코드 및 로직이 처리되는 부분이다.
2. 여러가지 화면 구성과 함께 많이 활용된다.
	(메서드 블럭안에 처리되는 부분으로 java로 비유하면 main()에서
	처리되는 실제 화면을 구현하는 부분이다.)
	1) 변수로 선언
	2) 변수 할당 및 활용
	3) 여러가지 화면과 함께 로직 처리..
 --%>
<%
	String name = "홍길동";
	String [] arry = {"사과","바나나","딸기"};
%>
<% 
	for(String fruit: arry){
%>
	<%-- 출력 영역 --%>
		<h2>과일:<%=fruit %></h2>
<%  }%>
<%--
# scriptlet 연습(단계별)
1. 반복문
	1) 증강 연산자에 의한 화면 구성 처리..
	2) 지역변수/전역변수 활용 
2. 조건문
3. 반복문과 조건문 혼합
4. 배열데이터 처리
5. 객체 사용 
6. 객체형배열처리
7. dao와 연동된 화면 처리
 --%>
 	<h2>카운트 업</h2>
 	<%-- 1~10까지 h3로 카운트 업 --%>
 	<%for(int cnt=1;cnt<=10;cnt++){%>
 		<h3>카운트 업!<%=cnt %></h3>
 	<%}%>
 	<h2>카운트 다운</h2>
 	<%-- ex) 테이블의 1X10로 카운트 다운 --%>
	<table border width="30%">
		<tr>
	 	<%for(int cnt=10;cnt>=1;cnt--){%>
 			<td><%=cnt%></td>
	 	<%}%>
		</tr>
	</table>
<%--
확인예제
1. web server와 web application server의 차이점을 기술하세요.
web server : 정적인 컨텐츠(HTML, CSS, 이미지 등)을 제공하고
처리하는 서버입니다. 클라이언트로부터 HTTP 요청을 받아
정적인 파일을 반환합니다. 대표적인 예로 Apache, Nginx가 있습니다.
web application server(WAS) : 동적인 컨텐츠를 처리하는 서버로,
비즈니스 로직을 실행하고 데이터베이스와의 상호작용,
트랜잭션 관리 등을 수행합니다. 클라이언트로부터의 요청을 받아서
웹 애플리케이션 로직을 수행한 후, 결과를 클라이언트에게 반환합니다.
대표적인 예로 Apache Tomcat, JBoss, jeus, weblogic가 있습니다. 

2. was안에서 jsp 프로그램의 처리 과정으로 client단부터 sever단까지 구분하여 설명하세요.
클라이언트(Client)가 웹 브라우저를 통해 JSP 페이지를 요청합니다.
url로 http://도메인/아이피주소:port/프로젝트명/경로/@@@.jsp
요청된 JSP 페이지는 WAS의 JSP 컨테이너에 의해 처리됩니다.
JSP 컨테이너는 JSP 페이지를 Servlet으로 변환합니다. (컴파일)
jsp ==> servlet(java) ==>
변환된 Servlet은 실행되어 동적인 HTML 문서를 생성합니다.
java+html(js, css) ==> html
java
<%
String isSuccess = 요청값을 받아서 DB를 확인해서 성공 여부를
Y/N으로 할당.
%>

<script>
var success = "<%=isSuccess%>";
if(success == 'Y'){
	alert("로그인성공")
}else{
	alert("로그인실패")
	
}


생성된 HTML 문서를 클라이언트에게 전달되어 웹 브라우저에서
랜저링되어 화면에 출력됩니다.
response.getWriter().print("") 형식으로
Stream을 객체를 통해서 웹브라우저에 전달.
js/jsp혼합해서 처리..

3. servlet과 jsp의 차이점을 기술하세요.
servlet : java로 만들어서 컨테이너 안에서 java+html을
	html로 최종적으로 만들어 client에 전달한다.
jsp : PrintWriter out = response.getWriter(); 내장되어 있음..
	server(request, response) 메서드로 감싸고 있고,
	주요 내장객체들은 벌써 선언된 상태이다.

4. servlet에서 한글과 html 코드로 처리할 때, 사용되는 코드를 기술하세요.
한글 코드 : response.setCharacterEncoding("utf-8");
	전달할 때, 한글 encoding방식 중에 utf-8방식으로 처리
html 코드 : response.setContentType("text/html;charset=utf-8");

5. servlet에서 반복문으로 7가지 무지개 색 h2를 만드세요
	String color[] = {"red","orange","yellow","green","blue","navy","Purple"};
	for(int cnt=0;cnt<=6;cnt++) {
		out.print("<h2 style='color:"+color[cnt]+"'>"+color[cnt]+"</h2>");
	}

6. servlet에서 4X4테이블로 클릭시 @@번호 안녕하세요가 alert으로 로딩되게 하세요.
		out.print("<style>td{text-align:center;width: 25%;}</style>");
		out.print("<h2>4X4 테이블</h2>");	
		out.print("<table width='300pt' height='300pt' border>");
		int cnt = 0;
		for(cnt=1;cnt<=16;cnt++) {
			if(cnt%4==1) out.print("<tr>");
			out.print("<td onclick='call("+cnt+")'>"+cnt+"</td>");
			if(cnt%4==0) out.print("</tr>");
			
		}
		out.print("<script>function call(td){alert(td);}</script>");
		out.print("</table>");
		
7. jsp의 script 3가지를 코드와 함께 기술하세요.
	1) 선언부(declaration) : <%! 	%>
		사이에 들어가는 변수/상수/메서드 선언부를 말한다.
	2) 스크립트릿(scriptlet) : <%코드%> 출력 <%코드%>
	3) 표현식(expression) : <%=변수/메서드%>
		html 혼합해서 출력할 때, 사용된다.

8. jsp에서 선언(declaration)을 통해서 가격과 갯수를 선언하고,
	메서드를 통해 가격과 갯수를 받아서 합산을 처리하는 메서드를
	선언하고, 하단에서 호출하는 화면을 만드세요.
--%>
<%!	int price = 3300;
	int getTotPrice(int cnt){
		return price*cnt;
	}%>
<h2>합계 : <%=getTotPrice(7)%></h2>
<%--   
9. jsp의 sciptlet과 expression을 이용해서 랜덤 구구단을 테이블로 9X1로 출력해보세요
--%>
<table>
<%double rd = Math.random()*9+1; %>
<%for(int cnt=1;cnt<=9;cnt++){ %>
	<tr><td>랜덤구구단:<%=cnt*(int)rd%></td></tr>	
<%}%>
</table>
<%--
# jsp의 조건문 처리
1. java단의 코드에서 화면을 분리시키거나 로직을 분리시킬 때 활용된다.
2. 여러가지 유형
	1) 화면 분리
		권한에 따른 메뉴 항목이 다르게 처리할 때...
	
	2) 로직에 의한 처리..
		point에 의해서 고객등급을 다르게 변수로 설정할 때..
		
	<% %> : java 
	그외 화면에 처리될 영역
--%>
	<%
	// java
	String auth = "admin";
	if(auth.equals("admin")){%>
		<span>관리자메뉴</span>
		<span>회원메뉴</span>
		<span>배송관련처리메뉴</span><br>
	<%
	}else{
	%>
		<span>물품종류1</span>
		<span>물품종류2</span>
		<span>장바구니메뉴</span><br>
	<%}%>
	<%int point = (int)(Math.random()*1000+1);
	String grade = "";
	if(point>=800){
		grade = "VVIP";
	}else if(point>=500){
		grade = "VIP";
	}else {
		grade = "일반고객";
	}%>
	<h2>포인트:<%=point%>, 고객등급:<%=grade%></h2>
	<%--
	ex1) 임의의 수를 1~10까지 발생해서 짝수일때와 홀수 일때를
	나누어, 오늘은 운이 좋은날입니다/ 오늘은 운이 안 좋으니 활동을
	삼가하깁시요 라고 출력되게 하세요.
	 --%>
	<%int rdNum = (int)(Math.random()*10+1);
	String luck = "";
	if(rdNum%2==0){
		luck = "운이 좋은 날";
	}else {
		luck = "운이 안좋으니 활동을 삼가하세요";
	}%>
	<h2>오늘의 운세 : <%=luck%></h2>
	<%--
	ex2) 나이는 1~90 임의로 나오게 하여
		13미만 : 어린이 사이트 입니다.
		~ 18 : 청소년 사이트 입니다.
	 --%>
	<%int rdage = (int)(Math.random()*90+1);
	String age = "";
	if(rdage<=13){
		age = "어린이 사이트입니다.";
	}else if(rdage<=18) {
		age = "청소년 사이트입니다.";
	}else if(rdage<=65) {
		age = "일반 사이트입니다.";
	}else {
		age = "노인 사이트입니다.";
	}%>
	<h2>나이 : <%=rdage%></h2>
	<h2>이용사이트 : <%=age%></h2>



</body>
</html>






















