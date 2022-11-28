package com.example.streamingdienst.repository;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query(value = "UPDATE `comment` SET `likes`=:like WHERE id = :id ",
            nativeQuery = true)
    void UpdateLike(@Param("id") int comment_id, @Param("like") int like_value);

    @Query(value = "SELECT * FROM `comment` WHERE film_id = :id",
    nativeQuery = true)
    Set<Comment> GetByFilm(@Param("id") int id);


}
