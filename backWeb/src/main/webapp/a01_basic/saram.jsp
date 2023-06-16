<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.saram.SaramMemDao"
    import="backWeb.saram_vo.Member"
    import="java.util.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 리스트</h2>
	<%
	String memberid = request.getParameter("memberid"); 
	if(memberid==null) memberid="";
	%>
	<form>
		사원번호:<input type="text"name="name"value="<%=memberid%>"/><br>
		<input type="submit"value="검색"/><br>
	</form>
	<table border>
	<tr><th>회원번호</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>폰번호</th><th>이메일</th><th>주소</th><th>공고번호</th></tr>
	<%
	SaramMemDao dao = new SaramMemDao();
	Map<String, String> sch = new HashMap<String,String>();
	sch.put("memberid",memberid);
	for(Member m:dao.getMemInfo(sch)){
	%>
	<tr>
		<td><%=m.getMemberid() %></td>
		<td><%=m.getMemName() %></td>
		<td><%=m.getMemBirth() %></td>
		<td><%=m.getMemSex() %></td>
		<td><%=m.getMemPhone() %></td>
		<td><%=m.getMemEmail() %></td>
		<td><%=m.getMemAddr() %></td>
		<td><%=m.getEmpNoticeld() %></td>
	</tr>
	<%}%>
	</table>
</body>
</html>