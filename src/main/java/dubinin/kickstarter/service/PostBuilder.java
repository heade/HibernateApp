package dubinin.kickstarter.service;

import dubinin.kickstarter.dto.PostDTO;
import dubinin.kickstarter.entity.Post;

/**
 * Created by daniel on 3/6/16.
 */
public class PostBuilder implements ObjectDuilder<PostDTO, Post>{
    public Post build(PostDTO object) {
        Post post = new Post();
        post.setId(object.getId());
        post.setCategory(object.getCategory());
        post.setPostname(object.getPostname());
        post.setText(object.getText());
        post.setDate(object.getDate());
        return post;
    }
}
