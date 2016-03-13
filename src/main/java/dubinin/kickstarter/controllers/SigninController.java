package dubinin.kickstarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daniel on 3/7/16.
 */
@Controller
public class SigninController {

    @RequestMapping(value = "signin")
    public String signin(){
        return "signin/signin";
    }
}
