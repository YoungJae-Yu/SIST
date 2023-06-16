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
# 배열 데이터 처리.
1. 배열을 이용하면 for문과 if문을 통해서 다양한 형식의
	웹 화면을 처리할 수 있다.
2. 실무 프로그램
	1) combo
	2) radio
	3) checkbox
	ex) 검색 : 
		사원명 [      ]
		부서명 [select]
			전체
			10  인사
			20  재무
			..
		DB에서 DAO로 불러온 데이터를 선택해서
		검색할 수 있게 처리해야 한다.
		==> 등록/수정/삭제시에도 위 DAO에서
		불러온 데이터 기준으로 선택해서 처리함으로
		데이터의 무결성/일관성에 문제가 없이 처리된다.
--%>
<ol>
<%String []fruits = {"사과","바나나","딸기"};
for(String fruit:fruits){
%>	
	<li><%=fruit %></li>
<%}
%></ol>
<%-- ex) select의 option내용에 맞는 부서 정보를 배열로 선언하고 출력 
		select 인사/회계/재무/기획
--%>
<%String []parts = {"인사","회계","재무","기획"};
int pcodes[] = {10,20,30,40};
%>
부서:
<select onchange = "alert('선택값:'+this.value)">
	<
<%
for(int idx=0;idx<parts.length;idx++){
%>	
	<option value='<%=pcodes[idx]%>'><%=parts[idx] %></option>
<%}
%>
</select>
</body>
</html>