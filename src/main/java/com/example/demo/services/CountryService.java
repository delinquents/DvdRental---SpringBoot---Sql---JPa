package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	
	
	public List<Country> getAllCountries() {
		
		List<Country> countries = this.countryRepository.findAll();
		
		return countries;
		
	}
	
}
