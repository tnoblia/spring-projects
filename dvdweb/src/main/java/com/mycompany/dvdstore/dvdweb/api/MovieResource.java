package com.mycompany.dvdstore.dvdweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.dvdstore.dvdcore.entity.Movie;
import com.mycompany.dvdstore.dvdcore.service.MovieServiceInterface;

@RestController
@RequestMapping("/movie")
public class MovieResource {
	
	public MovieResource(@Autowired  MovieServiceInterface movieService) {
		this.movieService =movieService;
	}

	private final MovieServiceInterface movieService;
	
	public MovieServiceInterface getMovieService() {
		return movieService;
	}
	
	@GetMapping("")
	public Iterable<Movie> list() {
		return this.movieService.getMovies();
	}
	
	@GetMapping("/{movieIdString}")
	public Movie get(@PathVariable  String movieIdString) {
		long movieIdLong = Long.parseLong(movieIdString);
		return movieService.getMoviebyId(movieIdLong);
	}
	
	@PostMapping("")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.registerMovie(movie);
	}

}
