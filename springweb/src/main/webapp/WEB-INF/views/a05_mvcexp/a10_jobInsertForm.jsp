<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good day!!</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style type="text/css">
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:auto;text-align:left;
		border:1px solid green;
	}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#mainBtn").click(function(){
			location.href="${path}/jobFormList.do"			
		})
		$("#ckId").click(function(){
			ckValidId()

		})
	});
	function ckValidId(){
	 	var idVal = $("#job_id").val()
	 	var idLen = idVal.length
 		// "등록불가":"등록가능";
	 	if(idLen<4 || idLen>8){
	 		alert("등록 아이디는 글자는 4~8이여야 합니다.")
	 	}else{
	 		// checkJob_id.do?job_id=PU_MAN
	 		$.ajax({
	 			url:"${path}/checkJob_id.do",
	 			data:"job_id="+idVal,
	 			dataType:"text",
	 			success:function(msg){
	 				var msg = msg.replaceAll("\"","")
	 				alert(msg)
	 				if(msg=="등록가능"){
	 					$("#ckId").val("유효성재확인")
	 					$("[name=job_id]").attr("readonly",true)
	 				}else{
	 					alert("다른 아이디 입력하세요")
	 					$("#job_id").val("").focus()
	 				}
		 		},
		 		error:function(err){
		 			console.log(err)
		 		}
		 			
		 	})
	 	}
	 			
	}
</script>
</head>
<body>
<div class="jumbotron text-center">
 	<h2 >직책 등록</h2>
</div>	
<div class="container">
	<form method="post">
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">직책아이디</span>
		</div>
		<input type="text" id="job_id" name="job_id" class="form-control" 
			placeholder="글자수는 4~8자/중복불가"/>
		<input id="ckId" type="button" class="btn btn-info" value="유효성확인" />
			
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">직책명</span>
		</div>
		<input type="text" name="job_title" class="form-control" 
			placeholder="글자수는 8자이상/중복불가"/>
		<input  id="ckTitle"  type="button" class="btn btn-info" value="유효성확인" />	
			
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">최소급여</span>
		</div>
		<input type="number" name="min_salary" class="form-control" placeholder="숫자입력"/>	
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">최대급여</span>
		</div>
		<input type="number" name="max_salary" class="form-control" placeholder="숫자입력" />	
	</div>	
				
	<div style="text-align:right;">
		<input type="submit" class="btn btn-success" value="등록" id="regBtn"/>
		<input type="button" class="btn btn-primary" value="조회리스트" id="mainBtn"/>		
	</div>	
	</form>		
</div>
</body>
</html>