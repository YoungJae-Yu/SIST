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
	<div class="container mt-3">
		<h2>학생정보</h2>
				<form action="" method="post">
			<div class="mb-3 mt-3">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" 
					placeholder="이름 입력" name="name">
			</div>
			<div class="mb-3 mt-3">
				<label for="kor">국어점수:</label> <input type="number"
					class="form-control" id="kor" 
					placeholder="국어점수 입력" name="kor">
			</div>
			<div class="mb-3 mt-3">
				<label for="eng">영어점수:</label> <input type="number"
					class="form-control" id="eng" 
					placeholder="영어점수 입력" name="eng">
			</div>
			<div class="mb-3 mt-3">
				<label for="math">수학점수:</label> <input type="number"
					class="form-control" id="math" 
					placeholder="수학점수 입력" name="math">
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
		</form>
		<%
		String name = request.getParameter("name");
		if(name==null)name="";
		int kor=0,eng=0,math=0;
		String korS = request.getParameter("kor");
		if(korS!=null)kor = Integer.parseInt(korS);
		String engS = request.getParameter("eng");
		if(engS!=null)eng = Integer.parseInt(engS);
		String mathS = request.getParameter("math");
		if(mathS!=null)math = Integer.parseInt(mathS);
		
		%>
		<jsp:include page="a05_sub.jsp">
			<jsp:param name="name" value="<%=name %>" />
			<jsp:param name="kor" value="<%=kor %>" />
			<jsp:param name="eng" value="<%=eng%>" />
			<jsp:param name="math" value="<%=math%>" />
		</jsp:include>
	</div>
</body>
</html>