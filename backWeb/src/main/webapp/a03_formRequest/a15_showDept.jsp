<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Dept"
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

    <div class="container mt-3">
    <h2>부서 내역</h2>
  <table class="table">
    <thead class="table-success">
      <tr>
        <th>부서번호</th>
        <th>부서명</th>
        <th>부서지역</th>
      </tr>
    </thead>
    <%
    String deptnoS = request.getParameter("deptno");
    int deptno=0;
    if(deptnoS!=null){deptno=Integer.parseInt(deptnoS);}
    String dname = request.getParameter("dname");
    if(dname==null){dname="";}
    String loc = request.getParameter("loc");
    if(loc==null){loc="";}
    Dept d = new Dept(deptno, dname, loc);
    %>
   <tbody>
      <tr>
        <td><%=d.getDeptno() %></td>
        <td><%=d.getDname() %></td>
        <td><%=d.getLoc() %></td>
      	</tr>
    </tbody>
     </table>
        <div class="input-group mb-3">
        <span class="input-group-text">부서번호</span>
        <input type="text" class="form-control" value="<%=d.getDeptno() %>">
      </div>
        <div class="input-group mb-3">
        <span class="input-group-text">부서명</span>
        <input type="text" class="form-control" value="<%=d.getDname() %>">
      </div>
        <div class="input-group mb-3">
        <span class="input-group-text">부서지역</span>
        <input type="text" class="form-control" value="<%=d.getLoc() %>">
      </div>
  </div>

</body>
</html>