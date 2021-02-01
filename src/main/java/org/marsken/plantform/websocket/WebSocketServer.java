package org.marsken.plantform.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/29 4:50 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@ServerEndpoint("/webSocket/{userId}")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
    }

    @OnClose
    public void onClose(Session session) {
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
    }

    @OnMessage
    public void onMessage(String message, Session session) {
    }


}
