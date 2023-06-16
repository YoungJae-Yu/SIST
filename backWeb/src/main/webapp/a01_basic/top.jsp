<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{background-color:pink;}
</style>
</head>
<script type="text/javascript">
function call(obj){
		obj.style.background = "red";
}
</script>
<body>
<h2 onclick="call(this)">상단 페이지(클릭)</h2>

</body>
</html>