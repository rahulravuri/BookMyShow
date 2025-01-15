package com.BookMyShow.BookMyShow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	private String Name;
	
	@OneToMany(mappedBy="user")
	private List<Booking> userBookings;
	
	private long phone_number;
	
	private String Email_id; 
	

}
