<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.google.gson.Gson"
    import="backWeb.a01_dao.*"
    import="backWeb.z01_vo.*"
    import="java.util.*"%>
<%
String title = request.getParameter("title");
if(title==null)title="";
A04_PreParedDao dao = new A04_PreParedDao();
List<Code> getCodeList = dao.getCodeList(title);
Gson gson  = new Gson();
%>
<%=gson.toJson(getCodeList)%>