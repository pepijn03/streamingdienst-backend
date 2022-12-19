package com.example.streamingdienst.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int length;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date releaseDate;
    private int ageRestriction;


    @OneToMany(mappedBy="film")
    @JsonManagedReference(value="film-comments")
    public Set<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;


    public Film(Optional<Film> film) {
        this.id = film.get().getId();
        this.name = film.get().getName();
        this.description = film.get().getDescription();
        this.length = film.get().getLength();
        this.ageRestriction = film.get().getAgeRestriction();
        this.releaseDate = film.get().getReleaseDate();
        this.comments = film.get().getComments();
        this.genres = film.get().getGenres();

    }
}
