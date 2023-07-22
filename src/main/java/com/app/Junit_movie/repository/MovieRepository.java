package com.app.Junit_movie.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Junit_movie.model.Movies;

public interface MovieRepository extends JpaRepository<Movies,Long> {
    
}
