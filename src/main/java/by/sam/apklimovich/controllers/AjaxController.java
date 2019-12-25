package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Message;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.IllnessDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.VisitService;
import jdk.internal.net.http.websocket.MessageEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    public ResponseEntity<String> demo1(String selected ,MessageDto message, Model model) {
        try {
//            model.addAttribute("chatMeas", message);
            message.setContent(selected);
            chatService.addMessageToChat(message, this.chat);
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
//    @RequestMapping(value = "/demo6", method = RequestMethod.POST)
//    public ResponseEntity<ArrayList<Date>> demo5(String id, Date selected) {
//        try {
//           //String str = selected;
//            long idValue = Long.parseLong(id);
//           // personDto.setVisitTime(str);
//            personDto.setVisitDate(selected);
//            personDto.setVisitDoctorId(idValue);
//            ResponseEntity<ArrayList<Date>> responseEntity = new ResponseEntity<ArrayList<Date>>(visitService.getFreeVisitDateByDocIdAndDate(idValue, selected), HttpStatus.OK);
//            return responseEntity;
//        } catch (Exception e) {
//            return new ResponseEntity<ArrayList<Date>>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
