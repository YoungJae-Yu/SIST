<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- jsp include 지시자로 페이지 지정 --%>
<%@ include file = "a13_sub.jsp" %>
<h2 onclick="call()">클릭해보세요 -<%= name %>-</h2>
<h2>메인 화면 입니다.</h2>
<h2 class="cls01">안녕하세요:<%= name %></h2>
<script type="text/javascript">
	var tdArr = document.querySelectorAll("td");
	tdArr.forEach(function(tdOb,idx){
		tdOb.innerText=idx+1;
	})
	alert("가격:"+price+", 갯수:"+cnt)
</script>
</body>
</html>