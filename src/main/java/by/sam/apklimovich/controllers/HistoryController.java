package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HistoryController {

    PersonDto personDto;

    @Autowired
    VisitService visitService;

    public Logger logger = LoggerFactory.getLogger(HistoryController.class);

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String chat(Model model) {
        model.addAttribute("currentUserRole", personDto.getWho());
        model.addAttribute("currUserStatusAndName", personDto.getAuthorizedValue());
        model.addAttribute("patHistory", visitService.getHistoryByPatId(personDto.getId()));
        model.addAttribute("langValRu", "patient_history?lang=ru");
        model.addAttribute("langValEn", "patient_history?lang=en");
        model.addAttribute("langValNl", "patient_history?lang=nl");
        return "patient_history";
    }
}
