package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.model.ChatMessageDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ChatController {

    @Autowired
    public MessageService messageService;

    @Autowired
    public ChatService chatService;

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Model model) {
        model.addAttribute("chatMeas", new ChatMessageDto());

        return "chat_two";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String helloSubmit(@ModelAttribute @Valid ChatMessageDto message, Model model) {
        model.addAttribute("chatMeas", message);
        Logger logger = LoggerFactory.getLogger(ChatController.class);
        chatService.createChat();
        logger.info(message.getContent());
        return "chat_two";
    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDto sendMessage(@Payload ChatMessageDto chatMessageDto) {
        return chatMessageDto;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDto addUser(@Payload ChatMessageDto chatMessageDto,
                                  SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessageDto.getSender());
        return chatMessageDto;
    }

}