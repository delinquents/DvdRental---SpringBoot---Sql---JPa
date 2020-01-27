package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rental;
import com.example.demo.repositories.RentalRepository;

@Service
public class RentalService {
	
	
	@Autowired
	private RentalRepository rentalRepository;
	
	

	public List<Rental> getAllRentals() {
		
		List<Rental> rentals = rentalRepository.findAll();
		
		return rentals;
	}
	
	
	
	
}
