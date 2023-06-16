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
# request
1. jsp에서 client단에 있는 정보를 서버단에 전송해서,
	서버단에서 받을 때, 사용하는 객체를 말한다.
2. 기능내용
	1) 요청값처리(***)
	2) 쿠키정보 전달
	3) request 범위 데이터 저장
	4) 기타 클라이언트에서 전달되어서 서버단에 처리하는 기능메서드..
# 요청값 처리 단계별 학습내용.
1. query string 이란 무엇인지?
	서버에 있는 jsp/서버의 servlet 등에 client가 데이터를 전송하는 방식
	페이지?key=value&key2=value2&key3=value3
	==> 주의 query string을 client단 프로그램이 처리한다.
	
2.서버단에서 받는 request의 메서드
	request.getParameter("key") : value
	String val = request.getParameter("key");
	result.jsp?id=himan
	
	String reqId = request.getParameter("id");
	// key인 id에 요청값으로 himan으로 query string전송하면
	// 위 코드에 의해서 reqId에는 "himan"할당되어 있다.
	// 이렇게 데이터를 서버에서 받아서 DB를 처리한다.
	
# 여러 유형 데이터 받기 정리
	1. default 문자열받기
	2. 숫자형(정수형/실수형)
	3. boolean형 받기	
	
3. form요소객체와 query string과의 관계
	?key=val&key1=val1
	
	name="key" value="val"
	name="key" value="val"
4. form에 있는 속성
	요소객체의 속성을 통한 데이터 처리
	- action
	- method : get/post
5. 단일 데이터 전송과 다중 데이터 전송
	1) front단(js)
		location.href="a01.jsp?id="+idVal+"&pwd="+passVal
		<a href="a02.jsp?id=himan&pwd=7777">특정페이지 호출 </a>
	2) back단(jsp)
		조건문에서 처리
		reponse.sendRedirect("a02.jsp?pname=사과&price=3000");
6. 다양한 query string 처리 예시
	request.getParameterValues("")
	1) 순수 query string으로 처리
	2) from 요소객체
		<input type="text" name="req01">
		<input type="text" name="req01">
		<input type="text" name="req01">
		
		<input type="checkbox" name="ck01"> checked가 된 다중
		<input type="checkbox" name="ck01">
		<input type="checkbox" name="ck01">
		<input type="checkbox" name="ck01">
		
		<select name="req2" multiple> ctrl로 선택한 다중
			<option>사과</option>
			<option>바나나</option>
			<option>딸기</option>
			<option>오렌지</option>
		
7. form요소객체, dao와 연동하여
	1) 조회
	2) 등록
	3) 수정
	4) 삭제 처리..
	
# query string에 의해 데이터 받기
a02_request.jsp?name=홍길동
age, loc로 나이와 사는곳 데이터 입력하고,
화면에 나이와 사는곳의 정보를 출력..
hint)페이지?key=value&key2=value2&key3=value3

a03_req.jsp?name=마길동&kor=70&eng=80&math=90

String korS = request.getParameter("kor")
String engS = request.getParameter("eng")
// int kor = Integer.parseInt(korS); 에러 발생
int kor = 0;
if(kor==null){
	kor = Integer.parseInt(korS);
}else{
	int tot = kor+eng
}

ex) a03_req.jsp?name=마길동&kor=70
이름:@@@
국어(+10):@@@

 --%>
	<h2>query string 통해서 데이터 받기</h2>
	<h3>이름:<%=request.getParameter("name") %></h3>
	<h3>나이:<%=request.getParameter("age") %></h3>
	<h3>사는곳:<%=request.getParameter("loc") %></h3>
</body>
</html>

















