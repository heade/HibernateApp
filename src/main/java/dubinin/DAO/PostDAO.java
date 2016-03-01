package dubinin.DAO;

import dubinin.kickstarter.Post.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Daniel on 01.03.2016.
 */
public interface PostDAO {
    void addPost(Post post) throws SQLException;
    void updateTest(Post post) throws SQLException;
    Post getPostByCategory(String category) throws SQLException;
    List getAllPosts() throws SQLException;
    void deletePost(Post post) throws SQLException;
}
