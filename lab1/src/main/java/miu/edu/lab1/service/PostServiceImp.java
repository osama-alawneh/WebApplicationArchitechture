package miu.edu.lab1.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;
import miu.edu.lab1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImp implements PostService{

    EntityManager em;
    private final PostRepo postRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public PostServiceImp(PostRepo postRepo, ModelMapper modelMapper, EntityManager em) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.em = em;
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public List<Post> getByAuthor(String author) {
        return postRepo.getAllByAuthor(author);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(long id, Post post) {
        Post oldPost = findById(id);
        postRepo.save(oldPost);
    }
    public List<Post> findAllByTitle(String title){
        return postRepo.findAllByTitle(title);
    }
}
