package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.service.CommentService;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") long id){
        return commentService.findById(id);
    }
    @PostMapping
    public void save(Comment comment){
        commentService.save(comment);
    }
}
