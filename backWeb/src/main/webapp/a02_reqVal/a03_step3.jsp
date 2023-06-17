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
# 요청값중에 동일한 key여러개의 데이터를 전송하는 경우
1. query string : 
	페이지?key1=val1&key2=val2&key3=val3
2. 이런 요청 처리
	1) 구매물건을 여러개 전송
	2) 등록할 회원정보가 여러개 전송
	3) checkbox에 의해 선택된 정보가 여러개 일 경우
3. 기능 메서드
	String arry[] = request.getParameterValues("다중key");
	for(String str:arry){
		out.print(str)
	}
	int tot = 0;
	for(String str:arry){
		int num = Integer.parseInt(str)
		out.print(num)
		tot+=num;
	}
a03_step03.jsp?fruit=사과&fruit=바나나&fruit=딸기
a03_step03.jsp?cnt=3&cnt=2&cnt=5
 --%>
 <%
String fruits[] = request.getParameterValues("fruit");
if(fruits!=null)
	for(String fruit:fruits){
		out.print("<h2>"+fruit+"</h2>");
	}
String cnts[] = request.getParameterValues("cnt");
if(cnts!=null){
	int tot = 0;
	for(String cnt:cnts){
		int cntInt = Integer.parseInt(cnt);
		tot += cntInt;
		out.print("<h3>구매할 갯수:"+cntInt+"</h3>");
	}
	out.print("총 구매갯수:"+tot);
}
 %>
 
</body>
</html>





























