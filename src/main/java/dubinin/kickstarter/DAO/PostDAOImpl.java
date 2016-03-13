package dubinin.kickstarter.DAO;

import dubinin.kickstarter.entity.Post;
import dubinin.kickstarter.entity.User;
import dubinin.kickstarter.util.HibernateUtil;
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
public class PostDAOImpl implements PostDAO {

   @Autowired
   private MainDAO mainDAO;

    @Override
    public Session getSession() {
        return mainDAO.getSession();
    }

    @Override
    public void addPost(Post post) throws SQLException {
        mainDAO.persist(post);
    }

    @Override
    public Post updatePost(Post post) throws SQLException {
        return mainDAO.merge(post);
    }

    @Override
    public Post getPostByCategory(String category) throws SQLException {
        return (Post)getSession().createCriteria(User.class)
                .add(Restrictions.eq("category", category))
                .uniqueResult();
    }

    @Override
    public Post getPost(Long id) {
        return mainDAO.findEntity(Post.class, id);
    }

    @Override
    public void deletePost(Post post) throws SQLException {
        mainDAO.remove(post);
    }

    //    public void addPost(Post post) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.save(post);
//            session.getTransaction().commit();
//        }catch (Exception e2){
//            JOptionPane.showMessageDialog(null, e2.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally{
//            if (session != null && session.isOpen()) session.close();
//        }
//
//    }
//
//    public Post updatePost(Post post) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.update(post);
//            session.getTransaction().commit();
//        }catch(Exception e2){
//            JOptionPane.showInputDialog(null, e2.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//
//    }
//
//    public Post getPostByCategory(String category) throws SQLException {
//        Session session = null;
//        Post post = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            post = (Post)session.load(Post.class, category);
//        }catch (Exception e2) {
//            JOptionPane.showMessageDialog(null, e2.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//        return post;
//    }
//
//    public List getAllPosts() throws SQLException {
//        Session session = null;
//        List<Post> posts = new ArrayList<Post>();
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            posts = session.createCriteria(Post.class).list();
//        }catch(Exception e2){
//            JOptionPane.showMessageDialog(null, e2.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//        return posts;
//    }
//
//    public void deletePost(Post post) throws SQLException {
//        Session session = null;
//        try{
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.delete(post);
//            session.getTransaction().commit();
//        } catch( Exception e2){
//            JOptionPane.showMessageDialog(null, e2.getMessage(), "Error I/O", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) session.close();
//        }
//    }
}
