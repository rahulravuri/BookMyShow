package com.BookMyShow.BookMyShow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.Movie;


@Repository
public interface Movierepository extends JpaRepository<Movie, Integer>  {
	
	

}
