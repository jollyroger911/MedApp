package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.PersonService;
//import by.sam.apklimovich.websocket.WebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    @Autowired
    public PersonService personService;

    public MessageService messageService;

    @Autowired
    public ChatService chatService;

    @Autowired
    PersonDto personDto;

    @Autowired
    private ChatDto chat;



    public Logger logger = LoggerFactory.getLogger(ChatController.class);


    @RequestMapping(value = "/chatt", method = RequestMethod.GET)
    public String chat(Model model) {
        model.addAttribute("chatMeas", new MessageDto());
        model.addAttribute("chatDto", chat);
        String str = personService.getPersonsNameById(personDto.getDestId());
        model.addAttribute("destName", str);
        this.chat.setSenderId(personDto.getId());
        this.chat.setRecieverId(personDto.getDestId());
        chatService.createChat(chat, personDto);
        //  model.addAttribute("receiverData", personService.getPersonsDataForChat(personDto.getDestId()));
        model.addAttribute("messagesList", chat.getCurrentMessages());

        return "chat5";
    }

//    @RequestMapping(value = "/chat", method = RequestMethod.POST)
//    public ResponseEntity<String> demo1(MessageDto message, Model model) {
//        try {
//            model.addAttribute("chatMeas", message);
//            chatService.addMessageToChat(message, this.chat);
//            ResponseEntity<String> responseEntity = new ResponseEntity<String>(messageService.getLastMessageOfChat(chat), HttpStatus.OK);
//            return responseEntity;
//        } catch (Exception e) {
//            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @RequestMapping(value = "/chat", method = RequestMethod.POST)
//    public String chatSubmit(MessageDto message, Model model) {
//        model.addAttribute("chatMeas", message);
//        // message.setSender(personDto.getId());
//        chatService.addMessageToChat(message, this.chat);
//        logger.info(chat.getContent());
//        return "redirect:/chat";
//    }
//
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatDto sendMessage(@Payload ChatDto chatDto) {
//        return chatDto;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatDto addUser(@Payload ChatDto chatDto,
//                           SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        //headerAccessor.getSessionAttributes().put("username", chatDto.getSender());
//        return chatDto;
//    }

}