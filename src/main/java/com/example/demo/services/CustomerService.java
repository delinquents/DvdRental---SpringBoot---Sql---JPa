package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = customerRepository.findAll();
		
		
		return customers;
	}
	
	
	
	
	
	
}
