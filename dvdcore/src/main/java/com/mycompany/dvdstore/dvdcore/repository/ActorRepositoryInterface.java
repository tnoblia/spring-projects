package com.mycompany.dvdstore.dvdcore.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.dvdstore.dvdcore.entity.Actor;
import com.mycompany.dvdstore.dvdcore.entity.Movie;

public interface ActorRepositoryInterface extends CrudRepository<Actor, Long>{
}
