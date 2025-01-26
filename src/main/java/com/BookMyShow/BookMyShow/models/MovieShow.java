package com.BookMyShow.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.*;
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
	private LocalDateTime showendTime;
	@OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
	private List<ShowSeats> seats;

}
