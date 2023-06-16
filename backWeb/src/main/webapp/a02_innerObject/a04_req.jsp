<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "backWeb.z01_vo.Jobs"
    import = "backWeb.a01_dao.A04_PreParedDao"
    import = "java.util.List"
    %>
   <%
   A04_PreParedDao dao = new A04_PreParedDao();
   List<Jobs> jlist = dao.getJobs();
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--ex) a04_req.jsp?pname=사과&price=3000&cnt=5

구매물품:@@
구메가격:@@
구매갯수:@@
총액:@@
1. 우선 데이터를 구매갯수까지 출력하고
2. 가격과 갯수를 형변환처리하여 총액을 변수에 할당 후,
3. 총액과 함께 전체 데이터를 요청값에 의해 출력하세요.
--%>

	<%
	String pname = request.getParameter("pname");
	String priceS = request.getParameter("price");
	String cntS = request.getParameter("cnt");
	
	int price = 0;
	int cnt = 0;
	
	if(priceS!=null&&cntS!=null){
		price = Integer.parseInt(priceS);
		cnt = Integer.parseInt(cntS);
	}
	int tot = price * cnt;
	%>
	<h2>query string 통해서 데이터 받기</h2>
	<h3>구매물품:<%=pname %></h3>
	<h3>구매가격:<%=price %></h3>
	<h3>구매갯수:<%=cnt %></h3>
	<h3>총액:<%=tot %></h3>
	
<%--
[1단계:실습] 1. 직책정보를 jsp에서 Combo 박스로 출력하세요(- jobs 테이블 참고, DAO,JSP처리) --%>
	직책정보:<select name="j">
		 <option>선택</option>
		<%for(Jobs j:jlist){ %>
		 <option value='<%=j.getJob_id()%>'><%=j.getJob_title() %></option>
		 <%} %>
	</select>
<%--
[1단계:실습] 2. 웹화면에서 main.jsp을 두고, 상단페이지(top.jsp), 하단페이지(bottom.jsp)
             를 include지시자로 두어 처리하되, java, js, css 코드를 top.jsp에 선언하여
             main.jsp, bottom.jsp에서 호출하는 것을 처리해보세요. 
-- top에 선언 -- 
<style type="text/css">
	h2{background-color:pink;}
</style>
<script type="text/javascript">
function call(obj){
		obj.style.background = "red";
}
</script>

 -- -- -- -- --
     
 -- main.jsp --
 <%@ include file = "top.jsp" %>
<h2 onclick="call(this)">메인 페이지(클릭)</h2>

-- top.jsp --
<%@ include file = "top.jsp" %>
<h2 onclick="call(this)">하단 페이지(클릭)</h2>
 --%>
             
             
<%--
[1단계:실습] 3. 쿼리스트링으로 회원정보(아이디,패스워드,이름,권한,포인트)를 전송하고 이것을 출력하세요 --%>


<%--
[1단계:실습] 4. 쿼리스트링으로 선수의정보(이름, 타석,안타)를 통해서 타석과 안타를 형변환하여 이름,타율을 출력하세요
 --%>
</body>
</html>




















