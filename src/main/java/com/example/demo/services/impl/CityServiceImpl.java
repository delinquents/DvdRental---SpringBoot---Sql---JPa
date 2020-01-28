package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.entities.City;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.CityRepository;
import com.example.demo.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
	
	public List<City> getAllCities() {
		
		List<City> cities = cityRepository.findAll();
		return cities;
	}
	
	public List<Address> getAllAddresses() {
		
		List<Address> addresses = addressRepository.findAll();
		
		return addresses;
	}
	
	
}
