package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Actor;
import com.example.demo.entities.Address;
import com.example.demo.entities.Category;
import com.example.demo.entities.City;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Film;
import com.example.demo.entities.FilmCategory;
import com.example.demo.entities.Inventory;
import com.example.demo.entities.Rental;
import com.example.demo.entities.Staff;
import com.example.demo.entities.Store;
import com.example.demo.services.ActorService;
import com.example.demo.services.CategoryService;
import com.example.demo.services.CityService;
import com.example.demo.services.CountryService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.FilmService;
import com.example.demo.services.RentalService;
import com.example.demo.services.StaffService;
import com.example.demo.services.StoreService;

@RestController
@RequestMapping("dvd-rental")
public class DvdRentalController {

	private ActorService actorService;
	private FilmService filmService;
	private CategoryService categoryService;
	private CountryService countryService;
	private CityService cityService;
	private CustomerService customerService;
	private StaffService staffService;
	private StoreService storeService;
	private RentalService rentalService;

	public DvdRentalController(ActorService actorService, FilmService filmService, CategoryService categoryService,
			CountryService countryService, CityService cityService, CustomerService customerService,
			StaffService staffService, StoreService storeService, RentalService rentalService) {
		
		this.actorService = actorService;
		this.filmService = filmService;
		this.categoryService = categoryService;
		this.countryService = countryService;
		this.cityService = cityService;
		this.customerService = customerService;
		this.staffService = staffService;
		this.storeService = storeService;
		this.rentalService = rentalService;
	}

	// http://localhost:8080/dvd-rental?page=0&limit=5
	@GetMapping
	public List<Actor> getActors(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {

		List<Actor> actors = actorService.getAllActors(page, limit);

		return actors;

	}

	@GetMapping("/films")
	public List<Film> getFilms() {

		return filmService.getAllFilms();
	}

	// http://localhost:8080/dvd-rental/film_category
	@GetMapping("/film_category")
	public List<FilmCategory> getFilmsCategories() {

		List<FilmCategory> filmCats = filmService.getListOfFilmCategories();

		return filmCats;
	}

	// http://localhost:8080/dvd-rental/films/1
	@GetMapping("/films/{id}")
	public Film getFilms(@PathVariable Integer id) {

		Film film = filmService.getFilmById(id);

		return film;
	}

	// http://localhost:8080/dvd-rental/categories
	@GetMapping("/categories")
	public List<Category> getCategories() {

		List<Category> categories = categoryService.getAllCategories();

		return categories;
	}

	// http://localhost:8080/dvd-rental/countries
	@GetMapping("/countries")
	public List<Country> getCountries() {
		List<Country> countries = this.countryService.getAllCountries();
		return countries;
	}

	// http://localhost:8080/dvd-rental/cities
	@GetMapping("/cities")
	public List<City> getAllCities() {

		List<City> cities = cityService.getAllCities();

		return cities;
	}

	// http://localhost:8080/dvd-rental/addresses
	@GetMapping("/addresses")
	public List<Address> getAllAddresses() {

		List<Address> addresses = cityService.getAllAddresses();

		return addresses;
	}

	// http://localhost:8080/dvd-rental/customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {

		List<Customer> customers = customerService.getAllCustomers();

		return customers;
	}

	// http://localhost:8080/dvd-rental/staffs
	@GetMapping("/staffs")
	public List<Staff> getAllStaffs() {

		List<Staff> staffs = staffService.getAllStaffs();

		return staffs;
	}

	// http://localhost:8080/dvd-rental/inventories
	@GetMapping("/inventories")
	public List<Inventory> getAllInvetories() {

		List<Inventory> invetories = storeService.getAllInventories();

		return invetories;
	}
	
	// http://localhost:8080/dvd-rental/stores
	@GetMapping("/stores")
	public List<Store> getAllStores() {

		List<Store> stores = storeService.getAllStores();

		return stores;
	}
	// http://localhost:8080/dvd-rental/rentals
		@GetMapping("/rentals")
	public List<Rental> getAllRentals() {
		
		List<Rental> rentals = rentalService.getAllRentals();
		return rentals;
	}
	
		

}
