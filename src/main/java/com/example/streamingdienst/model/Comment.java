package com.example.streamingdienst.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Film.class, cascade=CascadeType.ALL)
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

}
