package dubinin.DAO;

import dubinin.kickstarter.User.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daniel on 01.03.2016.
 */
public interface UserDAO {
    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    User getUserById(Long id) throws SQLException;
    List getAllUsers() throws SQLException;
    void deleteUser(User user) throws SQLException;
}
