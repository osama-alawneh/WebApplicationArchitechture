package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;

import java.util.List;

public interface PostService {
    public List<Post> getAll();
    public PostDto getById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
}
