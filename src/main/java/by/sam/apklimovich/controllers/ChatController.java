package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Chat;
import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ChatController {

    @Autowired
    public PersonService personService;

    public MessageService messageService;

    @Autowired
    public ChatService chatService;


    PersonDto personDto;


    private ChatDto chat;


    public Logger logger = LoggerFactory.getLogger(ChatController.class);



    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(@ModelAttribute(value = "personDestIdValue") Long destId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        ChatDto chat = new ChatDto();
        personDto = personService.getUserInfoByUsername(personDto, currentUserName);
   //     model.addAttribute("persons", person);
        //model.addAttribute("perosnDestIdValue" )
        personDto.setDestId(destId);
       // personDto.setDestId(person.getDestId());
        if(!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }
        model.addAttribute("chatMeas", new MessageDto());
        model.addAttribute("chatDto", chat);
        String str = personService.getPersonsNameById(personDto.getDestId());
        model.addAttribute("destinationUsername", personService.getDestinationUsername(personDto.getDestId()));
        model.addAttribute("senderLogin", personService.getDestinationUsername(personDto.getId()));
        model.addAttribute("destName", str);
        model.addAttribute("destId", personDto.getDestId());
        model.addAttribute("senderId", personDto.getId());
        model.addAttribute("senderName", personDto.getName() + " " + personDto.getSurname());
        chat.setSenderId(personDto.getId());
      //  this.chat.setRecieverId(personDto.getDestId());
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

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chatSubmit(MessageDto message, Model model) {
        model.addAttribute("chatMeas", message);
       // message.setSender(personDto.getId());
       // chatService.addMessageToChat(message.getContent(), this.chat);
        logger.info(chat.getContent());
        return "redirect:/chat";
    }


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