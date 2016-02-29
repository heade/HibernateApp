package dubinin.kickstarter.User;
import dubinin.kickstarter.Post.Post;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Daniel on 28.02.2016.
 */
public class User {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private Roles role;
//    private char [] password;
    private ArrayList<Post> post = new ArrayList<Post>();

    public User(){

    }

    public void registration(){
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        name = in.nextLine();
        System.out.println("Surname: ");
        surname = in.nextLine();
        System.out.println("Email: ");
        email = in.nextLine();
        System.out.println("Login: ");
        login = in.nextLine();
        System.out.println("Password: ");
        password = in.nextLine();
        //password = System.console().readPassword();
        System.out.println("Role (1 - User, 0 - Client) : ");
        int key = in.nextInt();
        role = (key==1) ? Roles.ROLE_USER: Roles.ROLE_CLIENT;
    }

    public void login(){
        Scanner in = new Scanner(System.in);
        System.out.println("Login: ");
        login = in.nextLine();
        System.out.println("Password: ");
        password = in.nextLine();
        //password = System.console().readPassword();
        //остальные поля заполнятся из базы
    }

    public void addPost()
    {
        post.add(new Post());
    }

    public void showAllPosts(){
        for (Post thisPost : post)
            thisPost.showPost();
    }

    public void showUserData(){
        System.out.println("Name: " + name + ", surname " + surname);
        System.out.println("Login: " + login);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role.getRole());
    }

    //сеттеры для изменения личных данных
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }
}
