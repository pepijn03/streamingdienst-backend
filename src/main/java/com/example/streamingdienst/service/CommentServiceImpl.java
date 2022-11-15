package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Optional<Comment> findComment(int comment_id){return commentRepo.findById(comment_id);}

    @Override
    public Comment SaveComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment UpdateComment(Comment comment){ return commentRepo.save(comment); }

    @Override
    public void UpdateLike(int comment_id, int like_value){commentRepo.UpdateLike(comment_id, like_value);  }

}