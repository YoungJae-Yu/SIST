<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%--  
3. forward 액션을 이용하여, 로딩된 구구단의 임의의 문제가 맞으면 정답페이지로 이동 
	그렇지 않으면 다시 문제풀이 페이지로 처리되게 하세요.
 --%>
	<%
	int rN1 = (int) (Math.random() * 9 + 1);
	int rN2 = (int) (Math.random() * 9 + 1);
	int rgugu = rN1 * rN2;
	String isgugu = "I";
	String guguS = request.getParameter("gugu");
	if (guguS != null) {
		int gugu = Integer.parseInt(guguS);
		if (gugu == rgugu) {
			isgugu = "T";
	%>
	<jsp:forward page="correct.jsp"/>
	<%
		} else {
			isgugu = "F";
	%>
	<<h2>오답입니다!!! 다시 풀어보세요</h2>
	<%
	}
	%>
	<%
	}
	%>
	<div class="container mt-3">
		<h2>
			임의의 구구단!<%=rN1%>X<%=rN2%></h2>
		<form action="" method="post">
			<div class="mb-3 mt-3">
				<label for="gugu">정답:</label> <input type="number"
					class="form-control" id="gugu" placeholder="정답 입력" name="gugu">
			</div>
			<button type="button" id="btn01" onclick="document.querySelector(''#btn01').submit" class="btn btn-primary">정답확인!</button>
		</form>
	</div>
	<script type="text/javascript">
			var isgugu = "<%=isgugu%>"
				var btn01Obj = document.querySelector("#btn01");

			if (isgugu != 'I') {
				if (isgugu == 'F') {
					alert("오답입니다!!! 다시 풀어보세요")
				}

		}
	</script>



</body>
</html>