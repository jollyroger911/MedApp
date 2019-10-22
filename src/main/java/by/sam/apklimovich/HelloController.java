package by.sam.apklimovich;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

//@Controller
//public class HelloController {
//    @RequestMapping("/")
//    public String display()
//    {
//        return "index";
//    }
//}
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String printHello() {

        return "Hello world.";
    }
}