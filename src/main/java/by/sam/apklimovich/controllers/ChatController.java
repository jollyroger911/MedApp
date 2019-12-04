package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ChatController {

    @Autowired
    public MessageService messageService;

    @Autowired
    public ChatService chatService;

    @Autowired
    PersonDto personDto;

    @Autowired
    private ChatDto chat;


    public Logger logger = LoggerFactory.getLogger(ChatController.class);

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Model model) {
        model.addAttribute("chatMeas", new MessageDto());
        model.addAttribute("chatDto", chat);
        this.chat.setSenderId(personDto.getId());
        this.chat.setRecieverId(personDto.getDestId());
        chatService.createChat(chat, personDto);
        model.addAttribute("messagesList", chat.getCurrentMessages());
        return "chat_two";
    }

    @RequestMapping(value = "/chatMessages", method = RequestMethod.POST)
    public @ResponseBody
    String chatMessages(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int last = chat.getCurrentMessages().size();
        return chat.getCurrentMessages().get(last - 1).getMessage();
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chatSubmit(MessageDto message, Model model) {
        model.addAttribute("chatMeas", message);
       // message.setSender(personDto.getId());
        chatService.addMessageToChat(message, this.chat);
        logger.info(chat.getContent());
        return "chat_two";
    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatDto sendMessage(@Payload ChatDto chatDto) {
        return chatDto;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatDto addUser(@Payload ChatDto chatDto,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        //headerAccessor.getSessionAttributes().put("username", chatDto.getSender());
        return chatDto;
    }

}