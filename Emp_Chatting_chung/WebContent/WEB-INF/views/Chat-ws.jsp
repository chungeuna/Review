<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <c:import url="/common/HeadTag.jsp"/>
<title>채팅</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
var wsocket;

function connect() {
	wsocket = new WebSocket("ws://localhost:8090/Emp_Chatting_chung/Chat-ws1.do");
	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.onclose = onClose;
}
function disconnect() {
	wsocket.close();
}
function onOpen(evt) {
	var nickname = $("#nickname").val();
	appendMessage(nickname + "님이 입장하셨습니다","center");
}
function onMessage(evt) {
	var data = evt.data;
	var jsonData = JSON.parse(data);
	if(jsonData.id == $("#nickname").val()) {
		appendMessage("나 :" + jsonData.message,"right");		
	} else {
		talkTo(jsonData.id);
		appendMessage(jsonData.id + ":" + jsonData.message,"left");
	}
}
function onClose(evt) {
	appendMessage("퇴장하셨습니다","center");
	appendMessage("채팅이 끝났습니다","center");
}
function talkTo(person) {
	
	var personlist = $("#talkToArea").text().split(" ");
	console.log(personlist);
	for (var i in personlist){
		console.log(i + "번째  사람" + personlist[i]);
		if(personlist[i].trim() != person){
		console.log(personlist[i].trim() == person + "결과");
		$("#talkToArea").append(person +" ");
		}
	}
}
function send() {
	var msg = $("#message").val();
	var jsonMsg = {
				"id" : $("#nickname").val(),
				"message" : msg
			};
	wsocket.send(JSON.stringify(jsonMsg));
	$("#message").val("");	
}
function appendMessage(msg,position) {
	var pTag = $("<p><span>" + msg + "</span></p>");
	pTag.css("text-align",position);
	$("#chatMessageArea").append(pTag);

	var chatAreaHeight = $("#chatArea").height();
	var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
	$("#chatArea").scrollTop(maxScroll);
}

$(document).ready(function() {
	$('#message').keypress(function(event){
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			send();	
		}
		event.stopPropagation();
	});
	$('#sendBtn').click(function() { send(); });
	$('#enterBtn').click(function() { 
		connect(); 
		talkTo( $("#nickname").val());
		$("#enterBtn").attr('disabled', true);});
	$('#exitBtn').click(function() { disconnect(); });
});
</script>
    <style type="text/css">
.headLine {
	font-weight: 700;
	text-align: center;
	font-size: 4rem;
	color: white;
	padding-top: 18%;
	font-style: italic;
	font-family: 'Droid Serif', -apple-system, BlinkMacSystemFont,
		'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif,
		'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol',
		'Noto Color Emoji';
}

#chatArea {
	width: 600px;
	height: 400px;
	overflow-y: auto;
	border: 1px solid black;
}
#talkToArea {
	width: 100px;
	height: 200px;
	overflow-y: auto;
	border: 1px solid black;
}
p span {
	margin-top: 10px;
	border-radius: 2em;
	border: 5px solid brown;
	padding : 5px;
	
}
</style>
</head>
<body id="page-top">
    <!-- Top -->
    <c:import url="/common/Top.jsp"/>
    <div id="wrapper">
        <!-- Left Menu -->
        <c:import url="/common/Left.jsp"/>
 		<div id="content-wrapper">
			<div id="content-main">
				<div class="container-fluid main">
					<div class="container-fluid">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-user-check"></i>채팅
								</div>
								  <div class="card-body">
								<div class="row">
									이름 : <input type="text" id="nickname"> <input
										type="button" id="enterBtn" value="입장"> <input
										type="button" id="exitBtn" value="나가기">
								</div>

								<div class="row">

									<div id="chatArea">
										<div id="chatMessageArea">

										</div>
									</div>
									<div id="talkTo">
										<div id="talkToArea"></div>
									</div>
								</div>
								<br> <input type="text" id="message"> <input
									type="button" id="sendBtn" value="전송">
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Bottom -->
             <c:import url="/common/Bottom.jsp"/>
        </div>
    </div>
</body>
</html>