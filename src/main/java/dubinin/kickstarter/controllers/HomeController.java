package dubinin.kickstarter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Calendar;

/**
 * Created by daniel on 3/7/16.
 */
@Controller
public class HomeController {
//    @Autowired
//    private ProgrammerService programmerRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal, Model model) {
        if(principal != null) {
//            String currentEmail = principal.getName();
//            Programmer programmer = programmerRepository.findByEmail(currentEmail);
//            programmer.setLastVisit(Calendar.getInstance());
//            programmerRepository.update(programmer);
//            model.addAttribute("programmer", programmer);
            return "home/homeSignedIn";
        }
        return "home/homeNotSignedIn";
    }

}
