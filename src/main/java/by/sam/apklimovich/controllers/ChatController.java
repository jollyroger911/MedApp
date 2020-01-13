package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {
    @Autowired
    public PersonService personService;
    @Autowired
    public MessageService messageService;
    @Autowired
    public ChatService chatService;
    public Logger logger = LoggerFactory.getLogger(ChatController.class);

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(@ModelAttribute(value = "personDestIdValue") Long destId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        ChatDto chat = new ChatDto();
        personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        personDto.setDestId(destId);
        if (!authentication.getPrincipal().equals("anonymousUser")) {
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
        chatService.createChat(chat, personDto);
        return "chat5";
    }
}