package by.sam.apklimovich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "")
            @NotEmpty String name, Model model, Person person) {
        model.addAttribute("message", name);
        return "hello"; //view
    }

    @PostMapping(value = "/formVal")
    public String processName(Person person) {
        if (person.getName().isEmpty())
            return "error";
        return "name";
    }
}

