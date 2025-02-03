package com.BookMyShow.BookMyShow.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.BookMyShow.BookMyShow.models.ShowSeatStatus;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
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


	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT s FROM ShowSeats s JOIN FETCH s.booking b WHERE s.booking IS NOT NULL AND s.SeatStatus = :status  AND b.bookingTime < :time")
	List<ShowSeats> findExpiredBlockedSeats(@Param("time") LocalDateTime time, @Param("status") ShowSeatStatus status);


}
