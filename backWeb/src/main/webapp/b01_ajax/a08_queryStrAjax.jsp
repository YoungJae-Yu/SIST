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
<script type="text/javascript">
	function getSyn(page){
 		var xhr = new XMLHttpRequest();
 		xhr.open("get",page,false);
 		xhr.send()
 		return xhr.responseText;
 	}
 	function callBB(){
 		var nameVal = document.querySelector("#name").value;
 		var seatVal = document.querySelector("#seat").value;
 		var hitVal = document.querySelector("#hit").value;
 		var page = "z08_reqJson.jsp?name="+nameVal+"&seat="+seatVal+"&hit="+hitVal
 		var empObj = JSON.parse(getSyn(page))
 		var tdArr = document.querySelectorAll("tbody td")
 		tdArr[0].innerText = empObj.playre
 		tdArr[1].innerText = empObj.seat
 		tdArr[2].innerText = empObj.hit
 		tdArr[3].innerText = empObj.heteronomy
 	}
 	// ex) 선수명 : [] 타석 : [] 안타 : [] [타율확인]
 	// 	z08_reqJson.jsp {"playre":"","seat":"","hit":""}
 	// 테이블로 정보 출력 선수면 타석 안타 타율
 	
 	
</script>
<body>
    <div class="container mt-3">
    	<h2>야구선수 등록</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <label for="name">이름:</label>
            <input type="text" class="form-control" 
      	     id="name" placeholder="이름 입력" name="name">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">안타:</label>
            <input type="number" class="form-control" 
      	     id="seat" placeholder="안타 입력" name="ename">
         	</div>
         	<div class="mb-3 mt-3">
            <label for="ename">타석:</label>
            <input type="number" class="form-control" 
      	     id="hit" placeholder="타석 입력" name="ename">
         	</div>
         	<%-- type="submit" 동기방식으로 화면전환으로 전송해버림.. --%>
         	<button type="button" onclick="callBB()" class="btn btn-primary">등록</button>
     	</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>이름</th>
				    <th>안타</th>
				    <th>타석</th>
				    <th>타율</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td></td>
			        <td></td>
			        <td></td>
			        <td></td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>