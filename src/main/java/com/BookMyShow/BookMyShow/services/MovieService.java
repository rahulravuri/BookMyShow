package com.BookMyShow.BookMyShow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.repositories.Movierepository;
import com.BookMyShow.BookMyShow.DTO.MovieDTO;
import com.BookMyShow.BookMyShow.Mapper.MovieMapper;
import com.BookMyShow.BookMyShow.models.Movie;


@Service
public class MovieService {
	
	
	private final Movierepository Movierepository;
	
	@Autowired
    public MovieService(Movierepository Movierepository) {
        this.Movierepository = Movierepository;
    }
	
	public List<MovieDTO> getAllMovies(){
		
		List<Movie> MovieList= Movierepository.findAll();
		
		return MovieList.stream()
        .map(movie -> MovieMapper.getMovieDTO(movie))
        .collect(Collectors.toList());
		
	}
	
	
	

}
