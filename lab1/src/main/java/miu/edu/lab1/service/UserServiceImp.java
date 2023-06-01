package miu.edu.lab1.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Users;
import miu.edu.lab1.repo.PostRepo;
import miu.edu.lab1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final EntityManager em;

    @Autowired
    public UserServiceImp(UserRepo userRepo, PostRepo postRepo, EntityManager em) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.em = em;
    }

    @Override
    public List<Users> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Users findUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Users user) {
        userRepo.save(user);
    }

    @Override
    public List<Post> getUserPosts(long id) {
        return userRepo.findPostsByUserId(id);
    }

    @Override
    public void saveUserPost(long id, Post post) {
        Users user = userRepo.findById(id).orElse(null);
        if(user == null)
            return;

        user.getPosts().add(post);
    }

    @Override
    public List<Post> findPostsByUserId(long userId) {
        Users user = userRepo.findById(userId).orElse(null);
        if(user == null){
            return null;
        }
        return user.getPosts();
    }

    @Override
    public Post findPostByUserIdAndPostId(long userId, long postId) {
        Users user = userRepo.findById(userId).orElse(null);
        if(user == null){
            return null;
        }
        return user.getPosts().stream()
                .filter(p -> p.getId() == postId)
                .findFirst()
                .orElse(null);
    }
}
