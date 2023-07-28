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
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		search()  // 초기화면 로딩
    		
    		$("#region_name").keyup(function(){
    			// 키입력시 enter입력시만 호출처리
    			// 주의) form 하위는 enter키로 submit가 default
    			// 이벤티가 있기에 이를 막아주는 설정을 하여야 한다.
    			
    			search()
    		})
    		$("#schBtn").click(function(){
    			search()
    		})
			$("#insBtn").click(function(){
				if(confirm("지역을 등록하겠습니까?")){
					$.ajax({
	    				type:"post",
	    				url:"${path}/regInsert.do",
	    				data:$("#regFrm").serialize(),
	    				dataType:"text",
	    				success:function(data){// data ==> 리턴값
	    					search()
	    						$("#regFrm")[0].reset()
	    					if(!confirm(data+"\n계속 등록하시겠습니까?")){
	    						$("#clsBtn").click()
	    					}
	    					
	    				},
	    				error:function(err){
	    					console.log(err)
	    				}
					})
				}
			})
    	});
    	function search(){
    		$.ajax({
    			url:"${path}/regData.do",
    			type:'post',
    			data:"region_name="+$("#region_name").val(),
    			dataType:"json",
    			success:function(regList){
    				console.log(regList)
    				var add=""
    				// region_id=5&region_name
    				regList.forEach(function(reg){
    					add+="<tr>"
    					add+="<td>"+reg.region_id+"</td>"
    					add+="<td>"+reg.region_name+"</td>"
    					add+="</tr>"
    				})
    				$("#show").html(add)
    			}
    		})
    	}
    </script>      
    
    
</head>
<body>
    <div class="container mt-3">
    	<h2>지역정보 리스트</h2>
	  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  		<div class="container-fluid">    	
	    	<form method="post"  class="d-flex align-items-center" >
	            <input type="text" class="form-control me-2" 
	      	     id="region_name" placeholder="지역명 입력" 
	      	     name="region_name"  aria-label="Search">
	         	<button type="button" id="schBtn"class="btn btn-primary" style="width:200px;">조회</button>
	         	<button id="regBtn" type="button" 
	         		class="btn btn-success" 
	         		data-toggle="modal" data-target="#exampleModalCenter"
	         		>등록</button>
	         			         	
	     	</form>
	 	    </div>
	 	</nav>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>지역아이디</th>
				    <th>지역명</th>
		      	</tr>
		    </thead>
		    <tbody id="show">
			   	<tr  class="text-center">
			        <td>John</td>
			        <td>Doe</td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">지역 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form  id="regFrm"   class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" 
	        	placeholder="지역아이디 입력" name="region_id">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control"
	        	 placeholder="지역명 입력" name="region_name">
	      </div>
	     </div>    
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" id="clsBtn" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="insBtn" class="btn btn-success">지역등록</button>
      </div>
    </div>
  </div>
</div>  
    
    
</body>
</html>