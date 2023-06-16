<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "backWeb.z01_vo.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
ex) 구매물품 상세 정보로 테이블과 form 요소객체를
이용하여, 물건명, 가격, 갯수, 상품정보를 table 안에 표현하되
VO객체를 만들어 value 값에 할당하세요.
1. 화면 구현
2. 화면에 출력될 속성
3. VO객체를 위한 class 선언
4. import VO객체
5. VO객체 생성
6. 화면에 expression으로 출력..
--%>
	<%
	Product p = new Product("사과",3500,5,"달달한 꿀사과");
	%>
<form>
<h2>구매물품 상세</h2>
<table border width="40%">
	<tr><th>물건명</th><td><input type="text" value="<%=p.getName()%>"/></td></tr>
	<tr><th>가격</th><td><input type="text" value="<%=p.getPrice()%>"/></td></tr>
	<tr><th>갯수</th><td><input type="text" value="<%=p.getNumber()%>"/></td></tr>
	<tr><th>상세정보</th><td>
			<textarea cols="20" rows="5"><%=p.getInfo() %></textarea>
		</td></tr>
	<tr><td colspan="2"><input type ="submit" value="구매"></td></tr>
	

</table>

</form>
</body>
</html>