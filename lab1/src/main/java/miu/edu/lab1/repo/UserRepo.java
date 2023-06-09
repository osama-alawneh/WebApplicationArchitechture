package miu.edu.lab1.repo;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    @Query("select Post from Users u where u.id = :id")
    List<Post> findPostsByUserId(long id);

    @Query("select u from Users u where size(u.posts) > :num")
    List<Users> findAllByPostsMoreThan(@Param("num") int num);
}
