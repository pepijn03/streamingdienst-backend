package com.example.streamingdienst.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Comment> comments;

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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Date getReleaseDate() {return releaseDate;}
    public void setReleaseDate(Date releaseDate) {this.releaseDate = releaseDate;}

    public int getAgeRestriction() {return ageRestriction;}
    public void setAgeRestriction(int ageRestriction) {this.ageRestriction = ageRestriction;}

    public Set<Genre> getGenres() {
        return genres;
    }
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Comment> getComments() {return comments;}
    public void setComments(Set<Comment> comments) {this.comments = comments;}
}
