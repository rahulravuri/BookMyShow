package com.BookMyShow.BookMyShow.DTO;

import java.util.List;

import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.models.ShowSeats;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookdetailsDTO {
	private int showId;
	private List<Integer> showseats;
	private int userid;

}
