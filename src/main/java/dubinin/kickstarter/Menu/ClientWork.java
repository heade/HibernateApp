package dubinin.kickstarter.Menu;

import dubinin.kickstarter.User.ControlPanel;
import dubinin.kickstarter.User.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Daniel on 29.02.2016.
 */
public class ClientWork extends Menu {
    private User user;
    private int key;
    private Scanner in = new Scanner(System.in);
    public ClientWork(User user){
        this.user = user;
    }

    public void work()throws SQLException{

        System.out.println("<---------- User Menu ---------->");
        System.out.println("1. Control Panel");
        System.out.println("2. Create new post");
        System.out.println("3. Show my posts");
        System.out.println("4. Exit");

        key = in.nextInt();
        switch(key){
            case 1: controllPanel();
                break;
            case 2: createPost();
                break;
            case 3: showAllPosts();
                break;
            case 4: run();
                break;
            default:
                System.out.println("Wrong value!");
                work();
                break;
        }
    }

    public void controllPanel()throws SQLException{
        int key;
        System.out.println("<------ Personal data ------>");
        user.showUserData();
        System.out.println("1. Change login");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Finish");

        key = in.nextInt();
        ControlPanel cp = new ControlPanel(user);
        switch(key){
            case 1:cp.changeLogin();
                controllPanel();
                break;
            case 2:cp.changeEmail();
                controllPanel();
                break;
            case 3:cp.changePassword();
                controllPanel();
                break;
            case 4: work();
                break;
            default:
                System.out.println("Wrong value");
                controllPanel();
                break;
        }
    }

    public void createPost()throws SQLException{
        user.addPost();
        System.out.println("Post is created");
        work();
    }

    public void showAllPosts()throws SQLException{
        user.showAllPosts();
        work();
    }
}
