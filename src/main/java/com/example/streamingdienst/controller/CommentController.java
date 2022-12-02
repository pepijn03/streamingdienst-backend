package com.example.streamingdienst.controller;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    //GET
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    @GetMapping("/{id}")
    public Set<Comment> GetCommentByfilm(@PathVariable int id) throws ExecutionException, InterruptedException {
        Set<Comment> comments = null;

        System.out.println("Invoking an asynchronous method. "
                + Thread.currentThread().getName());
        Future<Set<Comment>> future = commentService.GetCommentByFilm(id);

        while (true) {
            if (future.isDone()) {
                comments = future.get();
                break;
            }


        }

        return comments;
    }


    //POST
    @PostMapping("/add")
    public String add(@RequestBody Comment comment){
        //comment.setFilm(new Film(filmService.FetchFilm(String.valueOf(comment.getFilm().getId())))) ;
        comment.setLikes(0);
        commentService.SaveComment(comment);
        return "comment is added";
    }

    //PUT
    @PutMapping("/like")
    public String like(@RequestBody Comment comment){
        /*CommentDto c = new CommentDto(commentService.findComment(comment.getId()));
        c.setLikes(comment.getLikes());*/
        commentService.UpdateLike(comment.getId(), comment.getLikes());
        return "comment likes have been updated";
    }

    //DELETE
    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        commentService.DeleteComment(id);
        return "film deleted";
    }

}