package com.example.streamingdienst;

import com.example.streamingdienst.model.Film;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.streamingdienst.repository.FilmRepo;
import com.example.streamingdienst.service.FilmService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmServiceImplTest {

    @Autowired
    private FilmService filmService;

    @MockBean
    private FilmRepo filmRepo;

    @Test
    void createFilm() {
        Film film = new Film(){

        };


    }

    @Test
    void exceptionCreateUser() {

    }

    @Test
    void findUserByID() {

    }

    @Test
    void findUserByIDDoesNotExistException() {

    }
}
