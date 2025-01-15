package com.BookMyShow.BookMyShow.Mapper;

import com.BookMyShow.BookMyShow.DTO.showDTO;
import com.BookMyShow.BookMyShow.models.MovieShow;

import java.time.format.DateTimeFormatter;

public class showMapper {
	
public static showDTO getshowDTO(MovieShow MovieShow) {
		
	showDTO out= showDTO.builder()
				.MovieName(MovieShow.getMovie().getName())
				.showid(MovieShow.getShowid())
				.showTime(MovieShow.getShowTime())
				.TheatreName(MovieShow.getScreenShows().getTheatre().getTheatreName())
				.screentype(MovieShow.getScreenShows().getScreenType())
				.time(MovieShow.getShowTime().format(DateTimeFormatter.ofPattern("HH:mm")))
				.build();
		return out;
	}

}
