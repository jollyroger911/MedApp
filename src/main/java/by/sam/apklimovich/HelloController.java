package by.sam.apklimovich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("message", name);

        return "hello"; //view
    }

    @RequestMapping(value = "/formVal", method = RequestMethod.GET)
    public String formVal(@Validated @ModelAttribute(value = "person") Person person, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", person.getName());
        return "name";
    }
}

