package dubinin.kickstarter.Post;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Daniel on 28.02.2016.
 */
public class Post {

    private String postname;
    private String category;
    private Date date;
    private String text;

    public Post() {
        Scanner in = new Scanner(System.in);

        date = new Date();

        System.out.println("Title: ");
        postname = in.nextLine();

        System.out.println("Category: ");
        category = in.nextLine();

        System.out.println("Post: ");
        text = in.nextLine();
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void showPost(){
        System.out.println("Post name: " + postname);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
        System.out.println("Post" + text);
    }
}
