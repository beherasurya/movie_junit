package com.app.Junit_movie.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.app.Junit_movie.model.Movies;

@DataJpaTest
public class MovieRepositoryTest {
    
    @Autowired
    MovieRepository movieRepository;

    @Test
    @DisplayName("It should save the movie details in database")
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

    @Test
    @DisplayName("Movies list with size")
    void getAllMovies(){

         Movies avatarMovie= new Movies();
        avatarMovie.setName("Avatar");
        avatarMovie.setGenera("Action");
        avatarMovie.setReleaseDate(LocalDate.of(2003, Month.JANUARY, 29));

        //Act
        movieRepository.save(avatarMovie);
        //Assert

         Movies titanicMovie= new Movies();
        titanicMovie.setName("Titanic");
        titanicMovie.setGenera("Romance");
        titanicMovie.setReleaseDate(LocalDate.of(1999, Month.AUGUST, 31));

        //Act
        movieRepository.save(titanicMovie);
        //Assert


        List<Movies> movieList= movieRepository.findAll();
        assertNotNull(movieList);
        assertEquals(2, movieList.size());
       
    }

    @Test
    @DisplayName("Display Movie by ID")
    void getMovieById(){

        Movies titanicMovie= new Movies();
        titanicMovie.setName("Titanic");

        titanicMovie.setGenera("Romance");
        titanicMovie.setReleaseDate(LocalDate.of(1999, Month.AUGUST, 31));

        movieRepository.save(titanicMovie);
        Movies existingMovie = movieRepository.findById(titanicMovie.getId()).get();

        assertNotNull(existingMovie, "It should not be NULL");
        assertEquals("Romance", existingMovie.getGenera(), "It will check Genera is same or not");



    }
}
