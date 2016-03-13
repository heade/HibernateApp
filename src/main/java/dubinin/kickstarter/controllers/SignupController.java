package dubinin.kickstarter.controllers;

import dubinin.kickstarter.DAO.UserRoleService;
import dubinin.kickstarter.common.LinkUtil;
import dubinin.kickstarter.entity.Roles;
import dubinin.kickstarter.entity.User;
import dubinin.kickstarter.mail.MailService;
import dubinin.kickstarter.service.UserBuilder;
import dubinin.kickstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Created by daniel on 3/8/16.
 */
@Controller
public class SignupController {
    private static final String SIGNUP_VIEW_NAME = "signup/signup";

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "signup")
    public String signup(Model model){
        model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, HttpServletRequest req, Model model) throws SQLException, MalformedURLException{
        User user = signupForm.createUser();
        user.setRole(userRoleService.read(Roles.ROLE_UNACTIVE));
        userService.create(user);

        String activtionLink = LinkUtil.generateLink(req, user.getRegistrationKey());
        mailService.send(user.getEmail(), "Activtion", activtionLink);
        return "redirect:/";
    }
}
