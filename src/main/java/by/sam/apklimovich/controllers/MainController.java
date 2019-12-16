package by.sam.apklimovich.controllers;

import by.sam.apklimovich.config.WebMvcConfig;
import by.sam.apklimovich.entity.Person;
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
import java.time.LocalDate;

@Controller
public class MainController {

    @Autowired
    public PersonDto personDto;

    @Autowired
    public WebMvcConfig wmvc;

    @Autowired
    public PersonService personService;

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("currentUserRole", personDto.getWho());
        LocalDate today = LocalDate.now();
        model.addAttribute("currentDate", today);
        return "index";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        Logger logger = LoggerFactory.getLogger(MainController.class);
        logger.info("get controller");
        model.addAttribute("person1", new PersonDto());
        model.addAttribute("role", personDto.getWho());
        return "forms/hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloSubmit(@ModelAttribute @Valid PersonDto person, Model model) {
        model.addAttribute("person1", person);
        Logger logger = LoggerFactory.getLogger(MainController.class);
        Person p = new Person();
        p.setFirstName(person.getName());
        person.setStatus(personService.geussWho(person.getWho()));
        personService.createPerson(person.getName(), person.getSurname(), person.getWho());
        logger.info(person.getName());
        return "forms/name";
    }

}

