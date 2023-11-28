package com.mycompany.dvdstore.dvdweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.dvdstore.dvdcore.entity.Movie;
import com.mycompany.dvdstore.dvdcore.service.MovieServiceInterface;
import com.mycompany.dvdstore.dvdweb.form.MovieForm;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	public MovieController(@Autowired  MovieServiceInterface movieService) {
		this.movieService =movieService;
	}

	private final MovieServiceInterface movieService;
	
	public MovieServiceInterface getMovieService() {
		return movieService;
	}

	@GetMapping("/about-us")
	public String displayAboutUs() {
		return "about-us";
		
	}
	
//	@RequestMapping("/")
//	public @ModelAttribute("movies") List<Movie> displayHome(Model model) {
//		List<Movie> movies = this.movieService.getMovies();
//		return movies;
//		
//	}
	
	@GetMapping("/home")
	public ModelAndView displayHome() {
	    //List<Movie> movies = this.movieService.getMovies();
	    ModelAndView modelAndView = new ModelAndView("index");
	    //modelAndView.addObject("movies", movies);
	    return modelAndView;
	}
	/*
	@GetMapping("/{movieIdString}")
	public ModelAndView displayMovieCard(@RequestParam String movieIdString) {
		ModelAndView mv = new ModelAndView("movie-details");
		long movieIdLong = Long.parseLong(movieIdString);
		mv.addObject("movie", movieService.getMoviebyId(movieIdLong));
		return mv;
	}
	*/
	@GetMapping("/movie-create")
	public ModelAndView displayCreateMovieForm(@ModelAttribute Movie movie) {
		ModelAndView mv = new ModelAndView("movie-create-form");
		mv.addObject("movieForm",new MovieForm());
		return mv;
	}
	
	
	@PostMapping("/add")
	public ModelAndView addMovie(@Valid @ModelAttribute("movieForm") MovieForm movieForm, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Movie movie = new Movie();
		if(result.hasErrors()) {
			mv.setViewName("movie-create-form");
			mv.addObject("movieForm", movieForm);
			return mv;
		}
		mv.setViewName("movie-created");
		movie.setDescription(movieForm.getDescription());
		movie.setGenre(movieForm.getGenre());
		movie.setTitle(movieForm.getTitle());
		movieService.registerMovie(movie);
		return mv;
	}

}
