package dubinin.kickstarter.User;
import com.sun.istack.internal.NotNull;
import dubinin.kickstarter.Post.Post;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Daniel on 28.02.2016.
 */
@Entity
@Table(name = "kickstarter")
public class User {

    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name ="id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    @NotNull
    private String email;

    @JoinColumn(name = "role")
    @ManyToOne(fetch = FetchType.EAGER)
    private Roles role;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Calendar registrationDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ArrayList<Post> post = new ArrayList<Post>();

    public User(){

    }

    public ArrayList<Post> getPost() {
        return post;
    }

    public void setPost(ArrayList<Post> post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void registration(){
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        setName(in.nextLine());
        System.out.println("Surname: ");
        setSurname(in.nextLine());
        System.out.println("Email: ");
        setEmail(in.nextLine());
        System.out.println("Login: ");
        setLogin(in.nextLine());
        System.out.println("Password: ");
        setPassword(in.nextLine());
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

}
