package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
import by.sam.apklimovich.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VisitController {
    public Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private PersonDto personDto;

    @Autowired
    private VisitService visitService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ChatDto chat;
    static final int DOCTOR = 1;

    @RequestMapping(value = "/visit", method = RequestMethod.GET)
    public String doctorsList(Model model) {
        model.addAttribute("doctorsList", personService.findAllPersonsByWho(DOCTOR));
        model.addAttribute("currentUserRole", personDto.getWho());
        model.addAttribute("currUserStatusAndName", personDto.getAuthorizedValue());
        return "visit_time";
    }

    @RequestMapping(value = "/visit_time", method = RequestMethod.POST)
    public String doctorSubmit(MessageDto message, Model model) {
        // model.addAttribute("chatMeas", message);
        visitService.setVisitDetails(personDto.getVisitTime(), personDto.getVisitDoctorId(), personDto.getId());
        //   logger.info(chat.getContent());
        return "redirect:/visit";
    }
}
