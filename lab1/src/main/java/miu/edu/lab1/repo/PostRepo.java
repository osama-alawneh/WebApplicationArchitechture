package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;

import java.util.List;

public interface PostRepo {
    public List<Post> getAll();
    public Post getById(long id);
    public void save(Post post);
    public void delete(long id);
    public void update(long id, Post post);
}
