package dubinin.kickstarter.dto;

import dubinin.kickstarter.entity.User;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by daniel on 3/5/16.
 */
public class PostDTO implements Serializable {

    private Long id;
    private String postname;
    private String category;
    private String text;
    private User user;
    private Calendar date;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
}
