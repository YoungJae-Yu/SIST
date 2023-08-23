<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good day!!</title>
<%--
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src='${path}/a00_com/dist/index.global.js'></script>
 --%>
<link href='${path}/a00_com/lib/main.css' rel='stylesheet' />
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">


<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src='${path}/a00_com/lib/main.js'></script>
<script src='${path}/a00_com/dist/index.global.js'></script>
<script src='${path}/a00_com/packages/core/locales/ko.global.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var toDay = new Date();
		//alert(toDay.toISOString())
		//alert(toDay.toISOString().split("T")[0])
		var toDayTitle = toDay.toISOString().split("T")[0];
		
		var calendar = new FullCalendar.Calendar(calendarEl, {
			locale: 'ko',
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : toDayTitle,
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectMirror : true,
			select : function(arg) {
				console.log("#캘린더의 기본 속성 확인#")
				console.log(arg)
				console.log("시작:"+arg.startStr)
				console.log("마지막:"+arg.endStr)
				console.log("종일여부:"+arg.allDay)
				// 상세화면에 있던 내용 초기화 처리
				$("form")[0].reset()
				$("#calTitle").text("일정등록")
				$("#regBtn").show()
				$("#uptBtn").hide()
				$("#delBtn").hide()
				$("#start").val(arg.start.toLocaleString())
				$("[name=start]").val(arg.startStr)
				$("#end").val(arg.end.toLocaleString())
				$("[name=end]").val(arg.endStr)				
				$("#allDay").val(""+arg.allDay)				
				$("[name=allDay]").val(arg.allDay?1:0)	
				
				$("#modal01").click();
				
				
				/*
				arg : 기본 제공 데이터 객체
				arg.startStr : 날짜 ISO
				arg.endStr : 날짜 ISO
				arg.allDay : 시간설정/날짜이냐
				
				var title = prompt('Event Title:');
				if (title) {
				calendar.addEvent({
				  title: title,
				  start: arg.start,
				  end: arg.end,
				  allDay: arg.allDay
				})
				}
				 */
				calendar.unselect()
			},
			eventClick : function(arg) {
				console.log("# 일정 속성 #")
				console.log("아이디:"+arg.event.id)
				console.log("타이틀:"+arg.event.title)
				console.log("시작:"+arg.event.startStr)
				console.log("시작:"+arg.event.start.toLocaleString())
				console.log("종료:"+arg.event.endStr)
				console.log("종료:"+arg.event.end.toLocaleString())
				console.log("종일여부:"+arg.event.allDay)
				console.log("배경색상:"+arg.event.backgroundColor)
				console.log("글자색상:"+arg.event.textColor)
				// 추가적인 속성을 지정하고 가져올 때, extendedProps 사용
				console.log("작성자:"+arg.event.extendedProps.writer)
				console.log("내용:"+arg.event.extendedProps.content)
				console.log("링크:"+arg.event.extendedProps.urlLink)
				$("#calTitle").text("일정상세")
				$("#regBtn").hide()
				$("#uptBtn").show()
				$("#delBtn").show()
				addForm(arg.event)
				$("[name=urlLink]").dblclick(function(){
					// 내부페이지 외부 페이지 이동
					if(confirm("해당페이지로 이동하겠습니까?")){
						// 새로운 창으로 페이지 로딩 및 이동 처리
						window.open($(this).val(),"","")	
					}			
				})
				/*
				1. 타이틀 변경:일정상세
				2. 버튼 보이기 : 등록X, 수정/삭제(O)
				3. 각 form 요소에 위 데이터 할당하기..
				
				
				
				if (confirm('Are you sure you want to delete this event?')) {
				  arg.event.remove()
				}
				 */
				console.log($("#modal01").html())
				$("#modal01").click();
				console.log("#상세데이터확인#")
				console.log(arg.event)
			},
			eventDrop:function(arg){// 특정 일정을 드래그해서 드랍
				// 실제는 일정의 시작과 종료일이 변경되는 것인데
				// 수정할려면 form의 내용을 변경..
				addForm(arg.event)
				ajaxFun("calendarUpdate.do")
				
			},
			eventResize:function(arg){// 특정 일정의 사이즈를 변경
				addForm(arg.event)
				ajaxFun("calendarUpdate.do")				
			},
			editable : true,
			dayMaxEvents : true, // allow "more" link when too many events
			// calList.do
			events : function(info, successCallback, failureCallback){
				// 성공했을 때, 데이터를 처리해주는 함수:successCallback 
				// 실패했을 때 처리해주는 함수:failureCallback
				$.ajax({
					type:"post",
					url:"${path}/calList.do",
					dataType:"json",
					success:function(data){
						console.log(data)
						successCallback(data) // calendar리스트 데이터
						
					},
					error:function(err){
						console.log(err)	
						failureCallback(err)
					}
				})
				
			}
		});

		calendar.render();
		$("#regBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				console.log("#등록데이터 확인#")
				console.log("http://localhost:7080/springweb/insertCalendar.do?"
						+$("form").serialize())
				ajaxFun("insertCalendar.do")		
			}
		})
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				console.log("#수정 확인#")
				console.log("http://localhost:7080/springweb/calendarUpdate.do?"
						+$("form").serialize())
				ajaxFun("calendarUpdate.do")		
			}
			
		})
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				console.log("#삭제데이터 확인#")
				console.log("http://localhost:7080/springweb/calendarDelete.do?"
						+$("form").serialize())
				ajaxFun("calendarDelete.do")		
			}
		})		
	});
	// ajax 공통 처리 함수
	function ajaxFun(url){
		$.ajax({
			type:"post",
			url:"${path}/"+url,
			data:$("form").serialize(),
			success:function(data){
				if(confirm(data.replaceAll("\"","")+
						"\n전체화면 확인하시겠습니까?")){
					location.reload()
				}
			},
			error:function(err){
				console.log(err)
			}
		})		
	}
	// form 입력 내용 처리 공통 함수
	function addForm(event){
		$("form")[0].reset()
		$("[name=id]").val(event.id)
		$("[name=title]").val(event.title)
		$("[name=writer]").val(event.extendedProps.writer)
		$("#start").val(event.start.toLocaleString())
		$("[name=start]").val(event.startStr)
		console.log("# 마지막일:"+event.end)
		var end = event.end
		// 마지막일정이 null일 때, bug 처리..
		if(end==null){
			end = event.start
			// null일때는 시작일정 + 1시간으로 기본 설정
			end.setDate(end.getDate()+(1/24));
			console.log("# 마지막일(최종):"+ (end.toISOString()))
		}		
		$("#end").val(end.toLocaleString())
		$("[name=end]").val(end.toISOString())
		$("[name=backgroundColor]").val(event.backgroundColor)
		$("[name=textColor]").val(event.textColor)
		$("[name=content]").val(event.extendedProps.content)
		$("[name=urlLink]").val(event.extendedProps.urlLink)
		$("#allDay").val(""+event.allDay)				
		$("[name=allDay]").val(event.allDay?1:0)
	}
	
		
</script>
<style>
<
style>body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}

.input-group-text {
	width: 100%;
	text-align: center;
	background-color: #cfffdf;
	color: black;
	font-weight: bolder;
}

.input-group-prepend {
	width: 35%;
}
</style>

</style>

</head>
<body>

	<div class="jumbotron text-center" style="padding: 35px 5px 10px 5px;">
		<h2 id="modal01" data-toggle="modal" data-target="#exampleModalCenter">캘
			린 더</h2>
	</div>
	<div class="container">
		<div id='calendar'></div>
	</div>
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="calTitle">타이틀</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<!-- 

				
				 -->
				 
					<form class="form" method="post">
						<input type="hidden" name="id" value="0" />
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">일정제목</span>
							</div>
							<input type="text" name="title" class="form-control"
								placeholder="일정입력">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">작성자</span>
							</div>
							<input type="text" name="writer" class="form-control"
								placeholder="작성자입력">
						</div>
						
						
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">시작일</span>
							</div>
							<input type="text" id="start" class="form-control"
								placeholder="입력"> <input type="hidden" name="start">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">종료일</span>
							</div>
							<input type="text" id="end" class="form-control" placeholder="입력">
							<input type="hidden" name="end">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">내용</span>
							</div>
							<textarea name="content" rows="5" cols="10" class="form-control"></textarea>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">배경색상</span>
							</div>
							<input type="color" name="backgroundColor" value="#0099cc"
								class="form-control" placeholder="입력">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">글자색상</span>
							</div>
							<input type="color" name="textColor" value="#ccffff"
								class="form-control" placeholder="입력">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">종일여부</span>
							</div>
							<select id="allDay" class="form-control">
								<option value="true">종일</option>
								<option value="false">시간</option>
							</select> <input type="hidden" name="allDay" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">연관페이지</span>
							</div>
							<input type="text" name="urlLink" class="form-control"
								placeholder="url링크주소입력">
						</div>
						
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" id='regBtn' class="btn btn-primary">등록</button>
					<button type="button" id='uptBtn' class="btn btn-info">수정</button>
					<button type="button" id='delBtn' class="btn btn-warning">삭제</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>