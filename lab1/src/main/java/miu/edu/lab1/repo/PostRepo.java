package miu.edu.lab1.repo;
import miu.edu.lab1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    public List<Post> getAllByAuthor(String author);
    List<Post> findAllByTitle(String title);
}
