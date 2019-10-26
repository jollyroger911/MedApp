package by.sam.apklimovich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("message", name);

        return "hello"; //view
    }

//    @PostMapping("/hello")
//    public String greetingSubmit(@ModelAttribute Person person) {
//        return "result";
//    }


/*   // @RequestMapping(method = RequestMethod.GET)
    //@ResponseBody
   //public String printHello() {
   @GetMapping({"/", "/hello"})
   public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
       model.addAttribute("name", name);

        return "hello";
    }*/
}

