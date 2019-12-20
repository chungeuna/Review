package kr.or.bit.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler{
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.put(session.getId(), session);
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session.getId());
		
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(users + "");
		for(WebSocketSession s : users.values()) {
			s.sendMessage(message);
			
		}
	}
}
