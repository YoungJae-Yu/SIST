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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body>
    <div id="chat"></div>
    <input type="text" id="messageInput">
    <button onclick="sendMessage()">Send</button>
    
    <script>
        var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            stompClient.subscribe('/topic/messages', function (message) {
                showMessage(JSON.parse(message.body).content);
            });
        });

        function sendMessage() {
            var messageInput = document.getElementById('messageInput');
            stompClient.send("/app/chat", {}, JSON.stringify({ 'content': messageInput.value }));
            messageInput.value = '';
        }

        function showMessage(message) {
            var chatDiv = document.getElementById('chat');
            var messageDiv = document.createElement('div');
            messageDiv.innerText = message;
            chatDiv.appendChild(messageDiv);
        }
    </script>
</body>
</html>
