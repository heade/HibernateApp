package dubinin.kickstarter.entity;

import dubinin.kickstarter.common.KeyUtil;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "role")
    @ManyToOne(fetch = FetchType.EAGER)
    private  UserRole role;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Calendar registrationDate;

    @Column(name = "registration_key")
    private String registrationKey;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Post> posts;

    public User(){
        registrationDate = Calendar.getInstance();
        registrationKey = KeyUtil.generateKey("");
    }

    public User(User user){
        this();
        if(user!=null){
            this.name = user.name;
            this.surname = user.surname;
            this.email = user.email;
            this.registrationKey = user.registrationKey;
            this.role = user.role;
            this.login = user.login;
        }
    }

    public User(String login, String email, String name, String surname, String password, UserRole role) {
        this();
        this.login = login;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getRegistrationKey() {
        return registrationKey;
    }

    public void setRegistrationKey(String registrationKey) {
        this.registrationKey = registrationKey;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }
//
//    public void registration() throws SQLException{
//        Scanner in = new Scanner(System.in);
//        String line;
//        System.out.println("Name: ");
//        setName(in.nextLine());
//
//        System.out.println("Surname: ");
//        setSurname(in.nextLine());
//
//        System.out.println("Email: ");
//        while (true){
//            line = in.nextLine();
//            if (Factory.getInstance().getUserDAO().getUserByEmail(line) != null)
//            {
//                System.out.println("This email is already registered");
//                System.out.println("Email: ");
//                continue;
//            }
//            break;
//        }
//        setEmail(line);
//
//        System.out.println("Login: ");
//        while (true)
//        {
//            line = in.nextLine();
//            if (Factory.getInstance().getUserDAO().getUserByLogin(line) != null)
//            {
//                System.out.println("This login is already registered");
//                System.out.println("Login: ");
//                continue;
//            }
//            break;
//        }
//        setLogin(line);
//
////        line = in.nextLine();
////        if (Factory.getInstance().getUserDAO().getUserByLogin(line) != null){
////            System.out.println("This login is already registered");
////            registration();
////        }
////        else
////            setLogin(line);
//
//        System.out.println("Password: ");
//        setPassword(in.nextLine());
//        //password = System.console().readPassword();
//        System.out.println("Role (1 - User, 0 - Client) : ");
//        int key = in.nextInt();
//        role = (key==1) ? Roles.ROLE_USER: Roles.ROLE_CLIENT;
//    }
//
//    public void addPost() throws SQLException
//    {
//        Post p = new Post();
//        p.createPost();
//        Factory.getInstance().getPostDAO().addPost(p);
//        posts.add(p);
//    }
//
//    public void showAllPosts(){
//        for (Post thisPost : posts)
//            thisPost.showPost();
//    }
//
//    public void showUserData(){
//        System.out.println("Name: " + name + ", surname " + surname);
//        System.out.println("Login: " + login);
//        System.out.println("Email: " + email);
//        System.out.println("Role: " + role.getRole());
//    }

}
