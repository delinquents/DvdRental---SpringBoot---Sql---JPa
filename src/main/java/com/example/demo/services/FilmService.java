package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Film;
import com.example.demo.entities.FilmCategory;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.FilmCategoryRepository;
import com.example.demo.repositories.FilmRepository;



@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private FilmCategoryRepository filmcatRepository;
	

	
	public List<Film> getAllFilms() {

		List<Film> films = this.filmRepository.findAll();
		System.out.println(films);
		
		return films;
	}
	
	
	
	public String getFilmById(Integer id) {
		
//		Film film  = filmRepository.findById(id).get();
//		
//		System.out.println(film.getFulltext());
//		S
		System.out.println("Called filmBy Id " + id);
//		Object obj = filmRepository.findById(id).get();
		
		System.out.println(filmRepository.findById(1).get().toString());
		System.out.println("");
		
		return "film";
	}
	
	
	
	public List<FilmCategory> getListOfFilmCategories() {
				
		List<FilmCategory> filmCats = filmcatRepository.findAll();
		
		return  filmCats;
				
				
	}
	
	
	
}
