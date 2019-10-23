package by.sam.apklimovich;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.HelloWorld;

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

