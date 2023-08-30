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
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:auto;text-align:left;
		border:1px solid green;
	}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>

<script type="text/javascript">
	window.addEventListener("resize",function(){
		$("#chatMessageArea>div").width(
				$("#chatArea").width()-20)
	})
	

	// 소켓서버접속 변수
	var wsocket;
	// 접속한사용자 변수
	var members = []
	var chmembers =[] // choMems(chmembers)
	$(document).ready(function() {
		
	    $('#chatM').on('click', '.chMemDiv', function() {
	    	//alert($(this).attr("class"))
	    	if($(this).attr("class").indexOf('btn-outline-primary')>0){
	    		$(this).removeClass("btn-outline-primary")
	    		$(this).addClass("btn-primary")
	    		chmembers.push($(this).text())
	    		choMems()	
	    	}else{
	    		$(this).removeClass("btn-primary")
	    		$(this).addClass("btn-outline-primary")	 
	    		chmembers = chmembers.filter(str => str !== $(this).text());
	    		choMems()	
	    		
	    	}
	    });		
		
		$("#msg").attr("readOnly",true)
		//alert("접속 활성화")
		
		$("#id").focus() // 화면 로딩시 아이디를 입력하게..
		// 아이디를 입력하면 enter입력시 접속/접속시는 
		// 아이디 비활성화
		$("#id").keyup(function(){
			if(event.keyCode==13){
				if(conn()){
					$(this).attr("readOnly",true)
					$("#msg").focus()
				}
			}
			
		})
		conUsers();
		
		$("#enterBtn").click(function(){
			if(conn()){
				$("#id").attr("readOnly",true)
			}
		})
		$("#msg").keyup(function(){
			if(event.keyCode==13){
				choMems();
				sendMsg();
				
			}
		})
		$("#sndBtn").click(function(){
			choMems()	
			sendMsg();
		})
		$("#ckMemBtn").click(function(){
			conUsers()
		})
		
		$("#exitBtn").click(function(){
			if($("#id").val()!=""){
				if(confirm("접속을 종료하겠습니까?")){
					// 
					//alert("종료처리 프로세스진행..~~")
					wsocket.send($("#id").val()+":연결을 종료하였습니다.")
					wsocket.close() // afterConnectionClosed 핸들러에 연동
					// 대화내용 삭제
					$("#chatMessageArea").text("")
					// 등록자 아이디 내용 삭제
					$("#id").val("").focus()
					// 등록자 아이디 활성화
					$("#id").attr("readOnly",false)
					// 접속종료시 msg 부분 비활성화
					$("#msg").attr("readOnly",true)
					$("#chatGroup").html("")
					
					
				}
			}else{
				alert("접속되지 않았습니다!")
			}
	    })
	})
	
	// <!-- msg  sndBtn-->
	// 메시지 전송 함수..
	function sendMsg(){
		wsocket.send($("#id").val()+":"+$("#msg").val());
		$("#msg").val("").focus()
	}	
	function conn(){

		var idVal = $("#id").val()
		if(idVal.length<5 || idVal.length >12 ){
			alert("접속할 아이디는 5~12 입력하여야 합니다.")
			return false
		}else{
			var isNotValid=false;
			$(members).each(function(idx, mem){
				console.log(idVal+":"+mem)
				if(idVal==mem){
					isNotValid=true;
				}
			})
			if(isNotValid){
				alert("동일한 접속자 아이디가 있습니다.")
				$("#id").val("").focus()
				return false;
			}
			if(confirm(idVal+"님 채팅방 접속합니다")){
				$("#msg").attr("readOnly",false)
				wsocket = new WebSocket(
						"ws:192.168.10.99:7080/${path}/chat-ws.do")
				// 서버의 접속 핸들러 처리하는 메서드..
				wsocket.onopen = function(evt){
					console.log(evt)
					// 서버의 메시지 핸들러 메서드 호출..
	
					wsocket.send(idVal+":접속하셨습니다.");
					
					
				}
				// 서버에서 오는 메시지 받는 처리
				wsocket.onmessage=function(evt){
					// evt.data : 서버에서 오는 메시지는 메시지 창에서 
					// 출력 처리..
					revMsg(evt.data)
					
				}
				return true;
			}	
		}
	}
	
	var mx = 0
	function revMsg(msg){
		// 보내는 메시지는 오른쪽
		// 받는 메시지 왼쪽 정렬 처리..
		// 사용자아이디:메시지내용
		var alignOpt = "left"
		var msgArr = msg.split(":")
		var sndId = msgArr[0]
		if(msgArr[1]=="접속하셨습니다."||
		   msgArr[1]=="연결을 종료하였습니다."		
		   ){
			// push방식으로 메시지가 올 때..
			conUsers();
		}
	
		if($("#id").val()==sndId){
			alignOpt = "right"
			msg =msgArr[1]
		}
		// 메시지 객체 생성..
		var msgObj = $("<div></div>"
				).text(msg).attr("align",alignOpt
				).css("width",$("#chatArea").width())
				
		$("#chatMessageArea").append(msgObj)
		// 스크롤링 처리
		// 1. 전체 해당 데이터의 높이를 구한다.
		// 2. 포함하고 있는 부모 객체(#chatArea)에서
		// 		스프롤 기능메서드로 스크롤되게 처리한다. scrollTop()
		var height = parseInt($("#chatMessageArea").height())
		mx+=height+20
		$("#chatArea").scrollTop(mx)
	}
	function conUsers(){
		// 접속자들 ajax로 확인
		$.ajax({
			url:"${path}/getChatMem.do",

			dataType:"json",
			success:function(mlist){
				console.log(mlist)
				members = mlist
				chmembers = mlist
				console.log("#현재 채팅자members#")
				console.log(members)
				console.log("#현재 채팅자chmembers#")
				console.log(chmembers)
				var add=""
				mlist.forEach(function(member){
					console.log(member)
					add+="<div class='btn btn-primary chMemDiv'>"+
							member+"</div>"
				})
				$("#chatGroup").html(add)
				console.log("#크기1#")
				//console.log($(".chMemDiv").width()
				//$(".chatGroup2").css("height",'150px')		
				console.log("#크기2#")
				//$(".chatGroup").css("width",'100%')
				//console.log($(".chatGroup").width())
				
				
			},
			error:function(err){
				console.log(err)
			}
		})
	}
	function choMems(){	
		console.log("#대화할 사람(전송싱)#")
		console.log(chmembers)
		var len = chmembers.length
		var params=""
		var cnt = 0;
		chmembers.forEach(function(mem){
			cnt++;
			
			params+="members="+mem+(len !=cnt ?'&':'')
		})
		console.log(params)
		$.ajax({
		type:"get",	
		url:"${path}/choMems.do",
	    data: params,
		dataType:"text",
		success:function(msg){
			console.log("# 메시지 전송(서버에서 온 값) #")
			console.log(msg)

			
		},
		error:function(err){
			console.log("# 에러발생 #")
			console.log(err)
		}
	})
		
	}
	
</script>
</head>
<body>
	<div class="jumbotron text-center" style="padding: 35px 5px 10px 5px;">
		<h2>웹 소켙을 통한 채팅</h2>
	</div>
	<div class="container">
		<div class="input-group mb-3">	
			<div class="input-group-prepend ">
				<span class="input-group-text  justify-content-center">아이디</span>
			</div>
			<input type="text" id="id" class="form-control" 
				placeholder="접속할 아이디 입력"/>
			<input id="enterBtn" value="채팅방입장"  type="button" class="btn btn-info" />
			<input id="exitBtn" value="채팅방나가기"  type="button" class="btn btn-success" />
			<input id="ckMemBtn" value="접속자확인"  type="button" class="btn btn-warning" />
		</div>	
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<span class="input-group-text  justify-content-center ">접속자</span>
			</div>
			<div class="input-group-append"  id="chatM">
				<div id="chatGroup"></div> 
			</div>
		</div>		
		
		<div class="input-group mb-3">	
			<div class="input-group-prepend ">
				<span class="input-group-text  justify-content-center">메시지</span>
			</div>
			<div id="chatArea" class="input-group-append">
				<div id="chatMessageArea"></div>
			</div>
		</div>	
					
		<div class="input-group mb-3">	
			<div class="input-group-prepend ">
				<span class="input-group-text  justify-content-center">메시지</span>
			</div>
			
			<input type="text" id="msg" class="form-control" 
				placeholder="전송할 메시지 입력"/>
			<input id="sndBtn" value="메시지전송"  type="button" class="btn btn-info" />
		</div>
			
		
	
	</div>

</body>
</html>