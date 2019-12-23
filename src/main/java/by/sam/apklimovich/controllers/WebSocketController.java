//package by.sam.apklimovich.controllers;
//
//import by.sam.apklimovich.model.ChatMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage,
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
//}




//import by.sam.apklimovich.entity.Message2;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/publicChatRoom")
//    public Message2 sendMessage(@Payload Message2 chatMessage) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/publicChatRoom")
//    public Message2 addUser(@Payload Message2 chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getFrom());
//        return chatMessage;
//    }
//
//}