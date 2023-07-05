<%request.setCharacterEncoding("utf-8");%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.janjan.VO.*"
    import="project.janjan.DAO.*"
    import="java.util.*"
    import="com.google.gson.Gson"
    %>
<%
String title = request.getParameter("title");
if(title==null) title="";

String refnoS = request.getParameter("refno");
int refno = 0;
if(refnoS != null) {
	refno = Integer.parseInt(refnoS);
}

AdminDao dao = new AdminDao();
List<Admin> adList = dao.getAdminList(title, refno);
Gson g = new Gson();
%>
<%=g.toJson(adList)%>