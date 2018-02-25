package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by User on 26.02.2018.
 */
@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Well hello there";
    }
}
