package dubinin.kickstarter.controllers;

import dubinin.kickstarter.entity.User;
import dubinin.kickstarter.entity.UserRole;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by daniel on 3/8/16.
 */
public class SignupForm {

    private static final String NAME_MESSAGE = "{name.message}";
    private static final String SURNAME_MESSAGE = "{surname.message}";
    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";
    private static final String LOGIN_MESSAGE = "{login.message}";


    @NotBlank(message = SignupForm.NAME_MESSAGE)
    private String name;

    @NotBlank(message = SignupForm.SURNAME_MESSAGE)
    private String surname;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.LOGIN_MESSAGE)
    private String login;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User createUser() {
        return new User(getLogin(), getEmail(), getName(), getSurname(), getPassword(), new UserRole());
    }
}
