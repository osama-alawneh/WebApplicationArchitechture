package miu.edu.lab1.controller;

import jakarta.transaction.Transactional;
import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;
import miu.edu.lab1.service.CommentService;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@Transactional
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> findAll(@RequestParam(value = "author", required = false) String author,
                              @RequestParam(value = "title", required = false) String title){
        if(author != null){
            return postService.getByAuthor(author);
        }
        if(title != null){
            return postService.findAllByTitle(title);
        }
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v2")
    public List<Post> getAll2(){
        return postService.findAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") long id){
        return postService.findById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Post post){
        postService.save(post);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        postService.delete(id);
    }



    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Post post){
        postService.update(id, post);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getComments(@PathVariable("id") long id){
        Post post = postService.findById(id);
        return post.getComments();
    }
    @GetMapping("/{post_id}/comments/{comment_id}")
    public Comment findCommentPyPostAndCommentId(@PathVariable("post_id") long pathId, @PathVariable("comment_id") long commentId){
        List<Comment> comments = getComments(pathId);
        return comments.stream()
                .filter(p -> p.getId() == commentId)
                .findFirst()
                .orElse(null);
    }
    @PostMapping("/{id}/comments")
    public void saveCommentToPost(@PathVariable("id") long postId, @RequestBody Comment comment){
        Post post = getById(postId);
        post.getComments().add(comment);
    }
}
