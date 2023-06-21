<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Member"
    import="backWeb.a01_dao.A05_MemberDao"
    import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
</head>
<%--
	// backendWeb.z01_vo.Member
	// Member(String id, String pass, String name, String auth, int point) 

# 요청값으로 VO 객체 생성.
1. 요청값으로 호출된 내용을 여러개의 데이터로, VO 객체를 생성하는데
	까지 처리하여, 다른 모듈에 매개값으로 처리되는 경우가 많다.
2. 이 내용에서 처리한 중점사항.
	1) 기본 요청화면 구현
	2) 요청화면에서 form객체에 의해 넘겨지는 데이터가 
		어떤 유형인지 파악
		주의사항
		- number 형변환
		- date(DB) : 문자열로 받아서 db sql에서
			to_date(문자열, '형식')
			ex) sql : to_date(?, 'YYYY-MM-DD')
					pstmt.setString(5, vo.getDateS());
					
	3) 요청값에 의해 처리되는 값에 의해 type에 따른 VO객체 만들기
	4) 요청값이 null 및 유형이 잘 못 전달될 때에 대한 대비
		- 일반적으로 js에 의해 사전에 유효성 처리
	5) 요청값의 null에 대한 처리 
	6) type 변환 처리(String ==> 숫자/boolean형)
	7) VO객체의 생성자 생성 및 해당 생성자에 데이터 처리.
	8) DAO연동??
	9) 모든 처리가 끝나 후, js로 등록성공/실패 등에 대한 메시지 처리.
	

 --%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String auth = request.getParameter("auth");
	String pointS = request.getParameter("point");
	// 초기값과 비교 처리 처리.
	// 15:05~
	A05_MemberDao dao = new A05_MemberDao();
	String regYN="F";
	if(id!=null){// 입려 form에 입력이 되었을때
		int point = Integer.parseInt(pointS);
		// vo 객체로 받아들이기..
		Member m = new Member(id,pass,name,auth,point) ;
		log("# 회원등록 VO로 성공#");
		log(m.getId());
		log(m.getPass());
		log(m.getName());
		log(m.getAuth());
		log(""+m.getPoint());
		dao.insertMember(m);
		regYN="Y";
	}
%> 
<script>
	var regYN = "<%=regYN%>";
	if(regYN=='Y'){
		alert("등록 성공");
	}
	function checkValid(){
		// 유효성 check 처리..
		// 1) 필수데이터 입력처리
		// 2) 아이디 사전 check
		// 3) 패스워드 확인
		// 4) 숫자형/날짜. 데이터확인
		return true;
	}
</script>
<body>
	
    <div class="container mt-3">
    	<h2>회원 등록</h2>
    	<form onsubmit="return checkValid()" method="post">
         	<div class="mb-3 mt-3">
            <label for="id">아이디:</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="아이디 입력" name="id">
         	</div>
         	<%--
         	# 패스워드/패스워드확인은 등록시 반드시 check해야할 내용.
         	--%>
         	<div class="mb-3 mt-3">
            <label for="pass">패스워드:</label>
            <input type="password" class="form-control" 
      	     id="pass" placeholder="패스워드 입력" name="pass">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="name">이름:</label>
            <input type="text" class="form-control" 
      	     id="name" placeholder="이름 입력" name="name">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="auth">권한:</label>
            <input type="text" class="form-control" 
      	     id="auth" placeholder="권한 선택" name="auth">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="point">포인트:</label>
            <input type="text" class="form-control" 
      	     id="point" placeholder="초기포인트입력" name="point">
         	</div>         	         	         	
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>아이디</th>
				    <th>이름</th>
				    <th>권한</th>
				    <th>포인트</th>
				    <th>등록일</th>
		      	</tr>
		    </thead>
		    <tbody>
		    	<%for(Member m:dao.mlist()){ %>
			   	<tr  class="text-center">
			        <td><%=m.getId()%></td>
			        <td><%=m.getName() %></td>
			        <td><%=m.getAuth() %></td>
			        <td><%=m.getPoint() %></td>
			        <td><%=m.getRegdate()%></td>
			   	</tr>
			   	<%}%>
		 	</tbody>
		</table> 
    </div>
</body>
</html>