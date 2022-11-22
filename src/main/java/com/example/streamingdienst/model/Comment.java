package com.example.streamingdienst.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Film.class)
    @JsonBackReference(value="film-comments")
    @JoinColumn(name = "film_id")
    public Film film;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JsonBackReference(value="user-comments")
    @JoinColumn(name = "user_id")
    private User user;

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
