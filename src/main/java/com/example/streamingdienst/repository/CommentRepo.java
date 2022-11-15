package com.example.streamingdienst.repository;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query(value = "UPDATE `comment` SET `likes`=`likes` + :like WHERE id = :id; ",
            nativeQuery = true)
    void UpdateLike(@Param("id") int comment_id, @Param("like") int like_value);
}
