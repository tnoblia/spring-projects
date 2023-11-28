package com.mycompany.dvdstore.dvdcore.service.defaults;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dvdstore.dvdcore.entity.Movie;
import com.mycompany.dvdstore.dvdcore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.dvdcore.service.MovieServiceInterface;

@Service
public class DefaultMovieService implements MovieServiceInterface{
	
	public DefaultMovieService(@Autowired MovieRepositoryInterface movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	private final MovieRepositoryInterface movieRepository;
	
	public MovieRepositoryInterface getMovieRepository() {
		return movieRepository;
	}


	public Movie registerMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Iterable<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMoviebyId(long movieId) {
		return movieRepository.findById(movieId).orElseThrow();
	}

}
