package com.BookMyShow.BookMyShow.models;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieid;
	private String name;
	private String actor;
	@OneToMany(mappedBy = "movie")
	private List<MovieShow> shows;

}
