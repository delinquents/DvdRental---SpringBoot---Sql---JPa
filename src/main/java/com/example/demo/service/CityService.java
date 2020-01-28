package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Address;
import com.example.demo.entities.City;

public interface CityService {

	List<City> getAllCities();
	List<Address> getAllAddresses();
	
}
