package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.model.Genre;
import com.example.streamingdienst.repository.GenreRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepo genreRepo;

    @Override
    public Optional<Genre> FetchGenre(String id){return genreRepo.findById(Integer.parseInt(id));}

    @Override
    public List<Genre> GetAllGenres(){return genreRepo.findAll();}


}
