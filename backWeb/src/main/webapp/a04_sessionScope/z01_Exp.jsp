<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Member"
    import="backWeb.a01_dao.A05_MemberDao"
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<body>

<%--
실습과제
[1단계:개념] 1. session scope의 4가지 범위를 조원들과 함께 이해가 되었는지 확인하세요,
[1단계:코드] 2. member테이블을 기준으로 id가 있는지 여부를 확인하는 DB 처리를 해보세요
         회원아이디:[   ][등록여부확인] ==> dao (boolean getMember(String id)) ==> 등록여부에 따라 alert() 출력--%>
       <%
       A05_MemberDao dao = new A05_MemberDao();
       String id = request.getParameter("id");
       if(id==null)id="";
       
       String valid = "";
       if(dao.getMember(id)) {
    	   valid = "T";
       }
       if(!dao.getMember(id)){
    	   valid = "F";
       }
       
       %>
       <form  method="post">
            <div class="mb-3 mt-3">
            <label for="id">회원아이디:</label>
            <input type="text" class="form-control"
              id="id" placeholder="아이디 입력 입력" name="id">
            </div>

            <button type="submit" class="btn btn-primary">등록여부확인</button>
        </form>
       <script type="text/javascript">
       var v = "<%=valid%>"
       var id = "<%=id%>"
       if(id!=''){
    	   if(v=='T') {
    		   alert('이미 등록된 ID입니다')
    	   }
    	   if(v=='F'){
    		   alert('사용 가능한 ID입니다.')
    	   }
       }</script>
       <%-- dao getMember메서드
       	public boolean getMember(String id) {
		boolean isid = false;
	      String sql = "SELECT id\r\n"
	      		+ "FROM member02\r\n"
	      		+ "WHERE id=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         	pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	        	 isid = true;
	         }
	      } catch (SQLException e) {
	         System.out.println("DB:"+e.getMessage());
	      }catch(Exception e) {
	         System.out.println("기타:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      return isid;
	   }
        --%>
         
<%--
[1단계:코드] 3. session 범위로 num01을 할당하고, a01_sess.jsp <==> a02_sess.jsp 이동 시마다 증가하게 하세요.
 --%>
  
</body>
</html>