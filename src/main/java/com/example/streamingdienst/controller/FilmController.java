package com.example.streamingdienst.controller;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.model.Genre;
import com.example.streamingdienst.service.FilmService;
import com.example.streamingdienst.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/films")
@CrossOrigin
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private GenreService genreService;

    @GetMapping("/")
    public List<Film> getAllFilms(){

        return filmService.GetAllFilms();
    }

    @GetMapping("/{id}")
    public Optional<Film> GetFilm(@PathVariable String id){
        return filmService.FetchFilm(id);
    }

    @GetMapping("/find/{query}")
    public List<Film> FindFilm(@PathVariable String query) {return filmService.FindFilms(query);}

    @PostMapping("/add")
    public String add(@RequestBody Film film){
        filmService.SaveFilm(film);
        return "new film is added";
    }

    @GetMapping("/genres/{id}")
    public List<Film> FindFilmsByGenre(@PathVariable String id) {
        return filmService.GetFilmsByGenre(genreService.FetchGenre(id));
    };

    @GetMapping("/genres")
    public  List<Genre> GetAllFilms(){
        return genreService.GetAllGenres();
    }
}
