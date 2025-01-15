package com.BookMyShow.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int bookingID;

		@OneToOne
		@JoinColumn(name="paymentId")
		private Payment payment;

		@ManyToOne
		@JoinColumn(name="showid")
		private MovieShow show;

		@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
		private List<ShowSeats> seats;

		@Enumerated(EnumType.STRING)
		private BookingStatus BookingStatus;

		private LocalDateTime bookingTime;

		@ManyToOne
		@JoinColumn(name="user_id")
		private User user;
	

}
