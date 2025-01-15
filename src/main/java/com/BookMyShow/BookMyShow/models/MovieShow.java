package com.BookMyShow.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Entity;
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
public class MovieShow {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showid;
	
	@ManyToOne
	@JoinColumn(name="ScreenId")
	private TheatreScreen screenShows; 
	@ManyToOne
	@JoinColumn(name="movieid")
	private Movie movie;
	
	private LocalDateTime showTime;

	private Integer showdate;
	@OneToMany(mappedBy = "show")
	private List<ShowSeats> seats;

}
