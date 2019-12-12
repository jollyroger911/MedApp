package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatDto chat;

    @Autowired
    public VisitService visitService;

    @Autowired
    private PersonDto personDto;

    @RequestMapping(value = "/demo1", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Message>> demo1(MessageDto message, Model model) {
        try {
            model.addAttribute("chatMeas", message);
            chatService.addMessageToChat(message, this.chat);
            ResponseEntity<ArrayList<Message>> responseEntity = new ResponseEntity<ArrayList<Message>>(chat.getCurrentMessages(), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<ArrayList<Message>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<String>> demo2(String id, String selected) {
        try {
            String str = selected;
            long idValue = Long.parseLong(id);
            personDto.setVisitTime(str);
            personDto.setVisitDoctorId(idValue);
            ResponseEntity<ArrayList<String>> responseEntity = new ResponseEntity<ArrayList<String>>(visitService.getFreeVisitTimeByDocId(idValue), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<ArrayList<String>>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/demo3", method = RequestMethod.POST)
    public ResponseEntity<String> demo3() {
        try {
            ResponseEntity<String> responseEntity = new ResponseEntity<String>(personDto.getVisitTime(), HttpStatus.OK);
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

}
