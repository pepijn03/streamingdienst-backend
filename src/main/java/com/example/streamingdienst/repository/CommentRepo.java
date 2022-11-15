package com.example.streamingdienst.repository;

import com.example.streamingdienst.model.Comment;
import com.example.streamingdienst.model.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE `comment` SET `likes`=:like WHERE id = :id ",
            nativeQuery = true)
    void UpdateLike(@Param("id") int comment_id, @Param("like") int like_value);
}
