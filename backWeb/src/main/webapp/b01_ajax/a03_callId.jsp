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
 	// form 하위에 있는 input은
 	// 기본적으로 enter를 클릭 자동을 submit을 처리가 된다.
 	// 이것을 방지하기 위해서
 	// event.preventDefault();
 	// 기본적인 이벤트를 방지 처리하여야 한다.
		document.addEventListener('keydown',
		  function(event) {
			  if (event.keyCode === 13) {
			     event.preventDefault();
			  };
		  }, 
		  true);
 	function ckIdKey(){
 		if(event.keyCode==13){
 			ckId()
 		}
 	}
 	function ckId(){
 		var idVal = document.querySelector("#id").value
 		var xhr = new XMLHttpRequest()
 		xhr.open("get","z03_data.jsp",false);//동기방식
 		xhr.send()
 		var arry = xhr.responseText.split(",")
		var hasId = false;
 		arry.forEach(function(id){
 			console.log(id)
 			if(idVal == id){
	 			hasId=true;
 			}
 		})
 		if(hasId){
 			alert("이미 등록된 아이디 있습니다.")
 		}else{
 			alert("등록가능")
 		}
 	}	
 		
 		/*
 		tds[0].innerText = arry[0]
 		tds[1].innerText = arry[1]
 		tds[2].innerText = arry[2]*/ 
 	
 	// ex) a03_callId.jsp
 	// id:[] [등록여부확인]
 	// z03_data.jsp
 	// himan, goodMan, higirl
 	// 데이터와 동일여부를 확인해서 없으면 등록가능
 	// 있으면 등록된 아이디 있습니다. 처리.
 </script>
<body>
    <div class="container mt-3">
    	<h2>아이디 입력</h2>
    	<form action="" method="post">
    		<input hidden="hidden"/>
         	<div class="mb-3 mt-3">
            <label for="id">id:</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="id 입력" name="id"
      	     onkeyup="ckIdkey()">
         	<button type="button" onclick="ckId()" class="btn btn-primary">등록여부확인</button>
     	</form>    	
    </div>
</body>
</html>