package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = customerRepository.findAll();
		
		
		return customers;
	}
	
	
	
	
	
	
}
