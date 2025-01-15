package com.BookMyShow.BookMyShow.services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.BookMyShow.BookMyShow.models.Movie;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.DTO.showDTO;
import com.BookMyShow.BookMyShow.Mapper.MovieMapper;
import com.BookMyShow.BookMyShow.Mapper.showMapper;
import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.repositories.ShowRepository;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ShowService {
	private ShowRepository ShowRepository;
	
	public  ShowService(ShowRepository ShowRepository) {
		this.ShowRepository=ShowRepository;
	}

	
	public Object getalltheatreshows(int theatre_id){
		List<MovieShow> data= ShowRepository.findShowsBytheatre(theatre_id);


		return data.stream().sorted(Comparator.comparing((MovieShow movieShow) -> movieShow.getScreenShows().getScreenType())
						.thenComparing(movieShow -> movieShow.getShowTime()))
				.collect(Collectors.groupingBy(
						movieShow -> movieShow.getScreenShows().getTheatre().getTheatreName(),
						Collectors.groupingBy(
								movieShow -> movieShow.getShowTime().format(DateTimeFormatter.ofPattern("ddMMyyyy")),
								Collectors.groupingBy(movieShow -> movieShow.getMovie().getName(),
								Collectors.mapping(
										movieShow -> showMapper.getshowDTO(movieShow),
										Collectors.toList()
								))
						)
				));
	}

	public Object getallshows(int id) {
		List<MovieShow> data= ShowRepository.findShowsByMovieTitle(id);

		return data.stream().collect( groupingBy(movieShow -> movieShow.getMovie().getName(),Collectors.groupingBy(movieShow -> movieShow.getShowTime().format(DateTimeFormatter.ofPattern("ddMMyyyy")),Collectors.groupingBy(movieShow -> movieShow.getScreenShows().getTheatre().getTheatreName(),Collectors.mapping(movieShow ->showMapper.getshowDTO(movieShow),Collectors.toList())))));

		//return null;
	}
}
