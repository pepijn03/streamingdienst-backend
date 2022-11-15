package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> FetchGenre(String id);
    List<Genre> GetAllGenres();

}
