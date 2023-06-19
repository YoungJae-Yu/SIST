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
# jsp의 주요 내장 객체
1. 실제로 마지막에 전환될 servlet에서 선언된 객체를 말한다.
2. 주로 화면단 처리나 로직에서 많이 처리하는 객체를 사용할 때 활용된다.
3. 주요 객체 내용
	1) page : JSP 페이지에서 하나의 페이지의 구현에 사용하는 자바
		클래스의 인스턴스이다.
	2) request : 클라이언트 요청 정보를 저장하는 객체이다. 
	3) response : 응답 정보를 저장하는 객체이다.
	4) session : HTTP 세션 정보를 저장하는 객체이다.
		서버와 클라이언트의 연결된 상태를 기준으로 특정 변수를
		저장 범위로 처리한다.
	5) application : 웹 어플리케이션에 대한 정보를 저장한다.
		웹 서버 전체에 대한 저장 정보를 처리할 수 있다.
	6) out : jsp 페이지가 생성하는 결과를 출력할 때, 사용되는
		출력 스트림이다.
	7) config : JSP 페이지를 구현한 자바 클래스의 인스턴스이다.
	8) exception : 예외 객체, 예외 페이지에서만 사용된다.
 	# jsp에서 내장 객체 중에서 변수와 scope(시간에 따른 유지범위)
 	pageContext : 한페이지내에서만
 	request : 요청한 페이지까지 전달
 	session : 서버 vs 브라우저가 연결되어 있을 때까지
 	application : 서버가 재기동하는 범위까지
 	
 # out 기본 객체
 1. jsp페이지가 생성하는 모든 내용은 out 기본 객체를 통해서
 	전송 할 수 있다.
 2. 복잡한 if-else 문 사용시, out 기본 객체 사용하면 편리하다.
 	1) scriplet, expression 의 복잡한 사용보다.
 		특정한 경우 out으로 활용할 때, 더 효율적일 때가 많다.
 3. 출력 메서드
 	1) out.print():데이터를 출력만한다.
 	2) out.println():데이터를 출력하고 줄바꿈처리까지 한다.
 	3) out.newLine():줄바꿈 처리를 한다.
 	4) out.write() : char ==> 문자열 처리까지 출력..
 
 --%>
 <h2>script만 사용하는 경우</h2>
 <h3>
 	<%for(int cnt=1;cnt<=10;cnt++){ %>
 		<%=cnt %>
 	<%}%>
 </h3>
 <h2>out 객체 사용</h2>
 <h3>
 	<%for(int cnt=1;cnt<=10;cnt++){
 		out.print(cnt+", ");	
 	  }%>
 </h3>
 <%-- ex) 1~25까지 5X5테이블을 out이용하여 출력하되,
 		해당 cell을 클릭시, 배경색상이 변경되게 하세요..
 		1. 기본 tag로 기본틀을 만든다.
 		2. 반복적으로 처리할 내용 확인
 			==> 반복문 처리
 		3. 반복 step이 규칙적으로 다른 내용
 			==> if문 처리
 		 --%>
 	<table border width="300pt" height="300pt">
 	<%
 	for(int cnt=1;cnt<=25;cnt++){
 		if(cnt%5==1) out.print("<tr>");
 		out.print("<th onclick='call(this)'>");
 		out.print(cnt);
 		out.print("</th>");
 		if(cnt%5==0) out.print("</tr>");
 	}
 	%>
 	</table>

</body>
<script type="text/javascript">
function call(obj){
	obj.style.background ="yellow";
}
</script>
</html>