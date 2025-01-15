package com.BookMyShow.BookMyShow.services;

import java.util.List;
import java.util.Optional;

import com.BookMyShow.BookMyShow.DTO.PaymentDTO;
import com.BookMyShow.BookMyShow.models.*;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.DTO.BookdetailsDTO;
import com.BookMyShow.BookMyShow.Mapper.BookingMapper;
import com.BookMyShow.BookMyShow.repositories.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {
	
	private final BookingRepository BookingRepository;
	private final ShowRepository ShowRepository;
	private final userRepository userRepository;
	private final ShowSeatsRepository ShowSeatsRepository;
	
	
	public BookingService(ShowSeatsRepository ShowSeatsRepository,BookingRepository BookingRepository,ShowRepository ShowRepository,userRepository userRepository)
	{
		this.BookingRepository=BookingRepository;
				this.ShowRepository=ShowRepository;
				this.userRepository=userRepository;
				this.ShowSeatsRepository=ShowSeatsRepository;
	}

	@Transactional(isolation=Isolation.SERIALIZABLE)
	public String BookTicket(BookdetailsDTO BookdetailsDTO) throws Exception {
		System.out.println("All started");
		Optional<User> optionalUser=userRepository.findById(BookdetailsDTO.getUserid());
		if (!optionalUser.isPresent()) {
			throw new Exception("User Not Found with ID:  to book ticket");
		}
		
		Optional<MovieShow> optionalshow=ShowRepository.findById(BookdetailsDTO.getShowId());
		if (!optionalshow.isPresent()) {
			throw new Exception("show Not Found with ID:  to book ticket");
		}
		System.out.println("came here123");
		List<ShowSeats> optionalshowseat=(ShowSeatsRepository.getseatswithid(BookdetailsDTO.getShowseats()));
		System.out.println("came here");
		if (  optionalshowseat.size()!=BookdetailsDTO.getShowseats().size()) {

			throw new Exception("Show Seats Are Not Available  to book ticket");
		}
		for (ShowSeats seat : optionalshowseat) {
			if (seat.getSeatStatus() != ShowSeatStatus.Empty || seat.getShow().getShowid()!=optionalshow.get().getShowid()) {
				throw new Exception("Seat are Not Viable to book try other seats");
			}
		}
		System.out.println("All clear");
		
		try {
			Booking Booking = BookingMapper.mapBookingDTO(optionalshow.get(), optionalshowseat, optionalUser.get());
			for (ShowSeats i : optionalshowseat) {
				i.setSeatStatus(ShowSeatStatus.InProgress);
				i.setBooking(Booking);}
			BookingRepository.save(Booking);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "Completed";
	}

	public void PaymentStatustickets(PaymentDTO PaymentDTO) {
		if(PaymentDTO.getBookingStatus()==BookingStatus.Booked){
			finaltickets(PaymentDTO.getBookingId());
		}
		else{ cleartickets(PaymentDTO.getBookingId());}
	}



	public void cleartickets(int bookingId) {
		Booking b=BookingRepository.findById(bookingId).orElseThrow();
		for(ShowSeats i:b.getSeats()){
			i.setSeatStatus(ShowSeatStatus.Empty);
			i.setBooking(null);
			ShowSeatsRepository.save(i);
		}
    }

	public void finaltickets(int bookingId) {
		Booking b=BookingRepository.findById(bookingId).orElseThrow();
		for(ShowSeats i:b.getSeats()){
			i.setSeatStatus(ShowSeatStatus.Booked);
			ShowSeatsRepository.save(i);
		}
		b.setBookingStatus(BookingStatus.Booked);
		BookingRepository.save(b);

	}
}
