package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImp implements PostRepo{
    private static List<Post> posts;
    private static long postId = 300;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(111, "title1", "content1", "author1");
        Post p2 = new Post(112, "title2", "content2", "author2");
        Post p3 = new Post(113, "title3", "content3", "author3");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(long id) {
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public List<Post> getByAuthor(String author) {
        return posts.stream()
                .filter(p -> p.getAuthor().equals(author))
                .toList();
    }

    @Override
    public void save(Post post) {
        post.setId(postId);
        postId++;
        posts.add(post);
    }

    @Override
    public void delete(long id) {
        var post = getById(id);;
        posts.remove(post);
    }

    @Override
    public void update(long id, Post post) {
        var postToUpdate = getById(id);
        postToUpdate.setAuthor(post.getAuthor());
        postToUpdate.setContent(post.getContent());
        postToUpdate.setTitle(post.getTitle());
    }
}
