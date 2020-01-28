package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Rental;
import com.example.demo.repositories.RentalRepository;
import com.example.demo.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {
	
	
	@Autowired
	private RentalRepository rentalRepository;
	
	

//	public List<Rental> getAllRentals() {
//		
//		List<Rental> rentals = rentalRepository.findAll();
//		
//		return rentals;
//	}
	

	 public List<Rental> getAllRentals(Integer page, Integer limit) {	  
		  
		  Pageable pagingRequest = (Pageable) PageRequest.of(page,limit);
		  Page<Rental> pagedResult = rentalRepository.findAll(pagingRequest);
		  
		  return pagedResult.getContent();
	  }
	
	
}
