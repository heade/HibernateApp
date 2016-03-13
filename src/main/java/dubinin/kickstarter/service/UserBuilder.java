package dubinin.kickstarter.service;

import dubinin.kickstarter.dto.UserDTO;
import dubinin.kickstarter.entity.Post;
import dubinin.kickstarter.entity.User;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by daniel on 3/6/16.
 */
public class UserBuilder implements ObjectDuilder<UserDTO, User> {

    private PostBuilder postBuilder;

    public UserBuilder(PostBuilder postBuilder) {
        this.postBuilder = postBuilder;
    }

    public User build(UserDTO object) {
        User user = new User();
        user.setId(object.getId());
        user.setLogin(object.getLogin());
        user.setEmail(object.getEmail());
        user.setName(object.getName());
        user.setSurname(object.getSurname());
        user.setPassword(object.getPassword());
        List<Post> posts = object.getPosts().stream()
                .map(postBuilder::build)
                .collect(Collectors.toList());
        user.setPost(posts);
        return user;
    }
}
