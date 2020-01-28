package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.service.CountryService;


@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	
	
	
	public List<Country> getAllCountries() {
		
		List<Country> countries = this.countryRepository.findAll();
		
		return countries;
		
	}
	
}
