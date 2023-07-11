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
    		
    		//$("h2").text("jquery 로딩 성공")
    	});
    </script>      
    
    
</head>
<body>
<%
// ex) 구매물품의 가격을 클라이언트(브라우저)에 쿠키값을 누적시키는 처리


%>
    <div class="container mt-3">
    	<h2>구매 가격 등록(쿠키누적)</h2>
    	<form action="" method="post">
         	<div class="mb-3 mt-3">
            <input type="number" class="form-control" 
      	     id="price" placeholder="구매가격 입력" name="price">
         	</div>
         	<button type="submit" 
         	class="btn btn-primary">구매</button>
     	</form>
		    <%
		    	String priceS = request.getParameter("price");
		    	int price = 0;
		    	if(priceS!=null&&!priceS.equals(""))
		    		price=Integer.parseInt(priceS);
		    	// 쿠키값이 있으면 가져오고, 없으면 0
		   		Cookie cks[] = request.getCookies();
		   		int ckPrice = 0;
		   		for(Cookie  ck : cks){
		   			if(ck.getName().equals("price")){
		   				ckPrice =  Integer.parseInt(ck.getValue());
		   			}
		   		}
		   		int tot = price + ckPrice;
		   		// 누적 쿠키값을 client에 저장
		   		response.addCookie(new Cookie("price",""+tot));
		   	// ex) 구매한 물건을 누적해서 출력하게 하세요..
			// 구매 물건명 : [   ]
			// 구매한 물품리스트 : @@@ @@@ (쿠키값)
			// a13_buyList.jsp
		%>
		<table class="table table-striped table-hover">
			<thead class="table-success">
		      	<tr  class="text-center">
				    <th>이전 등록 가격</th>
				    <th>현재 총 가격</th>
		      	</tr>
		    </thead>
		    <tbody>
			   	<tr  class="text-center">
			        <td><%=price %></td>
			        <td><%=tot %></td>
			   	</tr>
		 	</tbody>
		</table>      	
    </div>
</body>
</html>