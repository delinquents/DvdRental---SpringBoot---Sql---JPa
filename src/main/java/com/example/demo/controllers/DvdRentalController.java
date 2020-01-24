package com.example.demo.controllers;


import java.util.List;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Actor;
import com.example.demo.entities.Category;
import com.example.demo.entities.Film;
import com.example.demo.entities.FilmCategory;
import com.example.demo.services.ActorService;
import com.example.demo.services.CategoryService;
import com.example.demo.services.FilmService;




//http://localhost:8080/actors?page=0&limit=10

@RestController
@RequestMapping("dvd-rental")
public class DvdRentalController {
	
	
	
	private ActorService actorService;
	private FilmService filmService;
	private CategoryService categoryService;
	
	

	
	
	public DvdRentalController(ActorService actorService, FilmService filmService, CategoryService categoryService) {		
		this.actorService = actorService;
		this.filmService = filmService;
		this.categoryService = categoryService;
	}
	
	//http://localhost:8080/dvd-rental?page=0&limit=5
	@GetMapping
	public List<Actor> getActors(@RequestParam(value="page", defaultValue = "1") int page,
								@RequestParam(value="limit", defaultValue = "25" ) int limit ) {
		
	List<Actor> actors = actorService.getAllActors(page,limit);
		
		return actors;
		
	}
	@GetMapping("/films")
	public List<Film> getFilms() {
		
		return  filmService.getAllFilms();
	}
	//http://localhost:8080/dvd-rental/film_category
	@GetMapping("/film_category")
	public List<FilmCategory> getFilmsCategories() {
		
		List<FilmCategory> filmCats = filmService.getListOfFilmCategories();
		
		return  filmCats;
	}
	
	
	//http://localhost:8080/dvd-rental/films/1
	@GetMapping("/films/{id}")
	public Film getFilms(@PathVariable Integer id) {
		
		Film film = filmService.getFilmById(id);
		
		return  film;
	}
	
	
	
	//http://localhost:8080/dvd-rental/categories
	@GetMapping("/categories")
	public List<Category> getCategories() {
		
		List<Category> categories = categoryService.getAllCategories();
		
		return  categories;
	}
	

}
