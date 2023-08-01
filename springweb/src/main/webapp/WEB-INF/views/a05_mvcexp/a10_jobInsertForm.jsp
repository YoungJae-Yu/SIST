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
	var msg = "${msg}"
	if(msg!=""){
		if(!confirm(msg+"\n계속 등록하시겠습니까?")){
			location.href="${path}/jobFormList.do"		
		}
	}
	$(document).ready(function(){
		$("#mainBtn").click(function(){
			location.href="${path}/jobFormList.do"			
		})
		$("#regBtn").click(function(){
			if($("#ckId").val()=="유효성확인"){
				alert("직책아이디 유효성 확인 하여야 등록가능 합니다.")
				return
			}
			if($("#ckTitle").val()=="유효성확인"){
				alert("직책명 유효성 확인 하여야 등록가능 합니다.")
				return
			}			
			$("form").submit()
		})
		
		$("#ckId").click(function(){
			if($(this).val()=="유효성확인"){
				var len = $("#job_id").val().length
			 	if(len<4 || len>8){
			 		alert("등록 아이디는 글자는 4~8이여야 합니다.")
			 		$("#job_id").focus()
			 	}else{
			 		ckValid("job_id","checkJob_id.do")
			 	}
			}else{
				if(confirm("다시 입력해서 유효성확인 하시겠습니까?")){
					$(this).val("유효성확인")
					$(this).prev().attr("readonly",false).focus()
				}
			}
		})
		$("#ckTitle").click(function(){
			if($(this).val()=="유효성확인"){
				var len = $("#job_title").val().length
			 	if(len<8){
			 		alert("등록 직책명은 8자이상 이여야 합니다.")
			 		$("#job_title").focus()
			 	}else{
			 		ckValid("job_title","checkJob_title.do")
			 	}
			}else{
				if(confirm("다시 입력해서 유효성확인 하시겠습니까?")){
					$(this).val("유효성확인")
					$(this).prev().attr("readonly",false).focus()
				}				
			}
		})		
	});
	// 매개변수1: 유효성 확인할 name이나 id값을 설정
	// 매개변수2: check할 유효성 확인 controller 주소//
	function ckValid(tar_str, url){
	 	 
 		$.ajax({
 			url:"${path}/"+url,
 			data:tar_str+"="+$("#"+tar_str).val(),
 			dataType:"text",
 			success:function(msg){
 				var msg = msg.replaceAll("\"","")
 				alert(msg)
 				if(msg=="등록가능"){
 					$("#"+tar_str).next().val("유효성재확인")
 					$("#"+tar_str).attr("readonly",true)
 				}else{
 					alert(tar_str+" 입력하세요")
 					$("#"+tar_str).val("").focus()
 				}
	 		},
	 		error:function(err){
	 			console.log(err)
	 		}
	 	})
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
		<input type="text" id="job_title" name="job_title" class="form-control" 
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
		<input type="button" class="btn btn-success" value="등록" id="regBtn"/>
		<input type="button" class="btn btn-primary" value="조회리스트" id="mainBtn"/>		
	</div>	
	</form>		
</div>
</body>
</html>