package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Person;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HistoryController {

    @Autowired
    private PersonService personService;

    @Autowired
    VisitService visitService;

    public Logger logger = LoggerFactory.getLogger(HistoryController.class);

    static final int DOCTOR = 1;
    static final int PATIENT = 0;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String chat(Model model) {
        PersonDto personDto = new PersonDto();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        model.addAttribute("currentUserRole", personDto.getWho());
        model.addAttribute("currUserStatusAndName", personDto.getAuthorizedValue());
        if(personDto.getWho() == PATIENT) {
            model.addAttribute("patHistory", visitService.getHistoryByPatId(personDto.getId()));
        }
        else if(personDto.getWho() == DOCTOR) {
            model.addAttribute("patHistory", visitService.getVisitsByDocId(personDto.getId()));
        }
        model.addAttribute("langValRu", "history?lang=ru");
        model.addAttribute("langValEn", "history?lang=en");
        model.addAttribute("langValNl", "history?lang=nl");
        return "patient_history";
    }
}
