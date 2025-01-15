package com.BookMyShow.BookMyShow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Getter
@Setter
@Entity
public class ShowSeats {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showSeatId;

	@Enumerated(EnumType.STRING)
	private SeatType seattype;

	@Enumerated(EnumType.STRING)
	private ShowSeatStatus SeatStatus;
	
	@ManyToOne
	@JoinColumn(name="showid", nullable = false)
	private MovieShow show;
	
	@ManyToOne
	@JoinColumn(name="bookingID")
	private Booking booking;

	private int seatrow;

	private int seatcol;

	@Version
	private Long version;
	

}
