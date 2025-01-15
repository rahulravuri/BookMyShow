package com.BookMyShow.BookMyShow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TheatreScreen  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ScreenId;

	@ManyToOne
	@JoinColumn(name="theatreID")
	private Theatre Theatre;
	@OneToMany(mappedBy = "screenShows")
	private List<MovieShow> movieShows;
	
	private int screenNumber;
	
	@Enumerated(EnumType.STRING) 
	private screenType screenType;
	
	

	

}
