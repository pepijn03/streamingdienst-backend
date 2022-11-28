package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Future;

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

    @Override
    public void DeleteComment(int id){commentRepo.deleteById(id);}

    @Override
    @Async
    public Future<Set<Comment>>  GetCommentByFilm(int id) {
        System.out.println("Execute method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            Set<Comment> comments = commentRepo.GetByFilm(id);
            return new AsyncResult<>(comments);
        } catch (InterruptedException e) {
            //
        }

        return null;
    }

}