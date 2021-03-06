package com.example.demo.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Film;
import com.example.demo.entities.FilmCategory;

import com.example.demo.repositories.FilmCategoryRepository;
import com.example.demo.repositories.FilmRepository;
import com.example.demo.service.FilmService;




@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmCategoryRepository filmcatRepository;
	
//	@Autowired
//	private LanguageRepository languageRepository;

	
	public List<Film> getAllFilms() {

		List<Film> films = this.filmRepository.findAll();
		System.out.println(films);
		
		return films;
	}
	
	
	
	public Film getFilmById(Integer id) {		

		System.out.println("Called filmBy Id " + id);
		Film film = filmRepository.findById(id).get();
		
		return film;
	}
	
	
	
	public List<FilmCategory> getListOfFilmCategories() {
				
		List<FilmCategory> filmCats = filmcatRepository.findAll();
		
		return  filmCats;
				
				
	}
	
	
	
}
