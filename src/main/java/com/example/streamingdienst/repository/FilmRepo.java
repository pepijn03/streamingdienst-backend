package com.example.streamingdienst.repository;

import com.example.streamingdienst.model.Film;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Statement;
import java.util.List;

@Transactional
@Repository
public interface FilmRepo extends JpaRepository<Film,Integer> {

    @Query(value = "SELECT * FROM `film` WHERE name LIKE :query",
            nativeQuery = true)
    List<Film> FindFilms(@Param("query") String query);

    @Query(value = "SELECT * FROM `film` INNER JOIN film_genres ON film.id = film_genres.film_id WHERE film_genres.genre_id = :id",
            nativeQuery = true)
    List<Film> FindFilmByGenre(@Param("id") String id);

    @Modifying
    @Query(value = "DELETE FROM `film_genres` WHERE `film_id` = :id " ,
    nativeQuery = true)
    void DeleteGenreRefs(@Param("id") String id);

    @Modifying
    @Query(value = "DELETE FROM `comment` WHERE `film_id` = :id ",
    nativeQuery = true)
    void DeleteCommentsOnFilm(@Param("id") String id);





}