package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostDto;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAll(){
        return postService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v2")
    public List<Post> getAll2(){
        return postService.getAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") long id){
        return postService.getById(id);
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
}
