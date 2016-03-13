package dubinin.kickstarter.DAO;

import dubinin.kickstarter.entity.User;
import dubinin.kickstarter.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 01.03.2016.
 */
public class UserDAOImpl implements UserDAO {

    @Autowired
    private MainDAO mainDao;

    @Override
    public Session getSession() {
        return mainDao.getSession();
    }

    @Override
    public User getUser(Long id) {
        return mainDao.findEntity(User.class, id);
    }

    @Override
    public void addUser(User user) throws SQLException {
        mainDao.persist(user);
    }

    @Override
    public User updateUser(User user) throws SQLException {
        return mainDao.merge(user);
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        return (User)getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .uniqueResult();
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        return (User)getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

//    @Override
//    public List getAllUsers() throws SQLException {
//        return null;
//    }

    @Override
    public void deleteUser(User user) throws SQLException {
        mainDao.remove(user);
    }

    //    public void addUser(User user) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.save(user);
//            session.getTransaction().commit();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//    }
//
//    public void updateUser(User user) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.update(user);
//            session.getTransaction().commit();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//    }
//
//    public User getUserByLogin(String login) throws SQLException {
//        Session session = null;
//        User user = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            Criteria criteria = session.createCriteria(User.class);
//            //user = (User)session.load(User.class, login);
//            user = (User)criteria.add(Restrictions.eq("login", login)).uniqueResult();
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally{
//            if (session != null && session.isOpen()) session.close();
//        }
//        return user;
//    }
//
//    public User getUserByEmail(String email)throws SQLException
//    {
//        Session session = null;
//        User user = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            Criteria criteria = session.createCriteria(User.class);
//            user = (User)criteria.add(Restrictions.eq("email", email)).uniqueResult();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally{
//            if (session != null && session.isOpen()) session.close();
//        }
//        return user;
//    }
//
//    public List getAllUsers() throws SQLException {
//        Session session = null;
//        List<User> users = new ArrayList<User>();
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            users = session.createCriteria(User.class).list();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return users;
//    }
//
//    public void deleteUser(User user) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(user);
//            session.getTransaction().commit();
//        }catch (Exception e){
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//    }
}
