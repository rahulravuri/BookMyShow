package com.BookMyShow.BookMyShow.repositories;

import com.BookMyShow.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.BookMyShow.BookMyShow.models.Booking;
import com.BookMyShow.BookMyShow.models.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Integer> {


    @Query("Select b from Booking b JOIN FETCH b.user u where u.Email_id= :email")
    Optional<List<Booking>> findByEmailId(@Param("email") String email);
}
