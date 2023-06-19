<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>등록한 회원 명단</h2>
	<%
	String members[]=request.getParameterValues("member");
	for(String member:members){
		if(member!=null&&!member.equals(""))
			out.print("<h3>"+member+"</h3>");
	}
	// ex) 구매물품의 가격 3개를 입력해서, 전송되게 하고,
	// 총비용을 출력하세요..(형변환 필요.)
	%>
	
	<h2>구매물품의 가격</h2>
	<%
	String prices[]=request.getParameterValues("price");
	int tot = 0;
	for(String priceS:prices){
		if(priceS!=null&&!priceS.equals("")){
			int price = Integer.parseInt(priceS);
			out.print("<h3>물건 가격 : "+price+"</h3>");
			tot += price;
		}
	}
	out.print("<h3>총 가격 : "+tot+"</h3>");
	%>
</body>
</html>