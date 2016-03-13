package dubinin.kickstarter.service;

import dubinin.kickstarter.DAO.UserDAO;
import dubinin.kickstarter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import java.sql.SQLException;

/**
 * Created by daniel on 3/8/16.
 */
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Inject
    private PasswordEncoder passwordEncoder;
    public User create(User user) throws SQLException{
        if (user != null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDAO.addUser(user);
        }

        return user;
    }
}
