<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		var sessName = "${mem.name}";
		if(sessName==""){
			alert("로그인이 필요합니다\n로그인 화면이동")
			location.href="${path}/login";
		}	
		 */
		var sessId = "${mem.id}"
		if(sessId!=$("#writer").val()){
			$("#uptBtn").hide()
			$("#delBtn").hide()
		}		 
		$("#reBtn").click(function(){
		    if(confirm("답글을 처리하겠습니까?")){
		       $("#refno").val($("#no").val())
		       $("#subject").val("RE:"+$("#subject").val())
		       $("#content").val("\n\n\n\n===이전글===\n"+$("#content").val())
		       $("form").attr("action", "${path}/boardInsert")
		       $("form").submit();
		    }
		 })
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("form").attr("action","${path}/boardUpdate");
				$("form").submit();
			}
		})
		$("#delBtn").click(function(){
			if(confirm("삭제 하시겠습니까?")){
				location.href="${path}/boardDelete?no="
						+$("#no").val()
			}
		})		
		var msg = "${msg}"
		if (msg != "") {
			
			if(msg.indexOf("수정")!=-1){
				if (confirm(msg+"\n 조회화면으로 이동 하시겠습니까?")) {
					location.href = "${path}/boardList"
				}
			}
			
			if(msg.indexOf("삭제")!=-1){
				alert(msg+"\n 조회화면으로 이동 합니다.")
				location.href = "${path}/boardList"
			}	
		}
		$("#goMain").click(function() {
			location.href = "${path}/boardList"
		})
	});
</script>
</head>

<body>
	<div class="input-form-backgroud row">
		<div class="input-form col-md-12 mx-auto">
			<h4 class="mb-3">게시판 상세</h4>
			<form method="post" enctype="multipart/form-data"
				class="validation-form" novalidate>
				<!-- ctrl+shift+f (코드정리) 
						글번호   답글번호
						제목
						작성자   조회수
						등록일   수정일
						내용
						첨부파일	
				-->
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="no">글번호</label> 
							<input name="no" type="text"
							value="${board.no}" readonly class="form-control  ckValid"
							id="no"  required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="refno">답글번호</label> 
							<input name="refno" type="text"
							value="${board.refno}" readonly class="form-control  ckValid"
							id="refno"  required>		
					</div>					
				</div>

								
				<div class="mb-3">
					<label for="subject">제목</label> 
					   <input name="subject" type="text" 
					   value="${board.subject}"
						class="form-control ckValid" id="subject"
						placeholder="제목 입력" required>
				</div>				
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="writer">작성자</label> 
							<input name="writer" type="text"
							value="${board.writer}" readonly class="form-control  ckValid"
							id="writer"  required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="readcnt">조회수</label> 
							<input name="readcnt" type="text"
							value="${board.readcnt}" readonly class="form-control  ckValid"
							id="readcnt"  required>
						
					</div>					
				</div>	
				<div class="row">
					<div class="col-md-6 mb-3">
						<label >등록일</label> 
						<input type="text"
							value=
							'<fmt:formatDate pattern="yyyy-MM-dd" 
								value="${board.regdte}"/>' 
								readonly class="form-control  ckValid">
					</div>
					<div class="col-md-6 mb-3">
						<label >수정일</label> 
						<input type="text"
							value='<fmt:formatDate  pattern="yyyy-MM-dd"  value="${board.uptdte}"/>' readonly class="form-control  ckValid">		
					</div>					
				</div>				
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea name="content" class="form-control  ckValid" id="content"
						placeholder="내용 입력" required rows="5">${board.content}</textarea>
					<div class="invalid-feedback">내용를 입력해주세요.</div>
				</div>
				<div class="mb-3">
					<div class="custom-file">
						<input type="file" name="report" class="custom-file-input"
							multiple="multiple" id="file01"> <label
							class="custom-file-label" for="file01">파일 선택</label>
					</div>
				</div>

				<script type="text/javascript">
					$(".custom-file-input").on("change", function() {
						$(this).next(".custom-file-label").text($(this).val())
					})
				</script>
				<div class="mb-4"></div>
				<button id="reBtn" class="btn btn-primary btn-lg btn-block"
					type="button">답글 달기</button>
				<button id="uptBtn" class="btn btn-warning btn-lg btn-block"
					type="button">수정</button>
				<button id="delBtn" class="btn btn-danger btn-lg btn-block"
					type="button">삭제</button>
					
				<button id="goMain" class="btn btn-info btn-lg btn-block"
					type="button">조회 화면</button>
			</form>
		</div>
	</div>
</body>
</html>