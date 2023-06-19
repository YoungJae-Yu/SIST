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
<%--
실습과제
[1단계:개념] 1. 요청값과 다중데이터 처리, form 형식 처리, form의 여러가지 형식에 따른 처리를 조원들과 함께 먼저 정리후 아래 문제를 풀어 보세요.

[1단계:코드] 2. form형식으로 다중 처리하는 예제를 아래 3가지 형식으로 선언하고 다음 페이지에 출력하세요
   1) 구매할 물건명 입력(type=text)
<body>
    <div class="container mt-3">
    <h2>3가지 형식 예제</h2>
    <form action="/">
<%-- 예제1-1 
         <div class="mb-3 mt-3">
            <label for="pname">물건명:</label>
            <input type="text" class="form-control" id="pname" placeholder="물건명 입력" name="pname">
         </div>
   2) 결재할 물건의 가격(type=checkbox) : 선택된 것만--%>
<%-- 예제1-2 
		<%
	 	String prices[] = {"3000","4000","5000"};
	 	%>
		<h3>물건의 가격 check</h3>
		<%for(String price:prices){ %>
			<input type="checkbox" name="price" 
			value="<%=price%>"/><%=price %><br>
		<%} %>    
   3) select로 구매할 물건의 가격 : ctrl로 선택된 것만--%>
<%-- 예제1-3  
		<h3>물건의 가격</h3>
		<select name="price" multiple>
		<%for(String price:prices){ %>
				<option><%=price+"[sel]" %></option>
		<%} %>
		</select>
	<button type="submit" class="btn btn-primary">등록</button>
     </form>
  </div>
[1단계:코드] 3. bootstrap형식으로 회원등록 화면 form 만들고, 등록시, 요청값 받아 VO객체로 생성 및 출력한 내용을 처리하세요.
-- z02_exp.jsp -- 
<body>
    <div class="container mt-3">
    <h2>회원 등록</h2>
    <form action="z03_exp.jsp">
         <div class="mb-3 mt-3">
            <label for="name">이름:</label>
            <input type="text" class="form-control" 
              id="name" placeholder="이름 입력" name="name">
         </div>
       <div class="mb-3 mt-3">
      <label for="gender">성별:</label>
      <select class="form-control" id="gender"name="gender">
      <option>=성별 선택=</option>
      <option>남</option>
      <option>여</option>
      </select>
         <div class="mb-3 mt-3">
            <label for="pNum">휴대폰 번호:</label>
            <input type="number" class="form-control" 
              id="pNum" placeholder="ex) 01012341234" name="pNum">
         </div>      
         <button type="submit" class="btn btn-primary">등록</button>
     </form>
  </div>
</body>
-- z03_exp.jsp --
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
--%>  
</body>
</html>