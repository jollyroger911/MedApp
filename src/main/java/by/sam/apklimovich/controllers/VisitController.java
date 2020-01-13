package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.MessageDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
import by.sam.apklimovich.service.VisitService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisitController {
    public Logger logger = LoggerFactory.getLogger(ChatController.class);


    private PersonDto personDto;

    @Autowired
    private VisitService visitService;

    @Autowired
    private PersonService personService;


    private ChatDto chat;
    static final int DOCTOR = 1;

    @RequestMapping(value = "/visit", method = RequestMethod.GET)
    public String doctorsList(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        if(!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }

        model.addAttribute("doctorsList", personService.getDoctors(DOCTOR));
        model.addAttribute("currentUserRole", personDto.getWho());
        model.addAttribute("currUserStatusAndName", personDto.getAuthorizedValue());
        model.addAttribute("langValRu", "visit?lang=ru");
        model.addAttribute("langValEn", "visit?lang=en");
        model.addAttribute("langValNl", "visit?lang=nl");
        return "visit_time";
    }

    @RequestMapping(value = "/visit_time", method = RequestMethod.POST)
    public String doctorSubmit(MessageDto message, @ModelAttribute("chosenVisitTime") String cvt, @ModelAttribute("chosenDoctorId") String docId) {
        // model.addAttribute("chatMeas", message);9
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        personDto.setVisitDoctorId(Long.parseLong(docId));
        personDto.setVisitTime(cvt);
        if(!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }
        visitService.setVisitDetails(personDto.getVisitTime(), personDto.getVisitDoctorId(), personDto.getId());
        //   logger.info(chat.getContent());
        return "redirect:/visit";
    }
}
