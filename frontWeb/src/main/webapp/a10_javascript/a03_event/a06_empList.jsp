<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="frontWeb.A04_PreParedDao"
    import="frontWeb.vo.Employee"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>������� ����Ʈ</h2>
	<%
	// a06_empList.jsp
	// a06_empList.jsp?name=Lex&minSal=7000&maxSal=99999
	String name = request.getParameter("name"); 
	if(name==null) name="";
	String minSal = request.getParameter("minSal"); 
	if(minSal==null) minSal="0";
	String maxSal = request.getParameter("maxSal"); 
	if(maxSal==null) maxSal="99999";
	%>
	<form>
		�����:<input type="text"name="name"value="<%=name%>"/><br>
		�ּұ޿�:<input type="text"name="minSal"value="<%=minSal%>"/><br>
		�ִ�޿�:<input type="text"name="maxSal"value="<%=maxSal%>"/><br>
		<input type="submit"value="�˻�"/><br>
	</form>
	<table border>
	<tr><th>�����ȣ</th><th>�����1</th><th>�����2</th><th>�޿�</th><th>�μ���ȣ</th></tr>
	<%
	A04_PreParedDao dao = new A04_PreParedDao();
	Map<String, String> sch = new HashMap<String,String>();
	sch.put("name",name);
	sch.put("minSal",minSal);
	sch.put("maxSal",maxSal);
	for(Employee e:dao.getEmpList(sch)){
	 %>
	<tr>
		<td><%=e.getEmployee_id() %></td>
		<td><%=e.getFirst_name() %></td>
		<td><%=e.getLast_name() %></td>
		<td><%=e.getSalary() %></td>
		<td><%=e.getDepartment_id() %></td>
	</tr>
	<%}%>
	</table>
</body>
</html>