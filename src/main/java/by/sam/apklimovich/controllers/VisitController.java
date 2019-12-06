package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VisitController {
    public Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    PersonDto personDto;

    @Autowired
    private PersonService personService;

    @Autowired
    private ChatDto chat;

    static final int DOCTOR = 1;

    @RequestMapping(value = "/visit", method = RequestMethod.GET)
    public String doctorsList(Model model) {
//        List<Person> persons;
//        persons = personService.findAllPersonsByWho(DOCTOR);
        model.addAttribute("doctorsList", personService.findAllPersonsByWho(DOCTOR));
        return "visit_time";
    }

    @RequestMapping(value = "/visit", method = RequestMethod.POST)
    public String doctorSubmit(MessageDto message, Model model) {
        model.addAttribute("chatMeas", message);
        // message.setSender(personDto.getId());
        logger.info(chat.getContent());
        return "visit_time";
    }
}
