<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="backWeb.a01_dao.*"
	import="backWeb.z01_vo.*"%>
<%
A05_MemberDao dao = new A05_MemberDao();
for (Member m: dao.mlist()) {
%>
	<tr class="text-center">
	<td><%=m.getId()%></td>
	<td><%=m.getPass()%></td>
	<td><%=m.getName()%></td>
	<td><%=m.getPoint()%></td>
	<td><%=m.getAuth()%></td>  
	 </tr>
<%
}
%>