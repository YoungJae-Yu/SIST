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
 	function goAjax(){
 		var xhr = new XMLHttpRequest()
 		xhr.open("get","z02_data.jsp",false);//동기방식
 		xhr.send()
 		var data = xhr.responseText
 		//alert(data)
 		var arry= data.split(",")
 		//alert(arry)
 		var tds = document.querySelectorAll("tbody td")
 		arry.forEach(function(prod,idx){
 			//console.log(prod+":"+idx)
	 		tds[idx].innerText = prod
 		})
 		/*
 		tds[0].innerText = arry[0]
 		tds[1].innerText = arry[1]
 		tds[2].innerText = arry[2]*/ 
 	}
 	// ex) a03_callId.jsp
 	// id:[] [등록여부확인]
 	// z03_data.jsp
 	// himan, goodMan, higirl
 	// 데이터와 동일여부를 확인해서 없으면 등록가능
 	// 있으면 등록된 아이디 있습니다. 처리.
 </script>
<body>
    <div class="container mt-3">
    	<h2 onclick="goAjax()">물건 정보 가져오기</h2>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr class="text-center">
				    <th>물건명</th>
				    <th>가격</th>
				    <th>갯수</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr class="text-center">
			        <td></td>
			        <td></td>
			        <td></td>
			   	</tr>
		 	</tbody>
		</table>  
    </div>
</body>
</html>