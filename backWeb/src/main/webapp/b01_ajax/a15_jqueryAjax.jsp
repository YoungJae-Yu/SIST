<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="utf-8"/>
<c:set var="path" 
	value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		$("h2").text("jquery 로딩 성공")
    		$("#sch").click(function(){
    			// ex)
    			// /backendWeb/empList.do?div=y
    			// jquery로 사원정보를 리스트 출력하세요.
    			search();
    		})
    	});
    	function search(){
    		var qstr="ename="+$("#ename").val()+
    			"&job="+$("#job").val()
    		
    		$.ajax({
    			url:"${path}/empList.do?div=y",
    			type:"post",
    			data:qstr,
    			dataType:"json",
    			success:function(data){
    				var empList = data
    				console.log(empList)
    				var html='';
    				empList.forEach(function(emp){
    					console.log(emp)
        				html+='<tr  class="text-center">'
            			html+='<td>'+emp.empno+'</td>'
            			html+='<td>'+emp.ename+'</td>'
            			html+='<td>'+emp.job+'</td>'
            			html+='<td>'+emp.mgr+'</td>'
            			html+='<td>'+emp.sal+'</td>'
            			html+='<td>'+emp.comm+'</td>'
            			html+='<td>'+emp.deptno+'</td>'
        			    html+='</tr>'    		
    				})

    				$("#show").html(html)
    			},
    			error:function(err){
    				console.log(err)
    			}
    		})
    	}
    </script>      
</head>
<body>
    <div class="container mt-3">
    	<h2>사원정보 조회</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="ename" placeholder="이름 입력" name="ename"  aria-label="Search">
	            <input type="text" class="form-control me-2" 
	      	     id="job" placeholder="직책명 입력"  name="job"  aria-label="Search">
	      	    <button type="button" id="sch" class="btn btn-primary" style="width:200px;">조회</button>
	     	</form>
	 	    </div>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>사원번호</th>
				    <th>사원명</th>
				    <th>직책</th>
				    <th>관리자번호</th>
				    <th>급여</th>
				    <th>보너스</th>
				    <th>부서번호</th>
		      	</tr>
		    </thead>
		    <tbody id="show">
			   	
		 	</tbody>
		</table>      	
    </div>
</body>
</html>