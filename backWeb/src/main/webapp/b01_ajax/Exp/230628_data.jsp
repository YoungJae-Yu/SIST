<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.google.gson.Gson"
    import="backWeb.a01_dao.*"
    import="backWeb.z01_vo.*"
    import="java.util.*"%>
<%
String dname = request.getParameter("dname");
if(dname==null)dname="";
String loc = request.getParameter("loc");
if(loc==null)loc="";
A04_PreParedDao dao = new A04_PreParedDao();
List<Dept> getDeptList = dao.getDeptList(dname, loc);
Gson gson  = new Gson();
%>
<%=gson.toJson(getDeptList)%>
