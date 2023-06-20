<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>다양한 요소 객체 전송</h2>
	<form action="a11_revForm.jsp">
		숫자:<input type="number" name="num01" value="0"><br>
		색상:<input type="color"  name="color01" value="#0000"><br>
		날짜:<input type="date"  name="date01" value=""><br>
		<input type="submit">
		<%-- 
		# 날짜형 데이터 처리
		1. 출력형태의 문자열 확인
			YYYY/MM/DD, YYYY-MM-DD
		2. VO date로 처리가 안된다.
			1) VO date는 가져올 때, 처리된다.
			2) 문자열로 설정해서 전달하여
				DB에서 입력 시 to_date(문자열속성, 'YYYY/MM/DD')
				형식을 지정하여 형변환 처리한다.
				
			
			
		 --%>
	</form>
</body>
</html>