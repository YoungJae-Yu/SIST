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
<%--
    code(키, 값, 상위키,정렬순위)
    1000  과일  0
    1001  사과   1000 1
    1002  바나나  1000 2
    1003  딸기   1000 3
    1004  오렌지  1000 4
    select *
    from code
    where 상위키 = 1000;
    order 정렬순위   
    
1. select(Combo box) 모듈 ajax로 list 및 등록 처리 만들어보기
2. 처리순서
	1) DB 테이블 sql 구성
	2) Dao 생성
	3) 초기 list 화면 구성 : ajax 처리(backend)
	4) 등록 click시  등록 화면 구성
	5) 클릭시, 상세화면 구성
		- 수정/삭제 처리...
	6) Combox Box 활용
	
# 진행 순서
0. 파일
	프런트(a13_ComBoAjax.jsp)
1. backend(z13_comboList.jsp)
	요청값 : title
	import 처리(dao,Gson,Code)
	Gson으로 json 데이터 로딩
2. frontend(a13_ComBoAjax.jsp)
	1) 화면구성
		제목 [   ] 
	2) 이벤트 처리
	3) 이벤트 핸들러 처리
		- 검색 DOM
		- ajax 처리
		- 화면 리스트 처리..
		

# 코드 등록 처리 ajax
1. back단(servlet 이용)
	1) Dao(등록 처리-메서드 추가)
		sql (insert문)
		INSERT INTO code VALUES (code_seq.nextval,'과일',0,1)
		INSERT INTO code VALUES (code_seq.nextval,?,?,?,?)
		dao insert메서드 추가.
	2) 요청값 받기
	3) 등록 결과 리턴 문자열
2. front단 
	1) 등록 버튼 : 클릭
	2) 등록 pop창 로딩(bootstrap 모달창)
		등록항목 text
		제목 : [   ]
		값 : [   ]
		상위번호 : [   ]
		정룔순서 : [   ]
		[등록]
	3) 이벤트 핸들러
		ajax로 등록 controller 호출 처리
 --%>
<script type="text/javascript">
	function schCode() {
		var titleVal = document.querySelector("#title").value
		var qurStr = "title=" + titleVal
		var xhr = new XMLHttpRequest()
		xhr.open("post", "z13_comboList.jsp", true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qurStr)
		xhr.onreadystatechange = function() {
			console.log(xhr.responseText)
			if (xhr.readyState == 4 && xhr.status == 200) {
				var codeList = JSON.parse(xhr.responseText)
				var codeShow = document.querySelector("#codeShow")
				var show = "";
				codeList.forEach(function(code) {
					show += "<tr class='text-center'>"
					show += "<td>" + code.no + "</td>"
					show += "<td>" + code.title + "</td>"
					show += "<td>" + code.refno + "</td>"
					show += "<td>" + code.ordno + "</td>"
					show += "</tr>"
				})
				codeShow.innerHTML = show
			}
		}
	}
</script>
<body>
	<div class="container mt-3">
		<h2>과일정보 조회</h2>
		<form action="" method="post">
			<div class="mb-3 mt-3">
				<label for="title">과일명:</label> <input onkeyup="schCode()"
					type="text" class="form-control" id="title" placeholder="과일명 입력"
					name="title">
			</div>
			<button type="button" class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#myModal">코드등록</button>
			<button onclick="schCode()" type="button" class="btn btn-primary">조회</button>
		</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
				<tr class="text-center">
					<th>번호</th>
					<th>과일명</th>
					<th>상위번호</th>
					<th>정렬</th>
				</tr>
			</thead>
			<tbody id="codeShow">
			</tbody>
		</table>
	</div>

	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">코드등록</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body 
				-- 제목, 값, 상위번호, 정렬
				-- title, val, refno, ordno
				-->
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="title">과일명:</label> <input
							type="text" class="form-control" id="title" 
							placeholder="과일명 입력"
							name="title">
					</div>
				</div>
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="val">값:</label> <input
							type="text" class="form-control" id="val" 
							placeholder="값 입력"
							name="val">
					</div>
				</div>
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="refno">상위번호:</label> <input
							type="text" class="form-control" id="refno" 
							placeholder="상위번호 입력"
							name="refno">
					</div>
				</div>
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="ordno">정렬:</label> <input
							type="text" class="form-control" id="ordno" 
							placeholder="정렬 입력"
							name="ordno">
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success"
						onclick="ajaxSave()">Save</button>
					<button  id="" type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
	function ajaxSave(){
		// 입력 val
		var title=document.querySelector(".modal-body #title").value
		var val=document.querySelector(".modal-body #val").value
		var refno=document.querySelector(".modal-body #refno").value
		var ordno=document.querySelector(".modal-body #ordno").value
		var qStr = "title="+title+"&refno="+refno
				+"&ordno="+ordno+"&val="+val
		alert(qStr)		
		// ajax 처리..
		var xhr = new XMLHttpRequest()
		xhr.open("post","/backWeb/codeIns.do",true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qStr)
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result = xhr.responseText
				if(result=="Y"){
					alert("등록성공")
				}else{
					alert("등록실패")
				}
			}
		}
		
		
	}
	</script>
</body>
</html>





























