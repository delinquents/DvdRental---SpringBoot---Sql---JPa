package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Rental;

public interface RentalService {

	List<Rental> getAllRentals(Integer page, Integer limit);
}
