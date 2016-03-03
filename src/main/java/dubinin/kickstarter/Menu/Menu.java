package dubinin.kickstarter.Menu;
import dubinin.DAO.Factory;
import dubinin.kickstarter.User.Roles;
import dubinin.kickstarter.User.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Daniel on 28.02.2016.
 */
public class Menu {

    private User user;
    private int key;
    private String login ="";
    private String password="";
    private Scanner in = new Scanner(System.in);
    public Menu(){

    }

    public void run()throws SQLException{

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

    public void login()throws SQLException{

        Scanner input = new Scanner(System.in);
        System.out.println("Login: ");
        login = input.nextLine();
        System.out.println("Password: ");
        password = input.nextLine();

        User u = Factory.getInstance().getUserDAO().getUserByLogin(login);
        if (u != null)
            if (u.getPassword().equals(password))
                user = u;
            else {
                System.out.println("Wrong login or password");
                run();
            }
        else {
            System.out.println("Wrong login or password");
            run();
        }

        System.out.println("Login is success");
        if (u.getRole() == Roles.ROLE_CLIENT)
           new ClientWork(user).work();
        else if (u.getRole() == Roles.ROLE_USER)
            new UserWork(user).work();
    }

    public void registration()throws SQLException{

        user = new User();
        user.registration();
        Factory.getInstance().getUserDAO().addUser(user);
        System.out.println("Registration is success");

        if (user.getRole() == Roles.ROLE_CLIENT)
           new ClientWork(user).work();
        else if (user.getRole() == Roles.ROLE_USER)
            new UserWork(user).work();

    }


}
