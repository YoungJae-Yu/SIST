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
<script type="text/javascript">
	function getSyn(page) {
		var xhr = new XMLHttpRequest();
		xhr.open("get", page, false);
		xhr.send()
		return xhr.responseText;
	}
	function key13(){
		if(event.keyCode==13)
			callEmpList()
	
	}
	function callEmpList() {
		var ename = document.querySelector("#ename").value;
		var job = document.querySelector("#job").value;
		//alert( getSyn("z09_empDBAll.jsp"))
		//console.log(getSyn("z09_empDBAll.jsp"))
		document.querySelector("#empList").innerHTML = getSyn("z09_empDBAll.jsp?ename="
				+ ename + "&job=" + job);
	}
</script>
<%--
# DB연동된 데이터 로딩화면 가져오기 처리
1. DB 연동 Dao 확인
	Dao 패키지 클래스/단위 객체 확인
	==> import
2. z10_jobDBAll.jsp
	에 위 내용 DAO/import 및 전체 데이터 리스트 처리
	for 구문 처리
	td td
	화면 확인 tr/td로 되어 있기에 데이터 확인
3. a09_DBAjax.jsp
	1) 이벤트 핸들러 함수 선언
		기본 ajax처리 함수 복사 및 선언 : function getSyn(page){}
		callAjax()
			위 ajax처리함수에 호출할 페이지 전달
			var htmlCode = getSyn("z10_jobDBAll.jsp")
			
	2) 출력한 DOM 객체 선언 및 위 getSyn 내용 할당
		document.querySelector("tbody").innerHTML = htmlCode
 --%>
<body>
	<div class="container mt-3">
		<h2>사원정보 등록</h2>
		<form action="" method="post">
			<div class="mb-3 mt-3">
				<label for="ename">사원명:</label> <input type="text"
					class="form-control" id="ename" onkeyup="key13()"
					placeholder="사원명 입력" name="ename">
			</div>
			<div class="mb-3 mt-3">
				<label for="job">직책명:</label> <input type="text"
					class="form-control" id="job" onkeyup="key13()"
					placeholder="직책명: 입력" name="job">
			</div>
			<button type="button" onclick="callEmpList()" class="btn btn-primary">등록</button>
		</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
				<tr class="text-center">
					<th>사원번호</th>
					<th>사원명</th>
					<th>직책명</th>
					<th>관리자</th>
					<th>입사일</th>
					<th>급여</th>
					<th>보너스</th>
					<th>부서번호</th>
				</tr>
			</thead>
			<tbody id="empList">
			</tbody>
		</table>
	</div>
</body>
</html>