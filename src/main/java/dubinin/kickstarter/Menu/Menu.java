package dubinin.kickstarter.Menu;
import dubinin.kickstarter.User.Roles;
import dubinin.kickstarter.User.User;

import java.util.Scanner;

/**
 * Created by Daniel on 28.02.2016.
 */
public class Menu {

    private User user;
    private int key;
    private Scanner in = new Scanner(System.in);
    public Menu(){

    }

    public void run(){

        System.out.println("<---------- Menu ---------->");
        System.out.println("1. Login");
        System.out.println("2. Registration");
        System.out.println("3. Exit");

        key = in.nextInt();
        switch(key){
            case 1: login();
                break;
            case 2: registration();
                break;
            case 3: System.exit(0);
                break;
            default:
                System.out.println("Wrong value!");
                run();
                break;
        }
    }

    public void login(){

        user = new User();
        user.login();
        System.out.println("Login is success");
        run();
    }

    public void registration(){

        user = new User();
        user.registration();
        System.out.println("Registration is success");
        if (user.getRole() == Roles.ROLE_CLIENT)
            new ClientWork(user).work();
        else if (user.getRole() == Roles.ROLE_USER)
            new UserWork(user).work();

    }


}
