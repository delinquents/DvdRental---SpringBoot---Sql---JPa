package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Film;
import com.example.demo.entities.FilmCategory;

public interface FilmService {

	
	List<Film> getAllFilms();
	Film getFilmById(Integer id);
	List<FilmCategory> getListOfFilmCategories();
	
}
