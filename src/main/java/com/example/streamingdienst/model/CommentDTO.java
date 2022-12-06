package com.example.streamingdienst.model;

import lombok.*;

import java.io.Serializable;
import java.util.Optional;
import javax.persistence.*;

/**
 * A DTO for the {@link Comment} entity
 */
@Data
@AllArgsConstructor
@Getter
@Setter
public class CommentDTO implements Serializable {
    @Column(name = "id")
    private final int id;
    @Column(name = "text")
    private final String text;
    @Column(name = "likes")
    private final int likes;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "film_id")
    private final int filmId;

    public CommentDTO(Optional<CommentDTO>  commentDto) {
        this.id = commentDto.get().id;
        this.text = commentDto.get().text;
        this.likes = commentDto.get().likes;
        this.filmId = commentDto.get().filmId;
    }

}