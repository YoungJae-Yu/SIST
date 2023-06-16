<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
text-align:center;
background-color:pink;
border-radius: 4px;
font-size: 50px;
}
</style>
</head>
<body>
<script type="text/javascript">
function call(obj){
	obj.style.background = "yellow";
}
</script>
	<%--
	ex) 물건명=@@@&가격=@@@&물건명&가격=@@@...
	테이블로
	구매내역
	no 물건명 가격
	1  ...	...
	
	~~
	총비용 @@
	 ?pname=사과&price=3500&pname=딸기&price=5500&pname=바나나&price=4500
	 --%>
	 <%
	 
	 %>
	<table border width = "50%" height="300px";>
	<tr><th>NO.</th><th>물건명</th><th>가격</th></tr>
	 <%
	String pname[] = request.getParameterValues("pname");
	String priceS[] = request.getParameterValues("price");
	int tot = 0;
	 if(pname!=null){
			for(int idx=0;idx<priceS.length;idx++){
				int price = Integer.parseInt(priceS[idx]);
				out.print("<tr><td onclick=call(this)>"+(idx+1)+"</td><td onclick=call(this)>"+pname[idx]+"</td><td onclick=call(this)>"+price+"</td></tr>");
				tot+=price;
			}
		}
	out.print("<tr><td onclick=call(this) colspan='2'>총계</td><td>"+tot+"</td></tr>");
	%>
	</table>
</body>
</html>