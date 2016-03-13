package dubinin.kickstarter.DAO;

/**
 * Created by Daniel on 01.03.2016.
 */
public class Factory {

    private static UserDAO userDAO = null;
    private static Factory instance = null;
    private static PostDAO postDAO = null;

    public static synchronized Factory getInstance(){
        if (instance == null)
            instance = new Factory();
        return instance;
    }

    public UserDAO getUserDAO(){
        if (userDAO == null)
            userDAO = new UserDAOImpl();
        return userDAO;
    }

    public PostDAO getPostDAO(){
        if (postDAO == null)
            postDAO = new PostDAOImpl();
        return postDAO;
    }
}
