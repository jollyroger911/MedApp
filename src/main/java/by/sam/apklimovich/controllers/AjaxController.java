package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.MessageService;
import by.sam.apklimovich.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ChatDto chat;

    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/demo1", method = RequestMethod.POST)
    public ResponseEntity<String> demo1(MessageDto message, Model model) {
        try {
            model.addAttribute("chatMeas", message);
            chatService.addMessageToChat(message, this.chat);
            ResponseEntity<String> responseEntity = new ResponseEntity<String>(messageService.getLastMessageOfChat(chat), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    public ResponseEntity<ArrayList<String>> demo2(Model model, long id) {
        try {

            ResponseEntity<ArrayList<String>> responseEntity = new ResponseEntity<ArrayList<String>>(visitService.getFreeVisitTimeByDocId(id), HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<ArrayList<String>>(HttpStatus.BAD_REQUEST);
        }
    }

//    @RequestMapping(value = "/getDefectCount", method = RequestMethod.POST, produces = "application/json")
//    public @ResponseBody Message postEmployeeData(@RequestBody Message message) {
//
//        // process the developer object
//        // Your implementation. For demo I hard-coded the Defect counts
//
//       Message defectSeverityDetails = new Message();
//        ArrayList<Message> messageList = messageService.findMessagesByChatId(chat.getChatId());
//        int messageListSize = messageList.size();
//        defectSeverityDetails.setMessage(messageList.get(messageListSize - 1).getMessage());
//
//        return defectSeverityDetails;
//    }

//    @RequestMapping(value = "/developerDefects")
//    public String showEmployeePage() {
//        return "developerDefects";
//    }

}

//@RestController
//public class AjaxController {
//    @Autowired
//    private MessageService messageService;
//
//    @Autowired
//    private ChatDto chat;
//
//
//    @RequestMapping("/api/myrequest")
//    public ResponseEntity<Message> catchPostMapping(@RequestBody Message object) {
//        //System.out.println(object);
//        Message responceObject = new Message();
//        // responceObject.setId(2);
//        ArrayList<Message> messageList = messageService.findMessagesByChatId(chat.getChatId());
//        int messageListSize = messageList.size();
//        responceObject.setMessage(messageList.get(messageListSize - 1).getMessage());
//        return new ResponseEntity<Message>(responceObject, HttpStatus.OK);
//    }
//
//}