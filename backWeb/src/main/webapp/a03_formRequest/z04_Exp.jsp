<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="backWeb.z01_vo.Salgrade"%>
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
[1단계:개념] 1. java와 js의 연동 처리할 때, 
흐름 순서에 따른 코드 처리 순서를 기본예제와 함께 설명하세요

 1) backend에서 넘겨준 변수, jsp에서 처리
<%String name="홍길동";%>

 2) 요청값을 넘겨 js 코드를 만든 후, 처리
<script type="text/javascript">
var name = "<%=name%>"
alert("이름은:"+name)</script>

[1단계:코드] 2. java로 임의의 구구단을 만들어 html의 form에 출력하고, [ @@] x [@@   ]  정답입력[  ][정답확인]
              정답입력이 맞을시, 정답 그렇지 않을시 오답이 처리되게 하세요. java+js 연동--%>
<%
// 랜덤 구구단
	int rNum1 = (int)(Math.random()*9+1);
	int rNum2 = (int)(Math.random()*9+1);
	int rM = rNum1*rNum2;
%>   

<body>
<form>
   <span>[<%=rNum1 %>]</span>
   <span>X</span>
   <span>[<%=rNum2 %>]</span>
   정답입력:<input type="text" id="answer">
   <button type="button" onclick="call()">정답 확인</button>
</form>

<script>
var num01 = "<%=rNum1%>"
var num02 = "<%=rNum2%>"
var tot = num01 * num02
var obj = document.querySelector("#answer");

function call() {
   if(tot==obj.value){
      alert("정답입니다.")
   }else {
      alert("오답입니다.")
   }   
}
</script>
<%--[1단계:코드] 3. salgrade 테이블을 확인하여, 해당 항목에 맞는 
속성으로 form 화면을 구성하고, 입력 후, 확인시, 요청값 처리후,
Salgrade 객체에 등록이 되어 출력되게 처리하세요.--%>    
<%
	String gradeS = request.getParameter("grade");
	String losalS = request.getParameter("losal");
	String hisalS = request.getParameter("hisal");
	z05_ExpDao dao= new z05_ExpDao();
	String regYN="F";
	if(gradeS!=null){
		Salgrade s = new Salgrade(gradeS,losalS,hisalS) ;
		dao.insertSalgrade(s);
		regYN="Y";
	}
%>
<script>
	var regYN = "<%=regYN%>";
	if(regYN=='Y'){
		alert("등록 성공");
	}
	function checkValid(){
		return true;
	}
</script>
    <div class="container mt-3">
    	<h2>급여 등급 확인</h2>
    	<form onsubmit="return checkValid()" method="post">
         	<div class="mb-3 mt-3">
            <label for="grade">등급:</label>
            <input type="number" class="form-control" 
      	     id="grade" placeholder="등급 입력" name="grade">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="losal">최저급여:</label>
            <input type="number" class="form-control" 
      	     id="losal" placeholder="최저급여 입력" name="losal">
         	</div>
         	</div>
         	<div class="mb-3 mt-3">
            <label for="hisal">최고급여:</label>
            <input type="number" class="form-control" 
      	     id="hisal" placeholder="최고급여 입력" name="hisal">
         	</div>
         	<div class="mb-3 mt-3">
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
     		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>등급</th>
				    <th>최저급여</th>
				    <th>최고급여</th>
		      	</tr>
		    </thead>
		    <tbody>
		    	<%for(Salgrade s:dao.slist()){ %>
			   	<tr  class="text-center">
			        <td><%=s.getGrade()%></td>
			        <td><%=s.getLosal() %></td>
			        <td><%=s.getHisal() %></td>
			   	</tr>
			   	<%}%>
		 	</tbody>
		</table> 
    </div>
</body>
</html>




