<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<c:set var="path" 
	value="${pageContext.request.contextPath}"/>
<%--
pageContext.request.contextPath
:웹서버와 연동된 프로젝트명으로 default webapp위치를 잡아준다.
:프로젝트명이 다를지라도 webapp 하위의 여러 자원들을 
절대경로로 접근이 가능하다.

 --%>

<fmt:requestEncoding value="utf-8"/>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "${path}/a00_com/jquery-3.7.0.js" 
    	type="text/javascript"></script>
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		$("h2").text("jquery 로딩 성공")
    		$("h2").click(function(){
    			// $(this) : 클릭한  html의 레이블이 클릭되었습니다.
    			// 출력..
    			$(this).text("클릭되었습니다.");
    			$("h3").text("모든 h3글자 변경!")
    		})
    		// ex) p를 5개 만들고 클릭해보세요 출력..
    		// 클릭시, touch me?? 클릭한 것만.
    			$("p").click(function(){
    				$(this).text("touch me??");
    			});
    	/*
    	# 레이블 변경
    	1. innerText ==>
    		$("선택자").text("변경할데이터")
    		$("선택자").text()
    	2. innerHTML
    		$("선택자").html("<h2>안녕</h2>")
    		$("선택자").html()
    	3. value
			$("[name=name]").val("할당")
			$("[name=name]").val()
	    4. 기본 속성
	    	1) align="center" img="a01_img.jpg"
	    		$("선택자").attr("align","center")
	    		$("선택자").attr("img","a01_img.jpg")
	    5. style속성
	    	1) style="background:red;color:blue;"
	    		$("선택자").css("background","red")
	    		$("선택자").css("color","blue")
	    		$("선택자").css({
	    			background:"red",
	    			color:"blue"
	    		})
	    		
    		
    		
    	*/
    	});
    </script>      
</head>
<body>
    <div class="container mt-3">
	    <p>클릭해보세요</p>
	    <p>클릭해보세요</p>
	    <p>클릭해보세요</p>
	    <p>클릭해보세요</p>
	    <p>클릭해보세요</p>
    	<h2>사원정보 등록</h2>
    	<h2>사원정보 등록</h2>
    	<h2>사원정보 등록</h2>
    	<h2>사원정보 등록</h2>
    	<h2>사원정보 등록</h2>
    	<h2>사원정보 등록</h2>
    	<h3>기본경로:${path}</h3>
    	<h3>기본경로:${path}</h3>
    	<h3>기본경로:${path}</h3>
    	<h3>기본경로:${path}</h3>
    	<%--  /backendWeb/ : webapp 경로와 동일 절대경로 --%>
    	<img src="/backendWeb/z01_upload/img01.png" 
    		width="200pt" height="200pt"/>
      	<img src="${path}/z01_upload/img01.png" 
    		width="200pt" height="200pt"/>  		
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="title" placeholder="직책명 입력" value="${param.title}" name="title"  aria-label="Search">
	            <input type="text" class="form-control me-2" 
	      	     id="min_sal1" placeholder="최소급여 시작"  
	      	     value="${empty param.min_sal1? 0: param.min_sal1}"  name="min_sal1"  aria-label="Search">
	      	    ~
	            <input type="text" class="form-control me-2" 
	      	     id="min_sal2" placeholder="최소급여 마지막" 
	      	      value="${empty param.min_sal2? 9999999: param.min_sal2}"  name="min_sal2"  aria-label="Search">
	      	     
	      	     
	         	<button type="submit" class="btn btn-primary" style="width:200px;">조회</button>
	     	</form>
	 	    </div>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>Firstname</th>
				    <th>Lastname</th>
				    <th>Email</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			        <td>john@example.com</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>