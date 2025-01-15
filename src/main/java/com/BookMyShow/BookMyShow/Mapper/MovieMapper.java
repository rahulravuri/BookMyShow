package com.BookMyShow.BookMyShow.Mapper;

import com.BookMyShow.BookMyShow.DTO.MovieDTO;
import com.BookMyShow.BookMyShow.models.Movie;

public class MovieMapper {
	
	public static MovieDTO getMovieDTO(Movie Movie) {
		
		MovieDTO out= MovieDTO.builder().actor(Movie.getActor())
				.movieid(Movie.getMovieid()).name(Movie.getName())
				.build();
		return out;
	}

}
