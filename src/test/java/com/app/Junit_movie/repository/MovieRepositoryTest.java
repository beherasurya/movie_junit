package com.app.Junit_movie.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.Junit_movie.model.Movies;

@DataJpaTest
public class MovieRepositoryTest {
    
    @Autowired
    MovieRepository movieRepository;

    @Test
    void save(){

        //Arrange
        Movies avatarMovie= new Movies();
        avatarMovie.setName("Avatar");
        avatarMovie.setGenera("Action");
        avatarMovie.setReleaseDate(LocalDate.of(2003, Month.JANUARY, 29));

        //Act
        Movies newMovie=movieRepository.save(avatarMovie);
        //Assert
        assertNotNull(newMovie);
        
        assertNotNull(newMovie.getId());

    }
}
