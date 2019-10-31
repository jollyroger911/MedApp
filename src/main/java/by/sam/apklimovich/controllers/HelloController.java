package by.sam.apklimovich.controllers;

import by.sam.apklimovich.Persons1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model, Persons1 person) {
        model.addAttribute("message", name);
        return "form/hello"; //view
    }

    @PostMapping(value = "/formVal")
    public String processName(@Valid Persons1 person, BindingResult br) {
        if (br.hasErrors()) {
            return "forms/error";
        }
        else {
            return "forms/name";
        }
    }
}

