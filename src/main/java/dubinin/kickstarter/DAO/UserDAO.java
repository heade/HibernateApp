package dubinin.kickstarter.DAO;

import dubinin.kickstarter.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daniel on 01.03.2016.
 */
public interface UserDAO {
   Session getSession();
    void addUser(User user) throws SQLException;
    User updateUser(User user) throws SQLException;
    User getUser(Long id) throws SQLException;
    User getUserByLogin(String login) throws SQLException;
    User getUserByEmail(String email)throws SQLException;
  //  List getAllUsers() throws SQLException;
    void deleteUser(User user) throws SQLException;
}
