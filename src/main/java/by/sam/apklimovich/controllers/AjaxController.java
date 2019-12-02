package by.sam.apklimovich.controllers;

//import by.sam.apklimovich.entity.Message;
//import by.sam.apklimovich.model.ChatDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//
//@Controller
//public class AjaxController {
//
//    @Autowired
//    public ChatDto chatDto;
//
//    @RequestMapping(value = "/chat", method = RequestMethod.GET)
//    public @ResponseBody
//    ArrayList<Message> processAJAXRequest() {
//        ArrayList<Message> arr = chatDto.getCurrentMessages();
//        // Process the request
//        // Prepare the response string
//        return arr;
//    }
//}

//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class AjaxController {
//
//    @ResponseBody
//    @RequestMapping(value = "/search/api/getSearchResult")
//    public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {
//
//        AjaxResponseBody result = new AjaxResponseBody();
//        //logic
//        return result;
//
//    }
//
//}