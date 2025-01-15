package com.BookMyShow.BookMyShow.Mapper;

import java.time.LocalDateTime;
import java.util.List;

import com.BookMyShow.BookMyShow.DTO.BookdetailsDTO;
import com.BookMyShow.BookMyShow.models.*;

public class BookingMapper {
	
		public static Booking mapBookingDTO(MovieShow MovieShow,List<ShowSeats> ShowSeats,User User) {
		Booking out= Booking.builder()
					.show(MovieShow)
					.seats(ShowSeats)
					.user(User)
				.BookingStatus(BookingStatus.Inprogress)
					.bookingTime(LocalDateTime.now())
					.build();
		
		return out;
		
	}

}
