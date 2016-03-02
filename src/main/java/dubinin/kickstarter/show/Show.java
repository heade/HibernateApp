package dubinin.kickstarter.show;

import dubinin.kickstarter.Post.Post;
import dubinin.kickstarter.User.User;

/**
 * Created by daniel on 3/2/16.
 */
public class Show {

    private static User user;

    public Show(){

    }

    public static void showUserData(User user){
        System.out.println("Name: " + user.getName() + ", surname " + user.getSurname());
        System.out.println("Login: " + user.getLogin());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Role: " + user.getRole().getRole());
    }

    public static void showAllPosts(User user){
        for (Post thisPost : user.getPost())
            thisPost.showPost();
    }
}
