package springweb.a06_util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
// chatHandler
@Component
public class ChatHandler extends TextWebSocketHandler{
	// 접속한 채팅 소켓세션설정(접속자 저장)
	private Map<String, WebSocketSession>
		users = new ConcurrentHashMap();
	// 접속시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		System.out.println(session.getId()+"님 접속했습니다.");
		// 접속한 사용자 id와 session을 누적해서 추가 처리.
		users.put(session.getId(), session);
	}
	// 메시지 전달(특정한 접속자가 보낸 메시지를 socket서버에 접속한
	// 모든 사용자에게 전송)
	// push방식으로 각 사용자들에 웹으로 메시지를 전달 처리..
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		System.out.println(session.getId()+"님이 보낸 메시지 : "+message.getPayload());
		for(WebSocketSession ws:users.values()) {
			ws.sendMessage(message);
		}
	}
	// 종료시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		System.out.println(session.getId()+"님 접속 종료되었습니다.");
		// 전역변수로 되어있는 사용자 명단에서 삭제 처리..
		users.remove(session.getId());
	}
	// 에러발생시
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
		System.out.println(session.getId()+"님 에러가 발생했습니다."+exception.getMessage());
		
	}
	
}
