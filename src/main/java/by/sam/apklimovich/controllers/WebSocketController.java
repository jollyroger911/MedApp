package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.ChatMessage;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.PersonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {

    PersonDto personDto;

    @Autowired
    public ChatService chatService;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private ChatDto chat;

    @Autowired
    private PersonService personService;

    private Gson gson = new Gson();

//    @MessageMapping("/chat.sendMessage")
//    @SendToUser("/queue/reply")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, Principal principal) {
//        // Message message = new Message(chatMessage.getContent(), Long.parseLong(chatMessage.getSender()), )
//        Long chatId = chatService.findChatByUsersId(chatMessage.getSenderId(), chatMessage.getDestId());
//        chatService.addMessageToChat(chatMessage.getContent(), chatId, chatMessage.getSenderId());
//        return chatMessage;
//    }
//
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/queue/reply")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage,
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", personService.getPersonsNameById(personDto.getId()));
//        return chatMessage;
//    }



    @MessageMapping("/chat.sendMessage")
    @SendToUser("/queue/reply")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
       // Message message = new Message(chatMessage.getContent(), Long.parseLong(chatMessage.getSender()), )
        Long chatId = chatService.findChatByUsersId(chatMessage.getSenderId(), chatMessage.getDestId());
        chatService.addMessageToChat(chatMessage.getContent(), chatId, chatMessage.getSenderId());
        String destUsername = personService.getDestinationUsername(chatMessage.getDestId());
      //  messagingTemplate.convertAndSendToUser(destUsername, "/queue/reply", chatMessage.getContent());
        messagingTemplate.convertAndSendToUser(destUsername, "/queue/reply", chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendToUser("/queue/reply")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        personDto = personService.getUserInfoByUsername(personDto, currentUserName);

        headerAccessor.getSessionAttributes().put("username", personService.getPersonsNameById(personDto.getDestId()));
        return chatMessage;
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}




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



























//package by.sam.apklimovich.controllers;
//
//        import by.sam.apklimovich.entity.Message;
//        import by.sam.apklimovich.model.ChatDto;
//        import by.sam.apklimovich.model.ChatMessage;
//        import by.sam.apklimovich.model.MessageDto;
//        import by.sam.apklimovich.model.PersonDto;
//        import by.sam.apklimovich.service.ChatService;
//        import by.sam.apklimovich.service.PersonService;
//        import com.google.gson.Gson;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.messaging.handler.annotation.MessageMapping;
//        import org.springframework.messaging.handler.annotation.Payload;
//        import org.springframework.messaging.handler.annotation.SendTo;
//        import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//        import org.springframework.messaging.simp.SimpMessageSendingOperations;
//        import org.springframework.messaging.simp.annotation.SendToUser;
//        import org.springframework.security.core.Authentication;
//        import org.springframework.security.core.context.SecurityContextHolder;
//        import org.springframework.stereotype.Controller;
//
//        import java.security.Principal;
//
//@Controller
//public class WebSocketController {
//
//    PersonDto personDto;
//
//    @Autowired
//    public ChatService chatService;
//
//    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;
//
//    private ChatDto chat;
//
//    @Autowired
//    private PersonService personService;
//
//    private Gson gson = new Gson();
//
////    @MessageMapping("/chat.sendMessage")
////    @SendToUser("/queue/reply")
////    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, Principal principal) {
////        // Message message = new Message(chatMessage.getContent(), Long.parseLong(chatMessage.getSender()), )
////        Long chatId = chatService.findChatByUsersId(chatMessage.getSenderId(), chatMessage.getDestId());
////        chatService.addMessageToChat(chatMessage.getContent(), chatId, chatMessage.getSenderId());
////        return chatMessage;
////    }
////
////
////    @MessageMapping("/chat.addUser")
////    @SendTo("/queue/reply")
////    public ChatMessage addUser(@Payload ChatMessage chatMessage,
////                               SimpMessageHeaderAccessor headerAccessor) {
////        // Add username in web socket session
////        headerAccessor.getSessionAttributes().put("username", personService.getPersonsNameById(personDto.getId()));
////        return chatMessage;
////    }
//
//
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        // Message message = new Message(chatMessage.getContent(), Long.parseLong(chatMessage.getSender()), )
//        Long chatId = chatService.findChatByUsersId(chatMessage.getSenderId(), chatMessage.getDestId());
//        chatService.addMessageToChat(chatMessage.getContent(), chatId, chatMessage.getSenderId());
//
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage,
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUserName = authentication.getName();
//        PersonDto personDto = new PersonDto();
//        personDto = personService.getUserInfoByUsername(personDto, currentUserName);
//
//        headerAccessor.getSessionAttributes().put("username", personService.getPersonsNameById(personDto.getId()));
//        return chatMessage;
//    }
//}
//
//
//
//
////import by.sam.apklimovich.entity.Message2;
////import org.springframework.messaging.handler.annotation.MessageMapping;
////import org.springframework.messaging.handler.annotation.Payload;
////import org.springframework.messaging.handler.annotation.SendTo;
////import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
////import org.springframework.stereotype.Controller;
////
////@Controller
////public class WebSocketController {
////
////
////
////    @MessageMapping("/chat.sendMessage")
////    @SendTo("/topic/publicChatRoom")
////    public Message2 sendMessage(@Payload Message2 chatMessage) {
////        return chatMessage;
////    }
////
////    @MessageMapping("/chat.addUser")
////    @SendTo("/topic/publicChatRoom")
////    public Message2 addUser(@Payload Message2 chatMessage, SimpMessageHeaderAccessor headerAccessor) {
////        // Add username in web socket session
////        headerAccessor.getSessionAttributes().put("username", chatMessage.getFrom());
////        return chatMessage;
////    }
////
////}