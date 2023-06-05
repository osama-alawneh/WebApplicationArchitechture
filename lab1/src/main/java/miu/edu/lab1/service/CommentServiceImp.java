package miu.edu.lab1.service;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService{

    CommentRepo commentRepo;

    @Autowired
    public CommentServiceImp(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findById(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }
}
