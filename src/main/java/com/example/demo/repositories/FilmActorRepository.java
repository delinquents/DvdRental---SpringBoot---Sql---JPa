package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.FilmActor;
import com.example.demo.entities.composedkey.FilmActorId;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {
	
//	
//	public List<FilmActor>  findByFilm_Id(Integer id);
//	public List<FilmActor>  findByActor_Id(Integer id);
}
