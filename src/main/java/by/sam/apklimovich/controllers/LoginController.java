package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.LoginService;
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
    private PersonService personService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login_form", method = RequestMethod.GET)
    public String login(Model model) {
        loginService.isFirstStart();
        return "forms/login_form";
    }

    @RequestMapping(value = "/login_form", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute @Valid PersonDto person, Model model) {
        model.addAttribute("person1", person);
        Logger logger = LoggerFactory.getLogger(LoginController.class);
        logger.info(person.getName());
        return "forms/login_form";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "error/403";
    }

}
