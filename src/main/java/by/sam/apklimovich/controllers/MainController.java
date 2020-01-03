package by.sam.apklimovich.controllers;

import by.sam.apklimovich.config.WebMvcConfig;
import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
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

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Controller
public class MainController {


    public PersonDto personDto;

    @Autowired
    public WebMvcConfig wmvc;

    @Autowired
    public PersonService personService;

    @RequestMapping("/")
    public String main(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        if(!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }
        String str = "";
        if(personDto.getWho() == 1) {
            str = "Doctor";
        }
        else if(personDto.getWho() == 0){
            str = "Patient";
        }
        else if(personDto.getWho() == 2){
            str = "Admin";
        }
        else{
            str = "Guest";
        }
        Integer state = 1;
        str = str + ": " + personDto.getName() + " " + personDto.getSurname();
        if(str.equals("Patient: null null")){
            personDto.setWho(-1);
            ResourceBundle username = ResourceBundle.getBundle("i18n.messages");
            str = username.getString("str.unauthorizedUser");
        }
        model.addAttribute("stateOfUser", state);
        personDto.setAuthorizedValue(str);
        model.addAttribute("currUserStatusAndName", str);
        LocalDate today = LocalDate.now();
        model.addAttribute("currentDate", today);
        model.addAttribute("currentUserRole", personDto.getWho());
        personDto.setCurrentDate(Date.valueOf(today));
        return "index";
    }


//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(Model model) {
//        Logger logger = LoggerFactory.getLogger(MainController.class);
//        logger.info("get controller");
//        model.addAttribute("person1", new PersonDto());
//        model.addAttribute("role", personDto.getWho());
//        return "forms/hello";
//    }

//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
//    public String helloSubmit(@ModelAttribute @Valid PersonDto person, Model model) {
//        model.addAttribute("person1", person);
//        Logger logger = LoggerFactory.getLogger(MainController.class);
//        Person p = new Person();
//        p.setFirstName(person.getName());
//        person.setStatus(personService.geussWho(person.getWho()));
//        personService.createPerson(person.getName(), person.getSurname(), person.getWho());
//        logger.info(person.getName());
//        return "forms/name";
//    }

}

