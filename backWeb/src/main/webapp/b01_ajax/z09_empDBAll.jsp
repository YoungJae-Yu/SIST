<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="backWeb.a01_dao.A04_PreParedDao"
	import="backWeb.z01_vo.Emp"%>
<%
A04_PreParedDao dao = new A04_PreParedDao();
for (Emp e : dao.elist()) {
%>
<tr class="text-center">
	<td><%=e.getEmpno()%></td>
	<td><%=e.getEname()%></td>
	<td><%=e.getJob()%></td>
	<td><%=e.getMgr()%></td>
	<td><%=e.getHiredateS()%></td>
	<td><%=e.getSal()%></td>
	<td><%=e.getComm()%></td>
	<td><%=e.getDeptno()%></td>
</tr>
<%
}
%>
