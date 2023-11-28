package com.mycompany.dvdstore.dvdcore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.dvdstore.dvdcore.entity.Movie;

public interface MovieRepositoryInterface extends CrudRepository<Movie, Long>{
//	public Movie create(Movie movie);
//	public List<Movie> list();
//	public Movie getById(long id);
}
