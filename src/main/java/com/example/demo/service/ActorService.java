package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Actor;
import com.example.demo.entities.FilmActor;

public interface ActorService {

	List<Actor> getAllActors(Integer page, Integer limit);
	List<FilmActor> getAllFilmActors();
}
