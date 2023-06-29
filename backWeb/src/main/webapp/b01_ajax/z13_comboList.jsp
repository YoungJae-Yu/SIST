<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.google.gson.Gson"
    import="backWeb.a01_dao.*"
    import="backWeb.z01_vo.*"
    import="java.util.*"%>
<%
String title = request.getParameter("title");
if(title==null)title="";
String refnoS = request.getParameter("refno");
int refno = 0;
if(refnoS!=null&&!refnoS.equals(""))
		refno = Integer.parseInt(refnoS);
A04_PreParedDao dao = new A04_PreParedDao();
List<Code> getCodeList = dao.getCodeList(title,refno);
Gson gson  = new Gson();
%>
<%=gson.toJson(getCodeList)%>