<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="project.janjan.VO.*"
    import="project.janjan.DAO.*"
    %>
<%
	// 아이디 중복 확인 백앤드 파일(.jsp)
	String id = request.getParameter("id");
	if(id==null)id="";
	MemberDao dao = new MemberDao();
	Member checkId = dao.checkId(id);
	if (checkId != null) {
	  out.println("N");
	} else {
	  out.println("Y");
	}
%>