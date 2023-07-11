<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
	<c:set var="path" 
	value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<%--
# jsp에서 에러 처리
1. 웹개발 프로그래밍을 하면 에러가 발생할 수 있다.
	자바 프로그램에서는 이러한 헤어가 발생되면 예외처리로 해당 에러에
	대한 내용의 원인을 출력해주고, 에러가 발생하더라도 프로세스가
	멈추지 않게 한다.
2. 웹개발에서는 위 내용과 함께 jsp 화면에서 에러에 대하여 어떻게
	표현하고, 처리해주는 것까지 포함된다.
3. 에러처리의 방식
	1) 각 에러가 발생한 페이지별로 에러 처리 페이지 설정
	2) 웹서버 단위로 에러의 내용에 따라 에러 처리 페이지 설정.
		- web.xml에서 서버단위 에러 코드나 에러 객체를 선언하여
		대체되는 화면을 로딩하게 처리한다.
# 각 화면별 에러 처리 페이지 구현
1. 에러가 발생했을 때, 처리한 페이지 설정
	<%@ page isErrorPage="true"%>
	위 옵션을 통해서 에러가 발생했을 때, 대체하는 페이지임을 명시하면
	exception 객체를 참조값에 의해 바로 사용할 수 있고,
	해당 객체의 메서드를 사용할 수 있다.
2. 에러가 발생할 가망성이 있는 페이지에 위 에러처리페이지 설정
	<%@ page errorPage = "위 만들어 둔 에러페이지 지정"%>
# 서버 단위로 에러 페이지 지정 구현
0. 위와 같이 모든 페이지에 설정을 하지 않더라도 효과적으로 에러를
	페이지를 대체할 수 있다.
	web.xml에서 해당 로딩 페이지를 지정하여 처리한다.
	기본 에러페이지 만들기
	아래 형식에 따른 web.xml 선언..
1. class단위 예외 처리
	자바에서 처리되는 대부분 클래스 단위 예외에 대한 설정 부분이다.
	1) 하위 클래스/사용자정의 예외 선언
			<error-page>
			<exception-type>java.lang.XXXException</exception-type>
			<location>경로지정</location>
	2) 최상위 클래스 선언.
		<error-page>
			<exception-type>java.lang.Exception</exception-type>
			<location>경로지정</location>

2. http 코드 에러로 설정..
	1) 응답코드를 아래와 같이 설정
	<error-page>
		<error-code>응답코드</error-code>
		<location>에러페이지</location>
		webapp기준으로 하위에 특정한 경로에 에러페이지를 지정하여 처리
	2) 응답코드종류
		200 : 요청이 성공적으로 처리
		301 : 요청한 자원이 이동, 헤더 정보에 이동 위치를 알려줄테니 다시요청
		304 : 클라이언트가 임시 보관한 응답 결과와 다르지 않다.
		400 : 잘못된 요청
		403 : 사용자허가모드오류
		404 : 요청한자원 못찾음
		405 : 요청한 method 지원하지 않음
		500 : 서버 내부에서 오류가 발생
			프로그램적 오류(java를 클래스예외는 이 경우에 해당된다.)


 --%>
<body>
    <div class="container mt-3">
    	<h2>사원정보 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="empno">사원번호:</label>
            <input type="number" class="form-control" 
      	     id="empno" placeholder="사원번호 입력" name="empno">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
      	     id="ename" placeholder="사원명 입력" name="ename">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>Firstname</th>
				    <th>Lastname</th>
				    <th>Email</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>