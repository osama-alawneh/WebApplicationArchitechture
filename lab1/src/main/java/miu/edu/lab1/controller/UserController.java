package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Users;
import miu.edu.lab1.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> findAll(@RequestParam(value = "moreThanOne", required = false) String posts){
        if(posts == null){
            return userService.findAll();
        }
        return userService.findUsersHaveMoreThanOnePost();
    }

    @GetMapping("/{id}")
    public Users findUserById(@PathVariable(name = "id") long id){
        return userService.findUserById(id);
    }

    @PostMapping()
    public void save(@RequestBody Users user){
        userService.save(user);
    }

    @PostMapping("/{id}/posts")
    public void saveUserPost(@PathVariable("id") long id,@RequestBody Post post){
        userService.saveUserPost(id, post);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable("id") long id){
        return userService.findPostsByUserId(id);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public Post findPostByUserIdAndPostId(@PathVariable("userId") long userId, @PathVariable("postId") long postId){
        return userService.findPostByUserIdAndPostId(userId, postId);
    }
}
