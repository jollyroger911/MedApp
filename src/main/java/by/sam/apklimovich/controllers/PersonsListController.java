package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.ChatDto;
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
import java.util.List;

@Controller
public class PersonsListController {
    @Autowired
    private PersonService personService;
    private PersonDto personDto;
    static final int DOCTOR = 1;
    static final int PATIENT = 0;

    private Logger logger = LoggerFactory.getLogger(PersonsListController.class);

    @RequestMapping(value = "/list_of_users", method = RequestMethod.GET)
    public String list(Model model, ChatDto chatDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        PersonDto personDto = new PersonDto();
        if (!authentication.getPrincipal().equals("anonymousUser")) {
            personDto = personService.getUserInfoByUsername(personDto, currentUserName);
        }
        logger.info("get controller");
        List<Person> persons;
        if (personDto.getWho() == DOCTOR) {
            persons = personService.findAllPersonsByWho(PATIENT);
        } else if (personDto.getWho() == PATIENT) {
            persons = personService.findAllPersonsByWho(DOCTOR);
        } else {
            persons = personService.findAllPersons();
        }

        model.addAttribute("persons", persons);
        model.addAttribute("currentUserRole", personDto.getWho());
        //  model.addAttribute("currUserStatusAndName", personDto.getAuthorizedValue());
        model.addAttribute("person", personDto);
        model.addAttribute("chatDto", chatDto);
        model.addAttribute("langValRu", "list_of_users?lang=ru");
        model.addAttribute("langValEn", "list_of_users?lang=en");
        model.addAttribute("langValNl", "list_of_users?lang=nl");
        return "list_of_users";
    }

    @RequestMapping(value = "/list_of_users/{destId}", method = RequestMethod.POST)
    public String userSubmit(@ModelAttribute @Valid PersonDto person, Model model) {
        model.addAttribute("persons", person);
        model.addAttribute("personDestIdValue", new Long(person.getDestId()));
        //personDto.setDestId(person.getDestId());
        // logger.info(id.toString() + " THIS IS ID");
        return "redirect:/chat";
    }

}
