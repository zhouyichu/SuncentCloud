/**  
* <p>Title: WebSocketServer.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.suncnet.top</p>  
* @author ZhouFei  
* @date 2020年11月12日  
* @version 1.0  
*/  
package com.suncent.websocket.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.suncent.websocket.vo.MessageVO;

/**  
 * <p>Title: WebSocketServer</p>  
 * <p>Description: </p>  
 * @author ZhouFei
 * @date 2020年11月12日 下午4:36:02
 */
@ServerEndpoint("/chat")
@Component
public class WebSocketServer {
	private static Map<String, Session> onlineSessions = new ConcurrentHashMap<String, Session>();
	
	@OnOpen
	public void onOpen(Session session) {
		onlineSessions.put(session.getId(), session);
		sendMsgToAll(MessageVO.jsonStr(MessageVO.ENTER,"","",onlineSessions.size()));
		
	}
	
	@OnMessage
	public void onMessage(Session session, String jsonStr) {
		MessageVO msg = JSON.parseObject(jsonStr,MessageVO.class);
		sendMsgToAll(MessageVO.jsonStr(MessageVO.SPEAK, msg.getUserName(), msg.getMsg(), onlineSessions.size()));
	}
	
	@OnClose
	public void onClose(Session session) {
		 onlineSessions.remove(session.getId());
		 sendMsgToAll(MessageVO.jsonStr(MessageVO.QUIT, "", "Bay bay!", onlineSessions.size()));
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}
	
	private static void sendMsgToAll(String msg) {
		onlineSessions.forEach((id, session) -> {
			try {
				session.getBasicRemote().sendText(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
