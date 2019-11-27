package by.sam.apklimovich.controllers;

import by.sam.apklimovich.model.NewPersonDto;
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

@Controller
public class AdminController {
    public Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonDto personDto;

    @RequestMapping(value = "/add_user_page", method = RequestMethod.GET)
    public String adminPage(Model model) {
        logger.info("get controller at add user page works");
        if (personDto.getWho() == 2) {
            model.addAttribute("personAdd", new NewPersonDto());
            return "add_user_page";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String adminAddUser(@ModelAttribute NewPersonDto newPersonDto, Model model) {
        model.addAttribute("personAdd", newPersonDto);
        logger.info("admin add user post method");
        if (personService.addUser(newPersonDto)) {
            return "/index.html";
        } else {
            return "forms/error";
        }
    }
}
