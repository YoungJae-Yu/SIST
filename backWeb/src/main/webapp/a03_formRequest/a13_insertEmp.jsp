<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Emp"
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
    <h2>등록 내역</h2>
  <table class="table">
    <thead class="table-success">
      <tr>
        <th>사원번호</th>
        <th>사원명</th>
        <th>직책번호</th>
        <th>관리자번호</th>
        <th>입사일(문자열)</th>
        <th>급여</th>
        <th>보너스</th>
        <th>부서번호</th>
      </tr>
    </thead>
    <%
    String empnoS = request.getParameter("empno");
    int empno=0;
    if(empnoS!=null) empno=Integer.parseInt(empnoS);
    String ename = request.getParameter("ename");
    if(ename==null) ename="";
    String job = request.getParameter("job");
    if(job==null) job="";
    String mgrS = request.getParameter("mgr");
    int mgr=0;
    if(mgrS!=null) mgr=Integer.parseInt(mgrS);
    String hiredateS = request.getParameter("hiredateS");
    if(hiredateS==null) hiredateS="";
    String salS = request.getParameter("sal");
    double sal=0;
    if(salS!=null) sal=Double.parseDouble(salS);
    String commS = request.getParameter("comm");
    double comm=0;
    if(commS!=null) comm=Double.parseDouble(commS);
    String deptnoS = request.getParameter("deptno");
    int deptno=0;
    if(deptnoS!=null) comm=Integer.parseInt(deptnoS);
    // 숫자(정수형/실수형)
    // 문자열
    Emp e = new Emp(empno, ename, job, mgr, hiredateS, sal, comm, deptno);
    // dao.insertXXX(e)
    %>
    <%--
    1. 요청값 ==> 객체변환
    	어디에 필요할까?
    2. 숫자형
    	1) 정수형
    		기본 데이터 선언 = 0;
    		문자열 요청 변수 선언 요청값 처리
    		문자열 요청 변수 null아닐 때 형변환 처리.
    	2) 실수형
    3. 문자열
    	null을 ""으로 처리
    4. 객체 type맞는 생성자 선언.(type과 갯수 확인)
    
    	ex) a14_formDept.jsp
    		부서번호 부서명 직책명
    		a15_showDept.jsp
    		요청값==> 객체 ==> 객체 getXX출력
    
     --%>
    <tbody>
      <tr>
        <td><%=e.getEmpno() %></td>
        <td><%=e.getEname() %></td>
        <td><%=e.getJob() %></td>
        <td><%=e.getMgr() %></td>
        <td><%=e.getHiredateS() %></td>
        <td><%=e.getSal() %></td>
        <td><%=e.getComm() %></td>
        <td><%=e.getDeptno() %></td>
   		</tr>
    </tbody>
    <%--
    <tbody>
      <tr>
        <td><%=request.getParameter("empno") %></td>
        <td><%=request.getParameter("ename") %></td>
        <td><%=request.getParameter("job") %></td>
        <td><%=request.getParameter("mgr") %></td>
        <td><%=request.getParameter("hiredateS") %></td>
        <td><%=request.getParameter("sal") %></td>
        <td><%=request.getParameter("comm") %></td>
        <td><%=request.getParameter("deptno") %></td>
   		</tr>
    </tbody>
     --%>
  </table>
  </div>


</body>
</html>