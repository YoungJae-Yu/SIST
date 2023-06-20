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
     String id = request.getParameter("id");
     if(id==null) id="";
     String isValid="";
     //초기화면/등록여부확인 구분
     if(id.equals("")){
    	 isValid="I";
     }else if(id.equals("himan")){
    	 isValid="Y";
     }else{
    	 isValid="N";    	 
     }
     %>
     <script type="text/javascript">

         // ex) a24_js_request.jsp
         // 회원등록
         // id:[   ][등록된여부] ==>
         // jsp : 요청값으로 himan 
         // js : 등록여부에 따라 등록된 회원 있습니다.
         // 등록가능합니다.
     
     </script>
<body>
    <div class="container mt-3">
    	<h2>ID 등록</h2>
    	<form method="post">
         	<div class="mb-3 mt-3">
            <label for="id">id입력:</label>
            <input type="text" class="form-control" 
      	     id="id" placeholder="아이디 입력" name="id">
         	</div>
         	<button type="button" id="btn01"class="btn btn-primary">등록여부</button>
     	</form>
     	<script type="text/javascript">
     		var btnObj = document.querySelector("#btn01");
     		var isValid = "<%=isValid%>"
         	if(isValid=='Y'){
         		alert("등록된 아이디가 있습니다.")
         	}
         	if(isValid=='N'){
         		alert("등록 가능한 아이디 입니다.")
         		document.querySelector("#id").value="<%=id%>";
         		// ID 에 대한 유효성이 완료될 때,  회원정보 등록이
         		// 가능하게 할 때, 꼭 필요..
         		console.log("# 등록 유효성 check #")
         		console.log(btnObj.value)
         		btnObj.innerText="유효성 확인완료";
         	}
     		btnObj.onclick=function(){
     			// 코드로 전송 처리...
     			document.querySelector("form").submit();
     		}
     	</script>
    </div>
</body>
</html>









