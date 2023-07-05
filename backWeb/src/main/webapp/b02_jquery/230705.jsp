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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
   
    <script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
    <script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<%--

실습과제
[1단계:개념]1. jquery ajax의 속성에 대하여 기술하세요.
	1) url : 호출하는 backend단 주소
	2) type : "get/post"
	3) data : 요청 query string
		 json 객체 형식
		$("form").serialize() : form하위 내용을 name과 value값 기준으로
		쿼리 스트링을 만들어 준다. key=value&key=value로 변환하여 처리
		var enameVal = $("[name=ename]").val()
		var qstr="ename="enameVal+....
	4) dataType : 서버에서 받는 데이터유형
		문자열(text,xml)을 받지만, 
		"json" 객체로 변환 해준다. JSON.parse()를 처리하지 않아도 된다.
	5) success:function(data){}
		성공시 받는 데이터 함수
	6) error:function(err){}
		실패시 받는 데이터 함수..
		
[1단계:코드]2. 화면에서 가격, 할인율을 입력하는 순간, 서버에서 전달해서 서버에서 최종 가격을 전달해서 받아오게 출력하세요.
   (controller[가격계산], 화면jsp 구현)
   		--- 서버 ---
         // 1. 요청값
        String discount = request.getParameter("discount");
        if(discount==null || discount.equals(""))discount="0";
        int discountPrice = Integer.parseInt(price)*Integer.parseInt(discount)/100;
  		// 3. 화면호출(jsp/json출력)
		if(!price.equals("")) {
			response.getWriter().print("가격 : "+price+", 할인율(%) : "+discount+", 최종 금액 : "+ discountPrice);
		}else {
			response.getWriter().print("가격과 할인율을 입력하세요.");
		}
		--- jsp ---
		// JS
	<script type="text/javascript">
    	$(document).ready( function(){
    		$("input").onkey(function(){
    			var priceVal = $("#price").val()
    			$.ajax({
    				url:"${path}/prodCalcu.do",
    				data:"price="+priceVal+"&discount="+$("#discount").val(),
    				type:"post",
    				dataType:"text",
    				success:function(data){
    					alert(data)
    				},
    				error:function(err){
    					console.log("#에러발생#")
    					console.log(err)
    				}
    			})
    		})
    	});
    </script>
    // html
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="price" placeholder="가격 입력" name="price">
         	</div>
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="discount" placeholder="할인율 입력(%)" name="discount">
         	</div>
    
[1단계:코드]3. 급여등급을 선택시, 최소와 최대을 출력되게 하세요.
		--- 서버 ---
        // 1. 요청값
        String grade = request.getParameter("grade");
        if(grade==null || grade.equals(""))grade="0";
        // 2. 모델데이터
        A04_PreParedDao dao = new A04_PreParedDao();
        Salgrade s = dao.getSalgrade(grade);
        // 3. 화면호출(jsp/json출력)
		Gson g = new Gson();
		response.getWriter().print(g.toJson(s));
		
		--- js ---
	    <script type="text/javascript">
    	$(document).ready( function(){
    		$("selectGrade").click(function(){
    			var gradeVal = $("selectGrade").val()
    			$.ajax({
    				url:"${path}/prodCalcu.do",
    				data:"grade="+gradeVal,
    				type:"post",
    				dataType:"text",
    				success:function(data){
    					alert(data)
    				},
    				error:function(err){
    					console.log("#에러발생#")
    					console.log(err)
    				}
    			})
    		})
    	});
    	</script>
		
		--- html ---
		<select name="selectGrade">
		    <option>= 급여등급선택 =</option>
		    <option value="1">1</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">3</option>
		</select>

[1단계:코드]4. 사원번호를 입력해서 enter키 시, dao에 사원정보를 출력되게 하세요(없으면 해당사원없음 표시)

 --%>
     <script type="text/javascript">
    	$(document).ready( function(){
    		$("selectGrade").click(function(){
    			var gradeVal = $("selectGrade").val()
    			$.ajax({
    				url:"${path}/prodCalcu.do",
    				data:"grade="+gradeVal,
    				type:"post",
    				dataType:"text",
    				success:function(data){
    					alert(data)
    				},
    				error:function(err){
    					console.log("#에러발생#")
    					console.log(err)
    				}
    			})
    		})
    	});
    </script>
<body>
    <div class="container mt-3">
    
   	<select name="selectGrade">
	    <option>= 급여등급선택 =</option>
	    <option value="1">1</option>
	    <option value="2">2</option>
	    <option value="3">3</option>
	    <option value="4">3</option>
	</select>

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