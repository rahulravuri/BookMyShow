package com.BookMyShow.BookMyShow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.Booking;
import com.BookMyShow.BookMyShow.models.Movie;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Integer> {
	

}
