<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>
		var sessName = "${mem.name}";
		if(sessName==""){
			alert("로그인이 필요합니다\n로그인 화면이동")
			location.href="${path}/login";
		}
		$("#logout").click(function(){
			if(confirm("로그아웃 하시겠습니까?"))
				location.href="${path}/logout";
		})	
	});
</script>
</head>

<body>
<div class="container">
	<div class="jumbotron text-center" style="padding:35px 5px 0px 5px;">
	  <h2 data-toggle="modal" data-target="#exampleModalCenter"></h2>
	  <h2>답변형 게시판</h2><br>
	  <p align="right">${mem.name}님 로그인 중
	  					<button id="logout" class="btn btn-primary" 
	  					type="button">로그아웃</button></p>
	
	</div>

	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="subject" value="${param.subject}" class="form-control mr-sm-2" placeholder="제목" />
	    
	    <input name="writer" value="${param.writer}"  class="form-control mr-sm-2" placeholder="내용" />
	    <button class="btn btn-info  mr-sm-2" type="submit">Search</button>
	    <button  class="btn btn-success  mr-sm-2" id="regBtn" type="button">등록화면</button>
 	</nav>
	</form>
	<script type="text/javascript">
		$("#regBtn").click(function(){
			//if(confirm("등록화면 이동합니다.")){
			location.href="${path}/boardInsertFrm"
				
			//}
		})
	</script>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>	
    <tbody><!-- 10:05~ -->
    	<c:forEach var="board" items="${boardList}">
    	<tr ondblclick="detail(${board.no})">
    		<td>${board.cnt}</td>
    		<td class="text-left">
    			<c:if test="${board.level>1}">
    				<c:forEach begin="2" 
    				    end="${board.level}">
    					&nbsp;&nbsp;&nbsp;
    				</c:forEach>
    			</c:if>
    		
    		
    			${board.subject}</td>
    		<td>${board.writer }</td>
    		<td><fmt:formatDate value="${board.regdte}"/></td>
    		<td>${board.readcnt}</td></tr>
    	</c:forEach>
    </tbody>
	</table>     
	<script type="text/javascript">
		function detail(no){
			//if(confirm("상세화면이동")){
			location.href="${path}/boardDetail?no="+no
			//}
		}
	</script>   
</div>
</body>
</html>