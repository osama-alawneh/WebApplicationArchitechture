package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;
import miu.edu.lab1.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService{

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public PostServiceImp(PostRepo postRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }

    @Override
    public List<Post> getByAuthor(String author) {
        return postRepo.getByAuthor(author);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, Post post) {
        postRepo.update(id, post);
    }
}
