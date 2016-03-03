package dubinin.kickstarter.User;

import dubinin.DAO.Factory;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Daniel on 29.02.2016.
 */
public class ControlPanel {

    private User user;
    private Scanner in = new Scanner(System.in);
    private String newValue;
    //private char [] newPass;
    public ControlPanel(User user){
        this.user = user;
    }

    public void changeLogin() throws SQLException{

        System.out.println("Enter new login: ");
        newValue = in.nextLine();
        user.setLogin(newValue);
        Factory.getInstance().getUserDAO().updateUser(user);
    }

    public void changeEmail() throws SQLException{

        System.out.println("Enter new email: ");
        newValue = in.nextLine();
        user.setEmail(newValue);
        Factory.getInstance().getUserDAO().updateUser(user);
    }

    public void changePassword() throws SQLException{

        System.out.println("Enter new password: ");
        newValue = in.nextLine();
        user.setPassword(newValue);
        Factory.getInstance().getUserDAO().updateUser(user);
    }
}