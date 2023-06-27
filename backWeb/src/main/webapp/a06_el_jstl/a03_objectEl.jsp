<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Person"
    import="backWeb.z01_vo.Member"
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
	<%
	session.setAttribute("p01", new Person("홍길동",25,"서울"));
	session.setAttribute("mem", new Member("himan","7777","홍길동","관리자",3000));
	//  ex) db에 job_history(테이블 없어서 dept로 함)기준을 VO를
	// 만들어 session으로 할당하고 출력하세요..
	// Date타입을 추가적으로 String 으로 만들어 출력되게 하세요.
	session.setAttribute("dept", new Dept(10,"총무","서울"));
	%>
    <div class="container mt-3">
		<h2>dept 예제</h2>	
		<a href='a03_session.jsp'>세션확인하러가기</a>
    	<h3>부서번호:${dept.deptno}</h3>
    	<h3>부서이름:${dept.dname}</h3>
    	<h3>근무지역:${dept.loc}</h3>
    	<h2>el 활용</h2>
    	<h3>이름:${p01.name}</h3>
    	<%-- p01.getXXX 
    		주의) getXXX로 호출되는 property이다...
    	--%>
    	<h3>나이:${p01.age}</h3>
    	<h3>사는곳:${p01.loc}</h3>
    	<h2>회원 정보</h2>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>아이디</th>
				    <th>패스워드</th>
				    <th>이름</th>
				    <th>권한</th>
				    <th>포인트</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td>${mem.id}</td>
			        <td>${mem.pass}</td>
			        <td>${mem.name}</td>
			        <td>${mem.auth}</td>
			        <td>${mem.point}</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>