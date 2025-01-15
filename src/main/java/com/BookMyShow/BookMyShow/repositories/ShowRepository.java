package com.BookMyShow.BookMyShow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.MovieShow;

@Repository
public interface ShowRepository extends JpaRepository<MovieShow, Integer> {
	
	List<MovieShow> findAll();
	
	//@Query(value = "SELECT s.* FROM movie_show s  WHERE s.movieid = :movieid", nativeQuery = true)
	//List<MovieShow> findShowsByMovieTitle(@Param("movieid") int movieid);
	
	@Query(value = "SELECT s.* FROM movie_show s join theatre_screen ts on(ts.screen_id=s.screen_id) WHERE ts.theatreid = :theatreid", nativeQuery = true)
	List<MovieShow> findShowsBytheatre(@Param("theatreid") int theatreid);
	
	@Query(value = "SELECT s FROM MovieShow s JOIN FETCH s.screenShows JOIN FETCH s.movie JOIN FETCH s.screenShows.Theatre    WHERE s.movie.id = :movieid")
	List<MovieShow> findShowsByMovieTitle(@Param("movieid") int movieid);
	
	@Query(value = "SELECT s FROM MovieShow s JOIN FETCH s.screenShows JOIN FETCH s.movie JOIN FETCH s.screenShows.Theatre    WHERE s.id = :showid")
	List<MovieShow> findShowsByshowid(@Param("showid") int showid);
	
//JOIN FETCH s.screenShows JOIN FETCH s.screenShows.Theatre  
}
