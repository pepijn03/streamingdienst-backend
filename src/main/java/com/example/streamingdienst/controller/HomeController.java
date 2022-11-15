package com.example.streamingdienst.controller;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/")
    public List<Film> getAllFilms(){

        return filmService.GetAllFilms();
    }
}