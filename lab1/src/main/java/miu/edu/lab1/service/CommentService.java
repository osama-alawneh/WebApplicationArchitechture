package miu.edu.lab1.service;

import miu.edu.lab1.domain.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();
    public Comment findById(long id);
    public void save(Comment comment);
}
