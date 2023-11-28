package com.mycompany.dvdstore.dvdcore.service;

import java.util.List;

import com.mycompany.dvdstore.dvdcore.entity.Movie;
import com.mycompany.dvdstore.dvdcore.repository.MovieRepositoryInterface;

public interface MovieServiceInterface {
	
	public Movie registerMovie(Movie movie);
	public MovieRepositoryInterface getMovieRepository();
	
	public Iterable<Movie> getMovies();
	public Movie getMoviebyId(long movieIdLong);
}


