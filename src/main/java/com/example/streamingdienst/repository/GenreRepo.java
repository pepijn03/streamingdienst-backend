package com.example.streamingdienst.repository;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Integer> {


}
