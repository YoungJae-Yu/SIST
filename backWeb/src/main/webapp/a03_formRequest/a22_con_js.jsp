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
 <%
 // DB에서 가져온 데이터..
 	String name="토마토";
	int price = 5000;
	int cnt = 10;
	int tot = price*cnt;
	boolean isAult = tot>=50000;
 
 %>
 <script type="text/javascript">
 	var name = "<%=name%>"
    var price = <%=price%>
    var cnt = <%=cnt%>
    var tot = <%=tot%>
    var isAult= <%=isAult%>
    function check01(){
	    alert(name)    	
    }
    function check02(){
	    alert(price)    	
    }
    function check03(){
	    alert(cnt)    	
    }
    function check04(){
	    if(isAult){
	    	alert(tot+" 고가")
	    }else{
	    	alert(tot+" 저가")    	
	    }
    }
    
    
//    alert("가격:"+price)
//  alert("갯수:"+cnt)
//    if(isAult){
//	    alert("총액(고가):"+tot)
//    }else{
//    	alert("총액(저가):"+tot)
//    }
    // 다시 서버 넘기는 방법?? form 객체 query string 전달
    // ex) a22_con_js.jsp
    // java 구매물건명, 가격, 갯수 설정 후..
    // js에 해당 내용 할당 후
    // 총계와 함께 50000이상 고가 그외 저가로 출력(alert)
 
 </script>
<body>
    <div class="container mt-3">
    	<h1>구매 정보</h1>
    	<h2 onclick="check01()">물건명 확인</h2>
    	<h2 onclick="check02()">가격 확인</h2>
    	<h2 onclick="check03()">갯수 확인</h2>
    	<h2 onclick="check04()">고가 여부</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="empno">사원번호:</label>
            <input type="number" class="form-control" 
      	     id="empno" placeholder="사원번호 입력" name="empno">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">사원명:</label>
            <input type="text" class="form-control" 
      	     id="ename" placeholder="사원명 입력" name="ename">
         	</div>
         	<button type="submit" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>Firstname</th>
				    <th>Lastname</th>
				    <th>Email</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>