package com.example.streamingdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.Optional;

@Entity
@JsonIgnoreProperties(value = "film")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Film.class)
    @JoinColumn(name = "film_id")
    private Film film;

    public Comment() {
    }

    public Comment(Optional<Comment> comment) {
        this.id = comment.get().id;
        this.text = comment.get().text;
        this.likes = comment.get().likes;
        this.film = comment.get().film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
