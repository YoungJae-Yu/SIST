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
# 반복문과 조건문 활용
1. 여러가지 유형의 script를 통한 java/html 코드를 처리할 수 있다.
2. 반복문과 조건문을 활용하면, 로직에 의한 여러가지 형태의 화면을 구현이 가능하다.
3. 주로 사용되는 연산식
	1) 비교연산자 ==, !=
	2) 논리연상자 &&, ||, !
	3) 사칙연산자(나머지연산자)
		% : 반복문에서 주로 특정한 index의 구분코드를 반복적으로 
		처리하여 화면을 구현할 때 사용된다.
		<tr>을 특정 조건에 따른 사용
		if(cnt%4==1)
	4) 문자열 비교
		equals() : 정확하게 같을 때,
		indexOf() : 포함되어 있을 때
	5) 숫자 비교
		
4. 처리 유형 형태
	1) 기본 로직을 이용한 반복문/조건문 처리
	2) 반복문 밖에 전역변수를 활용하여 처리하는 형태	
 --%>
 <%-- 1~10까지 출력하되 총합산을 마지막에 출력하세요
 	출력형태 1 + 2 + 3 ... = 총합..
  --%>
	<h2>
	<%--
	1. java코드로 처리
	2. <%%> 처리할 내용, <%=%>을 구분, 화면을 처리할 부분
	 --%>
	<%
	int tot = 0;
	for(int cnt=1; cnt<=10; cnt++){
		tot+=cnt;
		%>
		<%=cnt %>
	<%
		if(cnt==10){
	%>
			= <%=tot %>
	<%		
		}else{
	%>		
			+
	<%
		}
	}
	%>
	</h2>
	<%-- ex) 반복문을 활용하여 임의의 구구단을 설정하고,
		테이블을 통해서 출력하세요
	 	@@단
	 	@ X 1 = @@
	 	@ X 2 = @@
	 	@ X 3 = @@
	 	...
	 --%>
	 <table border>
	 <%int rNum = (int)(Math.random()*9+1);
	 for(int cnt=1;cnt<=9;cnt++){
	 %>
	 	<tr><td><%=rNum %> X <%=cnt %> = <%=rNum*cnt%></tr></td>
	 
	 <%}%>
	 </table>
	 <%-- ex2) 홀수/짝수 표시
	 	1~10 출력
	 	no 구분
	 	1  홀수
	 	2  짝수
	 	...
	 	10 짝수
	  --%>
	  <table border>
	  	<tr><td>NO.</td><td>구분</td></tr>
	  <%
	  for(int cnt=1;cnt<=10;cnt++){
	  %>
	  	<tr><td><%=cnt%></td><td>
	  	<%if(cnt%2==0){%>
	  		짝</td></tr>
	  	<%}else{%>
	  		홀	
	  	<%}%>
	  <%}%>
	  </table>
	  <%-- ex3) form 화면에서
	  	테이블로 학번 국어 영어 수학 평균
	  		   1 [70][70][70][@@]
	  		   
	  	점수부분은 <input 형식을 value값에 점수가 입력되어
	  	출력되게 하고, 반복문을 통해서 학생 5명을 출력하되
	  	점수는 임의로 0~100사이에 나오게 하세요
	   --%>
	   <form>
	   <table border width="40%">
	   <tr><td>학번</td><td >국어</td><td>영어</td><td>수학</td><td>평균</td></tr>
	   <%
	   int sum = 0;
	   for(int cnt=1;cnt<=5;cnt++){
	   %>
	   <%
	   int rkPoint = (int)(Math.random()*101);
	   int rePoint = (int)(Math.random()*101);
	   int rmPoint = (int)(Math.random()*101);
	   int avgPoint = (rkPoint+rePoint+rmPoint)/3;
	   sum += avgPoint;
	   %>
	   		<tr><td><%=cnt %></td>
	   		<td><input type="text"size="2"value="<%= rkPoint%>"></td>
	   		<td><input type="text"size="2"value="<%= rePoint%>"></td>
	   		<td><input type="text"size="2"value="<%= rmPoint%>"></td>
	   		<td><%=avgPoint%></td></tr>
	   <%}%>
	   <tr><th colspan="4">총평균</th><th><%=sum/5%></th></tr>
	   </table>
	   </form>

<%--실습예제1) jsp 스크립트릿에서 조건문을 활용하여 테이블로 홀/짝을 만들어서 정답을 클릭했을 때, 임의의 정답/오답으로 처리되게 하세요
	1) 화면구성
	2) 구슬게임 로직으로 컴퓨터의 결과 처리
		1~6개 임의의 구슬 쥐기
		if문과 %연산자에 의해 홀/짝 결과 처리
	3) 화면에 js에 위 내용에 따른 결과 alert으로 처리
		홀짝 이벤트로 맞을 때, 구슬 갯수와 정답 출력
		함수를 정의(구슬의 갯수, 홀짝 정보, 정답여부 전달)
--%>
<%int rn = (int)(Math.random()*6+1);
String rst = rn%2==0?"짝":"홀";%>
<h2>임의의 홀짝게임!</h2>
<table border width="30%" heigth="100pt">
	<%--
	# js와 jsp의 연동 처리시 주의 사항.
	1. 숫자형/boolean 데이터 : ''없이 그대로 할당 
		ex) 변수 = <%=자바변수%>
	2. 문자열 데이터 : 반드시 '',""에 할당해서 입력
		ex) 변수 = '<%=자바변수%>'
	
	 --%>
<tr>
<td onclick="call(<%=rn%>,'홀','<%=rst%>'=='홀')">홀</td>
<td onclick="call(<%=rn%>,'짝','<%=rst%>'=='짝')">짝</td>
</table>
<script>	
function call(cnt,rst,isCor) {
	if(isCor){
		alert(rst+" 맞추었습니다! 구슬의 갯수:"+cnt);
	}else{
		alert(rst+" 오답입니다! 구슬의 갯수:"+cnt);		
	}
}
</script>
<%--실습예제2) jsp 스크립트릿에서 조건문/반복문을 활용하여 4행 4열을 만들어 3/6/9게임의 내용을 1~16까지 내용으로 표시하세요--%>
<table width = "50%" border>
<%
// out.print("태그") : 화면 출력하는 jsp out 객체의 print 메서드
for(int i=1; i<=16;i++){
	if(i%4==1){out.print("<tr>");}
	out.print("<td>");
	// 1,2,짝...10,11,12,짝..
	out.print(i%10!=0 && i%10%3==0?"짝":i);	
	out.print("</td>");	
	if(i%4==0){out.print("</tr>");}
}
%>
</table>
<%--실습예제3) 도서 대출 정보를 VO로 만들어 화면에 표시할 때, 
			테이블로 화면에 출력하세요.--%>	
</body>
</html>




























