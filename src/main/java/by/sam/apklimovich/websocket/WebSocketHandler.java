//package by.sam.apklimovich.websocket;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
//import org.springframework.web.socket.config.annotation.WebMvcStompWebSocketEndpointRegistration;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//@RequestMapping(value = "/ws")
//public class WebSocketHandler extends TextWebSocketHandler {
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        session.sendMessage(new TextMessage("echo: "+message.getPayload()));
//    }
//
//}



//package by.sam.apklimovich.websocket;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//public class WebSocketHandler extends TextWebSocketHandler {
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message)
//            throws Exception {
//
//        String clientMessage = message.getPayload();
//
//        if (clientMessage.startsWith("Hello") || clientMessage.startsWith("Hi")) {
//            session.sendMessage(new TextMessage("Hello! What can i do for you?"));
//        } else {
//            session.sendMessage(
//                    new TextMessage("This is a simple hello world example of using Spring WebSocket."));
//        }
//    }
//}