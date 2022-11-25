package com.example.streamingdienst.service;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.model.Genre;
import com.example.streamingdienst.repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepo filmRepo;

    @Override
    public void SaveFilm(Film film) {
        filmRepo.save(film);
    }

    @Override
    public List<Film> GetAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public List<Film> GetFilmsByGenre(Optional<Genre> genre) {

        return filmRepo.FindFilmByGenre(String.valueOf(genre.get().getId()));
    }

    @Override
    public Optional<Film> FetchFilm(String id){return filmRepo.findById(Integer.parseInt(id));}

    @Override
    public  List<Film> FindFilms(String query){return filmRepo.FindFilms("%" + query + "%");}

    @Override
    public void DeleteFilm(int filmid){filmRepo.deleteById(filmid);}

    @Override
    public void DeleteGenreRefs(int id) {filmRepo.DeleteGenreRefs(String.valueOf(id));}

}
