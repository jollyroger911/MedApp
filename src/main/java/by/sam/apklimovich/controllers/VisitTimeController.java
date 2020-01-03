package by.sam.apklimovich.controllers;

import by.sam.apklimovich.config.WebMvcConfig;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class VisitTimeController {
    @Autowired
    public WebMvcConfig wmvc;

    @Autowired
    public PersonService personService;


    PersonDto personDto;

    public Logger logger = LoggerFactory.getLogger(VisitTimeController.class);

    @RequestMapping(value = "/visit_time", method = RequestMethod.GET)
    public String visitTimeChoose(Model model) {
        model.addAttribute("currentUserRole", personDto.getWho());
        //  model.addAttribute("time1", new PersonDto());
        return "visit_time";
    }

    @RequestMapping(value = "/visit", method = RequestMethod.POST)
    public String VisitTimeChosen(@ModelAttribute @Valid PersonDto person, Model model) {
        model.addAttribute("time1", person);

        personDto.getVisitTime();
        logger.info(person.getName());
        return "visit_time";
    }
}
