package com.BookMyShow.BookMyShow.models;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	@OneToOne
	@JoinColumn(name="bookingID")
	private Booking booking ;
	private int price;
	
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private LocalDateTime paymenttime;

}
