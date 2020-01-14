package by.sam.apklimovich.controllers;

import by.sam.apklimovich.config.WebMvcConfig;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        if (!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }
        String str = "";
        if (personDto.getWho() == 1) {
            str = "Doctor";
        } else if (personDto.getWho() == 0) {
            str = "Patient";
        } else if (personDto.getWho() == 2) {
            str = "Admin";
        } else {
            str = "Guest";
        }
        Integer state = 1;
        str = str + ": " + personDto.getName() + " " + personDto.getSurname();
        if (str.equals("Patient: null null")) {
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
        model.addAttribute("langValRu", "?lang=ru");
        model.addAttribute("langValEn", "?lang=en");
        model.addAttribute("langValNl", "?lang=nl");
        return "index";
    }

}

