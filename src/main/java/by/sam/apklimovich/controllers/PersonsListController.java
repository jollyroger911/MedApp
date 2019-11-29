package by.sam.apklimovich.controllers;

import by.sam.apklimovich.entity.Person;
import by.sam.apklimovich.model.ChatDto;
import by.sam.apklimovich.model.PersonDto;
import by.sam.apklimovich.service.ChatService;
import by.sam.apklimovich.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonsListController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonDto personDto;


    static final int DOCTOR = 1;
    static final int PATIENT = 0;

    private Logger logger = LoggerFactory.getLogger(PersonsListController.class);

    @RequestMapping(value = "/list_of_users", method = RequestMethod.GET)
    public String list(Model model, ChatDto chatDto) {
        logger.info("get controller");
        List<Person> persons;
        if(personDto.getWho() == DOCTOR) {
            persons = personService.findAllPersonsByWho(PATIENT);
        }
        else if(personDto.getWho() == PATIENT){
            persons = personService.findAllPersonsByWho(DOCTOR);
        }
        else {
           persons = personService.findAllPersons();
        }

        model.addAttribute("persons", persons);
        model.addAttribute("perosn", personDto );
        model.addAttribute("chatDto", chatDto);
        return "list_of_users";
    }
    @RequestMapping(value = "/list_of_users/{id}", method = RequestMethod.POST)
    public String helloSubmit(@ModelAttribute @Valid PersonDto person, Model model, @PathVariable(name = "personsId") Long id) {
        model.addAttribute("persons", person);
        logger.info(id.toString() + " THIS ID ID");
        Person p = new Person();
        p.setFirstName(person.getName());
        person.setStatus(personService.geussWho(person.getWho()));
        personService.createPerson(person.getName(), person.getSurname(), person.getWho());
        logger.info(person.getName());
        return "chat_two";
    }

}
