<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
       <h2>성적 등록</h2>
       <form action="/">
            </form>
       <table class="table">
          <thead class="table-success">
               <tr class="text-center">
                 <th>이름</th>
                 <th>국어</th>
                 <th>영어</th>
                 <th>수학</th>
                 <th>총계</th>
                 <th>평균</th>
               </tr>
          </thead>
          <tbody>
               <tr class="text-center">
               	<%
               	String name = request.getParameter("name");
               	int kor = 0,eng = 0,math = 0;
               	String korS = request.getParameter("kor");
               	if(korS!=null) kor = Integer.parseInt(korS);
               	String engS = request.getParameter("eng");
               	if(engS!=null) eng = Integer.parseInt(engS);
               	String mathS = request.getParameter("math");
               	if(mathS!=null) math = Integer.parseInt(mathS);
               	int tot = kor+eng+math;
               	int avg = tot/3;
               	%>
                 <td><%= name%></td>
                 <td><%= kor%></td>
                 <td><%= eng%></td>
                 <td><%= math%></td>
                 <td><%= tot%></td>
                 <td><%= avg%></td>
               </tr>
          </tbody>
        </table>         
     </div>
</body>
</html>