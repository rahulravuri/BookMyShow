package com.BookMyShow.BookMyShow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.models.ShowSeats;

@Repository
public interface ShowSeatsRepository  extends JpaRepository<ShowSeats, Integer> {


	@Query(value = "select s from ShowSeats s  JOIN Fetch s.show ss where s.booking is null and s.showSeatId in :seatlist")
	List<ShowSeats> getseatswithid(@Param("seatlist") List<Integer> seatlist);

	List<ShowSeats> findByshow(MovieShow show);
	

}
