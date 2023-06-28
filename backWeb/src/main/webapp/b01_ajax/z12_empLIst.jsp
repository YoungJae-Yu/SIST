<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.google.gson.Gson"
    import="backWeb.a01_dao.*"
    import="backWeb.z01_vo.*"
    import="java.util.*"
    %>
<%--
backend (z12_empList.jsp?ename=A&job=A)
		요청값 : 사원명(ename), 직책(job)
		import : Dao,Vo, Gson
		List<Emp> empList = dao.getEmpList(ename,job)
		<%=gson.toJson(empList)%>
--%>
<%
String ename = request.getParameter("ename");
if(ename==null)ename="";
String job = request.getParameter("job");
if(job==null)job="";
A04_PreParedDao dao = new A04_PreParedDao();
List<Emp> empList = dao.getEmpList(ename, job);
Gson gson  = new Gson();
%>
<%=gson.toJson(empList)%>