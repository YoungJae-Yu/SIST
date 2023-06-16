<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp include 지시자로 페이지 지정 --%>
<%@ include file = "a11_subPage.jsp" %>
<h2>현재 페이지의 메인 내용</h2>
<h2>선언된 변수를 사용:<%= name %></h2>
<%-- ex) a12_main.jsp 아래 내용을 include지시자에 의해 호출
						및 변수 사용..
a13_sub.jsp(js, java 변수 선언, 화면2x2테이블) --%>
<%-- 
# jsp의 디렉티브 지시자
1. jsp 페이지의 선언적 형태로 지시자를 이용해서 화면에 대한
	설정 정보나 외부라이브러리, 외부화면들을 처리할 수 있다.
	<%@ 지시자명 %>
2. 종류
	1) page
		해당 jsp 페이지의 속성을 설정한다.
		language속성은 jsp페이지에서 사용할 언어를 지정한다.
		contentType : 출력할 화면 형식으로 일반적으로
			html코드 기반인 경우 text/html을 선언한다.
			그외에서 excel파일, pdf파일, 파일 다운로드 등의
			형식을 선언하여 처리할 수 있다.
		pageEncoding : 페이지의 영어 외 언어에 대한 encoding
			방식을 선언하는 것이다.
		import : 사용할 외부 객체에 대한 패키지와 클래스명 선언
		isError : 예외 처리시 예외 페이지인지 여부
		buffer : Buffer메모리 설정 여러가지 페이지 관련 속성을 지정한다.
	2) taglib : jsp 페이지에서 사용할 태그 라이브러리를 선언한다.
		prefix는 태그의 접두사를 정의하고, uri는 태그 라이브러리의
		위치를 지정한다.
		java코드로 사용하는 script의 확장으로 보다 효과적으로
		화면구성을 하게 처리할 수 있는 확장형 taglib을 선언하여
		사용할 수 있다.
		ex) <tab01 pattern = "t01"/>
	3) include : 다른 jsp 파일을 현재페이지에 포함할 때 사용한다.
		file 속성에 포함할 파일의 경로를 지정한다.
		페이지 안에 공통적인 변수나 html에 사용할 공통화면을 활용하고자
		할 때 사용한다.
3. 주요 팁
	1)반드시 java 코드의 경우 포함된 페이지의 변수는 상단에서
		하단으로 컴파일 처리와 실행 처리되기에, 위치 선언을 명확하게
		하여야 한다.(소스내 코드로 생각)
	2) css, js의 선언 규칙도 하나의 소스로 생각해서 그대로 적용된다.
		- window.onload=function(){}
		- inline style 등에 대한 적용 등 ...
		
 --%>

</body>
</html>