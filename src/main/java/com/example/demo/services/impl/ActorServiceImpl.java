package com.example.demo.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Actor;
import com.example.demo.entities.FilmActor;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.repositories.FilmActorRepository;
import com.example.demo.repositories.GenericDAOWithJPA;
import com.example.demo.service.ActorService;

@Service
public class ActorServiceImpl extends GenericDAOWithJPA<Actor, Integer > implements ActorService {
	
  @Autowired
  private ActorRepository actorRepository;
  @Autowired
  private FilmActorRepository filmActorRepository;
  
	
	
  public List<Actor> getAllActors(Integer page, Integer limit) {	  
	  
	  Pageable pagingRequest = (Pageable) PageRequest.of(page,limit);
	  Page<Actor> pagedResult = actorRepository.findAll(pagingRequest);
	  
	  return pagedResult.getContent();
  }
  
  public List<Actor> getAllActorsFromGeneric() {	  
	  
	List<Actor> actors = super.findAll();
	  
	  return actors;
  }
  
  


public List<FilmActor> getAllFilmActors() {
	  
	  List<FilmActor> filmActors = filmActorRepository.findAll();
	  
	  return filmActors;
  }
  
  
	
}
