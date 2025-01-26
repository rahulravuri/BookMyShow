package com.BookMyShow.BookMyShow.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.BookMyShow.BookMyShow.DTO.NewShowDTO;
import com.BookMyShow.BookMyShow.DTO.TheatreShowDTO;
import com.BookMyShow.BookMyShow.models.Movie;
import com.BookMyShow.BookMyShow.models.TheatreShowHandler;
import com.BookMyShow.BookMyShow.models.TheatreShowStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.BookMyShow.BookMyShow.DTO.showDTO;
import com.BookMyShow.BookMyShow.Mapper.MovieMapper;
import com.BookMyShow.BookMyShow.Mapper.showMapper;
import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.repositories.ShowRepository;
import com.BookMyShow.BookMyShow.repositories.TheatreShowHRepository;

import static java.util.stream.Collectors.groupingBy;

@Service
public class ShowService {
	private ShowRepository ShowRepository;

	private TheatreShowHRepository TheatreShowHRepository;
	private static final ObjectMapper objectMapper = (new ObjectMapper()).registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


	public  ShowService(ShowRepository ShowRepository,TheatreShowHRepository TheatreShowHRepository) {
		this.TheatreShowHRepository=TheatreShowHRepository;
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

	public int createshows(NewShowDTO NewShowDTO){
		List<TheatreShowDTO> data=NewShowDTO.getNewShows();
		JsonNode showsData = objectMapper.valueToTree(data);
		TheatreShowHandler show=new TheatreShowHandler();
		show.setMovieid(NewShowDTO.getMovieId());
		show.setTheatreId(NewShowDTO.getMovieId());
		show.setInformation("Record Created");
		show.setShowsData(showsData);
		show.setCreationTime(LocalDateTime.now());
		show.setTheatreShowStatus(TheatreShowStatus.Pending);
		TheatreShowHRepository.save(show);
		TheatreShowHRepository.Create_Shows(show.getId());
		return show.getId();

	}

	public void CancelShow(int showId) throws Exception {
		if(!ShowRepository.existsById(showId)) {
			throw new EntityNotFoundException("Show not found with id: " + showId);
		}
		ShowRepository.deleteById(showId);

	}
}
