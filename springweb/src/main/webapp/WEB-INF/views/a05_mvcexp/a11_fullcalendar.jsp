<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
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
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >


<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src='${path}/a00_com/lib/main.js'></script>

<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2023-08-03',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	  console.log("# 캘린더의 기본 속성 확인 #")
    	  console.log(arg)
    	  $("#modal01").click(); 
    	  /*
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
      eventClick: function(arg) {
    	/*
        if (confirm('Are you sure you want to delete this event?')) {
          arg.event.remove()
        }
    	*/
    	console.log($("#modal01").html())
    	$("#modal01").click(); 
      },    
      editable: true,
      dayMaxEvents: true, // allow "more" link when too many events
      events: [
    	{
          title: '풀캘린더시작',
          start: '2023-08-03'
        },
        {
          title: '전체일정',
          start: '2023-08-01'
        },
        {
          title: '긴일정',
          start: '2023-08-07',
          end: '2023-08-10'
        },
        {
          groupId: 999,
          title: '반복일정',
          start: '2023-08-09T16:00:00'
        },
        {
          groupId: 999,
          title: '반복일정',
          start: '2023-08-16T16:00:00'
        },
        {
          title: '회의',
          start: '2023-08-11',
          end: '2023-08-13'
        },
        {
          title: '미팅',
          start: '2023-08-12T10:30:00',
          end: '2023-08-12T12:30:00'
        },
        {
          title: '점심',
          start: '2023-08-12T12:00:00'
        },
        {
          title: 'Meeting',
          start: '2023-08-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          start: '2023-08-12T17:30:00'
        },
        {
          title: 'Dinner',
          start: '2023-08-12T20:00:00'
        },
        {
          title: 'Birthday Party',
          start: '2023-08-13T07:00:00'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2023-08-28'
        }
      ]
    });

    calendar.render();
  });

</script>
<style>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }
  .input-group-text{width:100%;
		text-align:center;background-color:#cfffdf;
		color:black;font-weight:bolder;}
  .input-group-prepend{width:35%;}  
</style>

</style>

</head>
<body>

	<div class="jumbotron text-center" style="padding:35px 5px 10px 5px;">
		<h2 id="modal01" data-toggle="modal" 
		data-target="#exampleModalCenter">캘 린 더</h2>
	</div>  
	<div class="container">
	
	    <div id='calendar'></div>	
	
	</div>	
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

		<form  class="form"    method="post">
		  <input type="hidden" name="id" value="0"/>
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">일정</span>
		    </div>
		    <input type="text" name="title" class="form-control" placeholder="일정입력">
		  </div>
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">시작일</span>
		    </div>
		    <input type="text" id="start" class="form-control" placeholder="입력">
		    <input type="hidden" name="start" >
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">종료일</span>
		    </div>
		    <input type="text" id="end" class="form-control" placeholder="입력">
		    <input type="hidden" name="end" >
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">내용</span>
		    </div>
		    <textarea name="content" rows="5" cols="10"  
		    	class="form-control" ></textarea>
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">테두리색상</span>
		    </div>
		    <input type="color" name="borderColor"  value="#0099cc" class="form-control" placeholder="입력">
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">배경색상</span>
		    </div>
		    <input type="color" name="backgroundColor"  value="#0099cc"  class="form-control" placeholder="입력">
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">글자색상</span>
		    </div>
		    <input type="color" name="textColor" value="#ccffff" class="form-control" placeholder="입력">
		  </div>	
		  <div class="input-group mb-3">
		    <div class="input-group-prepend">
		      <span class="input-group-text">종일여부</span>
		    </div>
		    <select id="allDay" class="form-control" >
		    	<option value="true">종일</option>
		    	<option value="false">시간</option>
		    </select>
		    <input type="hidden" name="allDay"/>
		  </div>	
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id='regBtn' class="btn btn-primary">등록</button>
        <button type="button" id='uptBtn' class="btn btn-info">수정</button>
        <button type="button" id='delBtn' class="btn btn-warning">삭제</button>
      </div>
    </div>
  </div>
</div>  
</body>
</html>