package by.sam.apklimovich.controllers;

import by.sam.apklimovich.PersonDto;
import by.sam.apklimovich.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    public PersonService personService;

    @RequestMapping("/")
    public String main(){
        return "index.html";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model, PersonDto person) {
        model.addAttribute("message", name);
        return "forms/hello"; //view
    }


    @PostMapping(value = "/formVal")
    public String processName(@Valid PersonDto person, BindingResult br) {
        if (br.hasErrors()) {
            return "forms/error";
        }
        else {
            personService.createPerson();
            return "forms/name";
        }
    }
}

