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
# 등록 후, 처리 프로세스
1. 등록완료
	- 등록 성공
	- 화면에 있는 데이터를 재조회 처리
	- 입력데이터 초기화
	- 계속 여부 확인
		- 계속 시 등록 처리할 수 있게 하고
		- 취소시 창이 닫게 처리.
# 상세화면 로딩 및 수정/삭제
1. 화면처리
	1) 모델창(수정/삭제 버튼) 추가
	2) 클릭 row단위로 클릭
	3) 화면 로딩(모델창)
		- input hidden으로 process 처리.
		단일 데이터 가져오기/등록/수정/삭제 ==> 같은 servlet에서 처리.
		- 단일 데이터 ajax로 가져오기
	4) 수정 클릭시, 수정할 요청값을 query string 만들기
	5) 수정 프로세스 ajax로 처리.
		주의 기존 등록 process와 구분할 수 있도록
		
	6) 수정 후 처리 내용
		 - 수정 성공/계속 수정하시겠습니까?
	7) 단일데이터 ajax로 가져와서 로딩 처리	
2. backend처리
	1) sql 작성
		- 단일 데이터 조회 
			select * from code where no = ?
		- 수정 처리
			update code
				set title = ?,
					  var = ?,
					  refno = ?,
					  ordno = ?
				where no = ?
		- 삭제 처리
			delete from code
				where no = ?
	2) dao 메서드 추가
		public Code getCode(int no)
		public void insertCode(Code upt)
		public void deletCode(int no)
	3) Servlet(MVC 패턴의 Controller 연습)
		String proc = request.getParameter("proc");
		// 단일데이터 로딩, 등록, 수정, 삭제
		
		// Dao 생성
		// 조건에 따라서 메서드 처리
		// 결과값 처리 Gson활용.
		
# 상세 데이터 ajax가져오기..
1. 내용
	해당 list 내용 중에 특정 데이터 row 단위로 클릭시,
	상세 데이터를 ajax로 가져와서 form 화면에 출력한다.
2. 처리순서
	1) 클릭시, 해당 데이터를 요청값을 만들어 ajax 처리한다.(핸들러함수 선언)
	2) 단일 데이터 가져오는  dao생성
	3) 단일 데이터 가져와서 json 데이터 return하는  servlet 생성
	4) ajax 요청 처리로 servlet 호출, ajax 처리..
		

		 --%>
		 <%-- jquery 선언 --%>
<script src = "https://code.jquery.com/jquery-3.7.0.js" type="text/javascript"></script>
    
<script type="text/javascript">
    	// window.onload와 동일한 메서드
    	$(document).ready( function(){
    		
    		$("h2").text("jquery 로딩 성공")
    	});
</script> 

<script type="text/javascript">
	function schCode() {
		var titleVal = document.querySelector("#title").value
		var refnoVal = document.querySelector("#refno").value
		var qurStr = "title=" + titleVal+"&refno=" + refnoVal
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
					show += "<tr ondblclick='detail("+code.no+")' class='text-center "+(code.refno==0?'table-info':'')+"'>"
					show += "<td>" + code.no + "</td>"
					show += "<td>" + code.title + "</td>"
					show += "<td>" + (code.val==undefined?'':code.val) + "</td>"
					show += "<td>" + code.refno + "</td>"
					show += "<td>" + code.ordno + "</td>"
					show += "</tr>"
				})
				codeShow.innerHTML = show
			}
		}
	}
	function detail(no){
		document.querySelector("#detailModal").click();
		document.querySelector(".modal-title").innerText 
			= "코드상세 [코드번호:"+no+"]"	
			// ajax로 상세 데이터를 가져와서 화면에 데이터 넣기
			$("#regBtn").hide()
			$("#uptBtn").show()
			$("#delBtn").show()
	}
	function insModal(){
		document.querySelector(".modal-title").innerText 
			= "코드등록"	
				$("#regBtn").show()
				$("#uptBtn").hide()
				$("#delBtn").hide()
	}
</script>
<body>
	<div class="container mt-3">
		<h2>콤보박스</h2>
		<form action="" method="post" id="regFrm">
			<div class="mb-3 mt-3">
				<label for="title">타이틀:</label> <input onkeyup="schCode()"
					type="text" class="form-control" id="title" placeholder="타이틀 입력"
					name="title">
				<label for="">상위코드:</label> <input onkeyup="schCode()"
					type="text" class="form-control" id="refno" placeholder="상위코드 입력"
					name="refno" value="0"></div>
		<div  id="detailModal" data-bs-toggle="modal"
			data-bs-target="#myModal"></div>	
			<button type="button" onclick="insModal()" 
			class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#myModal">코드등록</button>
			<button onclick="schCode()" type="button" class="btn btn-primary">조회</button>
		</form>
		<table class="table table-striped table-hover">
			<thead class="table-success">
				<tr class="text-center">
					<th>번호</th>
					<th>타이틀</th>
					<th>값</th>
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
					<button type="button" class="btn-close" id="modalClsBtn" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body 
				-- 제목, 값, 상위번호, 정렬
				-- title, val, refno, ordno
				-->
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="title">타이틀:</label> <input
							type="text" class="form-control" id="title" 
							placeholder="타이틀 입력"
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
					<button id="regBtn" type="button" class="btn btn-success"
						onclick="ajaxSave()">등록</button>
					<button id="uptBtn"  type="button" class="btn btn-primary"
						onclick="ajaxUpdate()">수정</button>
					<button id="delBtn"  type="button" class="btn btn-warning"
						onclick="ajaxDelete()">삭제</button>
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
		//alert(qStr)		
		// ajax 처리..
		var xhr = new XMLHttpRequest()
		xhr.open("post","/backWeb/codeIns.do",true)
		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		xhr.send(qStr)
		alert("등록")
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result = xhr.responseText
				if(result=="Y"){
					alert("등록성공")
					schCode();
					document.querySelector("#regFrm").reset()
					if(!confirm("계속등록 하시겠습니까?")){
						// 창닫기 처리
						document.querySelector("#modalClsBtn").click()
					}
				}else{
					alert("등록실패")
				}
			}
		}
		
		
	}
	// 초기에 수행 처리.. (화면에 검색된 상태에서 처리)
	schCode();
	/*
	1. 등록완료
	- 등록 성공
	- 화면에 있는 데이터를 재조회 처리
	- 입력데이터 초기화
	- 계속 여부 확인
		- 계속 시 등록 처리할 수 있게 하고
		- 취소시 창이 닫게 처리.
	2. 리스트데이터 cjfl
		- 제목 : [   ]
		- 상위코드 : [   ]
		계층형 sql로 계층별로 리스되게 처리.
		sql 처리
		dao 변경
		-----------------
		요청값 상위코드 전달.(Servlet에서)
		
		
		
		
	*/
	</script>
</body>
</html>


































