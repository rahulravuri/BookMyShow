package com.BookMyShow.BookMyShow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BookMyShow.BookMyShow.DTO.MovieDTO;
import com.BookMyShow.BookMyShow.DTO.regionsDTO;
import com.BookMyShow.BookMyShow.DTO.showDTO;
import com.BookMyShow.BookMyShow.DTO.theatreDTO;
import com.BookMyShow.BookMyShow.models.Movie;
import com.BookMyShow.BookMyShow.models.MovieShow;
import com.BookMyShow.BookMyShow.models.Region;
import com.BookMyShow.BookMyShow.repositories.RegionRepository;
import com.BookMyShow.BookMyShow.services.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Objects;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/view")
public class UserController {

	private final RegionService RegionService;
	private final TheatreService TheatreService;
	private final ShowService ShowService;
	private final MovieService MovieService;
	private final User_View_Service User_View_Service;

	@Autowired
	public UserController(RegionService RegionService,
			TheatreService TheatreService, ShowService ShowService,
			MovieService MovieService, User_View_Service User_View_Service) {
		this.RegionService = RegionService;
		this.TheatreService = TheatreService;
		this.ShowService = ShowService;
		this.MovieService = MovieService;
		this.User_View_Service = User_View_Service;
	}

	@GetMapping("/")
	public String BasePage() {
		return "Welcome to BookMyshow";
	}


	@GetMapping("/regions")
	public ResponseEntity<Map<String, Object>> getAllregions() {
		Map<String, Object> re = new HashMap<>();
		regionsDTO data = RegionService.getRegions();
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}

	@GetMapping("/movies")
	public ResponseEntity<Map<String, Object>> getAllMovies() {
		Map<String, Object> re = new HashMap<>();
		List<MovieDTO> data = MovieService.getAllMovies();
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}

	@GetMapping("/shows/movie/{id}")
	public ResponseEntity<Map<String, Object>> getAllMovieshows(
			@PathVariable("id") int id) {
		Map<String, Object> re = new HashMap<>();
		Object data = ShowService.getallshows(id);
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}

	@GetMapping("/shows/movie1/{id}")
	public ResponseEntity<Map<String, Object>> getAllMovieshowstest(
			@PathVariable("id") int id) {
		Map<String, Object> re = new HashMap<>();
		Object data = ShowService.getallshows(id);
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}

	@GetMapping("/shows/theatre/{id}")
	public ResponseEntity<Map<String, Object>> getAlltheatreshows(
			@PathVariable("id") int id) {
		Map<String, Object> re = new HashMap<>();
		Object data = ShowService.getalltheatreshows(id);
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}
	
	@GetMapping("/region/theatre/{regionid}")
	public ResponseEntity<Map<String, Object>> gettheatreshows(
			@PathVariable("regionid") int regionid) {
		Map<String, Object> re = new HashMap<>();
		List<Object[]> data = TheatreService.getalltheatresbyregion(regionid);
		re.put("Movies List", data);
		return ResponseEntity.status(HttpStatus.OK).body(re);

	}

}
