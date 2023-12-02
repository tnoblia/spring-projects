package com.mycompany.dvdstore.dvdcore.service.defaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dvdstore.dvdcore.entity.Movie;
import com.mycompany.dvdstore.dvdcore.repository.ActorRepositoryInterface;
import com.mycompany.dvdstore.dvdcore.repository.MovieRepositoryInterface;
import com.mycompany.dvdstore.dvdcore.service.MovieServiceInterface;

@Service
public class DefaultMovieService implements MovieServiceInterface{
	
	private final MovieRepositoryInterface movieRepository;
	private final ActorRepositoryInterface ActorRepository;
	
	public DefaultMovieService(@Autowired MovieRepositoryInterface movieRepository,
			@Autowired ActorRepositoryInterface ActorRepository) {
		this.movieRepository = movieRepository;
		this.ActorRepository = ActorRepository;
	}
	

	
	public MovieRepositoryInterface getMovieRepository() {
		return movieRepository;
	}


	 @Transactional
	public Movie registerMovie(Movie movie) {
		ActorRepository.save(movie.getMainActor());
		return movieRepository.save(movie);
	}
	
	public Iterable<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	//Ici ça aurait du retourner un optional
	public Movie getMoviebyId(long movieId) {
		Movie movie = movieRepository.findById(movieId);
		 movie.getReviews().forEach(review ->
	        review.setMovie(null)
	    );
//		movie.getMainActor().getLastName();
//		movie.getReviews().forEach(review -> {
//		review.getReviewComment();
//		review.setMovie(null);
//		});
		return movie;
		
	}

}
