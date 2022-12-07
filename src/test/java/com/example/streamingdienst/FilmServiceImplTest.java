package com.example.streamingdienst;

import com.example.streamingdienst.model.Film;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.streamingdienst.repository.FilmRepo;
import com.example.streamingdienst.service.FilmService;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamingdienstBackend2Application.class)
@TestPropertySource("classpath:test.properties")
class FilmServiceImplTest {

    @Autowired
    private FilmService filmService;

    @MockBean
    private FilmRepo filmRepo;

    @Test
    void createFilm()   {
        //ARRANGE
        Film film = new Film();
        film.setId(1);
        film.setName("test");
        film.setDescription("test");
        film.setLength(100);
        film.setAgeRestriction(12);
        film.setReleaseDate(new Date());


        //ACT
        filmService.SaveFilm(film);
        List<Film> films = filmService.GetAllFilms();
        Film filmgot = new Film();
        if (films.size() > 0){
            filmgot = films.get(films.size());
        }



        //ASSERT
        //assertNotNull(filmgot);
        //assertEquals(filmgot.getName(), film.getName());
    }

    @Test
    void GetFilmByID()  {
        //ARRANGE
        Film film = new Film();
        film.setId(1);
        film.setName("test");
        film.setDescription("test");
        film.setLength(100);
        film.setAgeRestriction(12);
        film.setReleaseDate(new Date());


        //ACT
        filmService.SaveFilm(film);

        //ASSERT
        //assertEquals("test", filmService.FetchFilm("1").get().getName());

    }


}
