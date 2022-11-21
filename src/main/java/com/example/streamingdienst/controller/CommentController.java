package com.example.streamingdienst.controller;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.model.CommentDTO;
import com.example.streamingdienst.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;


    //GET

    //POST
    @PostMapping("/add")
    public String add(@RequestBody Comment comment){
        //comment.setFilm(new Film(filmService.FetchFilm(String.valueOf(comment.getFilm().getId())))) ;
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

}