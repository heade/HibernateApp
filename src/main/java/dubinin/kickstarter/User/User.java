package dubinin.kickstarter.User;
import com.sun.istack.internal.NotNull;
import dubinin.DAO.Factory;
import dubinin.kickstarter.Post.Post;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private  Roles role;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Calendar registrationDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @OneToMany
    private List<Post> post = new ArrayList<Post>();

    public User(){

    }

    public List<Post> getPost() {
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

    public void registration() throws SQLException{
        Scanner in = new Scanner(System.in);
        String line;
        System.out.println("Name: ");
        setName(in.nextLine());

        System.out.println("Surname: ");
        setSurname(in.nextLine());

        System.out.println("Email: ");
        while (true){
            line = in.nextLine();
            if (Factory.getInstance().getUserDAO().getUserByEmail(line) != null)
            {
                System.out.println("This email is already registered");
                System.out.println("Email: ");
                continue;
            }
            break;
        }
        setEmail(line);

        System.out.println("Login: ");
        while (true)
        {
            line = in.nextLine();
            if (Factory.getInstance().getUserDAO().getUserByLogin(line) != null)
            {
                System.out.println("This login is already registered");
                System.out.println("Login: ");
                continue;
            }
            break;
        }
        setLogin(line);

//        line = in.nextLine();
//        if (Factory.getInstance().getUserDAO().getUserByLogin(line) != null){
//            System.out.println("This login is already registered");
//            registration();
//        }
//        else
//            setLogin(line);

        System.out.println("Password: ");
        setPassword(in.nextLine());
        //password = System.console().readPassword();
        System.out.println("Role (1 - User, 0 - Client) : ");
        int key = in.nextInt();
        role = (key==1) ? Roles.ROLE_USER: Roles.ROLE_CLIENT;
    }

    public void addPost() throws SQLException
    {
        Post p = new Post();
        p.createPost();
        Factory.getInstance().getPostDAO().addPost(p);
        post.add(p);
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

}
