package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.model.CommentDTO;

import java.util.List;
import java.util.Optional;


public interface CommentService {
    Optional<Comment> findComment(int comment_id);
    Comment SaveComment(Comment comment);
    Comment UpdateComment(Comment comment);
    void UpdateLike(int comment_id, int like_value);

}
