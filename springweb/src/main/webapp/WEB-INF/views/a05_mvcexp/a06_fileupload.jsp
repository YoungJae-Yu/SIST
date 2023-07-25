<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
	<c:set var="path" 
	value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	.btn{white:200px; }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		var msg = "${msg}"
    		if(msg!="")
    			alert(msg)
    	});
    </script>         
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>파일업로드 DB 처리</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">
	  		<!-- 
	  		// fileInfos content
	  		 -->    	
	    	<form method="post" enctype="multipart/form-data" class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     placeholder="파일정보 입력" value="${param.content}" 
	      	     name="content"  aria-label="Search">
				<input type="file" class="form-control me-2" 
	      	     name="fileInfos" multiple="multiple"  aria-label="Search">
	         	<button type="submit" class="btn btn-primary" style="width:200px;">업로드</button>
	     	</form>
	 	    </div>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>번호</th>
				    <th>내용</th>
				    <th>파일명</th>
				    <th>등록일</th>
				    <th>수정일</th>
		      	</tr>
		    </thead>
		    <script>
		    	function down(fname){
		    		if(confirm(fname+"\n파일을 다운로드하시겠습니까?")){
		    			// download.do?fname=파일명
		    			location.href="${path}/download.do?fname="+fname
		    		}
		    	}
		    </script>
		    
		    <tbody>
		    	<c:forEach var="rs" items="${rlist}">
			   	<tr  onclick="down('${rs.filename}')" class="text-center">
			        <td>${rs.no}</td>
			        <td>${rs.content}</td>
			        <td>${rs.filename}</td>
			        <td><fmt:formatDate type="both"
			        	 dateStyle="short"
			        	 timeStyle="short"
			        	 value="${rs.regdte}"/></td>
			        <td><fmt:formatDate type="both"
			        	 dateStyle="short"
			        	 timeStyle="short"
			        	 value="${rs.uptdte}"/>			        
			        
			        </td>
			   	</tr>
			   	</c:forEach>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>