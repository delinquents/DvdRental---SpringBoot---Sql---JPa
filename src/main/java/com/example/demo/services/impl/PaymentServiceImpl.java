package com.example.demo.services.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Payment;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.service.PaymentService;



@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
//	public List<Payment> getAllPayments() {
//		
//		List<Payment> payments = paymentRepository.findAll();
//		
//		return payments;
//	}
	
	 public List<Payment> getAllPayments(Integer page, Integer limit) {	  
		  
		  Pageable pagingRequest = (Pageable) PageRequest.of(page,limit);
		  Page<Payment> pagedResult = paymentRepository.findAll(pagingRequest);
		  
		  return pagedResult.getContent();
	  }
	
}
