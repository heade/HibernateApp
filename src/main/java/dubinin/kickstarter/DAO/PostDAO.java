package dubinin.kickstarter.DAO;

import dubinin.kickstarter.entity.Post;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daniel on 01.03.2016.
 */
public interface PostDAO {
    Session getSession();
    void addPost(Post post) throws SQLException;
    Post updatePost(Post post) throws SQLException;
    Post getPost(Long id);
    Post getPostByCategory(String category) throws SQLException;
   // List getAllPosts() throws SQLException;
    void deletePost(Post post) throws SQLException;
}
