package dubinin.kickstarter.entity;


import dubinin.kickstarter.entity.User;

import java.util.Calendar;
import java.util.Scanner;
import javax.persistence.*;

/**
 * Created by Daniel on 28.02.2016.
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "post_name", unique = true)
    private String postname;

    @Column(name = "category")
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kickstarter")
    private User user;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @Column(name = "text")
    private String text;

    public Post() {

    }
//    public void createPost(){
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Title: ");
//        postname = in.nextLine();
//
//        System.out.println("Category: ");
//        category = in.nextLine();
//
//        System.out.println("Post: ");
//        text = in.nextLine();
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public void showPost(){
//        System.out.println("Post name: " + postname);
//        System.out.println("Category: " + category);
//        System.out.println("Date: " + date);
//        System.out.println("Post" + text);
//    }
}
