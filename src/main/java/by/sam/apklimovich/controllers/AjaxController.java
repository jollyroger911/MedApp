package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.ChatMessage;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.PersonService;
import by.sam.apklimovich.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private PersonService personService;

    private ChatDto chat;

    @Autowired
    public VisitService visitService;

    private PersonDto personDto;

    @RequestMapping(value = "/demo1", method = RequestMethod.POST)
    public ResponseEntity<String> demo1(String selected, MessageDto message, Model model) {
        try {
            message.setContent(selected);
            chatService.addMessageToChat(message.getContent(), chat.getChatId(), message.getReceiver());
            ResponseEntity<String> responseEntity = new ResponseEntity<String>(selected, HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<String>> demo2(String id, String selected) {
        try {
            String str = selected;
            long idValue = Long.parseLong(id);
            PersonDto personDto = new PersonDto();
            personDto.setVisitTime(str);
            personDto.setVisitDoctorId(idValue);
            ResponseEntity<ArrayList<String>> responseEntity = new ResponseEntity<ArrayList<String>>(visitService.getFreeVisitTimeByDocId(idValue), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<ArrayList<String>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.POST)
    public ResponseEntity<String> demo3(String id, String selected) {
        try {
            long destDoctorId = Long.parseLong(id);
            PersonDto personDto = new PersonDto();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
            visitService.setVisitDetails(selected, destDoctorId, personDto.getId());
            ResponseEntity<String> responseEntity = new ResponseEntity<String>(selected, HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo4", method = RequestMethod.POST)
    public ResponseEntity<Integer> demo4() {
        try {
            ResponseEntity<Integer> responseEntity = new ResponseEntity<Integer>(personDto.getWho(), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo5", method = RequestMethod.POST)
    public ResponseEntity<String> demo5() {
        try {
            ResponseEntity<String> responseEntity = new ResponseEntity<String>(personDto.getName() + " " + personDto.getSurname(), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo7", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<ChatMessage>> demo7(String idOne, String idTwo) {
        try {
            long idSender = Long.parseLong(idOne);
            long idDest = Long.parseLong(idTwo);
            ChatDto chat = new ChatDto();
            chat = chatService.getChatIds(idSender, idDest);
            if(chat != null) {
                ResponseEntity<ArrayList<ChatMessage>> responseEntity = new ResponseEntity<ArrayList<ChatMessage>>(messageService.findMessagesByChatId(chat), HttpStatus.OK);
                return responseEntity;
            }
            else {
                ResponseEntity<ArrayList<ChatMessage>> responseEntity = new ResponseEntity<ArrayList<ChatMessage>>(new ArrayList<ChatMessage>(), HttpStatus.OK);
                return responseEntity;
            }
        } catch (Exception e) {
            return new ResponseEntity<ArrayList<ChatMessage>>(HttpStatus.BAD_REQUEST);
        }
    }
}
