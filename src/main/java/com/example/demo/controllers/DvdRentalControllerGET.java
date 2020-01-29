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
import com.example.demo.entities.FilmActor;
import com.example.demo.entities.FilmCategory;
import com.example.demo.entities.Inventory;
import com.example.demo.entities.Payment;
import com.example.demo.entities.Rental;
import com.example.demo.entities.Staff;
import com.example.demo.entities.Store;
import com.example.demo.entities.views.FilmListView;
import com.example.demo.services.impl.ActorServiceImpl;
import com.example.demo.services.impl.CategoryServiceImpl;
import com.example.demo.services.impl.CityServiceImpl;
import com.example.demo.services.impl.CountryServiceImpl;
import com.example.demo.services.impl.CustomerServiceImpl;
import com.example.demo.services.impl.FilmListViewServiceImpl;
import com.example.demo.services.impl.FilmServiceImpl;

import com.example.demo.services.impl.PaymentServiceImpl;
import com.example.demo.services.impl.RentalServiceImpl;
import com.example.demo.services.impl.StaffServiceImpl;
import com.example.demo.services.impl.StoreServiceImpl;


@RestController
@RequestMapping("dvd-rental")
public class DvdRentalControllerGET {

	
	private ActorServiceImpl actorService;
	private FilmServiceImpl filmService;
	private CategoryServiceImpl categoryService;
	private CountryServiceImpl countryService;
	private CityServiceImpl cityService;
	private CustomerServiceImpl customerService;
	private StaffServiceImpl staffService;
	private StoreServiceImpl storeService;
	private RentalServiceImpl rentalService;
	private PaymentServiceImpl paymentService;
	private FilmListViewServiceImpl filmViewService;




	public DvdRentalControllerGET(ActorServiceImpl actorService, FilmServiceImpl filmService, CategoryServiceImpl categoryService,
			CountryServiceImpl countryService, CityServiceImpl cityService, CustomerServiceImpl customerService,
			StaffServiceImpl staffService, StoreServiceImpl storeService, RentalServiceImpl rentalService,
			PaymentServiceImpl paymentService, FilmListViewServiceImpl filmViewService) {		
		this.actorService = actorService;
		this.filmService = filmService;
		this.categoryService = categoryService;
		this.countryService = countryService;
		this.cityService = cityService;
		this.customerService = customerService;
		this.staffService = staffService;
		this.storeService = storeService;
		this.rentalService = rentalService;
		this.paymentService = paymentService;
		this.filmViewService = filmViewService;
	}
	
	
	
	
	// http://localhost:8080/dvd-rental/actors
	@GetMapping("/actors")
	public List<Actor> getActors() {

		List<Actor> actors = actorService.getAllActorsFromGeneric();
		return actors;

	}

	
	// http://localhost:8080/dvd-rental?page=0&limit=5
	@GetMapping
	public List<Actor> getActors(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {

		List<Actor> actors = actorService.getAllActors(page, limit);

		return actors;

	}
	// http://localhost:8080/dvd-rental/films
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

	// http://localhost:8080/dvd-rental/inventories?page=0&limit=5  
	@GetMapping("/inventories")
	public List<Inventory> getAllInvetories(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {

		List<Inventory> invetories = storeService.getAllInventories(page,limit);

		return invetories;
	}
	
	// http://localhost:8080/dvd-rental/stores
	@GetMapping("/stores")
	public List<Store> getAllStores() {

		List<Store> stores = storeService.getAllStores();

		return stores;
	}
	// http://localhost:8080/dvd-rental/rentals?page=0&limit=5   
		@GetMapping("/rentals")
	public List<Rental> getAllRentals(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<Rental> rentals = rentalService.getAllRentals(page,limit);
		return rentals;
	}
	
		// http://localhost:8080/dvd-rental/payments?page=0&limit=5  //TODO PAGINATION
		@GetMapping("/payments")
	public List<Payment> getAllPayments(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<Payment> payments = paymentService.getAllPayments(page,limit);
		return payments;
	}
		
		
		// http://localhost:8080/dvd-rental/film_actor
		@GetMapping("/film_actor")
	public List<FilmActor> getAllFilmActors() {
		
		List<FilmActor> filmActors = actorService.getAllFilmActors();
		return filmActors;
	}
		
		// http://localhost:8080/dvd-rental/filmView
		@GetMapping("/filmView")
		public List<FilmListView> getFilmsView() {
			
			List<FilmListView> filmsView = filmViewService.getListOfFIlms();
			
			return filmsView;
		}
		// http://localhost:8080/dvd-rental/inventory/1
		@GetMapping("/inventory/{id}")
		public Boolean isInventoryInStock(@PathVariable int id) {
			Boolean inStock = storeService.isInvetoryInStock(id);
			return inStock;
		}
		
}
