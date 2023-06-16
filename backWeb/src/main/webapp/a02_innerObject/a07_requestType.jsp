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
# 여러 유형 데이터 받기 정리
1. default 문자열받기
2. 숫자형(정수형/실수형)
3. boolean형 받기
 --%>
<%
	//요청값은 기본적으로 문자열이다.
	// 1. 숫자형을 사용할 때는 형변환을 처리하는데,
	//	  초기값이 없을 때(요청값이 없을 때)에 대한 처리를 하여야 된다.
	// 2. if(요청변수!=null)일 경우 형변환 처리
	// 3. default 데이터 설정 0
	String dblStr = request.getParameter("PI");
	double PI=0;
	if(dblStr!=null)
		PI = Double.parseDouble(dblStr);
	out.println("파이값:"+PI);
	String boolStr = request.getParameter("bool");
	boolean isTrue = false;
	if(boolStr!=null){
		isTrue = Boolean.parseBoolean(boolStr);
	}
	out.print("boolean값:"+isTrue);
	
	//ex) 원의 지름의 값을 요청값으로 입력 받아서, 면적을 구하세요(실수표현)
	String diameterS = request.getParameter("diameter");
	if(diameterS!=null){
		double diameter = Double.parseDouble(diameterS); 
		double circleArea = diameter/2*3.14;
		out.print("원의 면적:"+circleArea);
	}
%>
</body>
</html>
















