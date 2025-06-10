package org.example.config.ws;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat")
public class ChatWebSocket {
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message) {
//        sessions.forEach(s -> {
//            try {
//                s.getBasicRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        sessions.forEach(s -> {
            s.getAsyncRemote().sendText("update: " + message);
        });
    }
}
