package by.sam.apklimovich.controllers;

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
public class LoginController {
    @Autowired
    public PersonService personService;

    @RequestMapping(value = "/login_form", method = RequestMethod.GET)
    public String login(Model model) {
         model.addAttribute("");
        return "forms/login_form";
    }

    @RequestMapping(value = "/login_form", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute @Valid PersonDto person, Model model) {
        model.addAttribute("person1", person);
        Logger logger = LoggerFactory.getLogger(LoginController.class);
        //Person p = new Person();
        //p.setFirstName(person.getName());
        //person.setStatus(personService.geussWho(person.getWho()));
        //personService.createPerson(person.getName(), person.getSurname(), person.getWho());
        logger.info(person.getName());
        return "forms/login_form";
    }

}
