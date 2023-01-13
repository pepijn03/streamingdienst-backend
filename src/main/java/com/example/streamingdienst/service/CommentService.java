package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Comment;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;


public interface CommentService {
    Optional<Comment> findComment(int comment_id);
    Comment SaveComment(Comment comment);
    Comment UpdateComment(Comment comment);
    void UpdateLike(int comment_id, int like_value);
    void DeleteComment(int id);
    Future<Set<Comment>> GetCommentByFilm(int id);

}
