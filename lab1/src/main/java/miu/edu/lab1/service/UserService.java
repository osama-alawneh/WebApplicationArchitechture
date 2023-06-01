package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface UserService {
    public List<Users> findAll();
    public Users findUserById(long id);
    public void save(Users user);
    public List<Post> getUserPosts(long id);
    public void saveUserPost(long id,Post post);
    public List<Post> findPostsByUserId(long userId);
    public Post findPostByUserIdAndPostId(long userId, long postId);
}
