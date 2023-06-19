<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.User"
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
    <%
    String name = request.getParameter("name");
    if(name==null){name="";}
    
    String gender = request.getParameter("gender");
    if(gender==null){gender="";}
    
    String pNumS = request.getParameter("pNum");
    int pNum=0;
    if(pNumS!=null){pNum=Integer.parseInt(pNumS);}
        
    User d = new User(name,gender, pNum);
    %>
        <div class="input-group mb-3">
        <span class="input-group-text">이름</span>
        <input type="text" class="form-control" value="<%=u.getName() %>">
      </div>
        <div class="input-group mb-3">
        <span class="input-group-text">성별</span>
        <input type="text" class="form-control" value="<%=u.getGender() %>">
      </div>
        <div class="input-group mb-3">
        <span class="input-group-text">휴대폰 번호</span>
        <isnput type="number" class="form-control" value="<%=u.getPNum() %>">
      </div>
  </div>
</body>
</html>